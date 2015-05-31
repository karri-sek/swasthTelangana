package com.snlabs.aarogyatelangana.account.dao;

import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;

import java.util.Date;
import java.util.List;

public interface PatientDao {
    public Patient save(Patient patient);
    public int update(Patient patient);
    public Patient findByPatientName(String patient);
    public boolean delete(Patient patient);
    public Patient findByPatientId(Patient patient);
    public Patient searchPatientById(int patientId, UserDetails userDetails);
    public Patient searchPatientByName(String patientName, UserDetails userDetails);
    public List<Patient> searchPatientProfilesByCreator(UserDetails userDetails);
    public List<Patient> listPatientProfilesByDate(Date fromDate, Date toDate, UserDetails userDetails);

}