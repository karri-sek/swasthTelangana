package com.snlabs.aarogyatelangana.account.controller;

import com.snlabs.aarogyatelangana.account.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class DownloadController {

	@Autowired
	DownloadService downloadService;

	private static final int BUFFER_SIZE = 4096;



	@RequestMapping(value = { "downLoadForm.action" })
	public void downLoadReport(HttpServletRequest request, HttpSession session,
			HttpServletResponse response, ModelMap map) {
		//File downloadFile = downloadService.downloadForm(request, session);
		//downloadFile(downloadFile);
	}

	public DownloadService getDownloadService() {
		return downloadService;
	}

	public void setDownloadService(DownloadService downloadService) {
		this.downloadService = downloadService;
	}
}
