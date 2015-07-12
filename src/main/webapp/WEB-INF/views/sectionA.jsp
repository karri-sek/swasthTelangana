<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">FORM F > Section A:To be filled in for all
			Diagnostic Procedures/Tests</h3>
	</div>
	<c:if test="${error != null}">
        <div class="alert alert-danger" role="alert">${error}</div>
    </c:if>
	<form class="form-horizontal" method="POST" name="sectionA"
		id="sectionA" modelAttribute="sectionA">
		<input type="hidden" id="lastMenstrualPeriod" name="lastMenstrualPeriod"
			value="" />
		<div class="form-group">
			<label class="control-label col-sm-2"> Weeks of pregnancy</label>
			<div class="col-sm-2">
				<input class='form-control required onlyNumber' name="weeksOfPragnancy" type='text'
					value="${sectionA.weeksOfPragnancy}" />
			</div>
			<label class="control-label col-sm-2">Number of children</label>

			<div class="col-sm-2">
				<input class="form-control required onlyNumber" type="text" name="noOfChildren"
					id="noOfChildren"
					placeholder="Total Number of living children"
					value="${sectionA.noOfChildren}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Sons</label>
			<div class="col-sm-2">
				<input class="form-control required onlyNumber" type="text" name="noOfMaleKids"
					id="noOfMaleKids" value="${sectionA.noOfMaleKids}" />
			</div>
			<label class="control-label col-sm-2">Daughters</label>
			<div class="col-sm-2">
				<input class="form-control required onlyNumber" name="noOfFemaleKids" type='text'
					value="${sectionA.noOfFemaleKids}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Guardian Name</label>

			<div class="col-sm-5">
				<input class="form-control required" name="guardianName" type="text"
					placeholder="Husband's /Wife's/Father's / Mother's"
					value="${sectionA.guardianName}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2"
				title="Referral note with indications and case papers of the patient to be preserved with Form F">Referred
				by</label>

			<div class="col-sm-5">
				<input class="form-control" name="referredBy" type="text"
					placeholder="Full name and address of Doctor(s)/ Genetic Counseling Centre"
					value="${sectionA.referredBy}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2"
				title="Self-referral does not mean a client coming to a clinic and requesting for the test or the relative/s requesting for the test of a pregnant woman">Self-Referral
				by</label>

			<div class="col-sm-5">
				<input class="form-control" name="selfReferredBy" type="text"
					placeholder="Gynaecologist/Radiologist/Registered Medical Practitioner conductingthe diagnostic procedures" value="${sectionA.selfReferredBy}"/>
			</div>
		</div>

		<input type="hidden" id="patientID" name="patientID"
			value="${sectionA.patientID}" /> <input type="hidden"
			id="patientName" name="patientName" value="${sectionA.patientName}" />
			
		<input type="hidden" id="operation" name="operation" value="${sectionA.operation}"/>	
		
		<div class="box-footer">
				<label class="control-label col-sm-2"></label>
				<div class="col-sm-3">
					<a class="btn btn-default col-sm-5" href="#"
						onclick="submitForm('/account/previousSectionA.action', 'sectionAFormPrevious', 'containerdiv');">Previous</a>
				</div>
				<div class="col-sm-3">
					<a class="btn btn-primary" href="#"
						onclick="submitForm('/account/saveSectionA.action', 'sectionA', 'containerdiv');">Save</a>
				</div>
				<div class="col-sm-3">
					<a class="btn btn-primary" href="#"
						onclick="submitForm('/account/nextSectionA.action', 'sectionA', 'containerdiv');">Next</a>
				</div>
			</div>
		
		
	</form>
	<form name="sectionAFormPrevious" id="sectionAFormPrevious">
		<input name="patientID" type="hidden" value="${sectionA.patientID}" />
		<input type="hidden" id="patientName" name="patientName"
			value="${sectionA.patientName}" />
	</form>
</div>