<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="panel panel-default">
    <div class="panel-heading"><u>FORM F:Section A:To be filled in for
        all Diagnostic Procedures/Tests</u>
    </div>
    <div class="panel-body">
        <fieldset>
            <form class="form-horizontal" method="POST" name="clinicForm"
                  id="clinicForm" modelAttribute="clinicAddress">
                <div class="form-group">
                    <c:if test="${errorMessage != null}">
                        <div class="form-group">
                            <div class="alert alert-success">
                                <a href="#" class="close" data-dismiss="alert">&times;</a>
                                <c:choose>
                                    <c:when test="${errorMessage != null}">${errorMessage}</c:when>
                                </c:choose>
                            </div>
                        </div>
                    </c:if>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3"> Patient ID:
                    </label>

                    <div class="col-md-9 col-lg-9">
                        <input class='form-control uneditable-input' name="patientID"
                               type='text' value="${clinicAddress.patientID}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3"> Patient
                        Name: </label>

                    <div class="col-md-9 col-lg-9">
                        <input class='form-control uneditable-input' name="patientName"
                               type='text' value="${clinicAddress.patientName}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">
                        Clinic Name: </label>

                    <div class="col-md-4 col-lg-4">
                        <input class='form-control' name="clinicName"
                               type='text' value="${clinicAddress.clinicName}"/>
                    </div>
                    <label class="control-label col-md-1 col-lg-1">Mobile:</label>

                    <div class="col-md-4 col-lg-4">
                        <input class='form-control' name="contactNum"
                               type='text' value="${clinicAddress.contactNum}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">
                        Clinic Address:</label>

                    <div class="col-md-9 col-lg-9">
                        <textarea class='form-control' name="address"
                                  value="${clinicAddress.address}">${clinicAddress.address}</textarea>
                    </div>

                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">
                        District: </label>

                    <div class="col-md-3 col-lg-3">
                        <input class='form-control' name="district"
                               type='text' value='${clinicAddress.district}'/>
                    </div>
                    <label class="control-label col-md-1 col-lg-1">
                        State: </label>

                    <div class="col-md-3 col-lg-3">
                        <input class='form-control' name="state"
                               type='text' value="${clinicAddress.state}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">
                        Pincode: </label>

                    <div class="col-md-3 col-lg-3">
                        <input class='form-control' name="pincode"
                               type='text' value="${clinicAddress.pincode}"/>
                    </div>
                </div>
                <div class="form-actions">
                    <label class="control-label col-md-3 col-lg-3"></label>

                    <div class="col-md-3 col-lg-3">
                        <a class="btn btn-primary" href="#"
                           onclick="submitForm('/account/previousClinicDetails.action', 'clinicForm', 'containerdiv');">Previous</a>
                    </div>
                    <div class="col-md-3 col-lg-3">
                        <a class="btn btn-primary" href="#"
                           onclick="submitForm('/account/saveClinicDetails.action', 'clinicForm', 'containerdiv');">Save</a>
                    </div>
                    <div class="col-md-3 col-lg-3">
                        <a class="btn btn-primary" href="#"
                           onclick="submitForm('/account/nextClinicDetails.action', 'clinicForm', 'containerdiv');">Next</a>
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
</div>