<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Birth Report > Legal information</h3>
	</div>
	<c:if test="${error != null}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>
	<form class="form-horizontal" method="POST" name="sectionA"
		id="sectionA" modelAttribute="sectionA">
		<br>
		<div class="form-group mandatory">
			<label class="control-label col-sm-2">Date of Birth</label>
			<div class="col-sm-5">
				<input class="form-control required" value="${birthLegalInfo.dateOfBirth}"
					type="date" name="dateOfBirth" id="dateOfBirth" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" title="Select male or female">
				Sex </label>
			<div class="col-sm-5">
				<table class="table table-striped">
					<tr>
						<c:choose>
							<c:when test="${birthLegalInfo.sex == null}">
								<td title="Important "><input type="radio" value="MALE"
									name="sex" checked="checked"> Male &nbsp;</td>
								<td title="Important "><input type="radio" value="FEMALE"
									name="sex"> Female &nbsp;</td>
							</c:when>
							<c:otherwise>
								<td title="Important "><input type="radio" value="MALE"
									name="sex" ${birthLegalInfo.sex == 'MALE' ? 'checked' : ''}>
									Male &nbsp;</td>
								<td title="Important "><input type="radio" value="FEMALE"
									name="sex" ${birthLegalInfo.sex == 'FEMALE' ? 'checked' : ''}>
									Female &nbsp;</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</table>
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2"
				title="If not named leave blank ">Name of the Child, If any</label>

			<div class="col-sm-5">
				<input class="form-control" name="childName" type="text"
					placeholder="Enter child name" value="${birthLegalInfo.childName}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2"
				title="Full name as usually written">Name of the father</label>

			<div class="col-sm-5">
				<input class="form-control" name="fatherName" type="text"
					placeholder="Full name as usually written"
					value="${birthLegalInfo.fatherName}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2"
				title="Full name as usually written">Name of the mother</label>

			<div class="col-sm-5">
				<input class="form-control" name="motherName" type="text"
					placeholder="Full name as usually written"
					value="${birthLegalInfo.motherName}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2"
				title="Full name as usually written">Mother Aadhaar number</label>

			<div class="col-sm-5">
				<input class="form-control aadhaarNumber" name="motherAadhaar"
					type="text" placeholder="Enter Aadhar"
					value="${birthLegalInfo.motherAadhaar}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2"
				title="Full name as usually written">Mother Contact number</label>

			<div class="col-sm-5">
				<input class="form-control onlyMobileNum" name="motherContact"
					type="text" placeholder="Enter Aadhar"
					value="${birthLegalInfo.motherContact}" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2" title="Select male or female">
				Place of birth </label>
			<div class="col-sm-5">
				<table class="table table-striped">
					<tr>
						<c:choose>
							<c:when test="${birthLegalInfo.birthPlace == null}">
								<td title="Important "><input type="radio" value="HOSPITAL"
									name="birthPlace" checked="checked"}> Hospital &nbsp;</td>
								<td title="Important "><input type="radio" value="HOME"
									name="home"> Home &nbsp;</td>
								<td title="Important "><input type="radio" value="OTHER"
									name="other"> other</td>
							</c:when>
							<c:otherwise>
								<td title="Important "><input type="radio" value="HOSPITAL"
									name="birthPlace"
									${birthLegalInfo.birthPlace == 'HOSPITAL' ? 'checked' : ''}>
									Hospital &nbsp;</td>
								<td title="Important "><input type="radio" value="HOME"
									name="home" ${birthLegalInfo.birthPlace == 'HOME' ? 'checked' : ''}>
									Home &nbsp;</td>
								<td title="Important "><input type="radio" value="OTHER"
									name="other"
									${birthLegalInfo.birthPlace == 'OTHER' ? 'checked' : ''}>
									others</td>
							</c:otherwise>
						</c:choose>

					</tr>
				</table>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2"
				title="Hospital name where the birth took place">Hospital
				name</label>
			<div class="col-sm-5">
				<input class="form-control" name="hospitalName" type="text"
					placeholder="Hospital name where the birth took place"
					value="${birthLegalInfo.hospitalName}" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2"
				title="Full name as usually written">Informant's Name</label>

			<div class="col-sm-5">
				<input class="form-control" name="informantsName" type="text"
					placeholder="Informant's Name" value="${birthLegalInfo.informantsName}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" title="Address">Informant's
				Address</label>

			<div class="col-sm-5">
				<input class="form-control" name="informantsAddress" type="text"
					placeholder="Address" value="${birthLegalInfo.informantsAddress}" />
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
					onclick="submitForm('/account/saveBirthLegalInfo.action', 'sectionA', 'containerdiv');">Save</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/continueBirthLegalInfo.action', 'sectionA', 'containerdiv');">Next</a>
			</div>
		</div>


	</form>
	<form name="sectionAFormPrevious" id="sectionAFormPrevious">
		<input name="patientID" type="hidden" value="${sectionA.patientID}" />
		<input type="hidden" id="patientName" name="patientName"
			value="${sectionA.patientName}" />
	</form>
</div>