<html>
<div class="login-form">&nbsp;&nbsp;Total finance report..</div>

<div class="login-form">
	<form name="totalfinanceSearch" id="totalfinanceSearch"
		commandName="totalfinanceSearch" enctype="multipart/form-data"
		method="POST">
		<div class="form-group">
			<input type="text" class="form-control login-field" value=""
				placeholder="Pati" name="loginId" id="loginId" /> <label
				class="login-field-icon fui-user" for="login-name"></label>
		</div>
		<div class="form-group">
			<input type="text" class="form-control login-field" value=""
				placeholder="Display name" name="displayName" id="displayName" /> <label
				class="login-field-icon fui-user" for="login-name"></label>
		</div>
		<div class="form-group">
			<input type="text" class="form-control login-field" value=""
				placeholder="Role" name="userRole" id="userRole" /> <label
				class="login-field-icon fui-user" for="login-name"></label>
		</div>
		<div class="form-group">
			<input type="password" class="form-control login-field" value=""
				placeholder="Password" name="password" id="password" /> <label
				class="login-field-icon fui-lock" for="login-pass"></label>
		</div>
		<div class="form-group">
			<input type="password" class="form-control login-field" value=""
				placeholder="Confirm password" name="conPassword" id="conPassword" />
			<label class="login-field-icon fui-lock" for="login-pass"></label>
		</div>

		<a class="btn btn-primary btn-lg btn-block" href="#"
			onclick="submitForm('/account/createaccountsubmission.action', 'createaccount', 'containerdiv');">Create
			new account</a> <span class="login-link">All fields are mandatory</span>
	</form>
</div>

</html>
