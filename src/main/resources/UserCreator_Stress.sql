CREATE DEFINER=`root`@`localhost` PROCEDURE `create_users`()
begin

declare v_max int unsigned default 10000;
declare v_counter int unsigned default 1;

  start transaction;
  while v_counter < v_max do
    INSERT
INTO
  T_USER_DETAILS
  (
    F_LOGIN_ID,
    F_PASSWORD,
    F_IS_ENABLED,
    F_DISPLAY_NAME,
    F_MOBILE_NUMBER,
    F_CREATED_BY,
    F_CREATION_DATE
  )
  VALUES
  (
    CONCAT('user', v_counter),
    '202cb962ac59075b964b07152d234b70',
    'true',
    CONCAT('user', v_counter),
    '9898989899',
    'Superuser',
    sysdate()
  );

INSERT
INTO
  T_USER_ADDRESS
  (
    F_LOGIN_ID,
    F_DISTRICT,
    F_STATE
  )
  VALUES
  (
    CONCAT('user', v_counter),
    'Hyderabad',
    'Telangana'
  );

INSERT
INTO
  T_USER_ROLES
  (
    F_LOGIN_ID,
    F_ROLE
  )
  VALUES
  (
    CONCAT('user', v_counter),
    'HealthCenterUser'
  );
  
INSERT
INTO
  T_USER_CLINIC_DETAILS
  (
    F_LOGIN_ID,
    F_CLINIC_OWNER_NAME,
    F_TYPE,
    F_REG_NO,
    F_ADDRESS,
    F_DISTRICT,
    F_STATE,
    F_PINCODE,
    F_CONTACT_NO,
    F_CLINIC_NAME
  )
  VALUES
  (
    CONCAT('user', v_counter),
    'Owner',
    'HealthCenter',
    '123123',
    'Banjarahills',
    'Hyderabad',
    'Telangana',
    500081,
    '04062399',
    CONCAT('ClinicName', v_counter)
  );
    set v_counter=v_counter+1;
  end while;
  commit;
end