<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel panel-default">
    <div class="panel-heading" align="center"><B>Enter Patient Details</B></div>
    <c:if test="${error != null}">
        <div class="alert alert-danger" role="alert">${error}</div>
    </c:if>
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
                        <input class="form-control onlyNumber" type="text" name="aadharNo" id="aadharNo"
                               value="${patient.aadharNo}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">Contact No:</label>

                    <div class="col-md-9 col-lg-9">
                        <input class="form-control onlyMobileNum" id="patient.contactno"
                               name="patient.contactno"
                               value="${patient.contactno}"> </input>
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
                        <input class="form-control required" type="text" name="patient.patientAddress.cityName"
                               id="patient.patientAddress.cityName" value="${patient.patientAddress.cityName}"/>
                    </div>
                    <label class="control-label col-md-1 col-lg-1">District:</label>

                    <div class="col-md-3 col-lg-3">
                        <input class="form-control required" id="patient.patientAddress.district"
                               name="patient.patientAddress.district"
                               value="${patient.patientAddress.district}"> </input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">State:</label>

                    <div class="col-md-3 col-lg-3">
                        <input class="form-control required" id="patient.patientAddress.state"
                               name="patient.patientAddress.state" value="${patient.patientAddress.state}"> </input>
                    </div>
                    <label class="control-label col-md-1 col-lg-1">Pincode:</label>

                    <div class="col-md-3 col-lg-3">
                        <input class="form-control" id="patient.patientAddress.pincode"
                               name="patient.patientAddress.pincode" value="${patient.patientAddress.pincode}"> </input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">Address:</label>

                    <div class="col-md-7 col-lg-7">
                        <input class="form-control required" type="text" name="patient.patientAddress.address"
                               id="patient.patientAddress.address" value="${patient.patientAddress.address}"
                               checked="checked"/>
                    </div>
                </div>

                <div class="form-group">
                    <legend>Current Address</legend>
                    <input class="col-md-1 col-lg-1" type="checkbox"
                           name="patient.patientCurrentAddress.sameAsPresentAddress"
                           id="patient.patientCurrentAddress.sameAsPresentAddress"
                           value="${patient.patientCurrentAddress.sameAsPresentAddress}"
                            onclick="myfunction();"/>
                    <label class="control-label col-md-4 col-lg-4">Same as Present Address</label>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">City/Village Name:</label>

                    <div class="col-md-3 col-lg-3">
                        <input class="form-control" type="text" name="patient.patientCurrentAddress.cityName"
                               id="patient.patientCurrentAddress.cityName"
                               value="${patient.patientCurrentAddress.cityName}"/>
                    </div>
                    <label class="control-label col-md-1 col-lg-1">District:</label>

                    <div class="col-md-3 col-lg-3">
                        <input class="form-control" id="patient.patientCurrentAddress.district"
                               name="patient.patientCurrentAddress.district"
                               value="${patient.patientCurrentAddress.district}"> </input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">State:</label>

                    <div class="col-md-3 col-lg-3">
                        <input class="form-control" id="patient.patientCurrentAddress.state"
                               name="patient.patientCurrentAddress.state"
                               value="${patient.patientCurrentAddress.state}"> </input>
                    </div>
                    <label class="control-label col-md-1 col-lg-1">Pincode:</label>

                    <div class="col-md-3 col-lg-3">
                        <input class="form-control" id="patient.patientCurrentAddress.pincode"
                               name="patient.patientCurrentAddress.pincode"
                               value="${patient.patientCurrentAddress.pincode}"> </input>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">Address:</label>

                    <div class="col-md-7 col-lg-7">
                        <input class="form-control" type="text" name="patient.patientCurrentAddress.address"
                               id="patient.patientCurrentAddress.address"
                               value="${patient.patientCurrentAddress.address}"/>
                    </div>
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
                            & Continue</a>
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
</div>
