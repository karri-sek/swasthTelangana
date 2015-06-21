<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en-us">
<head>
    <meta charset="utf-8">
    <title>Swasth Telangana</title>
    <meta name="description" content="Swasth telangana work desk"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12 col-lg-12 col-sm-12">
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
                            Entry<span class="navbar-unread"></span>
                        </a></li>
                        <li><a href="#"
                               onclick="submitForm('/account/formftab.action', 'NO-DATA', 'lhndiv');">Form
                            F<span class="navbar-unread"></span>
                        </a></li>
                        <li><a href="#"
                               onclick="submitForm('/account/userAccounttab.action', 'NO-DATA', 'lhndiv');">Account<span
                                class="navbar-unread"></span>
                        </a></li>

                        <c:if test="${userDetails.userRole == 'Administrator'}">
                            <li><a href="#"
                                   onclick="submitForm('/account/accountmanagementtab.action', 'NO-DATA', 'lhndiv');">Management<span
                                    class="navbar-unread"></span>
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
                    <form class="navbar-form navbar-right" action="#">
                        <button type="submit" class="btn"
                                onclick="submitForm('/account/logout.action', 'NO-DATA', 'canvas');">
                            <span>Log out:${userDetails.displayName} </span>
                        </button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
    <%@ include file="patiententrywelocomelhn.jsp" %>
    <div class="row">
            <div id="containerdiv"/>
    </div>
</div>
<script type="text/javascript"
        src="<%=request.getContextPath()%>/resources/dist/js/jquery-2.1.3.js"></script>
<script type="text/javascript"
        src="<%=request.getContextPath()%>/resources/dist/js/apputils.js"></script>
<%--<link href="<%=request.getContextPath()%>/resources/dist/css/bootstrap.css" rel="stylesheet">--%>
</body>
</html>