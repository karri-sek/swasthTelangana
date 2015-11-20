<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="box box-info" id="downloadMTPDiv">
	<div class="box-header with-border">
		<h3 class="box-title">Birth report</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	<form class="form-horizontal" method="POST" name="brDownload"
		id="brDownload" modelAttribute="declaration">
		&nbsp; Birth report has been saved successfully <a href="#"
			onclick="submitForm('/account/birthSearchReport.action', 'mtpDownload', 'searchResultdiv');"><b>Download</b></a>
		<input name="birthId" type="hidden" value="${birthReport.birthId}" />
		<input type="hidden"
			id="searchType" name="searchType" value="ID" />
	</form>
</div>
<div id="searchResultdiv">
</div>