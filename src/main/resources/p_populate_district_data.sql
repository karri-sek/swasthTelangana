DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_populate_district_data`()
begin 
  DECLARE v_finished          integer DEFAULT 0;     
  declare v_state_id          int; 
  declare v_state_name char;  
  declare state_cursor CURSOR FOR SELECT f_state_id FROM t_state;    
  declare CONTINUE handler FOR NOT found SET v_finished = 1; 
  
  open state_cursor; 
  cur_state_loop: LOOP
  FETCH state_cursor INTO v_state_id;
  
      IF v_finished = 1 THEN 
      CLOSE state_cursor;
      LEAVE cur_state_loop;
      END IF;

      BLOCK2: BEGIN
        DECLARE v_district_id INT;
        DECLARE v_district_name varchar(20);
        DECLARE v_month_id,v_pregnant_disorder_yes,v_mtp_found, v_edd_current_month_yes INT;        
        DECLARE v_year INT;
        DECLARE v_formf_count,v_first_female_child_yes INT;
        DECLARE v_district_not_found integer DEFAULT 0; 
        DECLARE district_cursor CURSOR FOR 
          SELECT f_district_name 
            FROM t_district 
            WHERE  f_state_id = v_state_id;    
        DECLARE continue HANDLER for NOT found SET v_district_not_found =1;
        
        SELECT MONTH(CURRENT_DATE()) INTO v_month_id;
        SELECT YEAR(CURRENT_DATE()) INTO v_year;
        OPEN district_cursor; 

        get_clinic_data: LOOP
        FETCH FROM district_cursor INTO v_district_name;          
          IF v_district_not_found = 1 then 
            close district_cursor;
            LEAVE get_clinic_data;  
          END IF;    
   
          CREATE TABLE t_temp AS 
          ( SELECT  patient.f_aadhar_no,
                    patient.f_patient_id
              FROM  t_patient patient                    
              WHERE date(patient.f_created_timestamp) = CURRENT_DATE() AND F_STATUS = 'COMPLETED'                 
                   AND patient.f_created_by IN(select clinic.f_login_id
                                  from t_user_clinic_details clinic
   where clinic.f_district = v_district_name)
          );    
  
            SELECT COUNT(*)
                  INTO v_formf_count
   FROM t_form form, t_temp temp
    WHERE form.f_patient_id = temp.f_patient_id;
                  
                  SELECT COUNT(1)
                  INTO v_mtp_found
                  FROM t_non_invasive_procedures procedures,
                          t_temp temp
                     WHERE temp.f_patient_id = procedures.f_patient_id
                       AND procedures.f_mtp_indication = 'YES'; 
                  
                  SELECT count(1)
                     into v_pregnant_disorder_yes
                     FROM t_non_invasive_procedures procedures,
                          t_temp temp
                     WHERE temp.f_patient_id = procedures.f_patient_id
                       AND procedures.f_mtp_indication = 'YES'; 
                  
                  SELECT count(1)
                          INTO v_first_female_child_yes
                          FROM t_form formf,
                               t_temp temp
                          WHERE formf.f_patient_id = temp.f_patient_id AND formf.F_NO_OF_CHILDREN = 1
                          AND F_NO_OF_FEMALE_KIDS = 1;     
                  
                  select count(1)
						into v_edd_current_month_yes
                        FROM t_non_invasive_procedures procedures,
                          t_temp temp
						WHERE temp.f_patient_id = procedures.f_patient_id
                        and MONTH(procedures.f_edd) = v_month_id;
					
                INSERT INTO t_district_monthly_formfs_stats
                            ( f_formf_total,
                              f_mtp_yes,
                              f_mtp_no,
                              f_first_female_child_yes,
                              f_first_female_child_no,
                              f_pregnant_disorder_yes,
                              f_pregnant_disorder_no,
                              f_edd_current_month_yes,
                              f_edd_current_month_no,
                              f_state_id,
                              f_district_name,
                              f_month_id,
                              f_year,
                              f_created_date)
                      VALUES( v_formf_count,
                              v_mtp_found,
                              v_formf_count - v_mtp_found,
                              v_first_female_child_yes,
                              v_formf_count - v_first_female_child_yes,
                              v_pregnant_disorder_yes,
                              v_formf_count - v_pregnant_disorder_yes,
                              v_edd_current_month_yes,
                              v_formf_count - v_edd_current_month_yes,
                              v_state_id,
                              v_district_name,  
                              v_month_id,
                              v_year,
                              CURRENT_DATE())
          ON DUPLICATE KEY UPDATE f_formf_total = f_formf_total + v_formf_count,
                                  f_mtp_yes = f_mtp_yes + v_mtp_found,
                                  f_mtp_no = f_mtp_no + (v_formf_count - v_mtp_found),
                                  f_first_female_child_yes = f_first_female_child_yes + v_first_female_child_yes,
                                  f_first_female_child_no = f_first_female_child_no + (f_formf_total - v_first_female_child_yes),
                                  f_pregnant_disorder_yes = f_pregnant_disorder_yes + v_pregnant_disorder_yes,
                                  f_pregnant_disorder_no = f_pregnant_disorder_no + (v_formf_count - v_pregnant_disorder_yes),
                                  f_edd_current_month_yes = f_edd_current_month_yes + v_edd_current_month_yes,
								  f_edd_current_month_no = f_edd_current_month_no + (v_formf_count - v_edd_current_month_yes);
                                  
          DROP TABLE t_temp;
  COMMIT;                           
          END LOOP get_clinic_data;
      END BLOCK2; 
    
END LOOP cur_state_loop;
END$$
DELIMITER ;
