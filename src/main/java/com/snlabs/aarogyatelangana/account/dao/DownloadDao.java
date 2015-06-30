package com.snlabs.aarogyatelangana.account.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

public interface DownloadDao {
   
	public File downloadExcelForm(HttpServletRequest request,HttpSession session);
	public File downloadExcelPatient(HttpServletRequest request,HttpSession session);
	public File downloadDetails(int patientID, HttpServletRequest request,HttpSession session);
	
}
