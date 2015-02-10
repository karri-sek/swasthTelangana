package com.snlabs.aarogyatelangana.account.dao.impl;

import com.snlabs.aarogyatelangana.account.beans.*;
import com.snlabs.aarogyatelangana.account.dao.FormDao;
import com.snlabs.aarogyatelangana.account.service.impl.FormRowMapper;
import com.snlabs.aarogyatelangana.account.service.impl.PatientIDsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FormDaoImpl implements FormDao {

    private DataSource dataSource;

    @Override
    public Patient getPatientDetails(int patientID) {
        StringBuilder patientDetailsQuery = new StringBuilder();
        patientDetailsQuery.append("SELECT * FROM T_PATIENT patient, T_PATIENT_ADDRESS address")
                .append(" WHERE patient.F_PATIENT_ID=").append(patientID).append(" AND address.F_PATIENT_ID=").append(patientID);
        final Patient patient = new Patient();
        patient.setPatientID(patientID);
        try {
            jdbcTemplate.queryForObject(patientDetailsQuery.toString(), new RowMapper() {
                @Override
                public Patient mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
                    PatientAddress patientAddress = new PatientAddress();
                    patient.setAadharNo(resultSet.getString("F_AADHAR_NO"));
                    patient.setPatientName(resultSet.getString("F_PATIENT_NAME"));
                    patient.setGender(resultSet.getString("F_GENDER"));
                    patient.setAge(resultSet.getInt("F_AGE"));
                    patientAddress.setContactno(resultSet.getInt("F_CONTACT_NO"));
                    patientAddress.setAddress(resultSet.getString("F_ADDRESS"));
                    patientAddress.setCurrentAddress(resultSet.getString("F_CURRENT_ADDRESS"));
                    patientAddress.setDistrict(resultSet.getString("F_DISTRICT"));
                    patientAddress.setState(resultSet.getString("F_STATE"));
                    patientAddress.setPincode(resultSet.getInt("F_PINCODE"));
                    patient.setPatientAddress(patientAddress);
                    return patient;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public ClinicAddress saveClinicDetails(ClinicAddress clinicAddress) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO T_CLINIC_DETAILS(").append(
                "F_PATIENT_ID," + "F_CLINIC_OWNER_NAME," + "F_TYPE,"
                        + "F_ADDRESS," + "F_DISTRICT," + "F_STATE,"
                        + "F_PINCODE," + "F_CONTACT_NO," + "F_CLINIC_NAME)");
        sb.append("VALUES(?,?,?,?,?,?,?,?,?)");
        Object[] args = new Object[]{clinicAddress.getPatientID(),
                clinicAddress.getOwnerName(), clinicAddress.getType(),
                clinicAddress.getAddress(), clinicAddress.getDistrict(),
                clinicAddress.getState(), clinicAddress.getPincode(),
                clinicAddress.getContactNum(), clinicAddress.getClinicName()};
        try {
            return jdbcTemplate.update(sb.toString(), args) > 0 ? clinicAddress : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private int updatePatientRecord(Form form) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE T_PATIENT SET ").append("F_FORM_ID = ?");
        sb.append(" WHERE F_PATIENT_ID=?");
        Object[] args = new Object[]{form.getFormID(),
                form.getPatient().getPatientID()};
        try {
            if (jdbcTemplate.update(sb.toString(), args) > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean update(Form form) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateClinicDetails(ClinicAddress clinicAddress) {
        StringBuilder updateClinicRecord = new StringBuilder();
        updateClinicRecord.append("UPDATE T_CLINIC_DETAILS SET F_CLINIC_OWNER_NAME = ?,")
                .append(" F_TYPE = ?,").append(" F_ADDRESS  = ?,")
                .append(" F_DISTRICT = ?,").append(" F_STATE = ?,")
                .append(" F_PINCODE = ?,").append(" F_CONTACT_NO = ?,")
                .append(" F_CLINIC_NAME = ?")
                .append(" WHERE F_PATIENT_ID = ?");
        Object[] args = {clinicAddress.getOwnerName(), clinicAddress.getType(), clinicAddress.getAddress(),
                clinicAddress.getDistrict(), clinicAddress.getState(), clinicAddress.getPincode(),
                clinicAddress.getContactNum(), clinicAddress.getClinicName(), clinicAddress.getPatientID()};
        try {
            return jdbcTemplate.update(updateClinicRecord.toString(), args) > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateSectionA(SectionA sectionA) {
        StringBuilder updateFormRecord = new StringBuilder();
        updateFormRecord.append("UPDATE T_FORM SET F_NO_OF_CHILDREN = ?,")
                .append(" F_GUARDIAN_NAME = ?,").append(" F_NO_OF_MALE_KIDS  = ?,")
                .append(" F_NO_OF_FEMALE_KIDS = ?,").append(" F_MENSTRUAL_PERIOD = ?")
                .append(" WHERE F_PATIENT_ID = ?");
        Object[] args = {sectionA.getNoOfChildren(), sectionA.getGuardianName(), sectionA.getNoOfMaleKids(),
                sectionA.getNoOfFemaleKids(), sectionA.getMenstrualPeriod(), sectionA.getPatientID()};
        try {
            return jdbcTemplate.update(updateFormRecord.toString(), args) > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateNonInvasiveDetails(NonInvasive nonInvasive) {
        StringBuilder updateNonInvasiveRecord = new StringBuilder();
        updateNonInvasiveRecord.append("UPDATE T_NON_INVASIVE_PROCEDURES SET F_DOCTOR_NAME = ?,")
                .append(" F_DIAGNOSIS_INDICATION = ?,").append(" F_CARRIED_NON_INVASIVE_PROCEDURE  = ?,")
                .append(" F_DECLARATION_DATE = ?,").append(" F_PROCEDURE_CARRIED_DATE = ?,")
                .append(" F_PROCEDURE_RESULT = ?,").append(" F_CONVEY_ID = ?,")
                .append(" F_MTP_INDICATION = ?,").append(" F_DATE = ?,")
                .append(" F_PLACE = ?,").append(" F_SELECTED_DIAGNOSE = ?")
                .append(" WHERE F_PATIENT_ID = ?");
        Object[] args = {nonInvasive.getDoctorName(),
                nonInvasive.getDiagnosisIndication(), nonInvasive.getCarriedNonInvasiveProcedure(),
                nonInvasive.getDeclarationDate(), nonInvasive.getProcedureCarriedDate(),
                nonInvasive.getProcedureResult(), nonInvasive.getConveyID(),
                nonInvasive.getMtpIndication(), nonInvasive.getDate(),
                nonInvasive.getPlace(), nonInvasive.getSelectedDiagnoseDetails(),
                nonInvasive.getPatientID()};
        try {
            return jdbcTemplate.update(updateNonInvasiveRecord.toString(), args) > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateInvasiveDetails(Invasive invasive) {
        StringBuilder updateInvasiveRecord = new StringBuilder();
        updateInvasiveRecord.append("UPDATE T_INVASIVE_PROCEDURES SET F_DOCTOR_NAME = ?,")
                .append(" F_DIAGNOSIS_BASICS = ?,").append(" F_DIAGNOSIS_INDICATION  = ?,")
                .append(" F_ADVANCED_MATERNAL_AGE = ?,").append(" F_GENETIC_DISEASE = ?,")
                .append(" F_CONTEST_DATE = ?,").append(" F_CARRIED_INVASIVE_PROCEDURE = ?,")
                .append(" F_COMPILICATION = ?,").append(" F_ADDITIONAL_TEST = ?,")
                .append(" F_PROCEDURE_RESULT = ?,").append(" F_PROCEDURE_CARRIED_DATE = ?,")
                .append(" F_MTP_INDICATION = ?").append(" WHERE F_PATIENT_ID = ?");
        Object[] args = {invasive.getDoctorName(),
                invasive.getDignosisBasics(), invasive.getDiagnosisIndications(),
                invasive.getAdvancedMaternalAge(), invasive.getGeneticDisease(),
                invasive.getContestDate(), invasive.getCarriedInvasiveProcedure(),
                invasive.getCompilication(), invasive.getAdditionalTest(),
                invasive.getProcedureResult(), invasive.getProcedureCarriedDate(),
                invasive.getMtpIndication(), invasive.getPatientID()};
        try {
            return jdbcTemplate.update(updateInvasiveRecord.toString(), args) > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Form findByFormId(int formId) {
        Form form = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM T_FORM WHERE F_FORM_ID=").append(formId);
        try {
            /*
             * List<User> detailsList =
			 * jdbcTemplate.queryForObject(sb.toString(), new FormRowMapper());
			 * for (User user : detailsList) { if (user instanceof Form) { form
			 * = (Form) user; } }
			 */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return form;
    }

    @Override
    public boolean delete(Form form) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Form findByFromName(String formName) {
        // TODO Auto-generated method stub
        return null;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Form searchFormByDateRange(String fromDate, String toDate) {
        Form form = null;
        // Date format should be YYYY-MONTH-DATE
        StringBuilder sb = new StringBuilder();
        sb.append(
                "SELECT F_PATIENT_ID FROM T_PATIENT WHERE F_CREATED_TIMESTAMP BETWEEN ")
                .append("STR_TO_DATE('").append(fromDate)
                .append("','%Y-%m-%d') AND STR_TO_DATE('").append(toDate)
                .append("','%Y-%m-%d')");
        try {
            List<Integer> patientIDs = (List<Integer>) jdbcTemplate.queryForObject(
                    sb.toString(), new PatientIDsMapper());
            if (patientIDs.size() > 0) {
                StringBuilder getResult = new StringBuilder();
                getResult.append("SELECT PATIENT.F_PATIENT_NAME,"
                        + "PATIENT.F_PATIENT_ID," + "PATIENT.F_AGE,"
                        + "patient.F_GENDER," + "FORMF.F_NO_OF_CHILDREN");
                getResult
                        .append(" FROM T_FORM FORMF,T_PATIENT PATIENT WHERE patient.f_patient_id = formf.f_patient_id AND "
                                + "patient.f_patient_id>="
                                + patientIDs.get(0)
                                + " AND patient.f_patient_id<="
                                + patientIDs.get(patientIDs.size() - 1));
                List<User> formBeans = (List<User>) jdbcTemplate.queryForObject(
                        getResult.toString(), new FormRowMapper());
                form = new Form();
                form.setFormbeans(formBeans);
                return form;

            } else {
                form.setFormbeans(null);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public SectionA saveSectionA(SectionA section) {
        StringBuilder sectionADetails = new StringBuilder();
        sectionADetails.append("INSERT INTO T_FORM(").append(
                "F_PATIENT_ID," + "F_NO_OF_CHILDREN," + "F_NO_OF_MALE_KIDS,"
                        + "F_NO_OF_FEMALE_KIDS," + "F_GUARDIAN_NAME,"
                        + "F_MENSTRUAL_PERIOD)");
        sectionADetails.append("VALUES(?,?,?,?,?,?)");
        Object[] args = new Object[]{section.getPatientID(),
                section.getNoOfChildren(), section.getNoOfMaleKids(),
                section.getNoOfFemaleKids(), section.getGuardianName(),
                section.getMenstrualPeriod()};
        return jdbcTemplate.update(sectionADetails.toString(), args) > 0 ? section : null;
    }

    @Override
    public NonInvasive saveNonInvasive(NonInvasive nonInvasive) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO T_NON_INVASIVE_PROCEDURES(")
                .append("F_PATIENT_ID, F_DOCTOR_NAME," + "F_DIAGNOSIS_INDICATION,"
                        + "F_CARRIED_NON_INVASIVE_PROCEDURE,"
                        + "F_DECLARATION_DATE," + "F_PROCEDURE_CARRIED_DATE,"
                        + "F_PROCEDURE_RESULT," + "F_MTP_INDICATION,"
                        + "F_SELECTED_DIAGNOSE")
                .append(")VALUES(?,?,?,?,?,?,?,?,?)");
        Object[] args = new Object[]{nonInvasive.getPatientID(), nonInvasive.getDoctorName(),
                nonInvasive.getDiagnosisIndication(),
                nonInvasive.getCarriedNonInvasiveProcedure(),
                nonInvasive.getDeclarationDate(),
                nonInvasive.getProcedureCarriedDate(),
                nonInvasive.getProcedureResult(),
                nonInvasive.getMtpIndication(),
                nonInvasive.getSelectedDiagnoseDetails()};
        return jdbcTemplate.update(sb.toString(), args) > 0 ? nonInvasive : null;
    }

    @Override
    public Invasive saveInvasive(Invasive invasive) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO T_INVASIVE_PROCEDURES(")
                .append("F_PATIENT_ID, F_DOCTOR_NAME, F_DIAGNOSIS_BASICS,")
                .append(" F_ADVANCED_MATERNAL_AGE, F_GENETIC_DISEASE,")
                .append(" F_CONTEST_DATE, F_CARRIED_INVASIVE_PROCEDURE,")
                .append(" F_COMPILICATION, F_ADDITIONAL_TEST,")
                .append(" F_PROCEDURE_RESULT, F_PROCEDURE_CARRIED_DATE,")
                .append(" F_MTP_INDICATION")
                .append(")VALUES(?,?,?,?,?,SYSDATE(),?,?,?,?,SYSDATE(),?)");
        Object[] args = new Object[]{invasive.getPatientID(),
                invasive.getDoctorName(), invasive.getDignosisBasics(),
                invasive.getAdvancedMaternalAge(),
                invasive.getGeneticDisease(),
                invasive.getCarriedInvasiveProcedure(),
                invasive.getCompilication(), invasive.getAdditionalTest(),
                invasive.getProcedureResult(), invasive.getMtpIndication()};
        return jdbcTemplate.update(sb.toString(), args) > 0 ? invasive : null;
    }

    @Override
    public Declaration saveDeclaration(Declaration declaration) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO T_DOCTOR_DECLARATION(")
                .append("F_PATIENT_ID," + "F_DOCTOR_NAME," + "F_PLACE,"
                        + "F_PATIENT_NAME," + "F_DATE)")
                .append(" VALUES(?,?,?,?,SYSDATE())");
        Object[] args = new Object[]{declaration.getPatientID(),
                declaration.getDoctorName(), declaration.getPlace(),
                declaration.getPatientName()};
        return jdbcTemplate.update(sb.toString(), args) > 0 ? declaration : null;
    }

    @Override
    public SectionA getSectionADetails(int patientID) {
        StringBuilder patientDetailsQuery = new StringBuilder();
        patientDetailsQuery.append("SELECT * FROM T_FORM sectionA")
                .append(" WHERE sectionA.F_PATIENT_ID=").append(patientID);
        final SectionA sectionA = new SectionA();
        try {
            jdbcTemplate.queryForObject(patientDetailsQuery.toString(), new RowMapper() {
                @Override
                public SectionA mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
                    sectionA.setPatientID(resultSet.getInt("F_PATIENT_ID"));
                    sectionA.setNoOfChildren(resultSet.getInt("F_NO_OF_CHILDREN"));
                    sectionA.setMenstrualPeriod(resultSet.getInt("F_MENSTRUAL_PERIOD"));
                    sectionA.setNoOfMaleKids(resultSet.getInt("F_NO_OF_MALE_KIDS"));
                    sectionA.setNoOfFemaleKids(resultSet.getInt("F_NO_OF_FEMALE_KIDS"));
                    sectionA.setGuardianName(resultSet.getString("F_GUARDIAN_NAME"));
                    return sectionA;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ClinicAddress getClinicDetails(int patientID) {
        StringBuilder clinicDetailsQuery = new StringBuilder();
        clinicDetailsQuery.append("SELECT * FROM T_CLINIC_DETAILS clinic")
                .append(" WHERE clinic.F_PATIENT_ID=").append(patientID);
        final ClinicAddress clinicAddress = new ClinicAddress();
        try {
            jdbcTemplate.queryForObject(clinicDetailsQuery.toString(), new RowMapper() {
                @Override
                public ClinicAddress mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
                    clinicAddress.setPatientID(resultSet.getInt("F_PATIENT_ID"));
                    clinicAddress.setOwnerName(resultSet.getString("F_CLINIC_OWNER_NAME"));
                    clinicAddress.setType(resultSet.getString("F_TYPE"));
                    clinicAddress.setAddress(resultSet.getString("F_ADDRESS"));
                    clinicAddress.setDistrict(resultSet.getString("F_DISTRICT"));
                    clinicAddress.setClinicName(resultSet.getString("F_CLINIC_NAME"));
                    clinicAddress.setState(resultSet.getString("F_STATE"));
                    clinicAddress.setContactNum(resultSet.getInt("F_CONTACT_NO"));
                    return clinicAddress;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NonInvasive getNonInvasiveDetails(int patientID) {
        StringBuilder nonInvasiveDetailsQuery = new StringBuilder();
        nonInvasiveDetailsQuery.append("SELECT * FROM T_NON_INVASIVE_PROCEDURES nonInvasive")
                .append(" WHERE nonInvasive.F_PATIENT_ID=").append(patientID);
        final NonInvasive nonInvasive = new NonInvasive();
        try {
            jdbcTemplate.queryForObject(nonInvasiveDetailsQuery.toString(), new RowMapper<NonInvasive>() {
                @Override
                public NonInvasive mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
                    nonInvasive.setPatientID(resultSet.getInt("F_PATIENT_ID"));
                    nonInvasive.setDoctorName(resultSet.getString("F_DOCTOR_NAME"));
                    nonInvasive.setDiagnosisIndication(resultSet.getString("F_DIAGNOSIS_INDICATION"));
                    nonInvasive.setCarriedNonInvasiveProcedure(resultSet.getString("F_CARRIED_NON_INVASIVE_PROCEDURE"));
                    nonInvasive.setDeclarationDate(resultSet.getDate("F_DECLARATION_DATE"));
                    nonInvasive.setProcedureCarriedDate(resultSet.getDate("F_PROCEDURE_CARRIED_DATE"));
                    nonInvasive.setProcedureResult(resultSet.getString("F_PROCEDURE_RESULT"));
                    nonInvasive.setConveyID(resultSet.getInt("F_CONVEY_ID"));
                    nonInvasive.setMtpIndication(resultSet.getString("F_MTP_INDICATION"));
                    nonInvasive.setDate(resultSet.getDate("F_DATE"));
                    nonInvasive.setPlace(resultSet.getString("F_PLACE"));
                    nonInvasive.setSelectedDiagnoseDetails(resultSet.getString("F_SELECTED_DIAGNOSE"));
                    return nonInvasive;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Invasive getInvasiveDetails(int patientID) {
        StringBuilder invasiveDetailsQuery = new StringBuilder();
        invasiveDetailsQuery.append("SELECT * FROM T_INVASIVE_PROCEDURES invasive")
                .append(" WHERE invasive.F_PATIENT_ID=").append(patientID);
        final Invasive invasive = new Invasive();
        try {
            jdbcTemplate.queryForObject(invasiveDetailsQuery.toString(), new RowMapper<Invasive>() {
                @Override
                public Invasive mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
                    invasive.setPatientID(resultSet.getInt("F_PATIENT_ID"));
                    invasive.setDoctorName(resultSet.getString("F_DOCTOR_NAME"));
                    invasive.setDignosisBasics(resultSet.getString("F_DIAGNOSIS_BASICS"));
                    //invasive.setD(resultSet.getString("F_DIAGNOSIS_INDICATION"));
                    invasive.setAdvancedMaternalAge(resultSet.getString("F_ADVANCED_MATERNAL_AGE"));
                    invasive.setGeneticDisease(resultSet.getString("F_GENETIC_DISEASE"));
                    invasive.setContestDate(resultSet.getDate("F_CONTEST_DATE"));
                    invasive.setCarriedInvasiveProcedure(resultSet.getString("F_CARRIED_INVASIVE_PROCEDURE"));
                    invasive.setCompilication(resultSet.getString("F_COMPILICATION"));
                    invasive.setAdditionalTest(resultSet.getString("F_ADDITIONAL_TEST"));
                    invasive.setProcedureResult(resultSet.getString("F_PROCEDURE_RESULT"));
                    invasive.setProcedureCarriedDate(resultSet.getDate("F_PROCEDURE_CARRIED_DATE"));
                    invasive.setMtpIndication(resultSet.getString("F_MTP_INDICATION"));
                    return invasive;

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
