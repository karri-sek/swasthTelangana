package com.snlabs.aarogyatelangana.account.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.snlabs.aarogyatelangana.account.beans.AdditionalTests;
import com.snlabs.aarogyatelangana.account.beans.ConveyDetails;
import com.snlabs.aarogyatelangana.account.beans.DiagnosisBasis;
import com.snlabs.aarogyatelangana.account.beans.DiagnosisIndication;
import com.snlabs.aarogyatelangana.account.beans.Invasive;
import com.snlabs.aarogyatelangana.account.beans.InvasiveProcedures;

public class InvasiveRowMapper implements RowMapper {

	Invasive invasive = null;
    List<Invasive> invasiveList = new ArrayList<Invasive>();
    
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		do {
			Invasive invasive = new Invasive();
			invasive.setPatientID(rs.getLong("F_PATIENT_ID"));
			invasive.setDoctorName(rs.getString("F_DOCTOR_NAME"));
			invasive.setHistoryOfGeneticDisease(rs.getString("F_HISTORY_OF_GENETIC_DISEASE"));
			invasive.setAdvancedMaternalAge(rs.getString("F_ADVANCED_MATERNAL_AGE"));
			invasive.setGeneticDisease(rs.getString("F_GENETIC_DISEASE"));
			invasive.setPreviousComplication(rs.getString("F_PREVIOUS_COMPLICATION"));
			invasive.setFormGDate(rs.getDate("F_FORM_G_DATE"));
			invasive.setComplication(rs.getString("F_COMPLICATIONS"));
			invasive.setProcedureResult(rs.getString("F_PROCEDURE_RESULT"));
			invasive.setProcedureCarriedDate(rs.getDate("F_PROCEDURE_CARRIED_DATE"));
			invasive.setMtpIndication(rs.getString("F_MTP_INDICATION"));

			ConveyDetails invConveyDetails = new ConveyDetails();
			invConveyDetails.setConveyedName(rs.getString("F_CONVEY_NAME"));
			invConveyDetails.setConveyedDate(rs.getDate("F_CONVEY_DATE"));
			invasive.setConveyDetails(invConveyDetails);

			DiagnosisBasis diagnosisBasis = new DiagnosisBasis();
			diagnosisBasis.setBiochemical(rs.getString("F_BIOCHEMICAL"));
			diagnosisBasis.setClinical(rs.getString("F_CLINICAL"));
			diagnosisBasis.setCytogenetic(rs.getString("F_CYTOGENETIC"));
			diagnosisBasis.setOther(rs.getString("F_DB_OTHER"));
			invasive.setDiagnosisBasis(diagnosisBasis);

			DiagnosisIndication diagnosisIndication = new DiagnosisIndication();
			diagnosisIndication.setAnyOther(rs.getString("F_DI_OTHER"));
			diagnosisIndication.setChromosomalDisorders(rs.getString("F_CHROMOSOMAL_DISORDERS"));
			diagnosisIndication.setCongenitalAnomaly(rs.getString("F_CONGENITAL_ANOMALY"));
			diagnosisIndication.setHaemoglobinopathy(rs.getString("F_HAEMOGLOBINOPATHY"));
			diagnosisIndication.setMentalRetardation(rs.getString("F_MENTAL_RETARDATION"));
			diagnosisIndication.setMetabolicDisorders(rs.getString("F_METABOLIC_DISORDERS"));
			diagnosisIndication.setSexLinkedDisorders(rs.getString("F_SEXLINKED_DISORDERS"));
			diagnosisIndication.setSingleGeneDisorder(rs.getString("F_SINGLEGENE_DISORDER"));
			invasive.setDiagnosisIndication(diagnosisIndication);

			InvasiveProcedures invasiveProcedures = new InvasiveProcedures();
			invasiveProcedures.setAmniocentesis(rs.getString("F_AMNIOCENTESIS"));
			invasiveProcedures.setChorionicVilli(rs.getString("F_CHORIONIC_VILLI"));
			invasiveProcedures.setCordocentesis(rs.getString("F_CORDOCENTESIS"));
			invasiveProcedures.setFetalBiopsy(rs.getString("F_FETAL_BIOPSY"));
			invasiveProcedures.setOthers(rs.getString("F_IP_OTHER"));
			invasive.setInvasiveProcedures(invasiveProcedures);

			AdditionalTests additionalTests = new AdditionalTests();
			additionalTests.setBiochemicalStudies(rs.getString("F_BIOCHEMICAL_STUDIES"));
			additionalTests.setChromosomalStudies(rs.getString("F_CHROMOSOMAL_STUDIES"));
			additionalTests.setMolecularStudies(rs.getString("F_MOLECULAR_STUDIES"));
			additionalTests.setOthers(rs.getString("F_AT_OTHER"));
			additionalTests.setPreImplantationGender(rs.getString("F_PREIMPLANTATION_GENDER"));
			invasive.setAdditionalTests(additionalTests);

			invasiveList.add(invasive);
        } while (rs.next());
        return invasiveList;
	}
}
