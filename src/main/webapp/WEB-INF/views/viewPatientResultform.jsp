<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="<%=request.getContextPath()%>/resources/plugins/datatables/jquery.dataTables.min.js"
        type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/plugins/datatables/dataTables.bootstrap.min.js"
        type="text/javascript"></script>
<div class="panel panel-default">
	<div class="panel-heading">Patient Details</div>
	<div class="panel-body">
		<c:choose>
			<c:when test="${form != null}">
				<fieldset>
					<form class="form-horizontal" method="POST" name="formEntry"
						id="formEntry">
						<div id="buttonGroupId" class="form-group">
							<div class="col-md-7 col-lg-7"></div>
							<div class="col-md-3 col-lg-3">
								<div class="form-group">
									<a class="btn btn-primary"
										href="/account/downLoadForm.action?patientID=${form.patientID}">Download
										Details as Excel</a>
									<a class="btn btn-primary"
										href="#" onclick="printPatientPage();">Print this page</a>
								</div>
							</div>
						</div>
						<div class="box">
							<div class="box-body">
	  							<table class="table table-bordered">
									<tr>
										<th style="width: 10px">#</th>
										<th>Property</th>
										<th>Value</th>
									</tr>
									<tr>
										<td>1.</td>
										<td>Patient name</td>
										<td><span class="badge bg-light-blue">${form.patientName}</span></td>
									</tr>
									<tr>
										<td>2.</td>
										<td>Patient Id</td>
										<td><span class="badge bg-light-blue">${form.patientID}</span></td>
									</tr>
									<tr>
										<td>3.</td>
										<td>Age</td>
										<td><span class="badge bg-light-blue">${form.age}</span></td>
									</tr>
									<tr>
										<td>4.</td>
										<td>Patient Address</td>
										<td><span class="badge bg-light-blue">${form.patientAddress.address}</span></td>
									</tr>
									<tr>
										<td>5.</td>
										<td>Aadhar Number</td>
										<td><span class="badge bg-light-blue">${form.aadharNo}</span></td>
									</tr>
									<tr>
										<td>6.</td>
										<td>Contact Number</td>
										<td><span class="badge bg-light-blue">${form.patientAddress.contactno}</span></td>
									</tr>
									<tr>
										<td>7.</td>
										<td>form Id</td>
										<td><span class="badge bg-light-blue">${form.formId}</span></td>
									</tr>
									<tr>
										<td>8.</td>
										<td>created By</td>
										<td><span class="badge bg-light-blue">${form.createdBy}</span></td>
									</tr>
									<tr>
										<td>9.</td>
										<td>created Timestamp</td>
										<td><span class="badge bg-light-blue">${form.createdTimestamp}</span></td>
									</tr>
								</table>
							</div>
						</div>
					</form>
				</fieldset>
			</c:when>
			<c:otherwise>
				<fieldset>Ooops, No results found for your search.</fieldset>
			</c:otherwise>
		</c:choose>
	</div>
</div>