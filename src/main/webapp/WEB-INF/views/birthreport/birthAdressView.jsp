<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Horizontal Form -->
<form class="form-horizontal" method="POST" id="patientDetails"
	name="patientDetails">
	<!-- Permanent Address Box-->
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Birth Report > Statistical information >
				Address of parents at the time of birth of child</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<div class="form-group mandatory">
				<label for="inputEmail3" class="col-sm-2 control-label">Village/Town/City
					Name</label>

				<div class="col-sm-5">
					<input type="text" class="form-control required"
						placeholder="Enter City Name ..."
						name="birthPlaceAddress.cityName"
						id="birthPlaceAddress.cityName"
						value="${birthReportAddress.birthPlaceAddress.cityName}" />
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
		</div>
		<!-- /.box-body -->
	</div>

	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Permanent address / Residence of the
				Mother</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Same
					As above address</label>
				<div class="col-sm-5">
					<input type="checkbox"
						name="sameAsBirthAddress"
						id="sameAsBirthAddress" value="YES" onclick="birthReportSameAddressAction();"
						${birthReportAddress.sameAsBirthAddress == 'YES' ? 'checked' : ''} />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" title="Select male or female">
					Place of birth </label>
				<div class="col-sm-5">
					<table class="table table-striped">
						<tr>

							<c:choose>
								<c:when test="${birthReportAddress.permanentAddress.villageTownCity == null}">
									<td title="Important "><input type="radio" value="VILLAGE"
										name="permanentAddress.villageTownCity">
										Village &nbsp;</td>
									<td title="Important "><input type="radio" value="TOWN"
										name="permanentAddress.villageTownCity">
										Town &nbsp;</td>
									<td title="Important "><input type="radio" value="CITY"
										name="permanentAddress.villageTownCity" checked="checked">
										City</td>
								</c:when>
								<c:otherwise>
									<td title="Important "><input type="radio" value="VILLAGE"
										name="permanentAddress.villageTownCity"
										${birthReportAddress.permanentAddress.villageTownCity == 'VILLAGE' ? 'checked' : ''}>
										Village &nbsp;</td>
									<td title="Important "><input type="radio" value="TOWN"
										name="permanentAddress.villageTownCity"
										${birthReportAddress.permanentAddress.villageTownCity == 'TOWN' ? 'checked' : ''}>
										Town &nbsp;</td>
									<td title="Important "><input type="radio" value="CITY"
										name="permanentAddress.villageTownCity"
										${birthReportAddress.permanentAddress.villageTownCity == 'CITY' ? 'checked' : ''}>
										City</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</table>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Village/Town/City
					Name</label>

				<div class="col-sm-5">
					<input type="text" class="form-control"
						placeholder="City (OR) Village Name" name="permanentAddress.cityName"
						id="permanentAddress.cityName"
						value="${birthReportAddress.permanentAddress.cityName}" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Address</label>

				<div class="col-sm-5">
					<input type="text" class="form-control"
						placeholder="Permanant Address"
						name="permanentAddress.address"
						id="permanentAddress.address"
						value="${birthReportAddress.permanentAddress.address}" />
				</div>
			</div>
			<!-- select -->
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">District</label>

				<div class="col-sm-2">
					<select class="form-control"
						id="permanentAddress.district"
						name="permanentAddress.district">
						<option value="Hyderabad"
							${birthReportAddress.permanentAddress.district == 'Hyderabad' ? 'selected' : ''}>Hyderabad</option>
						<option value="Rangareddy"
							${birthReportAddress.permanentAddress.district == 'Rangareddy' ? 'selected' : ''}>Rangareddy</option>
						<option value="Karimnagar"
							${birthReportAddress.permanentAddress.district == 'Karimnagar' ? 'selected' : ''}>Karimnagar</option>
						<option value="Warangal"
							${birthReportAddress.permanentAddress.district == 'Warangal' ? 'selected' : ''}>Warangal</option>
						<option value="Adilabad"
							${birthReportAddress.permanentAddress.district == 'Adilabad' ? 'selected' : ''}>Adilabad</option>
					</select>
				</div>
				<label for="inputPassword3" class="col-sm-1 control-label">State</label>

				<div class="col-sm-2">
					<select class="form-control"
						id="permanentAddress.state"
						name="permanentAddress.state">
						<option value="Telangana"
							${birthReportAddress.permanentAddress.state == 'Telangana' ? 'selected' : ''}>Telangana</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2"> Pincode</label>

				<div class="col-sm-5">
					<input class='form-control onlyNumber' id="permanentAddress.pincode" name="permanentAddress.pincode"
						type='text' value="${birthReportAddress.permanentAddress.pincode}" />
				</div>
			</div>
		</div>

		<input type="hidden" id="birthId" name="birthId"
			value="${birthReportAddress.birthId}" />
			<input type="hidden"
			id="operation" name="operation"
			value="${birthReportAddress.operation}" />

		<div class="box-footer">
			<label class="control-label col-sm-2"></label>
			<div class="col-sm-3">
				<a class="btn btn-default col-sm-5" href="#"
					onclick="submitForm('/account/previousBirthReportAdress.action', 'birthReportAddressPrevious', 'containerdiv');">Previous</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/saveBirthReportAdress.action', 'patientDetails', 'containerdiv');">Save</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-primary" href="#"
					onclick="submitForm('/account/continueBirthReportAdress.action', 'patientDetails', 'containerdiv');">Next</a>
			</div>
		</div>

	</div>
</form>
<form name="birthReportAddressPrevious" id="birthReportAddressPrevious">
	<input name="birthId" type="hidden"
		value="${birthReportAddress.birthId}" />
</form>
