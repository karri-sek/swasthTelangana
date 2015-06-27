<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://css-spinners.com/css/spinner/throbber.css" type="text/css">
<head>
    <meta charset="utf-8">
    <title>Swasth Telangana</title>
    <meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/dist/img/icon.png">
    <script src="<%=request.getContextPath()%>/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
</head>
<body>

<div class="container" style="margin-top:40px" id="canvas" name="canvas">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>Sign in to continue</strong>
                </div>
                <div class="panel-body">
                    <form role="form" method="POST" name="loginform" id="loginform" commandName="loginUser"
                          enctype="multipart/form-data">
                        <fieldset>
                            <div class="row">
                                <div class="center-block">
                                    <img class="profile-img"
                                         src="<%=request.getContextPath()%>/resources/dist/img/icon.png"
                                         alt="swasthTelangana">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 col-md-10  col-md-offset-1">
                                    <div class="form-group">
                                        <div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-user"></i>
												</span>
                                            <input class="form-control" placeholder="Username" name="userName"
                                                   id="userName"
                                                   type="text" autofocus>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-lock"></i>
												</span>
                                            <input class="form-control" placeholder="Password" name="password"
                                                   id="password"
                                                   type="password" value="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <a href="#" class="btn btn-lg btn-primary btn-block"
                                           onclick="submitForm('/account/loginsubmission.action', 'loginform', 'canvas');"
                                           value="Sign in"> Sign in</a>
                                    </div>
                                    <div id='loginspinner'></div>
                                    <div class="panel-footer">
                                        <c:if test="${error != null}">
                                            <div class="alert alert-danger" role="alert">${error}</div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/dist/js/jquery-2.1.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/dist/js/apputils.js"></script>
</body>
</html>
