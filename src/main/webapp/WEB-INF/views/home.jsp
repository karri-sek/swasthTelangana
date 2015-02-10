<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="utf-8">

    <title>Swasth telangana</title>
    <meta name="description"
          content="Flat UI Kit Free is a Twitter Bootstrap Framework design and Theme, this responsive framework includes a PSD and HTML version."/>

    <meta name="viewport"
          content="width=1000, initial-scale=1.0, maximum-scale=1.0">
    <link rel="shortcut icon" href="img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/login/icon.png">
</head>
<body>
<div id="errorMessage"></div>
<div id="canvas">
    <div class="container">
        <br> <br>

        <div class="login">
            <div class="login-screen">
                <c:if test="${failedLogin != null}">
                    <div class="alert alert-info" role="alert">${failedLogin}</div>
                </c:if>
                <div class="login-icon">
                    <img
                            src="<%=request.getContextPath()%>/resources/img/login/icon.png"
                            alt="Welcome to Mail App"/>
                    <h4>
                        Welcome to
                        <small>Swasth Telangana</small>
                    </h4>
                </div>
                <div class="login-form">
                    <form name="loginform" id="loginform" commandName="loginUser"
                          enctype="multipart/form-data" method="POST">
                        <div class="form-group">
                            <input type="text" class="form-control login-field required date-picker" value=""
                                   placeholder="Enter your name" name="userName" id="userName"/>
                            <label class="login-field-icon fui-user"></label>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control login-field required" value=""
                                   placeholder="Password" name="password" id="passord"/> <label
                                class="login-field-icon fui-lock"></label>
                        </div>
                        <a class="btn btn-primary btn-lg btn-block" href="#"
                           onclick="submitForm('/account/loginsubmission.action', 'loginform', 'canvas');">Log
                            in</a> <a class="login-link" href="">Lost your password?</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript"
        src="<%=request.getContextPath()%>/resources/dist/js/vendor/jquery-2.1.3.js"></script>
<script type="text/javascript"
        src="<%=request.getContextPath()%>/resources/dist/js/app/apputils.js"></script>

<!-- Loading Bootstrap -->
<link
        href="<%=request.getContextPath()%>/resources/dist/css/vendor/bootstrap.min.css"
        rel="stylesheet">

<!-- Loading Flat UI -->
<link
        href="<%=request.getContextPath()%>/resources/dist/css/flat-ui.css"
        rel="stylesheet">
<link
        href="<%=request.getContextPath()%>/resources/docs/assets/css/demo.css"
        rel="stylesheet">
</body>
</html>
