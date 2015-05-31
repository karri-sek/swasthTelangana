<div class="panel panel-default">
	<div class="panel-heading">Update account</div>
	<div class="panel-body">
		<fieldset>
			<div class="login-form">
				<form name="updateaccount" id="updateaccount"
					commandName="updateaccount" enctype="multipart/form-data"
					method="POST" class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-md-3 col-lg-3" for="login-name">Login
							id</label>
						<div class="col-md-6">
							<input type="text" class="form-control login-field" value=""
								name="loginId" id="loginId" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-lg-3" for="login-pass">Password</label>
						<div class="col-md-6">
							<input type="password" class="form-control login-field" value=""
								placeholder="Password" name="password" id="password" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-lg-3" for="login-pass">Confirm password</label>
						<div class="col-md-6">
							<input type="password" class="form-control login-field" value=""
								placeholder="Confirm password" name="conPassword"
								id="conPassword" />
						</div>
					</div>

					<a class="btn btn-primary btn-lg btn-block" href="#"
						onclick="submitForm('/account/updateaccountsubmission.action', 'updateaccount', 'containerdiv');">Update
						existing account</a> <span class="login-link">All fields are
						mandatory</span>
				</form>
			</div>
		</fieldset>
	</div>
</div>