/**
 * 
 */
package com.snlabs.aarogyatelangana.account.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.snlabs.aarogyatelangana.account.beans.ConveyDetails;
import com.snlabs.aarogyatelangana.account.beans.DiagnoseDetails;
import com.snlabs.aarogyatelangana.account.beans.NonInvasive;
import com.snlabs.aarogyatelangana.account.beans.Procedures;

/**
 * @author nbattula
 *
 */
public class NonInvasiveRowMapper implements RowMapper {

	NonInvasive nonInvasive = null;
	List<NonInvasive> nonInvasiveList = new ArrayList<NonInvasive>();

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		do {
			nonInvasive = new NonInvasive();
			//nonInvasive.setNonInvasiveID(rs.getLong("F_NON_INVASIVE_ID"));
			nonInvasive.setPatientID(rs.getLong("F_PATIENT_ID"));
			nonInvasive.setPatientName(rs.getString("F_PATIENT_NAME"));
			nonInvasive.setDoctorName(rs.getString("F_DOCTOR_NAME"));
			nonInvasive.setDiagnosisIndication(rs
					.getString("F_DIAGNOSIS_INDICATION"));
			nonInvasive.setDeclarationDate(rs.getDate("F_DECLARATION_DATE"));
			nonInvasive.setProcedureCarriedDate(rs
					.getDate("F_PROCEDURE_CARRIED_DATE"));
			nonInvasive.setProcedureResult(rs.getString("F_PROCEDURE_RESULT"));
			nonInvasive.setConveyID(rs.getLong("F_CONVEY_ID"));
			nonInvasive.setMtpIndication(rs.getString("F_MTP_INDICATION"));
			nonInvasive.setDate(rs.getDate("F_DATE"));
			nonInvasive.setOtherDiagnoseDetails(rs
					.getString("F_OTHER_DIAGNOSE"));
			nonInvasive.setOtherProcedure(rs.getString("F_OTHER_PROCEDURE"));

			Procedures procedures = new Procedures();
			procedures.setUltrasound(rs.getString("F_CARRIED_NON_INVASIVE_PROCEDURE"));
			nonInvasive.setProcedures(procedures);
			
			ConveyDetails conveyDetails = new ConveyDetails();
			conveyDetails.setPatientID(rs.getInt("F_PATIENT_ID"));
			conveyDetails.setConveyID(rs.getLong("F_CONVEY_ID"));
			conveyDetails.setConveyedName(rs.getString("F_CONVEY_NAME"));
			conveyDetails.setConveyedDate(rs.getDate("F_CONVEY_DATE"));
			conveyDetails.setType(rs.getString("F_TYPE"));
			nonInvasive.setConveyDetails(conveyDetails);

			DiagnoseDetails diagnoseDetails = new DiagnoseDetails();
			diagnoseDetails.setPatientID(rs.getInt("F_PATIENT_ID"));
			diagnoseDetails.setGestational(rs.getString("F_GESTATIONAL"));
			diagnoseDetails.setIntrauterine(rs.getString("F_INTRAUTERINE"));
			diagnoseDetails.setChorionicity(rs.getString("F_CHORIONICITY"));
			diagnoseDetails.setVaginalbleeding(rs
					.getString("F_VAGINAL_BLEEDING"));
			diagnoseDetails.setAbortion(rs.getString("F_ABORTION"));
			diagnoseDetails.setIucdInSitu(rs.getString("F_IUCD_IN_SITU"));
			diagnoseDetails.setAssessmentOfCervical(rs
					.getString("F_ASSESSMENT_OF_CERVICAL"));
			diagnoseDetails.setUterineSizeAmenorrhea(rs
					.getString("F_UTERINESIZE_AMENORRHEA"));
			diagnoseDetails.setSuspectedAdenexal(rs
					.getString("F_SUSPECTED_ADENEXAL"));
			diagnoseDetails.setChromosomalAbnormalities(rs
					.getString("F_CHROMOSOMAL_ABNORMALITIES"));
			diagnoseDetails.setFetalPosition(rs.getString("F_FETAL_POSITION"));
			diagnoseDetails.setLiquorAmnii(rs.getString("F_LIQUOR_AMNII"));
			diagnoseDetails.setPretermLabor(rs.getString("F_PRETERM_LABOR"));
			diagnoseDetails.setPlacentalPosition(rs
					.getString("F_PLACENTAL_POSITION"));
			diagnoseDetails.setUmbilicalCord(rs.getString("F_UMBILICAL_CORD"));
			diagnoseDetails.setPreviousCaesarean(rs
					.getString("F_PREVIOUS_CAESAREAN"));
			diagnoseDetails.setFetalGrowth(rs.getString("F_FETAL_GROWTH"));
			diagnoseDetails.setDuplexDoppler(rs.getString("F_DUPLEX_DOPPLER"));
			diagnoseDetails.setTerminationOfPregnancy(rs
					.getString("F_TERMINATION_OF_PREGNANCY"));
			diagnoseDetails.setChorionicVillus(rs
					.getString("F_CHORIONIC_VILLUS"));
			diagnoseDetails.setIntraPartumEvents(rs
					.getString("F_INTRA_PARTUM_EVENTS"));
			diagnoseDetails.setComplicatingPregnancy(rs
					.getString("F_COMPLICATING_PREGNANCY"));
			diagnoseDetails.setResearchScientific(rs
					.getString("F_RESEARCH_SCIENTIFIC"));
			nonInvasive.setDiagnoseDetails(diagnoseDetails);

			nonInvasiveList.add(nonInvasive);
		} while (rs.next());
		return nonInvasiveList;
	}

}
