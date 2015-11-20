<script type="text/javascript">
	$("#userRole").change(
			function() {
				if ($("#userRole").val() != 'HealthCenterUser') {
					$("#clinicAddressClinicName").removeClass("required");
					$("#clinicAddressRegistrationNo").removeClass(
							"required onlyNumber");
					$("#clinicAddressContactNum").removeClass("onlyNumber");
					$("#clinicAddressPincode").removeClass("onlyNumber");
					$("#userClinicDetails").hide();
				} else {
					$("#clinicAddressClinicName").addClass("required");
					$("#clinicAddressRegistrationNo").addClass(
							"required onlyNumber");
					$("#clinicAddressContactNum").addClass("onlyNumber");
					$("#clinicAddressPincode").addClass("onlyNumber");
					$("#userClinicDetails").show();
				}
			});
</script>
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Create Account</h3>
	</div>
	<form name="createaccount" id="createaccount"
		enctype="multipart/form-data" method="POST" class="form-horizontal">
		<div class="box box-info">
			<div class="box-body">
				<div class="form-group mandatory">
					<label class="control-label col-sm-2">Login id</label>

					<div class="col-sm-5">
						<input type="text" class="required form-control" value=""
							name="loginId" id="loginId" />
					</div>
				</div>
				<div class="form-group mandatory">
					<label class="control-label col-sm-2">Display name</label>

					<div class="col-sm-5">
						<input type="text" class="required form-control login-field"
							value="" name="displayName" id="displayName" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Role</label>

					<div class="col-sm-5">
						<select class="form-control login-field" id="userRole"
							name="userRole">
							<option class="login-field-icon fui-user"
								value="HealthCenterUser">HealthCenterUser</option>
							<option class="login-field-icon fui-user" value="DistrictUser">DistrictUser</option>
							<option class="login-field-icon fui-user" value="StateUser">StateUser</option>
							<option class="login-field-icon fui-user" value="Administrator">Administrator</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Mobile number</label>

					<div class="col-sm-5">
						<input type="text" class="onlyMobileNum form-control login-field"
							value="" name="mobileNumber" id="mobileNumber" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">District</label>

					<div class="col-sm-5">
						<select class="form-control" id="district" name="district">
							<option value="Hyderabad">Hyderabad</option>
							<option value="Rangareddy">RangaReddy</option>
							<option value="Karimnagar">Karimnagar</option>
							<option value="Warangal">Warangal</option>
							<option value="Adilabad">Adilabad</option>
							<option value="Khammam">Khammam</option>
							<option value="Mahaboobnagar">Mahaboobnagar</option>
							<option value="Medak">Medak</option>
							<option value="Nalgonda">Nalgonda</option>
							<option value="Nizamabad">Nizamabad</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">State</label>

					<div class="col-sm-5">
						<select class="form-control" id="state" name="state">
							<option value="Telangana">Telangana</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Password</label>

					<div class="col-sm-5">
						<input type="password" class="form-control login-field" value=""
							name="password" id="password" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Confirm password</label>

					<div class="col-sm-5">
						<input type="password" class="form-control login-field" value=""
							name="conPassword" id="conPassword" />
					</div>
				</div>
			</div>
			<div class="box-header with-border" id="userClinicDetails">
				<div class="box-body">
					<div class="form-group">
						<label class="control-label col-sm-2">Health center type</label>
						<div class="col-sm-5">
							<select class="form-control login-field" id="clinicAddress.type"
								name="clinicAddress.type">
								<option class="login-field-icon fui-user" value="scanningCenter">Scanning
									center</option>
								<option class="login-field-icon fui-user" value="nursingHome">Nursing
									home</option>
							</select>
						</div>
					</div>
					<div class="form-group mandatory">
						<label class="control-label col-sm-2"> Clinic Name</label>

						<div class="col-sm-5">
							<input class='form-control required'
								placeholder="Enter Clinic Name ..."
								name="clinicAddress.clinicName" id="clinicAddressClinicName"
								type='text' value="${clinicAddress.clinicName}" />
						</div>
					</div>
					<div class="form-group mandatory">
						<label class="control-label col-sm-2"
							title="Under PC& PNDT Act, 1994"> Registration No</label>

						<div class="col-sm-5">
							<input class='form-control required onlyNumber'
								placeholder="Under PC& PNDT Act, 1994"
								name="clinicAddress.registrationNo"
								id="clinicAddressRegistrationNo" type='text'
								value="${clinicAddress.registrationNo}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Clinic contact no</label>

						<div class="col-sm-5">
							<input class='form-control onlyNumber'
								placeholder="Enter Clinic contact No"
								name="clinicAddress.contactNum" id="clinicAddressContactNum"
								type='text' value="${clinicAddress.contactNum}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Clinic Address</label>

						<div class="col-sm-5">
							<textarea class='form-control' rows='3'
								name="clinicAddress.address">${clinicAddress.address}</textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2"> District </label>

						<div class="col-sm-2">
							<select class="form-control" id="clinicAddress.district"
								name="clinicAddress.district" value="${clinicAddress.district}">
								<option value="Hyderabad"
									${clinicAddress.district == 'Hyderabad' ? 'selected' : ''}>Hyderabad</option>
								<option value="Rangareddy"
									${clinicAddress.district == 'Rangareddy' ? 'selected' : ''}>Rangareddy</option>
								<option value="Karimnagar"
									${clinicAddress.district == 'Karimnagar' ? 'selected' : ''}>Karimnagar</option>
								<option value="Warangal"
									${clinicAddress.district == 'Warangal' ? 'selected' : ''}>Warangal</option>
								<option value="Adilabad"
									${clinicAddress.district == 'Adilabad' ? 'selected' : ''}>Adilabad</option>
								<option value="Khammam"
									${clinicAddress.district == 'Khammam' ? 'selected' : ''}>Khammam</option>
								<option value="Mahaboobnagar"
									${clinicAddress.district == 'Mahaboobnagar' ? 'selected' : ''}>Mahaboobnagar</option>
								<option value="Medak"
									${clinicAddress.district == 'Medak' ? 'selected' : ''}>Medak</option>
								<option value="Nalgonda"
									${clinicAddress.district == 'Nalgonda' ? 'selected' : ''}>Nalgonda</option>
								<option value="Nizamabad"
									${clinicAddress.district == 'Nizamabad' ? 'selected' : ''}>Nizamabad</option>
							</select>
						</div>
						<label class="control-label col-sm-2"> State </label>

						<div class="col-sm-2">
							<select class="form-control" id="clinicAddressState"
								name="clinicAddress.state" value="${clinicAddress.state}">
								<option value="Telangana"
									${clinicAddress.state == 'Telangana' ? 'selected' : ''}>Telangana</option>
							</select>
						</div>

					</div>
					<div class="form-group">
						<label class="control-label col-sm-2"> Pincode</label>

						<div class="col-sm-5">
							<input class='form-control onlyNumber'
								name="clinicAddress.pincode" type='text'
								id="clinicAddressPincode" value="${clinicAddress.pincode}" />
						</div>
					</div>
				</div>
			</div>
			<div class="box-footer">
				<label class="control-label col-sm-2"></label>

				<div class=" col-sm-3">
					<a class="btn btn-primary" href="#"
						onclick="submitForm('/account/createaccountsubmission.action', 'createaccount', 'containerdiv');">Create
						new account</a>
				</div>
			</div>

			<%--<span class="login-link">All fields are mandatory</span>--%>
	</form>
</div>