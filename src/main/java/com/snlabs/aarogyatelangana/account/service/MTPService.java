package com.snlabs.aarogyatelangana.account.service;

import com.snlabs.aarogyatelangana.account.beans.ClinicAddress;
import com.snlabs.aarogyatelangana.account.beans.MTPDetails;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.SectionA;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.beans.Form;

import java.io.File;
import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface MTPService {
    //Insert patient details into the DB and returns the patient ID
    public Patient createPatientRecord(Patient patient);

    public Patient searchPatientById(Patient patient, UserDetails userDetails);

    public List<MTPDetails> getPatientProfiles(UserDetails userDetails, Form form);

    public List<Patient> getPatientProfilesByDate(Date fromDate, Date tillDate, UserDetails userDetails);

    public MTPDetails searchPatient(Patient pat, UserDetails userDetails,
			String searchType);

	public File prepareExcelreport(HttpServletRequest request,
			HttpSession session, UserDetails userDetails, Patient patient);

	public ClinicAddress getClinicDetails(long patientID);

	public ClinicAddress saveClinicDetails(ClinicAddress clinicAddress);

	public MTPDetails getMtpOtherDetails(long patientID);

	public MTPDetails saveAbortionDetails(MTPDetails mtpDetails);
}