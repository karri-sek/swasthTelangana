package com.snlabs.aarogyatelangana.account.service.impl;

import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.dao.PatientDao;
import com.snlabs.aarogyatelangana.account.service.PatientService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PatientServiceImpl implements PatientService {

    PatientDao patientDao;

    public static HashMap<String, String> patientSessionMap = new HashMap<String, String>();

    @Override
    public Patient createPatientRecord(Patient patient) {
        try {
            if (patient.getPatientID() > 0 && patientDao.update(patient) > 0) {
                return patient;
            } else {
                patient.setPatientID(new Random().nextInt(9999 - 1000) + 1000);
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
    public Patient searchPatientById(int patientId, UserDetails userDetails) {
        return patientDao.searchPatientById(patientId, userDetails);
    }

    @Override
    public Patient searchPatientByName(String patientName, UserDetails userDetails) {
        return patientDao.searchPatientByName(patientName, userDetails);
    }

    public static HashMap<String, String> getPatientSessionMap() {
        return patientSessionMap;
    }

    public static void setPatientSessionMap(
            HashMap<String, String> patientSessionMap) {
        PatientServiceImpl.patientSessionMap = patientSessionMap;
    }

    @Override
    public List<Patient> getPatientProfiles(UserDetails userDetails) {
        return patientDao.searchPatientProfilesByCreator(userDetails);
    }

    @Override
    public List<Patient> getPatientProfilesByDate(Date fromDate, Date toDate, UserDetails userDetails) {
        return patientDao.listPatientProfilesByDate(fromDate, toDate, userDetails);
    }

}