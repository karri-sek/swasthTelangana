/**
 * 
 */
package com.snlabs.aarogyatelangana.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.snlabs.aarogyatelangana.account.beans.BirthFamilyInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthHealthInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthLegalInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthReportAddress;
import com.snlabs.aarogyatelangana.account.beans.BirthReportDetails;
import com.snlabs.aarogyatelangana.account.beans.BirthReportSearchBean;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.dao.BirthReportDao;
import com.snlabs.aarogyatelangana.account.service.BirthReportService;


/**
 * @author nbattula
 *
 */
public class BirthReportServiceImpl implements BirthReportService  {
	@Autowired
	public BirthReportDao birthReportDao;
	
	public BirthReportDao getBirthReportDao() {
		return birthReportDao;
	}

	public void setBirthReportDao(BirthReportDao birthReportDao) {
		this.birthReportDao = birthReportDao;
	}
	
	@Override
	public BirthLegalInfo searchBirthReportLegalInfo(
			BirthLegalInfo birthLegalInfo, UserDetails userDetails,
			String searchType) {
		// TODO Auto-generated method stub
		return birthReportDao.searchBirthReportLegalInfo(birthLegalInfo, userDetails, searchType);
	}

	@Override
	public BirthLegalInfo createBirthReportLegalInfo(
			BirthLegalInfo birthLegalInfo) {
		// TODO Auto-generated method stub
		
		try {
            if (birthLegalInfo.getBirthId() > 0 && "UPDATE".equals(birthLegalInfo.getOperation())) {
                return birthReportDao.updateBirthReportLegalInfo(birthLegalInfo);
            } else {
                return birthReportDao.saveBirthReportLegalInfo(birthLegalInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return null;
	}

	@Override
	public BirthReportAddress getBirthReportAddress(
			BirthLegalInfo birthLegalInfo, UserDetails userDetails, String searchType) {
		// TODO Auto-generated method stub
		
		return birthReportDao.searchBirthReportAddress(birthLegalInfo, userDetails, searchType);
	}

	@Override
	public BirthReportAddress createBirthReportAddress(
			BirthReportAddress birthReportAddress) {
		try {
            if (birthReportAddress.getBirthId() > 0 && "UPDATE".equals(birthReportAddress.getOperation())) {
            	//birthReportDao.updateBirthReportAddress(birthReportAddress);
                return birthReportDao.updateBirthReportAddress(birthReportAddress);
            } else {
                return birthReportDao.saveBirthReportAdress(birthReportAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public BirthFamilyInfo getBirthFamilyInfo(
			BirthReportAddress birthReportAddress, UserDetails userDetails,
			String searchType) {
		// TODO Auto-generated method stub
		BirthFamilyInfo birthFamilyInfo = new BirthFamilyInfo();
		birthFamilyInfo.setBirthId(birthReportAddress.getBirthId());
		return birthReportDao.searchBirthReportFamilyInfo(birthFamilyInfo, userDetails, searchType);
	}

	@Override
	public BirthFamilyInfo searchBirthReportFamilyInfo(
			BirthFamilyInfo birthFamilyInfo, UserDetails userDetails,
			String searchType) {
		// TODO Auto-generated method stub
		return birthReportDao.searchBirthReportFamilyInfo(birthFamilyInfo, userDetails, searchType);
	}

	@Override
	public BirthFamilyInfo createBirthFamilyInfo(BirthFamilyInfo birthFamilyInfo) {
		try {
            if (birthFamilyInfo.getBirthId() > 0 && "UPDATE".equals(birthFamilyInfo.getOperation())) {
            	//birthReportDao.updateBirthReportAddress(birthReportAddress);
                return birthReportDao.updateBirthFamilyInfo(birthFamilyInfo);
            } else {
                return birthReportDao.saveBirthFamilyInfo(birthFamilyInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public BirthHealthInfo createBirthHealthInfo(BirthHealthInfo birthHealthInfo) {
		// TODO Auto-generated method stub
		try {
            if (birthHealthInfo.getBirthId() > 0 && "UPDATE".equals(birthHealthInfo.getOperation())) {
            	//birthReportDao.updateBirthReportAddress(birthReportAddress);
                return birthReportDao.updateBirthHealthInfo(birthHealthInfo);
            } else {
                return birthReportDao.saveBirthHealthInfo(birthHealthInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public BirthHealthInfo getBirthHealthInfo(BirthFamilyInfo birthFamilyInfo,
			UserDetails userDetails, String searchType) {
		// TODO Auto-generated method stub
		return birthReportDao.searchBirthHealthInfo(birthFamilyInfo, userDetails, searchType);
	}

	@Override
	public BirthReportDetails searchBirthReportDetails(
			BirthReportSearchBean birthReportSearchBean,
			UserDetails userDetails, String searchType) {
		// TODO Auto-generated method stub
		return birthReportDao.searchBirthReportDetails(birthReportSearchBean, userDetails, searchType);
	}

	@Override
	public List<BirthReportDetails> listBirthReportsByDate(
			UserDetails userDetails, BirthReportSearchBean birthReportSearchBean) {
		// TODO Auto-generated method stub
		return birthReportDao.listBirthReportsByDate(birthReportSearchBean, userDetails);
	}

}
