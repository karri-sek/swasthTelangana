<div class="panel panel-default">
    <div class="panel-heading">Get Patient Details with Patient ID</div>
    <div class="panel-body">
        <fieldset>
            <form class="form-horizontal" id="searchPatientId"
                  name="searchPatientId">
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">Enter
                        Patient Id</label>
                    <div class="col-md-4 col-lg-4">
                        <input type="text" class="form-control" name="patientID" id="patientID"
                               placeholder="Enter Patient ID">
                    </div>
                    <input type="hidden" name="searchType" value="ID">
                    <div class="col-md-3 col-lg-3">
                        <a class="btn btn-primary form-control" href="#"
                           onclick="submitForm('/account/patientSearchReport.action', 'searchPatientId', 'searchResultdiv');">
                            Search </a>
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
</div>
<div id="searchResultdiv">
</div>

