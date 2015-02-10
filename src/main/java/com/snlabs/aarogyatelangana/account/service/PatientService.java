package com.snlabs.aarogyatelangana.account.service;

import com.snlabs.aarogyatelangana.account.beans.Patient;

import java.util.List;
import java.util.Date;

public interface PatientService {
    //Insert patient details into the DB and returns the patient ID
    public Patient createPatientRecord(Patient patient);

    public Patient searchPatientById(int patientId);

    public Patient searchPatientByName(String patientName);

    public List<Patient> getPatientProfiles(String createdBy);

    public List<Patient> getPatientProfilesByDate(Date fromDate, Date tillDate, String createdBy);
}
