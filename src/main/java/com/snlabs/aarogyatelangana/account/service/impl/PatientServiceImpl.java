package com.snlabs.aarogyatelangana.account.service.impl;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.snlabs.aarogyatelangana.account.beans.Form;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.dao.DownloadDao;
import com.snlabs.aarogyatelangana.account.dao.PatientDao;
import com.snlabs.aarogyatelangana.account.service.PatientService;

public class PatientServiceImpl implements PatientService {

    PatientDao patientDao;
    
    @Autowired
    DownloadDao downloadDao;

    public static HashMap<String, String> patientSessionMap = new HashMap<String, String>();

    @Override
    public Patient createPatientRecord(Patient patient) {
        try {
            if (patient.getPatientID() > 0 && "UPDATE".equals(patient.getOperation())) {
            	patientDao.update(patient);
                return patient;
            } else {
                return patientDao.save(patient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }

    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public Patient searchPatientById(long patientId, UserDetails userDetails) {
        return patientDao.searchPatientById(patientId, userDetails);
    }   
    public static HashMap<String, String> getPatientSessionMap() {
        return patientSessionMap;
    }

    public static void setPatientSessionMap(
            HashMap<String, String> patientSessionMap) {
        PatientServiceImpl.patientSessionMap = patientSessionMap;
    }

    @Override
    public List<Patient> getPatientProfiles(UserDetails userDetails, Form form) {
        return patientDao.searchPatientProfilesByCreator(userDetails, form);
    }

    @Override
    public List<Patient> getPatientProfilesByDate(Date fromDate, Date toDate, UserDetails userDetails) {
        return patientDao.listPatientProfilesByDate(fromDate, toDate, userDetails);
    }

	@Override
	public Patient searchPatient(Patient pat, UserDetails userDetails,
			String searchType) {
		return patientDao.searchPatient(pat, userDetails, searchType);
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

}