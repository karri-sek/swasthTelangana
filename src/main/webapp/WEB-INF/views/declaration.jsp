<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">DECLARATION OF DOCTOR/PERSON
            CONDUCTING PRE NATAL DIAGNOSTIC PROCEDURE/TEST</h3>
    </div>
    <!-- /.box-header -->
    <!-- form start -->
    <form class="form-horizontal" method="POST" name="declaration" id="declaration" modelAttribute="declaration">

        <c:if test="${result != null}">
            <div class="alert alert-success">
                <a href="#" class="close" data-dismiss="alert">&times;</a> <strong>${result}!</strong>
            </div>
        </c:if>
        <div class="box-body">
            I, <strong><label class="control-label">${doctorName}</label>
        </strong> (name of the person conducting ultrasonography/image scanning)
            declare that while conducting ultrasonography/image scanning on <strong>Ms./
            Mr.${patientName}</strong> (name of the pregnant woman or the person
            undergoing pre natal diagnostic procedure/ test), I have neither
            detected nor disclosed the sex of her fetus to anybody in any manner.
            Date:
            <div class="box-footer">
                <label class="control-label col-md-3 col-lg-3"/>

                <div class="col-sm-3">
                    <a class="btn btn-primary" href="#"
                       onclick="submitForm('/account/saveDeclarationDetails.action', 'declaration', 'containerdiv');">Submit>></a>
                </div>
            </div>
            <input type="hidden" id="patientID" name="patientID" value="${patientID}"/>
            <input type="hidden" id="patientName" name="patientName" value="${patientName}"/>
        </div>
    </form>
</div>