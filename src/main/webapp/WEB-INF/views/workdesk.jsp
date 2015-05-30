<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>Swasth Telangana work desk</title>
    <meta name="description" content="Swasth telangana work desk"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body bgcolor="#edeff1" class="gray-lightest">
<div class="container-fluid">
    <div class="row demo-row">
        <div class="col-xs-12">
            <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#navbar-collapse-01">
                        <span class="sr-only">Toggle navigation</span>
                    </button>
                    <a class="navbar-brand" href="#"
                       onclick="submitForm('/account/backtohome.action', 'NO-DATA', 'containerdiv');">Home</a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-collapse-01">
                    <ul class="nav navbar-nav navbar-left">
                        <li><a href="#"
                               onclick="submitForm('/account/newpatiententrytab.action', 'NO-DATA', 'lhndiv');">Patient
                            Entry<span class="navbar-unread">1</span>
                        </a></li>
                        <li><a href="#"
                               onclick="submitForm('/account/formftab.action', 'NO-DATA', 'lhndiv');">Form
                            F<span class="navbar-unread">1</span>
                        </a></li>
                        <li><a href="#"
                               onclick="submitForm('/account/userAccounttab.action', 'NO-DATA', 'lhndiv');">Account<span
                                class="navbar-unread">1</span>
                        </a></li>

                        <c:if test="${userDetails.userRole == 'Administrator'}">
                            <li><a href="#"
                                   onclick="submitForm('/account/accountmanagementtab.action', 'NO-DATA', 'lhndiv');">Management<span
                                    class="navbar-unread">1</span>
                            </a></li>
                        </c:if>

                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                data-toggle="dropdown"
                                                onclick="submitForm('/account/underconstruction.action', 'NO-DATA', 'containerdiv');">About
                            Us <b class="caret"></b>
                        </a> <span class="dropdown-arrow"></span>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Link</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </li>
                        <li>
                    </ul>
                    <form class="navbar-form navbar-right" action="#" role="search">
                        <div class="form-group">
                            <div class="input-group">
								<span>
									<button type="submit" class="btn"
                                            onclick="submitForm('/account/logout.action', 'NO-DATA', 'canvas');">
                                        <span>Log out:${userDetails.displayName} </span>
                                    </button>
								</span>
                            </div>
                        </div>
                    </form>
                </div>
            </nav>
        </div>
    </div>
    <div class="col-xs-3, col-lg-3 col-md-3 col-sm-3">
        <div class="sidebar-nav">
            <div class="navbar navbar-default" role="navigation">
                <div class="navbar-collapse collapse sidebar-navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="#"
                               onclick="submitForm('/account/enterPatientDetails.action', 'NO-DATA', 'containerdiv');">New
                            Patient entry</a>
                        </li>
                        <li><a href="#"
                               onclick="submitForm('/account/patientNameReportDetails.action', 'NO-DATA', 'containerdiv');">Search
                            by name</a>
                        </li>
                        <li><a href="#"
                               onclick="submitForm('/account/patientIdReportDetails.action', 'NO-DATA', 'containerdiv');">Search
                            by ID</a>
                        </li>
                        <li><a href="#"
                               onclick="submitForm('/account/formDateReportDetails.action', 'NO-DATA', 'containerdiv');">Search
                            with dates</a>
                        </li>
                        <li><a href="#"
                               onclick="submitForm('/account/patientProfiles.action', 'NO-DATA', 'containerdiv');">Patient
                            Profiles</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xs-9, col-lg-9 col-md-9 col-sm-9">
        <div id="containerdiv">
            <div class="login-form">
                &nbsp;&nbsp; Welcome to Swasth telangana.
            </div>
            <br/>
        </div>
    </div>
</div>
</div>
<script type="text/javascript"
        src="<%=request.getContextPath()%>/resources/dist/js/app/jquery-2.1.3.js"></script>
<script type="text/javascript"
        src="<%=request.getContextPath()%>/resources/dist/js/app/apputils.js"></script>
<link href="<%=request.getContextPath()%>/resources/dist/css/bootstrap.css" rel="stylesheet">
</body>
</html>