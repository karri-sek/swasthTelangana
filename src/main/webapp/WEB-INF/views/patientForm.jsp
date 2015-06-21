<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Horizontal Form -->
<form class="form-horizontal" method="POST" id="patientDetails">
    <div class="box box-info">
        <div class="box-header with-border">
            <h3 class="box-title">Patient Details</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->

        <div class="box-body">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Patient Name</label>

                <div class="col-sm-5">
                    <input type="text" class="form-control required" placeholder="Enter Patient Name" name="patientName"
                           id="patientName" value="${patient.patientName}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Aadhar No</label>

                <div class="col-sm-5">
                    <input type="text" class="form-control onlyNumber" placeholder="Enter Aadhar" name="aadharNo"
                           id="aadharNo"
                           value="${patient.aadharNo}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Contact No</label>

                <div class="col-sm-5">
                    <input type="text" class="form-control onlyMobileNum" placeholder="Enter contact No" id="contactno"
                           name="contactno"
                           value="${patient.contactno}"/>
                </div>
            </div>
            <!-- select -->
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Age</label>

                <div class="col-sm-2">
                    <select class="form-control" name="age" id="age">
                        <c:forEach var="i" begin="20" end="50">
                            <option>
                                <c:out value="${i}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <label for="inputPassword3" class="col-sm-1 control-label">Gender</label>

                <div class="col-sm-2">
                    <select class="form-control" name="gender" id="gender">
                        <option>Female</option>
                    </select>
                </div>
            </div>
        </div>
        <!-- /.box-body -->
    </div>

    <!-- Permanent Address Box-->
    <div class="box box-info">
        <div class="box-header with-border">
            <h3 class="box-title">Premanent Address</h3>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">City/Village Name</label>

                <div class="col-sm-5">
                    <input type="text" class="form-control required" placeholder="Enter City Name ..."
                           name="patient.patientAddress.cityName"
                           id="patient.patientAddress.cityName" value="${patient.patientAddress.cityName}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Address</label>

                <div class="col-sm-5">
                    <input type="text" class="form-control required" placeholder="Permanent Address ...."
                           name="patient.patientAddress.address"
                           id="patient.patientAddress.address" value="${patient.patientAddress.address}"/>
                </div>
            </div>
            <!-- select -->
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">District</label>

                <div class="col-sm-2">
                    <select class="form-control" id="patient.patientAddress.district"
                            name="patient.patientAddress.district"
                            value="${patient.patientAddress.district}">
                        <option>Hyderabad</option>
                        <option>Rangareddy</option>
                        <option>Karimnagar</option>
                        <option>Warangal</option>
                        <option>Adilabad</option>
                    </select>
                </div>
                <label for="inputPassword3" class="col-sm-1 control-label">State</label>

                <div class="col-sm-2">
                    <select class="form-control" id="patient.patientAddress.state"
                            name="patient.patientAddress.state"
                            value="${patient.patientAddress.state}">
                        <option>Telangana</option>
                        <option>Karnakata</option>
                        <option>Tamilnadu</option>
                        <option>Orissa</option>
                        <option>Maharastra</option>
                    </select>
                </div>
            </div>
        </div>
        <!-- /.box-body -->
    </div>

    <div class="box box-info">
        <div class="box-header with-border">
            <h3 class="box-title">Current Address</h3>
        </div>
        <!-- /.box-header -->
            <div class="box-body">
                <div class="form-group">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" onclick="myfunction();"/>
                            Same As Present Address
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">City/Village Name</label>

                    <div class="col-sm-5">
                        <input type="text" class="form-control" placeholder="City (OR) Village Name"
                               name="patient.patientCurrentAddress.cityName"
                               id="patient.patientCurrentAddress.cityName"
                               value="${patient.patientCurrentAddress.cityName}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">Address</label>

                    <div class="col-sm-5">
                        <input type="text" class="form-control" placeholder="Current Address"
                               name="patient.patientCurrentAddress.address"
                               id="patient.patientCurrentAddress.address"
                               value="${patient.patientCurrentAddress.address}"/>
                    </div>
                </div>
                <!-- select -->
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">District</label>

                    <div class="col-sm-2">
                        <select class="form-control" id="patient.patientCurrentAddress.district"
                                name="patient.patientCurrentAddress.district"
                                value="${patient.patientCurrentAddress.district}">
                            <option>Hyderabad</option>
                            <option>RangaReddy</option>
                            <option>Karimnagar</option>
                            <option>Warangal</option>
                            <option>Medak</option>
                        </select>
                    </div>
                    <label for="inputPassword3" class="col-sm-1 control-label">State</label>

                    <div class="col-sm-2">
                        <select class="form-control" id="patient.patientCurrentAddress.state"
                                name="patient.patientCurrentAddress.state"
                                value="${patient.patientCurrentAddress.state}">
                            <option>Telangana</option>
                            <option>Karnataka</option>
                            <option>Maharastra</option>
                            <option>Madhya Pradesh</option>
                            <option>Orissa</option>
                        </select>
                    </div>
                </div>
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
                <a type="submit" href='#' class="btn btn-default"
                   onclick="submitForm('/account/savePatientDetails.action', 'patientDetails', 'containerdiv');">Save</a>
                <a type="submit" class="btn btn-info pull-right" href="#"
                   onclick="submitForm('/account/savePatientDetailsAndContinue.action', 'patientDetails', 'containerdiv');">Continue</a>
            </div>
            <!-- /.box-footer -->
            <input type="hidden" id="formID" name="createdBy" value="${loginID}"/>
            <input type="hidden" id="patientID" name="patientID" value="${patient.patientID}"/>
    </div>
</form>