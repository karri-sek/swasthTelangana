<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">FORM C:Section A:To be filled in for
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
        <div class="form-group mandatory">
            <label class="control-label col-sm-2"> Clinic Name</label>

            <div class="col-sm-5">
                <input class='form-control required' placeholder="Enter Clinic Name ..." name="clinicName" type='text' value="${clinicAddress.clinicName}"/>
            </div>
        </div>
        <div class="form-group mandatory">
            <label class="control-label col-sm-2" title="Under PC& PNDT Act, 1994"> Registration No.</label>

            <div class="col-sm-5">
                <input class='form-control required onlyNumber' placeholder="Under PC& PNDT Act, 1994" name="registrationNo" type='text' value="${clinicAddress.registrationNo}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Clinic contact no.</label>

            <div class="col-sm-5">
                <input class='form-control onlyNumber' placeholder="Enter Clinic contact No" name="contactNum"
                       type='text' value="${clinicAddress.contactNum}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Clinic Address</label>

            <div class="col-sm-5">
                <textarea class='form-control' rows='3' name="address">${clinicAddress.address}</textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2"> District: </label>

            <div class="col-sm-2">
                <select class="form-control" id="district" name="district" value="${clinicAddress.district}">
                    <option value="Hyderabad" ${clinicAddress.district == 'Hyderabad' ? 'selected' : ''}>Hyderabad</option>
                    <option value="Rangareddy" ${clinicAddress.district == 'Rangareddy' ? 'selected' : ''}>Rangareddy</option>
                    <option value="Karimnagar" ${clinicAddress.district == 'Karimnagar' ? 'selected' : ''}>Karimnagar</option>
                    <option value="Warangal" ${clinicAddress.district == 'Warangal' ? 'selected' : ''}>Warangal</option>
                    <option value="Adilabad" ${clinicAddress.district == 'Adilabad' ? 'selected' : ''}>Adilabad</option>
                </select>
            </div>
            <label class="control-label col-sm-2"> State: </label>

            <div class="col-sm-2">
                <select class="form-control" id="state" name="state" value="${clinicAddress.state}">
                    <option value="Telangana" ${clinicAddress.state == 'Telangana' ? 'selected' : ''}>Telangana</option>
                    <option value="Andhra Pradesh" ${clinicAddress.state == 'Andhra Pradesh' ? 'selected' : ''}>Andhra Pradesh</option>
                    <option value="Tamilnadu" ${clinicAddress.state == 'Tamilnadu' ? 'selected' : ''}>Tamilnadu</option>
                </select>
            </div>
          
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2"> Pincode</label>

            <div class="col-sm-5">
                <input class='form-control onlyNumber' name="pincode" type='text' value="${clinicAddress.pincode}"/>
            </div>
        </div>
        
        <input type="hidden" id="operation" name="operation" value="${clinicAddress.operation}"/>
        
        <div class="box-footer">
				<label class="control-label col-sm-2"></label>
				<div class="col-sm-3">
					<a class="btn btn-default col-sm-5" href="#"
						onclick="submitForm('/account/previousAbortingClinicDetails.action', 'clinicFormPrevious', 'containerdiv');">Previous</a>
				</div>
				<div class="col-sm-3">
					<a class="btn btn-primary" href="#"
						onclick="submitForm('/account/saveAbortingClinicDetails.action', 'clinicForm', 'containerdiv');">Save</a>
				</div>
				<div class="col-sm-3">
					<a class="btn btn-primary" href="#"
						onclick="submitForm('/account/nextAbortingClinicDetails.action', 'clinicForm', 'containerdiv');">Next</a>
				</div>
			</div>
        
    </form>
    
    <form name="clinicFormPrevious" id="clinicFormPrevious">
    	<input name="patientID" type="hidden" value="${clinicAddress.patientID}"/>
    	<input name="patientName" type='hidden' value="${clinicAddress.patientName}"/>
    </form>
</div>