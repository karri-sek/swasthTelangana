<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">FORM F: Section A:To be filled in for
            all Diagnostic Procedures/Tests</h3>
    </div>
    <form class="form-horizontal" method="POST" name="sectionA"
          id="sectionA" modelAttribute="sectionA">
        <div class="form-group">
            <label class="control-label col-sm-2"> Menstrual period</label>
            <div class="col-sm-2">
                <input class='form-control' name="menstrualPeriod" type='text'/>
            </div>
            <label class="control-label col-sm-2">No of Children</label>

            <div class="col-sm-2">
                <input class="form-control" type="text" name="noOfChildren" id="noOfChildren"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Sons</label>
            <div class="col-sm-2">
                <input class="form-control" type="text" name="noOfMaleKids"  id="noOfMaleKids"/>
            </div>
            <label class="control-label col-sm-2">Daughters</label>
            <div class="col-sm-2">
                <input class="form-control" name="noOfFemaleKids" type='text'/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Guardian Name</label>

            <div class="col-sm-5">
                <input class="form-control" name="guardianName" type="text"/>
            </div>
        </div>
        <input type="hidden" id="patientID" name="patientID" value="${sectionA.patientID}"/>
        <input type="hidden" id="patientName" name="patientName" value="${sectionA.patientName}"/>

        <div class="box-footer">
            <label class="control-label col-sm-2"/>

            <div class="col-sm-3">
                <a class="btn btn-primary" href="#"
                   onclick="submitForm('/account/previousSectionA.action', 'sectionA', 'containerdiv');">Previous</a>
            </div>
            <div class="col-sm-2">
                <a class="btn btn-primary" href="#"
                   onclick="submitForm('/account/saveSectionA.action', 'sectionA', 'containerdiv');">Save</a>
            </div>
            <div class="col-sm-2">
                <a class="btn btn-primary" href="#"
                   onclick="submitForm('/account/nextSectionA.action', 'sectionA', 'containerdiv');">Next</a>
            </div>
        </div>
    </form>
</div>