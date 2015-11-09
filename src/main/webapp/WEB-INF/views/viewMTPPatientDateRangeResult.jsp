<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="<%=request.getContextPath()%>/resources/plugins/datatables/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/plugins/datatables/dataTables.bootstrap.min.js"
	type="text/javascript"></script>
<div class="panel panel-default">
	<div class="panel-heading">Patient MTP Details for searched date
		range</div>
	<div class="panel-body">
		<c:choose>
			<c:when test="${patientProfiles != null}">
				<fieldset>
					<form class="form-horizontal" method="POST" name="formEntry"
						id="formEntry">
						<div class="form-group">
							<div class="col-md-7 col-lg-7"></div>
							<div class="col-md-3 col-lg-3">
								<div class="form-group">
									<a class="btn btn-primary"
										href="/account/downLoadForm.action?fromDate=${fromDate}&toDate=${toDate}&searchType=dateRange">Download 
										Details as Excel</a>
								</div>
							</div>
						</div>
						<div class="box">
							<div class="box-body">
								<table class="table table-bordered">
									<tr>
										<th style="width: 10px">#</th>
										<th>Patient name</th>
										<th>Patient Id</th>
										<th>Age</th>
										<th>Patient Address</th>
										<th>Aadhar Number</th>
										<th>Contact Number</th>
										<th>Clinic details</th>
										<th>Weeks of pregnancy</th>
										<th>Woman details</th>
										<th>Daughter / Wife of</th>
										<th>Guardian Name</th>
										<th>Reason for termination</th>
										<th>created By</th>
										<th>created Timestamp</th>
										<th>Action</th>
									</tr>

									<c:forEach var="patientProfile" items="${patientProfiles}"
										varStatus="status">
										<tr>
											<td><span class="">${status.count}</span></td>
											<td><span class="">${patientProfile.patient.patientName}</span></td>
											<td><span class="">${patientProfile.patientID}</span></td>
											<td><span class="">${patientProfile.patient.age}</span></td>
											
											<td><span class="">${patientProfile.patient.patientAddress.address} ${patientProfile.patient.patientAddress.district}</span></td>
											<td><span class="">${patientProfile.patient.aadharNo}</span></td>
											<td><span class="">${patientProfile.patient.patientAddress.contactno}</span></td>
											<td><span class="">${patientProfile.clinicAddress.clinicName}</span></td>
											<td><span class="">${patientProfile.weeksOfPregnancy}</span></td>
											<td><span class="">Mentally ill : ${patientProfile.isMentallyIll}</span></td>
											
											<td><span class="">${patientProfile.daughterOfWifeOf}</span></td>
											<td><span class="">${patientProfile.guardianName}</span></td>
											<td><span class="">${patientProfile.reasonForTermination}</span></td>
											<td><span class="">${patientProfile.patient.createdBy}</span></td>
											<td><span class="">${patientProfile.patient.createdTimestamp}</span></td>

											<c:choose>
												<c:when
													test="${patientProfile.patient.patientStatus == 'COMPLETED'}">
													<td><span class=""><a href="/account/downLoadMTPForm.action?patientID=${patientProfile.patientID}">
													<i class="fa fa-save"></i> <span>Download Form F</span>
													</a></span></td>
												</c:when>
												<c:otherwise>
													<td>
														<a href="#" onclick="submitGetAsPost('/account/enterAbortingPatientDetails.action', '${patientProfile.patientID}', 'containerdiv');">
                    									<i class="fa fa-pencil-square-o"></i> <span>Continue</span>
                										</a>
													</td>
												</c:otherwise>
											</c:choose>

										</tr>
									</c:forEach>
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