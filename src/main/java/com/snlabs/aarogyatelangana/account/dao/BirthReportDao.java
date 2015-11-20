/**
 * 
 */
package com.snlabs.aarogyatelangana.account.dao;

import java.util.List;

import com.snlabs.aarogyatelangana.account.beans.BirthFamilyInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthHealthInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthLegalInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthReportAddress;
import com.snlabs.aarogyatelangana.account.beans.BirthReportDetails;
import com.snlabs.aarogyatelangana.account.beans.BirthReportSearchBean;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;

/**
 * @author nbattula
 *
 */
public interface BirthReportDao {

	BirthLegalInfo searchBirthReportLegalInfo(BirthLegalInfo birthLegalInfo,
			UserDetails userDetails, String searchType);

	BirthLegalInfo updateBirthReportLegalInfo(BirthLegalInfo birthLegalInfo);

	BirthLegalInfo saveBirthReportLegalInfo(BirthLegalInfo birthLegalInfo);

	BirthReportAddress searchBirthReportAddress(BirthLegalInfo birthLegalInfo,
			UserDetails userDetails, String searchType);

	BirthReportAddress saveBirthReportAdress(
			BirthReportAddress birthReportAddress);

	BirthReportAddress updateBirthReportAddress(
			BirthReportAddress birthReportAddress);

	BirthFamilyInfo searchBirthReportFamilyInfo(
			BirthFamilyInfo birthFamilyInfo, UserDetails userDetails,
			String searchType);

	BirthFamilyInfo updateBirthFamilyInfo(BirthFamilyInfo birthFamilyInfo);

	BirthFamilyInfo saveBirthFamilyInfo(BirthFamilyInfo birthFamilyInfo);

	BirthHealthInfo updateBirthHealthInfo(BirthHealthInfo birthHealthInfo);

	BirthHealthInfo saveBirthHealthInfo(BirthHealthInfo birthHealthInfo);

	BirthHealthInfo searchBirthHealthInfo(BirthFamilyInfo birthFamilyInfo,
			UserDetails userDetails, String searchType);

	BirthReportDetails searchBirthReportDetails(
			BirthReportSearchBean birthReportSearchBean,
			UserDetails userDetails, String searchType);

	List<BirthReportDetails> listBirthReportsByDate(
			BirthReportSearchBean birthReportSearchBean, UserDetails userDetails);
}
