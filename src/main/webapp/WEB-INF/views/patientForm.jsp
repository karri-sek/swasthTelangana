<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel panel-default">
    <div class="panel-heading"><B>Enter Patient Details</B></div>
    <div class="panel-body">
        <fieldset>
            <form class="form-horizontal" method="POST" id="patientDetails"
                  role="form">
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">Patient Name:</label>

                    <div class="col-md-9 col-lg-9">
                        <input class="form-control required" type="text" name="patientName"
                               id="patientName" value="${patient.patientName}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">Aadhar No:</label>

                    <div class="col-md-9 col-lg-9">
                        <input class="form-control isANumber" type="text" name="aadharNo" id="aadharNo"
                               value="${patient.aadharNo}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">Contact No:</label>

                    <div class="col-md-9 col-lg-9">
                        <input class="form-control " id="patient.patientAddress.contactno"
                               name="patient.patientAddress.contactno"
                               value="${patient.patientAddress.contactno}"> </input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">Age:</label>

                    <div class="col-md-2 col-lg-2">
                        <select class="form-control isANumber" name="age" id="age">
                            <c:forEach var="i" begin="23" end="90">
                                <option>
                                    <c:out value="${i}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <label class="control-label col-md-1 col-lg-1">Gender:</label>

                    <div class="col-md-3 col-lg-3">
                        <select class="form-control" name="gender" id="gender">
                            <c:forTokens items="Female,Male" delims="," var="i">
                                <option>
                                    <c:out value="${i}"/>
                                </option>
                            </c:forTokens>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <legend>Present Address</legend>
                    <label class="control-label col-md-3 col-lg-3">City/Village Name:</label>
                    <div class="col-md-3 col-lg-3">
                        <input class="form-control required" type="text" name="cityName"
                               id="cityName" value="${patient.patientAddress.cityName}"/>
                    </div>
                    <label class="control-label col-md-1 col-lg-1">District:</label>
                    <div class="col-md-3 col-lg-3">
                        <input class="form-control" id="patient.patientAddress.district"
                               name="patient.patientAddress.district"
                               value="${patient.patientAddress.district}"> </input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">State:</label>
                    <div class="col-md-3 col-lg-3">
                        <input class="form-control" id="patient.patientAddress.state"
                               name="patient.patientAddress.state" value="${patient.patientAddress.state}"> </input>
                    </div>
                    <label class="control-label col-md-1 col-lg-1">Pincode:</label>
                    <div class="col-md-3 col-lg-3">
                        <input class="form-control" id="patient.patientAddress.pincode"
                               name="patient.patientAddress.pincode" value="${patient.patientAddress.pincode}"> </input>
                    </div>
                </div>
                <div class="form-group">
                    <legend>Current Address:</legend>
                </div>

                <input type="hidden" id="formID" name="createdBy" value="${loginID}"/>
                <input type="hidden" id="patientID" name="patientID" value="${patient.patientID}"/>

                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3"></label>

                    <div class="col-md-3 col-lg-3">
                        <a class="btn btn-primary btn-lg btn-block" href="#"
                           onclick="submitForm('/account/savePatientDetails.action', 'patientDetails', 'containerdiv');">Save</a>
                    </div>
                    <div class="col-md-6 col-lg-6">
                        <a class="btn btn-primary btn-lg btn-block" href="#"
                           onclick="submitForm('/account/savePatientDetailsAndContinue.action', 'patientDetails', 'containerdiv');">Save
                            And Continue>></a>
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
</div>
