package com.snlabs.aarogyatelangana.account.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;

import java.io.File;

public interface DownloadDao {
   
	public File downloadExcelForm(HttpServletRequest request,HttpSession session);
	public File downloadDetails(int patientID, HttpServletRequest request,HttpSession session);
	public File downloadExcelFile(HttpServletRequest request,
			HttpSession session, UserDetails userDetails, Patient patient);
	
}
