<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">DECLARATION BY APPLICANT</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	<form class="form-horizontal" method="POST" name="declaration"
		id="declaration" modelAttribute="declaration">

		<c:choose>
			<c:when test="${result != null}">
				<div class="alert alert-success">
					<strong>${result}!</strong> &nbsp; <a href="${downloadUrl}">
					</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="box-body">
					I, Sh./Smt./Kum./Dr. <strong><label class="control-label">Sulochana</label>
					</strong> son/daughter/wife of <b>W/O MR.Ramesh Kumar</b> aged <b> 48 </b> years resident<b> Hyderabad</b> working
					as (indicate designation) <b> Surgeon</b> in (indicate name of the
					organisation to be registered) <b> Image hospitals </b> hereby declare that I have read
					and understood the Pre-natal Diagnostic Techniques (Regulation and
					Prevention of Misuse) Act, 1994 (57 of 1994) and the Pre-natal
					Diagnostic Techniques (Regulation and Prevention of Misuse) Rules,
					1996, I also undertake to explain the said Act and Rules to all
					employees of the Genetic Counselling Centre/Genetic
					Laboratory/Genetic Clinic/ultrasound clinic/imaging centre in
					respect of which registration is sought and to ensure that Act and
					Rules are fully complied with. manner. Date: <b>30/Jan/2016</b> 
					<div class="box-footer">
						<label class="control-label col-md-3 col-lg-3" />

						<div class="col-sm-3">
							<a class="btn btn-primary" href="#"
								onclick="submitForm('/account/saveRegDeclaration.action', 'declaration', 'containerdiv');">Submit>></a>
						</div>
					</div>
					<input type="hidden" id="patientID" name="patientID"
						value="${patientID}" /> <input type="hidden" id="patientName"
						name="patientName" value="${patientName}" />
				</div>
			</c:otherwise>
		</c:choose>
	</form>
</div>