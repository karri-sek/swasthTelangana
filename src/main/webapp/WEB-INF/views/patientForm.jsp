<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Horizontal Form -->
<form class="form-horizontal" method="POST" id="patientDetails"
	name="patientDetails">
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Patient Details</h3>
		</div>
		<c:if test="${error != null}">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
		<div class="box-body">
			<div class="form-group mandatory">
				<label for="inputEmail3" class="col-sm-2 control-label">Patient
					Name</label>

				<div class="col-sm-5">
					<input type="text" class="form-control required"
						placeholder="Enter Patient Name" name="patientName"
						id="patientName" value="${patient.patientName}" />
				</div>
			</div>
			<div class="form-group mandatory">
				<label for="inputPassword3" class="col-sm-2 control-label">Aadhar
					No</label>

				<div class="col-sm-5">
					<input type="text" class="form-control required aadhaarNumber"
						placeholder="Enter Aadhar" name="aadharNo" id="aadharNo"
						value="${patient.aadharNo}" />
				</div>
			</div>
			<div class="form-group mandatory">
				<label for="inputPassword3" class="col-sm-2 control-label">Contact
					No</label>

				<div class="col-sm-5">
					<input type="text" class="form-control required onlyMobileNum"
						placeholder="Enter contact No"
						id="patient.patientAddress.contactno"
						name="patient.patientAddress.contactno"
						value="${patient.patientAddress.contactno}" />
				</div>
			</div>
			<!-- select -->
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Age</label>

				<div class="col-sm-2">
					<select class="form-control" name="age" id="age">
						<c:forEach var="i" begin="20" end="50">
							<option value='${i}' ${patient.age == i ? 'selected' : ''}>
								<c:out value="${i}" />
							</option>
						</c:forEach>
					</select>
				</div>
				<label for="inputPassword3" class="col-sm-1 control-label">Gender</label>

				<div class="col-sm-2">
					<select class="form-control" name="gender" id="gender">
						<option value="female"
							${patient.gender == 'female' ? 'selected' : ''}>Female</option>
						<option value="male" ${patient.gender == 'male' ? 'selected' : ''}>male</option>
					</select>
				</div>
			</div>
		</div>
		<!-- /.box-body -->
	</div>

	<!-- Permanent Address Box-->
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Permanent address</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<div class="form-group mandatory">
				<label for="inputEmail3" class="col-sm-2 control-label">City/Village
					Name</label>

				<div class="col-sm-5">
					<input type="text" class="form-control required"
						placeholder="Enter City Name ..."
						name="patient.patientAddress.cityName"
						id="patient.patientAddress.cityName"
						value="${patient.patientAddress.cityName}" />
				</div>
			</div>
			<div class="form-group mandatory">
				<label for="inputPassword3" class="col-sm-2 control-label">Address</label>

				<div class="col-sm-5">
					<input type="text" class="form-control required"
						placeholder="Permanent Address ...."
						name="patient.patientAddress.address"
						id="patient.patientAddress.address"
						value="${patient.patientAddress.address}" />
				</div>
			</div>
			<!-- select -->
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">District</label>

				<div class="col-sm-2">
					<select class="form-control" id="patient.patientAddress.district"
						name="patient.patientAddress.district">
						<option value="Hyderabad"
							${patient.patientAddress.district == 'Hyderabad' ? 'selected' : ''}>Hyderabad</option>
						<option value="Rangareddy"
							${patient.patientAddress.district == 'Rangareddy' ? 'selected' : ''}>Rangareddy</option>
						<option value="Karimnagar"
							${patient.patientAddress.district == 'Karimnagar' ? 'selected' : ''}>Karimnagar</option>
						<option value="Warangal"
							${patient.patientAddress.district == 'Warangal' ? 'selected' : ''}>Warangal</option>
						<option value="Adilabad"
							${patient.patientAddress.district == 'Adilabad' ? 'selected' : ''}>Adilabad</option>
						<option value="Khammam" ${patient.patientAddress.district == 'Khammam' ? 'selected' : ''}>Khammam</option>	
					</select>
				</div>
				<label for="inputPassword3" class="col-sm-1 control-label">State</label>

				<div class="col-sm-2">
					<select class="form-control" id="patient.patientAddress.state"
						name="patient.patientAddress.state">
						<option value="Telangana"
							${patient.patientAddress.state == 'Telangana' ? 'selected' : ''}>Telangana</option>
						<option value="Andhra Pradesh"
							${patient.patientAddress.state == 'Andhra Pradesh' ? 'selected' : ''}>Andhra
							Pradesh</option>
						<option value="Tamilnadu"
							${patient.patientAddress.state == 'Tamilnadu' ? 'selected' : ''}>Tamilnadu</option>
					</select>
				</div>
			</div>
		</div>
		<!-- /.box-body -->
	</div>

	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Current Address</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Same
					As Present Address</label>
				<div class="col-sm-5">
					<input type="checkbox"
						name="patient.patientCurrentAddress.sameAsPresentAddress"
						id="sameAsPresentAddress" value="YES" onclick="myfunction();"
						${patient.patientCurrentAddress.sameAsPresentAddress == 'YES' ? 'checked' : ''} />
				</div>
			</div>
			<div class="form-group mandatory">
				<label for="inputEmail3" class="col-sm-2 control-label">City/Village
					Name</label>

				<div class="col-sm-5">
					<input type="text" class="form-control required"
						placeholder="City (OR) Village Name"
						name="patient.patientCurrentAddress.cityName"
						id="patient.patientCurrentAddress.cityName"
						value="${patient.patientCurrentAddress.cityName}" />
				</div>
			</div>
			<div class="form-group mandatory">
				<label for="inputPassword3" class="col-sm-2 control-label">Address</label>

				<div class="col-sm-5">
					<input type="text" class="form-control required"
						placeholder="Current Address"
						name="patient.patientCurrentAddress.address"
						id="patient.patientCurrentAddress.address"
						value="${patient.patientCurrentAddress.address}" />
				</div>
			</div>
			<!-- select -->
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">District</label>

				<div class="col-sm-2">
					<select class="form-control"
						id="patient.patientCurrentAddress.district"
						name="patient.patientCurrentAddress.district">
						<option value="Hyderabad"
							${patient.patientCurrentAddress.district == 'Hyderabad' ? 'selected' : ''}>Hyderabad</option>
						<option value="Rangareddy"
							${patient.patientCurrentAddress.district == 'Rangareddy' ? 'selected' : ''}>Rangareddy</option>
						<option value="Karimnagar"
							${patient.patientCurrentAddress.district == 'Karimnagar' ? 'selected' : ''}>Karimnagar</option>
						<option value="Warangal"
							${patient.patientCurrentAddress.district == 'Warangal' ? 'selected' : ''}>Warangal</option>
						<option value="Adilabad"
							${patient.patientCurrentAddress.district == 'Adilabad' ? 'selected' : ''}>Adilabad</option>
					</select>
				</div>
				<label for="inputPassword3" class="col-sm-1 control-label">State</label>

				<div class="col-sm-2">
					<select class="form-control"
						id="patient.patientCurrentAddress.state"
						name="patient.patientCurrentAddress.state">
						<option value="Telangana"
							${patient.patientCurrentAddress.state == 'Telangana' ? 'selected' : ''}>Telangana</option>
						<option value="Andhra Pradesh"
							${patient.patientCurrentAddress.state == 'Andhra Pradesh' ? 'selected' : ''}>Andhra
							Pradesh</option>
						<option value="Tamilnadu"
							${patient.patientCurrentAddress.state == 'Tamilnadu' ? 'selected' : ''}>Tamilnadu</option>
					</select>
				</div>
			</div>
		</div>

		<input type="hidden" id="formID" name="createdBy" value="${loginID}" />
		<input type="hidden" id="patientID" name="patientID"
			value="${patient.patientID}" /> <input type="hidden"
			name="searchType" value="NA"> <input type="hidden"
			id="operation" name="operation" value="${patient.operation}" />

		<div class="box-footer">
			<label class="control-label col-sm-2"></label>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/savePatientDetails.action', 'patientDetails', 'containerdiv');">Save</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/savePatientDetailsAndContinue.action', 'patientDetails', 'containerdiv');">Next</a>
			</div>
		</div>

	</div>
</form>