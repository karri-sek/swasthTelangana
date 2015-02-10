<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="panel panel-default">
    <div class="panel-heading">Patient Profiles</div>
    <div class="panel-body">
        <fieldset>
            <form class="form-horizontal" method="POST" id="patientProfiles"
                  role="patientProfiles">
                <div class="form-group">
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
                </div>
                <div class="form-group" id="resultDev">
                    <table class="table table-bordered" data-toggle="table"
                           data-cache="false" data-height="299">
                        <thead>
                        <tr>
                            <th data-field="id">Patient ID</th>
                            <th data-field="name">Patient Name</th>
                            <th data-field="price">Mobile No</th>
                            <th data-field="price">Download FormF</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${result != null}">
                            <c:forEach var="patient" items="${patientProfiles}">
                                <tr>
                                    <td><c:out value="${patient.patientID}"/></td>
                                    <td><c:out value="${patient.patientName}"/></td>
                                    <td><c:out value="${patient.patientAddress.contactno}"/></td>
                                    <c:url value='/downLoadPatientProfile.action' var="url">
                                        <c:param name="filePath" value="${patient.formFDownloadPath}"/>
                                    </c:url>
                                    <c:if test="${patient.formFDownloadPath != null}">
                                        <td><a class="btn btn-primary"
                                               href="<%=request.getContextPath()%>${url}">Download</a>
                                                <%--<a class="btn btn-primary col-md-9 col-lg-9" href="#"
                                                   onclick="submitForm('${url}', 'patientProfiles', 'searchResultdiv')">Download</a>--%>
                                        </td>
                                    </c:if>
                                    <c:url value='/enterPatientDetails.action' var="continueurl">
                                        <c:param name="patientID" value="${patient.patientID}"/>
                                    </c:url>
                                    <c:if test="${patient.formFDownloadPath == null}">
                                        <td><a class="btn btn-danger col-md-9 col-lg-9" href="#"
                                               onclick="submitForm('${continueurl}', 'patientProfiles', 'containerdiv')">Continue</a>
                                        </td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </form>
        </fieldset>
    </div>
</div>
