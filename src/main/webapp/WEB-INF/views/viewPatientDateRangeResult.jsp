<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="panel panel-default">
	<div class="panel-heading">Patient Details for searched date range</div>
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
										href="<%=request.getContextPath()%>/downLoadForm.action">Download
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
										<th>form Id</th>
										<th>created By</th>
										<th>created Timestamp</th>
									</tr>
									
									<c:forEach var="patientProfile" items="${patientProfiles}" varStatus="status">
										<tr>
											<td><span class="">${status.count}</span></td>
											<td><span class="">${patientProfile.patientName}</span></td>
											<td><span class="">${patientProfile.patientID}</span></td>
											<td><span class="">${patientProfile.age}</span></td>
											<td><span class="">${patientProfile.aadharNo}</span></td>
											<td><span class="">${patientProfile.patientAddress.contactno}</span></td>
											<td><span class="">${patientProfile.formId}</span></td>
											<td><span class="">${patientProfile.createdBy}</span></td>
											<td><span class="">${patientProfile.createdTimestamp}</span></td>
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