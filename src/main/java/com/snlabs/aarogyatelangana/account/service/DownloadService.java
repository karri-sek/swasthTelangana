package com.snlabs.aarogyatelangana.account.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

public interface DownloadService {
     
	public File downloadForm(int patientID, HttpServletRequest request,HttpSession session);
}
