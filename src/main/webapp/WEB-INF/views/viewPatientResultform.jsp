<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel panel-default">
    <div class="panel-heading">Patient Details</div>
    <div class="panel-body">
        <c:choose>
            <c:when test="${form != null}">
                <fieldset>
                    <form class="form-horizontal" method="POST" name="formEntry"
                          id="formEntry">
                        <div class="form-group">
                            <div class="col-md-7 col-lg-7"></div>
                            <div class="col-md-3 col-lg-3">
                                <div class="form-group">
                                    <a class="btn btn-primary"
                                       href="<%=request.getContextPath()%>/downLoadForm.action">Download
                                        Details as Excel</a>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-5 col-lg-5">Patient
                                Name </label> <label class="control-label col-md-9 col-lg-9">${form.patientName}</label>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-5 col-lg-5">Age</label> <label
                                class="control-label col-md-9 col-lg-9">${form.age}</label>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-5 col-lg-5">Patient
                                Address</label> <label class="control-label col-md-9 col-lg-9">${form.patientAddress.address}</label>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-5 col-lg-5">Aadhar
                                Number</label> <label class="control-label col-md-9 col-lg-9">${form.aadharNo}</label>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-5 col-lg-5">createdBy</label>
                            <label class="control-label col-md-9 col-lg-9">${form.createdBy}</label>
                        </div>
                    </form>
                </fieldset>
            </c:when>
            <c:otherwise>
                <fieldset>Ooops, No results found for your search.</fieldset>
            </c:otherwise>
        </c:choose>
    </div>
</div>