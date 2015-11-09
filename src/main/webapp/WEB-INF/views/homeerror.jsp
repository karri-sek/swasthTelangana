<div class="login-logo">
	<b>Swasth</b>Telangana
</div>
<!-- /.login-logo -->
<div class="login-box-body">
	<p>
	<p>
	<h4 class="login-box-msg">Sign in to continue</h4>
	<form role="form" method="POST" name="loginform" id="loginform"
		commandName="loginUser" enctype="multipart/form-data">
		<div class="form-group has-feedback">
			<div class="center-block">
				<img class="profile-img"
					src="<%=request.getContextPath()%>/resources/dist/img/icon.png"
					alt="swasthTelangana">
			</div>
		</div>
		<div class="form-group has-feedback">
			<input class="form-control" placeholder="Username" name="userName"
				id="userName" type="text" value="${userName}" autofocus /> <span
				class="glyphicon glyphicon-envelope form-control-feedback"></span>
		</div>
		<div class="form-group has-feedback">
			<input class="form-control" placeholder="Password" name="password"
				id="password" type="password" value="" /> <span
				class="glyphicon glyphicon-lock form-control-feedback"></span>
		</div>
		<div class="form-group has-error">
			<label class="control-label" for="inputError"><i
				class="fa fa-times-circle-o"></i> Invalid ID or password, please try again.</label>
		</div>
		<div class="row">
			<div class="col-xs-8"></div>
			<div class="col-xs-4">
				<a href="#" class="btn btn-primary btn-block btn-flat"
					onclick="submitForm('/account/loginsubmission.action', 'loginform', 'canvas');"
					value="Sign in"> Sign in</a>
			</div>
			<!-- /.col -->
		</div>
	</form>

	<div class="social-auth-links text-center"></div>
	<!-- /.social-auth-links -->

</div>