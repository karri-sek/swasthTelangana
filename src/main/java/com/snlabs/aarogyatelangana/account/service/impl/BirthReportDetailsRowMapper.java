/**
 * 
 */
package com.snlabs.aarogyatelangana.account.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.snlabs.aarogyatelangana.account.beans.Address;
import com.snlabs.aarogyatelangana.account.beans.BirthFamilyInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthHealthInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthLegalInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthReportAddress;
import com.snlabs.aarogyatelangana.account.beans.BirthReportDetails;

/**
 * @author nbattula
 *
 */
public class BirthReportDetailsRowMapper implements RowMapper {

	List<BirthReportDetails> detailsList = new ArrayList<BirthReportDetails>();

	@Override
	public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		do {
			BirthReportDetails birthReportDetails = new BirthReportDetails();

			BirthLegalInfo legalInfo = new BirthLegalInfo();

			legalInfo.setBirthId(resultSet.getLong("F_BR_ID"));
			legalInfo.setDateOfBirth(resultSet.getDate("F_DATE_OF_BIRTH"));
			legalInfo.setSex(resultSet.getString("F_SEX"));
			legalInfo.setChildName(resultSet.getString("F_CHILD_NAME"));
			legalInfo.setFatherName(resultSet.getString("F_FATHER_NAME"));
			legalInfo.setMotherName(resultSet.getString("F_MOTHER_NAME"));
			legalInfo.setBirthPlace(resultSet.getString("F_PLACE_OF_BIRTH"));
			legalInfo.setMotherContact(resultSet.getString("F_CONTACT_NO"));
			legalInfo.setHospitalName(resultSet.getString("F_HOSPITAL_NAME"));
			legalInfo.setMotherAadhaar(resultSet
					.getString("F_MOTHER_AADHAR_N0"));
			legalInfo.setInformantsName(resultSet
					.getString("F_INFORMANTS_NAME"));
			legalInfo.setInformantsAddress(resultSet
					.getString("F_INFORMANTS_ADDRESS"));

			birthReportDetails.setBirthLegalInfo(legalInfo);

			BirthReportAddress brAddress = new BirthReportAddress();
			Address birth = new Address();
			Address permanent = new Address();

			brAddress.setBirthId(resultSet.getLong("F_BR_ID"));
			birth.setAddress(resultSet.getString("F_ADDRESS"));
			birth.setCityName(resultSet.getString("F_CITY"));
			birth.setDistrict(resultSet.getString("F_DISTRICT"));
			birth.setPincode(resultSet.getString("F_PINCODE"));
			birth.setState(resultSet.getString("F_STATE"));

			permanent.setAddress(resultSet
					.getString("F_ADDRESS_PERMANENT"));
			permanent.setCityName(resultSet.getString("F_CITY_PERMANENT"));
			permanent.setDistrict(resultSet
					.getString("F_DISTRICT_PERMANENT"));
			permanent.setPincode(resultSet
					.getString("F_PINCODE_PERMANENT"));
			permanent.setState(resultSet.getString("F_STATE_PERMANENT"));
			permanent.setVillageTownCity(resultSet
					.getString("F_IS_VILLAGE_TOWN_CITY"));

			brAddress.setBirthPlaceAddress(birth);
			brAddress.setPermanentAddress(permanent);

			birthReportDetails.setBirthReportAddress(brAddress);

			BirthFamilyInfo familyInfo = new BirthFamilyInfo();

			familyInfo.setBirthId(resultSet.getLong("F_BR_ID"));
			familyInfo.setReligion(resultSet.getString("F_RELIGION"));
			familyInfo.setFatherEducation(resultSet
					.getString("F_FATHER_EDUCATION"));
			familyInfo.setMotherEducation(resultSet
					.getString("F_MOTHER_EDUCATION"));
			familyInfo.setFatherOccupation(resultSet
					.getString("F_FATHER_OCCUPATION"));
			familyInfo.setMotherOccupation(resultSet
					.getString("F_MOTHER_OCCUPATION"));
			familyInfo.setMotherAge(resultSet.getInt("F_MOTHER_AGE"));
			familyInfo.setMotherAgeAtMrg(resultSet
					.getInt("F_MOTHER_AGE_AT_MRG"));
			familyInfo.setNoOfChildren(resultSet
					.getInt("F_NO_OF_CHILDREN"));

			birthReportDetails.setBirthFamilyInfo(familyInfo);

			BirthHealthInfo bHealthInfo = new BirthHealthInfo();

			bHealthInfo.setBirthId(resultSet.getLong("F_BR_ID"));
			bHealthInfo.setAttentionAtDelivery(resultSet
					.getString("F_ATTENTION_AT_DELIVERY"));
			bHealthInfo.setDeliveryMethod(resultSet
					.getString("F_DELIVERY_METHOD"));
			bHealthInfo.setBirthWeight(resultSet
					.getInt("F_BIRTH_WEIGHT"));
			bHealthInfo.setPregnancyDuration(resultSet
					.getInt("F_PRAGNANCY_DURATION"));

			birthReportDetails.setBirthHealthInfo(bHealthInfo);

			detailsList.add(birthReportDetails);
		} while (resultSet.next());

		return detailsList;
	}

}
