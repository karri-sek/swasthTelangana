<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Birth Report > Statistical information >
			Health information</h3>
	</div>
	<c:if test="${error != null}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>
	<form class="form-horizontal" method="POST" name="sectionA"
		id="sectionA" modelAttribute="sectionA">
		<br>
		<div class="form-group">
			<label class="control-label col-sm-2" title="Religion"> Type
				of attention at delivery </label>
			<div class="col-sm-5">
				<select class="form-control" id="attentionAtDelivery"
					name="attentionAtDelivery">
					<option value="Institutional-Government"
						${healthInfo.attentionAtDelivery == 'Institutional-Government' ? 'selected' : ''}>Institutional-Government</option>
					<option value="Institutional-PrivateNon-Government"
						${healthInfo.attentionAtDelivery == 'Institutional-PrivateNon-Government' ? 'selected' : ''}>Institutional-Private
						or Non-Government</option>
					<option value="DoctorNurseORTrainedMidwife"
						${healthInfo.attentionAtDelivery == 'DoctorNurseORTrainedMidwife' ? 'selected' : ''}>Doctor,
						Nurse or Trained midwife</option>
					<option value="TraditionalBirthAttendant"
						${healthInfo.attentionAtDelivery == 'TraditionalBirthAttendant' ? 'selected' : ''}>Traditional
						Birth Attendant</option>
					<option value="RelativesORothers"
						${familyInfo.fatherEducation == 'RelativesORothers' ? 'selected' : ''}>Relatives
						or others</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" title="Religion">
				Method of Delivery </label>
			<div class="col-sm-5">
				<table class="table table-striped">
					<tr>
						<c:choose>
							<c:when test="${legaldata.deliveryMethod == null}">
								<td title="Important "><input type="radio" value="Natural"
									name="deliveryMethod" checked="checked"> Natural &nbsp;</td>
								<td title="Important "><input type="radio"
									value="Caesarean" name="deliveryMethod"> Caesarean
									&nbsp;</td>
								<td title="Important "><input type="radio"
									value="ForcepsVacuum" name="deliveryMethod"> Forceps
									/Vacuum &nbsp;</td>
							</c:when>
							<c:otherwise>
								<td title="Important "><input type="radio" value="Natural"
									name="deliveryMethod"
									${healthInfo.deliveryMethod == 'HINDU' ? 'checked' : ''}>
									Natural &nbsp;</td>
								<td title="Important "><input type="radio"
									value="Caesarean" name="deliveryMethod"
									${healthInfo.deliveryMethod == 'Caesarean' ? 'checked' : ''}>
									Caesarean &nbsp;</td>
								<td title="Important "><input type="radio"
									value="ForcepsVacuum" name="deliveryMethod"
									${healthInfo.deliveryMethod == 'ForcepsVacuum' ? 'checked' : ''}>
									Forceps /Vacuum &nbsp;</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</table>
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2" title="in kg .s">Birth
				Weight</label>

			<div class="col-sm-5">
				<input class="form-control" name="birthWeight" type="text"
					placeholder="in kg .s" value="${healthInfo.birthWeight}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" title="in weeks">Duration
				of Pregnancy</label>

			<div class="col-sm-5">
				<input class="form-control" name="pregnancyDuration" type="text"
					placeholder="in weeks" value="${healthInfo.pregnancyDuration}" />
			</div>
		</div>

		<input type="hidden" id="birthId" name="birthId"
			value="${healthInfo.birthId}" /> <input type="hidden" id="operation"
			name="operation" value="${healthInfo.operation}" />

		<div class="box-footer">
			<label class="control-label col-sm-2"></label>
			<div class="col-sm-3">
				<a class="btn btn-default col-sm-5" href="#"
					onclick="submitForm('/account/previousHealthInfo.action', 'sectionAFormPrevious', 'containerdiv');">Previous</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/saveHealthInfo.action', 'sectionA', 'containerdiv');">Save</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/continueHealthInfo.action', 'sectionA', 'containerdiv');">Next</a>
			</div>
		</div>


	</form>
	<form name="sectionAFormPrevious" id="sectionAFormPrevious">
		<input name="birthId" type="hidden" value="${healthInfo.birthId}" />
	</form>
</div>