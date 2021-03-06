<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="<%=request.getContextPath()%>/resources/plugins/datatables/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/plugins/datatables/dataTables.bootstrap.min.js"
	type="text/javascript"></script>
<div class="panel panel-default">
	<div class="panel-heading">Patient Details for searched date
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
										<th>Aadhar Number</th>
										<th>Contact Number</th>
										<th>created By</th>
										<th>created Timestamp</th>
										<th>Action</th>
									</tr>

									<c:forEach var="patientProfile" items="${patientProfiles}"
										varStatus="status">
										<tr>
											<td><span class="">${status.count}</span></td>
											<td><span class="">${patientProfile.patientName}</span></td>
											<td><span class="">${patientProfile.patientID}</span></td>
											<td><span class="">${patientProfile.age}</span></td>
											<td><span class="">${patientProfile.aadharNo}</span></td>
											<td><span class="">${patientProfile.patientAddress.contactno}</span></td>
											<td><span class="">${patientProfile.createdBy}</span></td>
											<td><span class="">${patientProfile.createdTimestamp}</span></td>

											<c:choose>
												<c:when
													test="${patientProfile.patientStatus == 'COMPLETED'}">
													<td><span class=""><a href="/account/downLoadForm.action?patientID=${patientProfile.patientID}">
													<i class="fa fa-save"></i> <span>Download Form F</span>
													</a></span></td>
												</c:when>
												<c:otherwise>
													<td>
														<a href="#" onclick="submitGetAsPost('/account/enterPatientDetails.action', '${patientProfile.patientID}', 'containerdiv');">
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