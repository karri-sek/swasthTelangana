<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-info">
    <div class="box-header with-border"><h3 class="box-title">FORM F: Section B: To be filled in for performing
        non-invasive diagnostic Procedures/Tests only </h3>
    </div>

    <form class="form-horizontal" method="POST" name="nonInvasive" id="nonInvasive" modelAttribute="nonInvasive">
        <div class="box-body">
            <div class="form-group">
                <label class="control-label col-sm-2">Doctor Name</label>

                <div class="col-sm-5">
                    <input class="form-control" type="text" name="doctorName"
                           id="doctorName" value="${nonInvasive.doctorName}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Indications for diagnosis procedure</label>

                <div class="col-sm-5">
                    <table class="table table-bordered table-striped">
                        <c:forEach var="diagnose" items="${diagnoseDetails}">
                            <tr>
                                <td><input type="checkbox" value="${diagnose.value}">${diagnose.value}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Any other Specify</label>

                <div class="col-sm-5">
                    <input class="form-control" type="text" name="otherDiagnoseDetails" id="otherDiagnoseDetails"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2"> Procedures </label>

                <div class="col-sm-5">
                    <table class="table table-striped">
                        <c:forEach var="procedure" items="${procedures}">
                            <tr>
                                <td><input type="checkbox" value="${procedure.value}">${procedure.value}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Any other Specify</label>

                <div class="col-sm-5">
                    <input class="form-control" type="text" name="otherProcedure" id="otherProcedure"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Declaration Date</label>

                <div class="col-sm-2">
                    <input class="form-control" value="2014-12-22" type="date" name="declarationDate"
                           id="declarationDate"/>
                </div>
                <label class="control-label col-sm-2">Procedure Carried Date</label>

                <div class="col-sm-2">
                    <input class="form-control" value="2014-12-22" type="date" name="procedureCarriedDate"
                           id="procedureCarriedDate"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2">Procedure Result</label>

                <div class="col-sm-5">
                    <input class='form-control' name="procedureResult" type='text'
                           value="${nonInvasive.procedureResult}"/>
                </div>
            </div>
            <div class="form-group">
                <legend>Convey Details:</legend>
                <label class="control-label col-sm-2">Name:</label>

                <div class="col-sm-2">
                    <input class='form-control' name="conveyDetails.conveyedName" type='text'/>
                </div>
                <label class="control-label col-sm-2">Date:</label>

                <div class="col-sm-2">
                    <input class="form-control" value="2014-12-22" type="date" name="conveyDetails.conveyedDate"
                           id="procedureCarriedDate"/>
                </div>
            </div>
            <div class="form-group">
                <legend>MTP Indication :</legend>
                <label class="control-label col-sm-2">Mtp Indication:</label>

                <div class="col-sm-5">
                    <input class='form-control' name="mtpIndication" type='text'/>
                </div>
            </div>
            <input type="hidden" id="patientID" name="patientID" value="${nonInvasive.patientID}"/>
            <input type="hidden" id="patientName" name="patientName" value="${nonInvasive.patientName}">

            <div class="form-actions">
                <label class="control-label col-sm-2"/>
                <div class="col-sm-3">
                    <a class="btn btn-primary" href="#"
                       onclick="submitForm('/account/previousNonInvasiveDetails.action', 'nonInvasive', 'containerdiv');">Previous</a>
                </div>
                <label class="control-label col-sm-1"/>
                <div class="col-sm-3">
                    <a class="btn btn-primary" href="#"
                       onclick="submitForm('/account/saveNonInvasiveDetails.action', 'nonInvasive', 'containerdiv');">Save</a>
                </div>
                <label class="control-label col-sm-1"/>
                <div class="col-sm-3">
                    <a class="btn btn-primary" href="#"
                       onclick="submitForm('/account/nextNonInvasiveDetails.action', 'nonInvasive', 'containerdiv');">Next</a>
                </div>
            </div>
    </form>
    </fieldset>
</div>
</div>