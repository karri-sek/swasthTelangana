<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Centre other details</h3>
	</div>
	<c:if test="${error != null}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>
	<form class="form-horizontal" method="POST" name="clinicForm"
		id="clinicForm" modelAttribute="clinicAddress">
		<div class="form-group">
			<c:if test="${errorMessage != null}">
				<div class="form-group">
					<div class="alert alert-success">
						<a href="#" class="close" data-dismiss="alert">&times;</a>
						<c:choose>
							<c:when test="${errorMessage != null}">${errorMessage}</c:when>
						</c:choose>
					</div>
				</div>
			</c:if>
		</div>
		<div class="form-group mandatory">
			<label class="control-label col-sm-2">Employees details</label>

			<div class="col-sm-5">
				<textarea class='form-control required'
					placeholder="Names, qualifications, experience and registration number of employees"
					rows='3' name="address">${clinicAddress.address}</textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" title="Rule 3">
				Qualifies for registration in terms of requirements laid down in
				Rule 3 </label>
			<div class="col-sm-5">
				<table class="table table-striped">
					<tr>
						<c:choose>
							<c:when test="${birthLegalInfo.sex == null}">
								<td title="Important "><input type="radio" value="MALE"
									name="Qualifies" checked="checked"> Yes &nbsp;</td>
								<td title="Important "><input type="radio" value="FEMALE"
									name="Qualifies"> No &nbsp;</td>
							</c:when>
							<c:otherwise>
								<td title="Important "><input type="radio" value="MALE"
									name="Qualifies"
									${birthLegalInfo.sex == 'MALE' ? 'checked' : ''}> Yes
									&nbsp;</td>
								<td title="Important "><input type="radio" value="FEMALE"
									name="Qualifies"
									${birthLegalInfo.sex == 'FEMALE' ? 'checked' : ''}> No
									&nbsp;</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</table>
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2"
				title="Is a renewal application"> Is a renewal application </label>
			<div class="col-sm-5">
				<table class="table table-striped">
					<tr>
						<c:choose>
							<c:when test="${birthLegalInfo.sex == null}">
								<td title="Important "><input type="radio" value="MALE"
									name="isRenewal" checked="checked"> Yes &nbsp;</td>
								<td title="Important "><input type="radio" value="FEMALE"
									name="isRenewal"> No &nbsp;</td>
							</c:when>
							<c:otherwise>
								<td title="Important "><input type="radio" value="MALE"
									name="isRenewal"
									${birthLegalInfo.sex == 'MALE' ? 'checked' : ''}> Yes
									&nbsp;</td>
								<td title="Important "><input type="radio" value="FEMALE"
									name="isRenewal"
									${birthLegalInfo.sex == 'FEMALE' ? 'checked' : ''}> No
									&nbsp;</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</table>
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2">Registration No</label>

			<div class="col-sm-5">
				<input class='form-control onlyNumber'
					placeholder="Equipment available with the make and model"
					name="contactNum" type='text' value="${clinicAddress.contactNum}" />
			</div>
		</div>
		<div class="form-group mandatory">
			<label class="control-label col-sm-2">Date of issue</label>
			<div class="col-sm-5">
				<input class="form-control required"
					value="${birthLegalInfo.dateOfBirth}" type="date"
					name="dateOfBirth" id="dateOfBirth" />
			</div>
		</div>
		<div class="form-group mandatory">
			<label class="control-label col-sm-2">Date of expiry</label>
			<div class="col-sm-5">
				<input class="form-control required"
					value="${birthLegalInfo.dateOfBirth}" type="date"
					name="dateOfBirth" id="dateOfBirth" />
			</div>
		</div>

		<input type="hidden" id="operation" name="operation"
			value="${clinicAddress.operation}" />

		<div class="box-footer">
			<label class="control-label col-sm-2"></label>
			<div class="col-sm-3">
				<a class="btn btn-default col-sm-5" href="#"
					onclick="submitForm('/account/previousRegOtherDetails.action', 'clinicFormPrevious', 'containerdiv');">Previous</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/saveRegOtherDetails.action', 'clinicForm', 'containerdiv');">Save</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/nextRegOtherDetails.action', 'clinicForm', 'containerdiv');">Next</a>
			</div>
		</div>

	</form>

	<form name="clinicFormPrevious" id="clinicFormPrevious">
		<input name="patientID" type="hidden"
			value="${clinicAddress.patientID}" /> <input name="patientName"
			type='hidden' value="${clinicAddress.patientName}" />
	</form>
</div>