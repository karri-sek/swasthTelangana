<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en-us">
<head>
<style>
   .form-group.mandatory .control-label:after { 
	   content:"*";
	   color:red;
	}
</style>
<meta charset="UTF-8">
<title>Swasth Telangana</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/dist/css/AdminLTE.min.css"
	rel="stylesheet" type="text/css" />

<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/dist/img/icon.png">

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />

<%-- <!-- Font Awesome Icons -->
     <link href="<%=request.getContextPath()%>/resources/dist/css/font-awesome.min.css" rel="stylesheet"
           type="text/css"/>
     <!-- Ionicons -->
     <link href="<%=request.getContextPath()%>/resources/dist/css/ionicons.min.css" rel="stylesheet" type="text/css"/>--%>
<!-- jvectormap -->
<link
	href="<%=request.getContextPath()%>/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->

<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link
	href="<%=request.getContextPath()%>/resources/dist/css/skins/skin-blue.min.css"
	rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="skin-blue sidebar-mini">
	<div class="wrapper">

		<header class="main-header"> <!-- Logo --> <a href="#"
			class="logo"> <!-- mini logo for sidebar mini 50x50 pixels --> <span
			class="logo-mini"><b>S</b>T</span> <!-- logo for regular state and mobile devices -->
			<span class="logo-lg"><b>Swasth</b>Telangana</span>
		</a> <!-- Header Navbar: style can be found in header.less --> <nav
			class="navbar navbar-static-top" role="navigation"> <!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas" id="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a> <!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- Messages: style can be found in dropdown.less-->
				<!-- Notifications: style can be found in dropdown.less -->
				<!-- Tasks: style can be found in dropdown.less -->
				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <img
						src="<%=request.getContextPath()%>/resources/dist/img/user2-160x160.jpg"
						class="user-image" alt="User Image" /> <span class="hidden-xs">${userDetails.displayName}</span>
				</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header"><img
							src="<%=request.getContextPath()%>/resources/dist/img/user2-160x160.jpg"
							class="img-circle" alt="User Image" />

							<p>
								${userDetails.displayName} - ${userDetails.mobileNumber} <small>${userDetails.userRole}
									- ${userDetails.district}, ${userDetails.state}</small>
							</p></li>
						<!-- Menu Body -->
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" onclick="submitForm('/account/userProfile.action', 'NO-DATA', 'containerdiv');" class="btn btn-default btn-flat">Profile</a>
								<!--<input type="hidden" id = "__ctoken" name="__ctoken" value= '${__ctoken}'/> -->
							</div>
							<div class="pull-right">
								<button type="submit" class="btn btn-default btn-flat"
									onclick="submitForm('/account/logout.action', 'NO-DATA', 'containerdiv');">
									<span>Sign out</span>
								</button>
							</div>
						</li>
					</ul></li>
				<!-- Control Sidebar Toggle Button -->
			</ul>
		</div>

		</nav> </header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar"> <!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar"> <!-- /.search form --> <!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="active"><a href="#"
				onclick="submitForm('/account/dashboard.action', 'NO-DATA', 'containerdiv');">
					<i class="fa fa-dashboard"></i> <span>Dashboard</span>
			</a></li>
			<li class="active"><a href="#"
				onclick="submitForm('/account/regBasicInfo.action', 'NO-DATA', 'containerdiv');">
					<i class="fa fa-book"></i> <span>Registration</span>
			</a></li>
			<li class="active"><a href="#"
				onclick="submitForm('/account/enterPatientDetails.action', 'NO-DATA', 'containerdiv');">
					<i class="fa fa-bed"></i> <span>Patient entry</span>
			</a></li>
			<li class="treeview"><a href="#"> <i class="fa fa-th-list"></i>
					<span>Patient search</span> <i class="fa fa-search pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"
						onclick="submitForm('/account/patientIdReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by ID
					</a></li>
					<li><a href="#"
						onclick="submitForm('/account/patientNameReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by Name
					</a></li>
					<li><a href="#"
						onclick="submitForm('/account/patientContactReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by Mobile No
					</a></li>
					<li><a href="#"
						onclick="submitForm('/account/patientAadharReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by Aadhar No
					</a></li>
					<li><a href="#"
						onclick="submitForm('/account/formDateReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by Dates
					</a></li>

				</ul></li>
