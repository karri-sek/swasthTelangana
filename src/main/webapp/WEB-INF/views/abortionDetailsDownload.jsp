<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="box box-info" id="downloadMTPDiv">
	<div class="box-header with-border">
		<h3 class="box-title">Abortion details</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	<form class="form-horizontal" method="POST" name="mtpDownload"
		id="mtpDownload" modelAttribute="declaration">
		&nbsp; MTP has been saved successfully <a href="#"
			onclick="submitForm('/account/mtpPatientSearchReport.action', 'mtpDownload', 'searchResultdiv');"><b>Download</b></a>
		<input name="patientID" type="hidden" value="${mtpDetails.patientID}" />
		<input type="hidden"
			id="searchType" name="searchType" value="ID" />
	</form>
</div>
<div id="searchResultdiv">
</div>