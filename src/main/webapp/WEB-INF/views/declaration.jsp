<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal" method="POST" name="declaration"
      id="declaration" modelAttribute="declaration">
    <div class="panel panel-default">
        <div class="panel-heading">DECLARATION OF DOCTOR/PERSON
            CONDUCTING PRE NATAL DIAGNOSTIC PROCEDURE/TEST
        </div>
        <c:if test="${result != null}">
            <div class="alert alert-success">
                <a href="#" class="close" data-dismiss="alert">&times;</a> <strong>${result}!</strong>
            </div>
        </c:if>
        <div class="panel-body">
            I, <strong><label class="control-label">${doctorName}</label>
        </strong> (name of the person conducting ultrasonography/image scanning)
            declare that while conducting ultrasonography/image scanning on <strong>Ms./
            Mr.${patientName}</strong> (name of the pregnant woman or the person
            undergoing pre natal diagnostic procedure/ test), I have neither
            detected nor disclosed the sex of her fetus to anybody in any manner.
            Date:
            <div class="form-actions">
                <label class="control-label col-md-3 col-lg-3"/>

                <div class="col-md-9 col-lg-9">
                    <a class="btn btn-primary col-md-9 col-lg-9" href="#"
                       onclick="submitForm('/account/saveDeclarationDetails.action', 'declaration', 'containerdiv');">Submit>></a>
                </div>
            </div>
        </div>
        <input type="hidden" id="patientID" name="patientID" value="${patientID}"/>
        <input type="hidden" id="patientName" name="patientName" value="${patientName}"/>
    </div>
</form>