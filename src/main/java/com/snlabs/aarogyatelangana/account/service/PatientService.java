package com.snlabs.aarogyatelangana.account.service;

import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.beans.Form;

import java.util.List;
import java.util.Date;

public interface PatientService {
    //Insert patient details into the DB and returns the patient ID
    public Patient createPatientRecord(Patient patient);

    public Patient searchPatientById(int patientId, UserDetails userDetails);

    public List<Patient> getPatientProfiles(UserDetails userDetails, Form form);

    public List<Patient> getPatientProfilesByDate(Date fromDate, Date tillDate, UserDetails userDetails);

	Patient searchPatient(Patient pat, UserDetails userDetails,
			String searchType);
}