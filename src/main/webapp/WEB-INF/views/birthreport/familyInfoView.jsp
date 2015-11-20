<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Birth Report > Statistical information >
			Family information</h3>
	</div>
	<c:if test="${error != null}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>
	<form class="form-horizontal" method="POST" name="sectionA"
		id="sectionA" modelAttribute="sectionA">
		<br>
		<div class="form-group">
			<label class="control-label col-sm-2" title="Religion">
				Religion of the Family </label>
			<div class="col-sm-5">
				<table class="table table-striped">
					<tr>
						<c:choose>
							<c:when test="${legaldata.religion == null}">
								<td title="Important "><input type="radio" value="HINDU"
									name="religion" checked="checked"> Hindu &nbsp;</td>
								<td title="Important "><input type="radio" value="MUSLIM"
									name="religion"> Muslim &nbsp;</td>
								<td title="Important "><input type="radio"
									value="CHRISTAIN" name="religion"> Christain &nbsp;</td>
								<td title="Important "><input type="radio" value="OTHER"
									name="religion"> Others &nbsp;</td>
							</c:when>
							<c:otherwise>
								<td title="Important "><input type="radio" value="HINDU"
									name="religion"
									${familyInfo.religion == 'HINDU' ? 'checked' : ''}>
									Hindu &nbsp;</td>
								<td title="Important "><input type="radio" value="MUSLIM"
									name="religion"
									${familyInfo.religion == 'MUSLIM' ? 'checked' : ''}>
									Muslim &nbsp;</td>
								<td title="Important "><input type="radio"
									value="CHRISTAIN" name="religion"
									${familyInfo.religion == 'CHRISTAIN' ? 'checked' : ''}>
									Christain &nbsp;</td>
								<td title="Important "><input type="radio" value="OTHER"
									name="religion"
									${familyInfo.religion == 'OTHER' ? 'checked' : ''}>
									Other &nbsp;</td>
							</c:otherwise>
						</c:choose>

					</tr>
				</table>
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2"
				title="If not named leave blank ">Father's level of
				education</label>

			<div class="col-sm-5">
				<select class="form-control" id="fatherEducation"
					name="fatherEducation">
					<option value="pg"
						${familyInfo.fatherEducation == 'Hyderabad' ? 'selected' : ''}>PG</option>
					<option value="ug"
						${familyInfo.fatherEducation == 'Hyderabad' ? 'selected' : ''}>UG</option>
					<option value="inter"
						${familyInfo.fatherEducation == 'Hyderabad' ? 'selected' : ''}>Intermediate</option>
					<option value="tenth"
						${familyInfo.fatherEducation == 'Hyderabad' ? 'selected' : ''}>10</option>
					<option value="lessThanTenth"
						${familyInfo.fatherEducation == 'Hyderabad' ? 'selected' : ''}>Less
						than 10</option>

				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2"
				title="If not named leave blank ">Mother's Level of
				education</label>

			<div class="col-sm-5">
				<select class="form-control" id="motherEducation"
					name="motherEducation">
					<option value="pg"
						${familyInfo.motherEducation == 'pg' ? 'selected' : ''}>PG</option>
					<option value="ug"
						${familyInfo.motherEducation == 'ug' ? 'selected' : ''}>UG</option>
					<option value="inter"
						${familyInfo.motherEducation == 'inter' ? 'selected' : ''}>Intermediate</option>
					<option value="tenth"
						${familyInfo.motherEducation == 'tenth' ? 'selected' : ''}>10</option>
					<option value="lessThanTenth"
						${familyInfo.motherEducation == 'lessThanTenth' ? 'selected' : ''}>Less
						than 10</option>

				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2"
				title="If not named leave blank ">Father's Occupation</label>

			<div class="col-sm-5">
				<input class="form-control" name="fatherOccupation" type="text"
					placeholder="Enter child name"
					value="${familyInfo.fatherOccupation}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2"
				title="If not named leave blank ">Mother's Occupation</label>

			<div class="col-sm-5">
				<input class="form-control" name="motherOccupation" type="text"
					placeholder="Enter child name"
					value="${familyInfo.motherOccupation}" />
			</div>
		</div>


		<div class="form-group">
			<label class="control-label col-sm-2"
				title="If not named leave blank ">Age of the mother at the
				time of marriage</label>

			<div class="col-sm-5">
				<input class="form-control" name="motherAgeAtMrg" type="text"
					placeholder="in completed years"
					value="${familyInfo.motherAgeAtMrg}" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2"
				title="If not named leave blank ">Age of the mother at the
				time of this birth</label>

			<div class="col-sm-5">
				<input class="form-control" name="motherAge" type="text"
					placeholder="in completed years" value="${familyInfo.motherAge}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2"
				title="Number of children born alive to the mother so far including this child">Number
				of children</label>

			<div class="col-sm-5">
				<input class="form-control" name="noOfChildren" type="text"
					placeholder="including this child"
					value="${familyInfo.noOfChildren}" />
			</div>
		</div>

		<input type="hidden" id="birthId" name="birthId"
			value="${familyInfo.birthId}" /> <input type="hidden"
			id="operation" name="operation"
			value="${familyInfo.operation}" />

		<div class="box-footer">
			<label class="control-label col-sm-2"></label>
			<div class="col-sm-3">
				<a class="btn btn-default col-sm-5" href="#"
					onclick="submitForm('/account/previousFamilyInfo.action', 'familyPrevious', 'containerdiv');">Previous</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/saveFamilyInfo.action', 'sectionA', 'containerdiv');">Save</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/continueFamilyInfo.action', 'sectionA', 'containerdiv');">Next</a>
			</div>
		</div>


	</form>
	<form name="familyPrevious" id="familyPrevious">
		<input name="birthId" type="hidden" value="${familyInfo.birthId}" />
	</form>
</div>