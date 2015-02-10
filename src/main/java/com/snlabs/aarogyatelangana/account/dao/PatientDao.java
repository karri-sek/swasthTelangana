package com.snlabs.aarogyatelangana.account.dao;

import com.snlabs.aarogyatelangana.account.beans.Patient;

import java.util.Date;
import java.util.List;

public interface PatientDao {
     public Patient save(Patient patient);
     public int update(Patient patient);
     public Patient findByPatientName(String patient);
     public boolean delete(Patient patient);
     public Patient findByPatientId(Patient patient);
	 public Patient searchPatientById(int patientId);
	 public Patient searchPatientByName(String patientName);
	 public List<Patient> searchPatientProfilesByCreator(String createdBY);
    public List<Patient> listPatientProfilesByDate(Date fromDate, Date toDate, String createdBY);

}
