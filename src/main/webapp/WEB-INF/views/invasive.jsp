<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-info">
    <div class="box-header with-border"><h3 class="box-title">FORM F: SECTION C: To be filled for
        performing invasive Procedures/ Tests only</h3>
    </div>
    <form class="form-horizontal" method="POST" name="invasive"
          id="invasive" modelAttribute="invasive">
        <div class="box-body">
            <div class="form-group">
                <label class="control-label col-sm-2">Doctor Name </label>

                <div class="col-sm-5">
                    <input class="form-control" type="text" name="doctorName"
                           id="doctorName"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">History of medical disease in the family </label>

                <div class="col-sm-5">
                    <input class="form-control" type="text" name="historyOfGeneticDisease" id="historyOfGeneticDisease"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Basis of diagnosis:</label>

                <div class="col-sm-5">
                    <table class="table table-striped">
                        <c:forEach var="diagnose" items="${diagnosisBasis}">
                            <tr>
                                <td><input type="checkbox" value="${diagnose.value}">${diagnose.value}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Indication/s for the diagnosis procedure:</label>

                <div class="col-sm-5">
                    <table class="table table-striped">
                        <c:forEach var="diagnose" items="${diagnosisIndication}">
                            <tr>
                                <td><input type="checkbox" value="${diagnose.value}">${diagnose.value}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Advanced maternal age(35 years): </label>

                <div class="col-sm-5">
                    <input class="form-control" type="text" name="advancedMaternalAge"
                           id="advancedMaternalAge"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Mother/father/sibling has genetic disease: </label>

                <div class="col-sm-5">
                    <input class="form-control" type="text" name="geneticDisease"
                           id="geneticDisease"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">FORM G
                    Obtained Date: </label>

                <div class="col-sm-5">
                    <input class="form-control" type="text" name="contestDate"
                           id="contestDate"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Invasive procedures carried out: </label>

                <div class="col-sm-5">
                    <table class="table table-striped">
                        <c:forEach var="procedure" items="${invasiveProcedures}">
                            <tr>
                                <td><input type="checkbox" value="${procedure.value}">${procedure.value}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Any Other Specify:</label>

                <div class="col-sm-5">
                    <input class="form-control" type="text" name="compilication"
                           id="compilication"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Procedures
                    Result: </label>

                <div class="col-sm-5">
                    <input class="form-control" type="text" name="procedureResult" id="procedureResult"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Procedures carried Date:</label>

                <div class="col-sm-5">
                    <input class='form-control' name="procedureCarriedDate"
                           type='text'/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">convey Details:</label>
                <div class="col-sm-2">
                    <input class='form-control' name="conveyDetails.conveyedName" placeholder="Enter Name ..." type='text'/>
                </div>
                <div class="col-sm-2">
                    <input class='form-control' name="conveyDetails.conveyedDate" type='text' placeholder="Enter date ..."/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">MTP Indication: </label>

                <div class="col-sm-5">
                    <input class='form-control' name="mtpIndication" type='text'/>
                </div>
            </div>
            <input type="hidden" name="patientID" value="${invasive.patientID}"/>
            <input type="hidden" name="patientName" value="${invasive.patientName}"/>

            <div class="box-footer">
                <label class="control-label col-sm-2"></label>
                    <div class="col-sm-4">
                        <a class="btn btn-primary col-sm-5" href="#"
                           onclick="submitForm('/account/previousInvasiveDetails.action', 'invasive', 'containerdiv');">Previous</a>
                    </div>
                    <div class="col-sm-4">
                        <a class="btn btn-primary" href="#"
                           onclick="submitForm('/account/saveInvasiveDetails.action', 'invasive', 'containerdiv');">Save</a>
                    </div>
                    <div class="col-sm-4">
                        <a class="btn btn-primary" href="#"
                           onclick="submitForm('/account/nextInvasiveDetails.action', 'invasive', 'containerdiv');">Next</a>
                    </div>
            </div>
        </div>
    </form>
</div>