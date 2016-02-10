<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Registration > Basic information</h3>
	</div>
	<c:if test="${error != null}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>
	<form class="form-horizontal" method="POST" name="sectionA"
		id="sectionA" modelAttribute="sectionA">
		<br>
		<div class="form-group mandatory">
			<label class="control-label col-sm-2">Name of the applicant</label>
			<div class="col-sm-5">
				<input class="form-control required" value="${birthLegalInfo.dateOfBirth}"
					type="text" name="name" id="name" />
			</div>
		</div>
		<div class="form-group mandatory">
				<label for="inputPassword3" class="col-sm-2 control-label">Address</label>

				<div class="col-sm-5">
					<input type="text" class="form-control required"
						placeholder="Permanent Address ...."
						name="birthPlaceAddress.address"
						id="birthPlaceAddress.address"
						value="${birthReportAddress.birthPlaceAddress.address}" />
				</div>
			</div>
			<!-- select -->
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">District</label>

				<div class="col-sm-2">
					<select class="form-control"
						id="birthPlaceAddress.district"
						name="birthPlaceAddress.district">
						<option value="Hyderabad"
							${birthReportAddress.birthPlaceAddress.district == 'Hyderabad' ? 'selected' : ''}>Hyderabad</option>
						<option value="Rangareddy"
							${birthReportAddress.birthPlaceAddress.district == 'Rangareddy' ? 'selected' : ''}>Rangareddy</option>
						<option value="Karimnagar"
							${birthReportAddress.birthPlaceAddress.district == 'Karimnagar' ? 'selected' : ''}>Karimnagar</option>
						<option value="Warangal"
							${birthReportAddress.birthPlaceAddress.district == 'Warangal' ? 'selected' : ''}>Warangal</option>
						<option value="Adilabad"
							${birthReportAddress.birthPlaceAddress.district == 'Adilabad' ? 'selected' : ''}>Adilabad</option>
						<option value="Khammam"
							${birthReportAddress.birthPlaceAddress.district == 'Khammam' ? 'selected' : ''}>Khammam</option>
					</select>
				</div>
				<label for="inputPassword3" class="col-sm-1 control-label">State</label>

				<div class="col-sm-2">
					<select class="form-control"
						id="birthPlaceAddress.state"
						name="birthPlaceAddress.state">
						<option value="Telangana"
							${birthReportAddress.birthPlaceAddress.state == 'Telangana' ? 'selected' : ''}>Telangana</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2"> Pincode</label>

				<div class="col-sm-5">
					<input class='form-control onlyNumber' name="birthPlaceAddress.pincode" id="birthPlaceAddress.pincode"
						type='text' value="${birthReportAddress.birthPlaceAddress.pincode}" />
				</div>
			</div>
		<div class="form-group">
			<label class="control-label col-sm-2"
				title="Full name as usually written">Type of facility to be registered</label>

			<div class="col-sm-5">
				<input class="form-control" name="fatherName" type="text"
					placeholder="Type of facility to be registered"
					value="${birthLegalInfo.fatherName}" />
			</div>
		</div>
		
		<input type="hidden" id="birthId" name="birthId"
			value="${birthLegalInfo.birthId}" /> <input type="hidden" id="operation"
			name="operation" value="${birthLegalInfo.operation}" />

		<div class="box-footer">
			<label class="control-label col-sm-2"></label>
			<div class="col-sm-3">
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/saveRegbasicInfo.action', 'sectionA', 'containerdiv');">Save</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/continueRegbasicInfo.action', 'sectionA', 'containerdiv');">Next</a>
			</div>
		</div>

	</form>
	<form name="sectionAFormPrevious" id="sectionAFormPrevious">
		<input name="patientID" type="hidden" value="${sectionA.patientID}" />
		<input type="hidden" id="patientName" name="patientName"
			value="${sectionA.patientName}" />
	</form>
</div>