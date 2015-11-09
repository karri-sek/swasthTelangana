/**
 * 
 */
package com.snlabs.aarogyatelangana.account.dao;

import java.util.Date;
import java.util.List;

import com.snlabs.aarogyatelangana.account.beans.ClinicAddress;
import com.snlabs.aarogyatelangana.account.beans.Form;
import com.snlabs.aarogyatelangana.account.beans.MTPDetails;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.SectionA;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;

/**
 * @author nbattula
 *
 */
public interface MTPDao {
	 public Patient save(Patient patient);
	    public int update(Patient patient);
	    public Patient findByPatientName(String patient);
	    public boolean delete(Patient patient);
	    public Patient findByPatientId(Patient patient);
	    public Patient searchPatientById(Patient patient, UserDetails userDetails);
	    public Patient searchPatientByName(String patientName, UserDetails userDetails);
	    public List<MTPDetails> searchPatientProfilesByCreator(UserDetails userDetails, Form form);
	    public List<Patient> listPatientProfilesByDate(Date fromDate, Date toDate, UserDetails userDetails);
	    public MTPDetails searchPatient(Patient pat, UserDetails userDetails,
				String searchType);
		ClinicAddress getClinicDetails(long patientID);
		public ClinicAddress saveClinicDetails(ClinicAddress clinicAddress);
		public MTPDetails getMtpOtherDetails(long patientID);
		public MTPDetails saveAbortionDetails(MTPDetails mtpDetails);
}
