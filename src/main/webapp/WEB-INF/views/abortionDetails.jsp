<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">MTP > Abortion details</h3>
	</div>
	<c:if test="${error != null}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>
	<form class="form-horizontal" method="POST" name="mtpDetails"
		id="mtpDetails" modelAttribute="mtpDetails">
		<br>
		<div class="form-group">
			<label class="control-label col-sm-2"> Weeks of pregnancy</label>
			<div class="col-sm-2">
				<input class='form-control required onlyNumber'
					name="weeksOfPregnancy" type='text'
					value="${mtpDetails.weeksOfPregnancy}" />
			</div>
		</div>
		<div class="form-group">
				<label class="control-label col-sm-2"
					title="Please fill all the details">
					Woman details : </label>
				<div class="col-sm-5">
					<table class="table table-striped">
						<tr>
							<td
								title="Mentally ill"><input
								type="checkbox" value="YES" name="isMentallyIll"
								${mtpDetails.isMentallyIll == 'YES' ? 'checked' : ''}>Mentally ill</td>
							<td
								title="Minor"><input
								type="checkbox" value="YES" name="isMinor"
								${mtpDetails.isMinor == 'YES' ? 'checked' : ''}>Minor</td>
							<td
								title="Married"><input
								type="checkbox" value="YES" name="isMarried"
								${mtpDetails.isMarried == 'YES' ? 'checked' : ''}>Married</td>	
						</tr>
					</table>
				</div>
			</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Daughter / Wife of</label>

			<div class="col-sm-5">
				<input class="form-control required" name="daughterOfWifeOf" type="text"
					placeholder="Daughter Of / Wife Of"
					value="${mtpDetails.daughterOfWifeOf}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" title="Guardian where the woman is mentally ill person or minor">Guardian Name</label>

			<div class="col-sm-5">
				<input class="form-control required" name="guardianName" type="text"
					placeholder="Escort while termination"
					value="${mtpDetails.guardianName}" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2"
				title="Reason for termination">Reason for termination
				</label>
			<div class="col-sm-5">
				<input class="form-control" name="reasonForTermination" type="text"
					placeholder="Reason"
					value="${mtpDetails.reasonForTermination}" />
			</div>
		</div>
		
		<input type="hidden" id="patientID" name="patientID"
			value="${mtpDetails.patientID}" /> <input type="hidden"
			id="patientName" name="patientName" value="${mtpDetails.patientName}" />

		<input type="hidden" id="operation" name="operation"
			value="${mtpDetails.operation}" />

		<div class="box-footer">
			<label class="control-label col-sm-2"></label>
			<div class="col-sm-3">
				<a class="btn btn-default col-sm-5" href="#"
					onclick="submitForm('/account/previousAbortionDetails.action', 'mtpDetailsFormPrevious', 'containerdiv');">Previous</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/saveAbortionDetails.action', 'mtpDetails', 'containerdiv');">Save</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/saveNextAbortionDetails.action', 'mtpDetails', 'containerdiv');">Next</a>
			</div>
		</div>

	</form>
	<form name="mtpDetailsFormPrevious" id="mtpDetailsFormPrevious">
		<input name="patientID" type="hidden" value="${mtpDetails.patientID}" />
		<input type="hidden" id="patientName" name="patientName"
			value="${mtpDetails.patientName}" />
	</form>
</div>