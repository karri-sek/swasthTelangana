<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="box">
    <div class="box-header with-border">
        <h3 class="box-title">Patient Profiles Created by ${name}</h3>
    </div>
   <%-- <c:if test="${error != null}">
        <div class="alert alert-danger" role="alert">${error}</div>
    </c:if>--%>
        <div class="box-body" id="resultDev">
           <%-- <div class="form-group">
                <c:if test="${result != null}">
                    <div class="form-group">
                        <div class="alert alert-success">
                            <a href="#" class="close" data-dismiss="alert">&times;</a>
                            <c:choose>
                                <c:when test="${result != null}">${result}</c:when>
                            </c:choose>
                        </div>
                    </div>
                </c:if>
            </div>--%>
                <table id="patientProfiles" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Patient ID</th>
                        <th>Patient Name</th>
                        <th>Mobile No</th>
                        <th>Aadhar No</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${result != null}">
                        <c:forEach var="patient" items="${patientProfiles}">
                            <tr>
                                <td><c:out value="${patient.patientID}"/></td>
                                <td><c:out value="${patient.patientName}"/></td>
                                <td><c:out value="${patient.contactno}"/></td>
                                <td><c:out value="${patient.aadharNo}"/></td>
                                <c:url value='/downLoadPatientProfile.action' var="url">
                                    <c:param name="filePath" value="${patient.formFDownloadPath}"/>
                                </c:url>
                                <c:if test="${patient.formFDownloadPath != null}">
                                    <td><a class="btn btn-primary"
                                           href="${url}">Download Form F</a>
                                            <%-- <%=request.getContextPath()%><a class="btn btn-primary col-md-9 col-lg-9" href="#"
                                               onclick="submitForm('${url}', 'patientProfiles', 'searchResultdiv')">Download</a>--%>
                                    </td>
                                </c:if>
                                <c:url value='/enterPatientDetails.action' var="continueurl">
                                    <c:param name="patientID" value="${patient.patientID}"/>
                                </c:url>
                                <c:if test="${patient.formFDownloadPath == null}">
                                    <td><a class="btn btn-primary" href="#"
                                           onclick="submitForm('${continueurl}', 'patientProfiles', 'containerdiv')">Continue</a>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th>Patient ID</th>
                        <th>Patient Name</th>
                        <th>Mobile No</th>
                        <th>Aadhar No</th>
                        <th>Status</th>
                    </tr>
                    </tfoot>
                </table>
            </div>
</div>
