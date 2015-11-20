<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="<%=request.getContextPath()%>/resources/plugins/datatables/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/plugins/datatables/dataTables.bootstrap.min.js"
	type="text/javascript"></script>
<div class="panel panel-default">
	<div class="panel-heading">Birth report Details</div>
	<div class="panel-body">
		<c:choose>
			<c:when test="${birthReportDetails != null}">
				<fieldset>
					<form class="form-horizontal" method="POST" name="formEntry"
						id="formEntry">
						<div id="buttonGroupId" class="form-group">
							<div class="col-md-7 col-lg-7"></div>
							<div class="col-md-3 col-lg-3">
								<div class="form-group">
									<a class="btn btn-primary" href="#"
										onclick="printPatientPage();"> <i class="fa fa-print"></i> Print this page</a>
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
										<td>Date of Birth</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthLegalInfo.dateOfBirth}</span></td>
									</tr>
									<tr>
										<td>2.</td>
										<td>Sex</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthLegalInfo.sex}</span></td>
									</tr>
									<tr>
										<td>3.</td>
										<td>Name of the Child, If any</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthLegalInfo.childName}</span></td>
									</tr>
									<tr>
										<td>4.</td>
										<td>Name of the father</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthLegalInfo.fatherName}
										</span></td>
									</tr>
									<tr>
										<td>5.</td>
										<td>Name of the mother</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthLegalInfo.motherName}</span></td>
									</tr>
									<tr>
										<td>6.</td>
										<td>Mother Aadhaar number</td>
										<td><span class="badge bg-light-blue">
												${birthReportDetails.birthLegalInfo.motherAadhaar}</span></td>
									</tr>
									<tr>
										<td>7.</td>
										<td>Mother Contact number</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthLegalInfo.motherContact}
										</span></td>
									</tr>
									<tr>
										<td>8.</td>
										<td>Place of birth</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthLegalInfo.birthPlace}</span></td>
									</tr>
									<tr>
										<td>9.</td>
										<td>Hospital name</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthLegalInfo.hospitalName}</span></td>
									</tr>
									<tr>
										<td>10.</td>
										<td>Informant's Name</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthLegalInfo.informantsName}</span></td>
									</tr>
									<tr>
										<td>11.</td>
										<td>Informant's Address</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthLegalInfo.informantsAddress}</span></td>
									</tr>
									<!-- Address -->
									<tr>
										<td>12.</td>
										<td>Birth address</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthReportAddress.birthPlaceAddress.cityName}
												<br> ${birthReportDetails.birthReportAddress.birthPlaceAddress.address} <br>
												${birthReportDetails.birthReportAddress.birthPlaceAddress.district} <br>
												${birthReportDetails.birthReportAddress.birthPlaceAddress.state} <br>
												${birthReportDetails.birthReportAddress.birthPlaceAddress.pincode}
										</span></td>
									</tr>

									<tr>
										<td>13.</td>
										<td>Permanent address / Residence of the Mother</td>
										<td><span class="badge bg-light-blue">Place of
												birth :
												${birthReportDetails.birthReportAddress.permanentAddress.villageTownCity} <br>
												${birthReportDetails.birthReportAddress.permanentAddress.cityName} <br>
												${birthReportDetails.birthReportAddress.permanentAddress.address} <br>
												${birthReportDetails.birthReportAddress.permanentAddress.district} <br>
												${birthReportDetails.birthReportAddress.permanentAddress.state} <br>
												${birthReportDetails.birthReportAddress.permanentAddress.pincode}
										</span></td>
									</tr>
									<tr>
										<td>14.</td>
										<td>Religion of the Family</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthFamilyInfo.religion}</span></td>
									</tr>
									<tr>
										<td>15.</td>
										<td>Father's level of education</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthFamilyInfo.fatherEducation}</span></td>
									</tr>
									<tr>
										<td>16.</td>
										<td>Mother's Level of education</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthFamilyInfo.motherEducation}</span></td>
									</tr>
									<tr>
										<td>17.</td>
										<td>Father's Occupation</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthFamilyInfo.fatherOccupation}</span></td>
									</tr>
									<tr>
										<td>18.</td>
										<td>Mother's Occupation</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthFamilyInfo.motherOccupation}</span></td>
									</tr>
									<tr>
										<td>19.</td>
										<td>Age of the mother at the time of marriage</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthFamilyInfo.motherAgeAtMrg}</span></td>
									</tr>
									<tr>
										<td>20.</td>
										<td>Age of the mother at the time of this birth</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthFamilyInfo.motherAge}</span></td>
									</tr>
									<tr>
										<td>21.</td>
										<td>Number of children</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthFamilyInfo.noOfChildren}</span></td>
									</tr>
									<!-- Health info -->
									<tr>
										<td>22.</td>
										<td>Type of attention at delivery</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthHealthInfo.attentionAtDelivery}</span></td>
									</tr>
									<tr>
										<td>23.</td>
										<td>Method of Delivery</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthHealthInfo.deliveryMethod}</span></td>
									</tr>
									<tr>
										<td>24.</td>
										<td>Birth Weight</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthHealthInfo.birthWeight}</span></td>
									</tr>
									<tr>
										<td>25.</td>
										<td>Duration of Pregnancy</td>
										<td><span class="badge bg-light-blue">${birthReportDetails.birthHealthInfo.pregnancyDuration}</span></td>
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