<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">FORM F:Section A:To be filled in for
            all Diagnostic Procedures/Tests</h3>
    </div>
    <c:if test="${error != null}">
        <div class="alert alert-danger" role="alert">${error}</div>
    </c:if>
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
            <label class="col-sm-2 control-label"> Patient ID </label>

            <div class="col-sm-2">
                <input class='form-control' name="patientID" type='text' value="${clinicAddress.patientID}"/>
            </div>

            <label class="control-label col-sm-2"> Patient Name </label>

            <div class="col-sm-5">
                <input class='form-control' name="patientName" type='text' value="${clinicAddress.patientName}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2"> Clinic Name</label>

            <div class="col-sm-5">
                <input class='form-control required' placeholder="Enter Clinic Name ..." name="clinicName" type='text' value="${clinicAddress.clinicName}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Clinic Mobile</label>

            <div class="col-sm-5">
                <input class='form-control onlyMobileNum' placeholder="Enter Clinic contact No" name="contactNum"
                       type='text' value="${clinicAddress.contactNum}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Clinic Address</label>

            <div class="col-sm-5">
                <textarea class='form-control' rows='3' name="address"
                          value="${clinicAddress.address}">${clinicAddress.address}</textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2"> District: </label>

            <div class="col-sm-2">
                <select class="form-control" id="district" name="district" value="${clinicAddress.district}">
                    <option>Hyderabad</option>
                    <option>Rangareddy</option>
                    <option>Karimnagar</option>
                    <option>Warangal</option>
                    <option>Adilabad</option>
                </select>
            </div>
            <%--<div class="col-sm-3">
                <input class='form-control' name="district" type='text' value='${clinicAddress.district}'/>
            </div>--%>
            <label class="control-label col-sm-2"> State: </label>

            <div class="col-sm-2">
                <select class="form-control" id="state" name="state" value="${clinicAddress.state}">
                    <option>Telangana</option>
                    <option>Karnakata</option>
                    <option>Tamilnadu</option>
                    <option>Orissa</option>
                    <option>Maharastra</option>
                </select>
            </div>

          <%--  <div class="col-sm-3">
                <input class='form-control' name="state" type='text' value="${clinicAddress.state}"/>
            </div>--%>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2"> Pincode</label>

            <div class="col-sm-5">
                <input class='form-control' name="pincode" type='text' value="${clinicAddress.pincode}"/>
            </div>
        </div>
        <div class="box-footer">
            <a class="btn btn-default pull-left" href="#"
               onclick="submitForm('/account/previousClinicDetails.action', 'clinicForm', 'containerdiv');">Previous</a>
            <label class="control-label col-sm-3"></label>
            <a class="btn bg-primary btn-flat margin" href="#"
               onclick="submitForm('/account/saveClinicDetails.action', 'clinicForm', 'containerdiv');">Save</a>
            <a class="btn btn-primary pull-right" href="#"
               onclick="submitForm('/account/nextClinicDetails.action', 'clinicForm', 'containerdiv');">Next</a>
        </div>
    </form>
</div>