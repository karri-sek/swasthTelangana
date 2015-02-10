<div class="panel panel-default">
	<div class="panel-heading">Create account</div>
	<div class="panel-body">
		<fieldset>
			<form name="createaccount" id="createaccount" enctype="multipart/form-data"
				method="POST" class="form-horizontal">

				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">Login id</label>
					<div class="col-md-6">
						<input type="text" class="required form-control" value="" name="loginId"
							id="loginId"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">Display name</label>
					<div class="col-md-6">
						<input type="text" class="required form-control login-field" value=""
							name="displayName" id="displayName" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">Role</label>
					<div class="col-md-6">
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
					<label class="control-label col-md-3 col-lg-3">Mobile number</label>
					<div class="col-md-6">
						<input type="text" class="onlyMobileNum form-control login-field" value=""
							name="mobileNumber" id="mobileNumber" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">District</label>
					<div class="col-md-6">
						<input type="text" class="form-control login-field" value=""
							name="district" id="district" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">State</label>
					<div class="col-md-6">
						<input type="text" class="form-control login-field" value=""
							name="state" id="state" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">Password</label>
					<div class="col-md-6">
						<input type="password" class="form-control login-field" value=""
							name="password" id="password" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">Confirm
						password</label>
					<div class="col-md-6">
						<input type="password" class="form-control login-field" value=""
							name="conPassword" id="conPassword" />
					</div>
				</div>

				<a class="btn btn-primary btn-lg btn-block" href="#"
					onclick="submitForm('/account/createaccountsubmission.action', 'createaccount', 'containerdiv');">Create
					new account</a> <span class="login-link">All fields are
					mandatory</span>

			</form>
		</fieldset>
	</div>
</div>