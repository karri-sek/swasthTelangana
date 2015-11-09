package com.snlabs.aarogyatelangana.account.service.impl;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.snlabs.aarogyatelangana.account.beans.ClinicAddress;
import com.snlabs.aarogyatelangana.account.beans.Form;
import com.snlabs.aarogyatelangana.account.beans.MTPDetails;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.SectionA;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.dao.DownloadDao;
import com.snlabs.aarogyatelangana.account.dao.MTPDao;
import com.snlabs.aarogyatelangana.account.dao.PatientDao;
import com.snlabs.aarogyatelangana.account.service.MTPService;
import com.snlabs.aarogyatelangana.account.service.PatientService;

public class MTPServiceImpl implements MTPService {
	
	@Autowired
    MTPDao mtpDao;
    
    @Autowired
    DownloadDao downloadDao;

    public static HashMap<String, String> patientSessionMap = new HashMap<String, String>();

    @Override
    public Patient createPatientRecord(Patient patient) {
        try {
            if (patient.getPatientID() > 0 && "UPDATE".equals(patient.getOperation())) {
            	mtpDao.update(patient);
                return patient;
            } else {
                return mtpDao.save(patient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
	public MTPDao getMtpDao() {
		return mtpDao;
	}
	
	public void setMtpDao(MTPDao mtpDao) {
		this.mtpDao = mtpDao;
	}

	@Override
    public Patient searchPatientById(Patient patient, UserDetails userDetails) {
        return mtpDao.searchPatientById(patient, userDetails);
    }   
    public static HashMap<String, String> getPatientSessionMap() {
        return patientSessionMap;
    }

    public static void setPatientSessionMap(
            HashMap<String, String> patientSessionMap) {
        MTPServiceImpl.patientSessionMap = patientSessionMap;
    }

    @Override
    public List<MTPDetails> getPatientProfiles(UserDetails userDetails, Form form) {
        return mtpDao.searchPatientProfilesByCreator(userDetails, form);
    }

    @Override
    public List<Patient> getPatientProfilesByDate(Date fromDate, Date toDate, UserDetails userDetails) {
        return mtpDao.listPatientProfilesByDate(fromDate, toDate, userDetails);
    }

	@Override
	public MTPDetails searchPatient(Patient pat, UserDetails userDetails,
			String searchType) {
		return mtpDao.searchPatient(pat, userDetails, searchType);
	}

	@Override
	public File prepareExcelreport(HttpServletRequest request,
			HttpSession session, UserDetails userDetails, Patient patient) {
		return downloadDao.downloadExcelFile(request,session, userDetails, patient);
	}

	public DownloadDao getDownloadDao() {
		return downloadDao;
	}

	public void setDownloadDao(DownloadDao downloadDao) {
		this.downloadDao = downloadDao;
	}

	@Override
	public ClinicAddress getClinicDetails(long patientID) {
		// TODO Auto-generated method stub
		return mtpDao.getClinicDetails(patientID);
	}

	@Override
	public ClinicAddress saveClinicDetails(ClinicAddress clinicAddress) {
		// TODO Auto-generated method stub
		return mtpDao.saveClinicDetails(clinicAddress);
	}

	@Override
	public MTPDetails getMtpOtherDetails(long patientID) {
		// TODO Auto-generated method stub
		return mtpDao.getMtpOtherDetails(patientID);
	}

	@Override
	public MTPDetails saveAbortionDetails(MTPDetails mtpDetails) {
		// TODO Auto-generated method stub
		return mtpDao.saveAbortionDetails(mtpDetails);
	}
}