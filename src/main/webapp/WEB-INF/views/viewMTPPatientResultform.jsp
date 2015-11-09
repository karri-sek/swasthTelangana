<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="<%=request.getContextPath()%>/resources/plugins/datatables/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/plugins/datatables/dataTables.bootstrap.min.js"
	type="text/javascript"></script>
<div class="panel panel-default">
	<div class="panel-heading">MTP Patient Details</div>
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
									<a class="btn btn-primary" href="#"
										onclick="printPatientPage();">Print this page</a>
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
										<td><span class="badge bg-light-blue">${form.patient.patientName}</span></td>
									</tr>
									<tr>
										<td>2.</td>
										<td>Patient Id</td>
										<td><span class="badge bg-light-blue">${form.patientID}</span></td>
									</tr>
									<tr>
										<td>3.</td>
										<td>Age</td>
										<td><span class="badge bg-light-blue">${form.patient.age}</span></td>
									</tr>
									<tr>
										<td>4.</td>
										<td>Patient Address</td>
										<td><span class="badge bg-light-blue">${form.patient.patientAddress.address}
												<br> ${form.patient.patientAddress.district} <br>
												${form.patient.patientAddress.state} <br>
										</span></td>
									</tr>
									<tr>
										<td>5.</td>
										<td>Aadhaar Number</td>
										<td><span class="badge bg-light-blue">${form.patient.aadharNo}</span></td>
									</tr>
									<tr>
										<td>6.</td>
										<td>Contact Number</td>
										<td><span class="badge bg-light-blue">
												${form.patient.patientAddress.contactno}</span></td>
									</tr>
									<tr>
										<td>7.</td>
										<td>Clinic details</td>
										<td><span class="badge bg-light-blue">${form.clinicAddress.clinicName}<br>
												${form.clinicAddress.address}<br>
												${form.clinicAddress.district}<br>
												${form.clinicAddress.state}<br>
												${form.clinicAddress.contactNum}
										</span></td>
									</tr>
									<tr>
										<td>8.</td>
										<td>Weeks of pregnancy</td>
										<td><span class="badge bg-light-blue">${form.weeksOfPregnancy}</span></td>
									</tr>
									<tr>
										<td>9.</td>
										<td>Woman details</td>
										<td><span class="badge bg-light-blue"> Mentally
												ill: ${form.isMentallyIll}&nbsp; Minor:
												${form.isMinor}&nbsp; Married : ${form.isMarried}</span></td>
									</tr>
									<tr>
										<td>10.</td>
										<td>Daughter / Wife of</td>
										<td><span class="badge bg-light-blue">${form.daughterOfWifeOf}</span></td>
									</tr>
									<tr>
										<td>11.</td>
										<td>Guardian Name</td>
										<td><span class="badge bg-light-blue">${form.guardianName}</span></td>
									</tr>
									<tr>
										<td>12.</td>
										<td>Reason for termination</td>
										<td><span class="badge bg-light-blue">${form.reasonForTermination}</span></td>
									</tr>

									<tr>
										<td>13.</td>
										<td>Created By</td>
										<td><span class="badge bg-light-blue">${form.patient.createdBy}</span></td>
									</tr>
									<tr>
										<td>14.</td>
										<td>Created Timestamp</td>
										<td><span class="badge bg-light-blue">${form.patient.createdTimestamp}</span></td>
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