<%-- Disabling MTP and Birth report

			<li class="active"><a href="#"
				onclick="submitForm('/account/enterAbortingPatientDetails.action', 'NO-DATA', 'containerdiv');">
					<i class="fa fa-scissors"></i> <span>MTP</span>
			</a></li>
			<li class="treeview"><a href="#"> <i class="fa fa-th-list"></i>
					<span>MTP search</span> <i class="fa fa-search pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"
						onclick="submitForm('/account/mtpPatientIdReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by ID
					</a></li>
					<li><a href="#"
						onclick="submitForm('/account/mtpPatientNameReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by Name
					</a></li>
					<li><a href="#"
						onclick="submitForm('/account/mtpPatientContactReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by Mobile No
					</a></li>
					<li><a href="#"
						onclick="submitForm('/account/mtpPatientAadharReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by Aadhar No
					</a></li>
					<li><a href="#"
						onclick="submitForm('/account/mtpFormDateReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by Dates
					</a></li>

				</ul></li>
			<li class="active"><a href="#"
				onclick="submitForm('/account/enterBirthReportDetails.action', 'NO-DATA', 'containerdiv');">
					<i class="fa fa-child"></i> <span>Birth report</span>
			</a></li>
			<li class="treeview"><a href="#"> <i class="fa fa-th-list"></i>
					<span>Birth report search</span> <i class="fa fa-search pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"
						onclick="submitForm('/account/birthReportIdReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by ID
					</a></li>
					<li><a href="#"
						onclick="submitForm('/account/birthReportNameReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by Mother Name
					</a></li>
					<li><a href="#"
						onclick="submitForm('/account/birthReportContactReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by Mother Mobile No
					</a></li>
					<li><a href="#"
						onclick="submitForm('/account/birthReportAadharReportDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by Mother Aadhar No
					</a></li>
					<li><a href="#"
						onclick="submitForm('/account/birthReportsByDate.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>by Dates
					</a></li>

				</ul></li>
		--%>
			<li class="treeview"><a href="#"> <i class="fa fa-bar-chart"></i>
					<span>Statistics</span> <i class="fa pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"
						onclick="submitForm('/account/formFDashboardDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>Form F
					</a></li> <%-- 
					<li><a href="#"
						onclick="submitForm('/account/mtpDashboardDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>MTP
					</a></li>
					<li><a href="#"
						onclick="submitForm('/account/birtReporthDashboardDetails.action', 'NO-DATA', 'containerdiv');">
							<i class="fa fa-angle-double-right"></i>Birth report
					</a></li> --%>
				</ul></li>
			<c:if test="${userDetails.userRole == 'Administrator'}">
				<li class="treeview"><a href="#"> <i class="fa fa-gears"></i>
						<span>Management</span>
				</a>
					<ul class="treeview-menu">
						<li><a href="#"
							onclick="submitForm('/account/createaccount.action', 'NO-DATA', 'containerdiv');"><i
								class="fa fa-plus"></i> Create Account</a></li>
						<li><a href="#"
							onclick="submitForm('/account/updateaccount.action', 'NO-DATA', 'containerdiv');"><i
								class="fa fa-edit"></i> Update Account</a></li>
						<li><a href="#"
							onclick="submitForm('/account/formDateReportDetails.action', 'NO-DATA', 'containerdiv');"><i
								class="fa fa-group"></i> List Accounts</a></li>
						<li><a href="#"
							onclick="submitForm('/account/loggedInUserCount.action', 'NO-DATA', 'containerdiv');"><i
								class="fa fa-line-chart"></i> Logged in users info</a></li>		
						<li><a href="#"
							onclick="submitForm('/account/formDateReportDetails.action', 'NO-DATA', 'containerdiv');"><i
								class="fa fa-envelope"></i> Add banner</a></li>
						<li><a href="#"
							onclick="submitForm('/account/populateDistrictData.action', 'NO-DATA', 'containerdiv');"><i
								class="fa fa-database"></i> populate dist data</a></li>
					</ul></li>
				<li><a href="#"> <i class="fa fa-wrench"></i> <span>Setting</span>
						<small class="label pull-right bg-green">new</small>
				</a>
					<ul class="treeview-menu">
						<li><a href="#"
							onclick="submitForm('/account/createaccount.action', 'NO-DATA', 'containerdiv');"><i
								class="fa fa-angle-double-right"></i> Form F alerts</a></li>
					<%--	<li><a href="#"
							onclick="submitForm('/account/updateaccount.action', 'NO-DATA', 'containerdiv');"><i
								class="fa fa-angle-double-right"></i> MTP alerts</a></li>
						<li><a href="#"
							onclick="submitForm('/account/formDateReportDetails.action', 'NO-DATA', 'containerdiv');"><i
								class="fa fa-angle-double-right"></i> Birth report alerts</a></li>
					--%>
					</ul></li>
			</c:if>
		</ul>
		</section> <!-- /.sidebar --> </aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header"> <c:if
				test="${error != null}">
				<div class="alert alert-danger" role="alert">${error}</div>
			</c:if> <c:if test="${formName != null}">
				<h1>
					${formName} <small>${formSubName}</small>
				</h1>
			</c:if> </section>

			<!-- Main content -->
			<section class="content">
			<div id="containerdiv"></div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<!-- Control Sidebar -->
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
     immediately after the control sidebar -->
		<div class='control-sidebar-bg'></div>

	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.1.4 -->
	<script
		src="<%=request.getContextPath()%>/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- FastClick -->
	<script
		src='<%=request.getContextPath()%>/resources/plugins/fastclick/fastclick.min.js'></script>
	<!-- AdminLTE App -->
	<script src="<%=request.getContextPath()%>/resources/dist/js/app.js"
		type="text/javascript"></script>

	<!-- SlimScroll 1.3.0 -->
	<script
		src="<%=request.getContextPath()%>/resources/plugins/slimScroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- ChartJS 1.0.1 -->
	<script
		src="<%=request.getContextPath()%>/resources/plugins/chartjs/Chart.min.js"
		type="text/javascript"></script>
	<link
		href="<%=request.getContextPath()%>/resources/plugins/iCheck/all.css"
		rel="stylesheet" type="text/css" />

	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<%--<script src="<%=request.getContextPath()%>/resources/dist/js/pages/dashboard2.js" type="text/javascript"></script>--%>

	<!-- AdminLTE for demo purposes -->
	<%--<script src="<%=request.getContextPath()%>/resources/dist/js/demo.js" type="text/javascript"></script>--%>
	<%--<script type="text/javascript"
        src="<%=request.getContextPath()%>/resources/dist/js/jquery-2.1.3.js"></script>--%>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/resources/plugins/daterangepicker/daterangepicker.js"
		type="text/javascript"></script>
	<!-- daterange picker -->
	<link
		href="<%=request.getContextPath()%>/resources/plugins/daterangepicker/daterangepicker-bs3.css"
		rel="stylesheet" type="text/css" />

	<script
		src="<%=request.getContextPath()%>/resources/plugins/datatables/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/resources/plugins/datatables/dataTables.bootstrap.min.js"
		type="text/javascript"></script>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/dist/js/apputils.js"></script>

</body>
</html>
