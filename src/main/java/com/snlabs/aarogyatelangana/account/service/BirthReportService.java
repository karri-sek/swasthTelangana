/**
 * 
 */
package com.snlabs.aarogyatelangana.account.service;

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
public interface BirthReportService {

	BirthLegalInfo createBirthReportLegalInfo(BirthLegalInfo birthLegalInfo);

	BirthLegalInfo searchBirthReportLegalInfo(BirthLegalInfo birthLegalInfo,
			UserDetails userDetails, String searchType);

	BirthReportAddress getBirthReportAddress(BirthLegalInfo birthLegalInfo, UserDetails userDetails, String searchType);

	BirthReportAddress createBirthReportAddress(
			BirthReportAddress birthReportAddress);

	BirthFamilyInfo getBirthFamilyInfo(BirthReportAddress birthReportAddress,
			UserDetails userDetails, String string);

	BirthFamilyInfo searchBirthReportFamilyInfo(
			BirthFamilyInfo birthFamilyInfo, UserDetails userDetails,
			String searchType);

	BirthFamilyInfo createBirthFamilyInfo(BirthFamilyInfo birthFamilyInfo);

	BirthHealthInfo createBirthHealthInfo(BirthHealthInfo birthHealthInfo);

	BirthHealthInfo getBirthHealthInfo(BirthFamilyInfo birthFamilyInfo,
			UserDetails userDetails, String searchType);

	BirthReportDetails searchBirthReportDetails(
			BirthReportSearchBean birthReportSearchBean,
			UserDetails userDetails, String searchType);

	List<BirthReportDetails> listBirthReportsByDate(UserDetails userDetails,
			BirthReportSearchBean birthReportSearchBean);
}
