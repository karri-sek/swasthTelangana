<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">Centre details</h3>
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
            <label class="control-label col-sm-2"> Type of ownership </label>
            <div class="col-sm-2">
                <select class="form-control" id="district" name="district" value="${clinicAddress.district}">
                    <option value="Hyderabad">Individual ownership</option>
                    <option value="Hyderabad">Partnership</option>
                    <option value="Hyderabad">Company</option>
                    <option value="Hyderabad">Co-operative</option>
                    <option value="Hyderabad">Others</option>
                </select>
            </div>
        </div>
        <div class="form-group mandatory">
            <label class="control-label col-sm-2">Articles of association</label>

            <div class="col-sm-5">
                <input class='form-control required' placeholder="Articles of association ..." name="clinicName" type='text' value="${clinicAddress.clinicName}"/>
            </div>
        </div>
        <div class="form-group mandatory">
            <label class="control-label col-sm-2">Names and addresses</label>

            <div class="col-sm-5">
                <input class='form-control required' placeholder="Names and addresses ..." name="clinicName" type="text" value="${clinicAddress.clinicName}"/>
            </div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-sm-2"> Type of Institution </label>
            <div class="col-sm-2">
				<select class="form-control" id="district" name="district"
					value="${clinicAddress.district}">
					<option value="Hyderabad">Govt. Hospital</option>
					<option value="Hyderabad">Municipal Hospital</option>
					<option value="Hyderabad">Public Hospital</option>
					<option value="Hyderabad">Private Hospital</option>
					<option value="Hyderabad">Private Nursing Home</option>
					<option value="Hyderabad">Private Clinic</option>
					<option value="Hyderabad">Private Laboratory</option>
					<option value="Hyderabad">Others</option>
				</select>
			</div>
        </div>
        <div class="form-group mandatory">
            <label class="control-label col-sm-2" title="Specific for which approval is sought">Approval is for - Invasive</label>

            <div class="col-sm-2">
				<select class="form-control" id="district" name="district"
					value="${clinicAddress.district}">
					<option value="Hyderabad">Amniocentesis</option>
					<option value="Hyderabad">Chorionic villi aspiration</option>
					<option value="Hyderabad">Chromosomal</option>
					<option value="Hyderabad">Biochemical</option>
					<option value="Hyderabad">Molecular studies</option>
					<option value="Hyderabad">Others</option>
				</select>
			</div>
			<label class="control-label col-sm-2" title="Specific for which approval is sought">Approval is for - Non-Invasive</label>

            <div class="col-sm-2">
				<select class="form-control" id="district" name="district"
					value="${clinicAddress.district}">
					<option value="Hyderabad">Ultrasonography</option>
					<option value="Hyderabad">Others</option>
				</select>
			</div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Equipment make and model</label>

            <div class="col-sm-5">
                <input class='form-control' placeholder="Equipment available with the make and model" name="contactNum"
                       type='text' value="${clinicAddress.contactNum}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Facilities available</label>

			<div class="col-sm-2">
				<select class="form-control" id="district" name="district"
					value="${clinicAddress.district}">
					<option value="Hyderabad">Ultrasound</option>
					<option value="Hyderabad">Amniocentesis</option>
					<option value="Hyderabad">Chorionic villi aspiration</option>
					<option value="Hyderabad">Foetoscopy</option>
					<option value="Hyderabad">Foetal biopsy</option>
					<option value="Hyderabad">Cordocentesis</option>
					<option value="Hyderabad">Chromosomal studies</option>
					<option value="Hyderabad">Biochemical studies</option>
					<option value="Hyderabad">Molecular studies</option>
					<option value="Hyderabad">Preimplantation genetic
						diagnosis</option>
				</select>
			</div>
		</div>
        
        <input type="hidden" id="operation" name="operation" value="${clinicAddress.operation}"/>
        
        <div class="box-footer">
				<label class="control-label col-sm-2"></label>
				<div class="col-sm-3">
					<a class="btn btn-default col-sm-5" href="#"
						onclick="submitForm('/account/previousRegCentreDetails.action', 'clinicFormPrevious', 'containerdiv');">Previous</a>
				</div>
				<div class="col-sm-3">
					<a class="btn btn-primary" href="#"
						onclick="submitForm('/account/saveRegCentreDetails.action', 'clinicForm', 'containerdiv');">Save</a>
				</div>
				<div class="col-sm-3">
					<a class="btn btn-primary" href="#"
						onclick="submitForm('/account/nextRegCentreDetails.action', 'clinicForm', 'containerdiv');">Next</a>
				</div>
			</div>
        
    </form>
    
    <form name="clinicFormPrevious" id="clinicFormPrevious">
    	<input name="patientID" type="hidden" value="${clinicAddress.patientID}"/>
    	<input name="patientName" type='hidden' value="${clinicAddress.patientName}"/>
    </form>
</div>