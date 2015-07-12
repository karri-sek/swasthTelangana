<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Swasth Telangana</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link
	href="<%=request.getContextPath()%>/resources/dist/css/AdminLTE.min.css"
	rel="stylesheet" type="text/css" />
<!-- iCheck -->
<link
	href="<%=request.getContextPath()%>/resources/plugins/iCheck/square/blue.css"
	rel="stylesheet" type="text/css" />

<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/dist/img/icon.png">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-page" >
	<div class="login-box" id="canvas" name="canvas">
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
				<c:if test="${loginError != null}">
					<div class="form-group has-error">
						<label class="control-label" for="inputError"><i
							class="fa fa-times-circle-o"></i>${loginError}</label>
					</div>
				</c:if>
				<div class="row">
					<div class="col-xs-8">
					</div>
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
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.1.4 -->
	<script
		src="<%=request.getContextPath()%>/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- iCheck -->
	<script
		src="<%=request.getContextPath()%>/resources/plugins/iCheck/icheck.min.js"
		type="text/javascript"></script>
	<script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/dist/js/apputils.js"></script>
</body>
</html>