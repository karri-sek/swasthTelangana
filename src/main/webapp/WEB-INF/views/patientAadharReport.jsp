<div class="panel panel-default">
    <div class="panel-heading">Get Patient Details with Patient Aadhar number</div>
    <div class="panel-body">
        <fieldset>
            <form class="form-horizontal" id="searchPatientAadhar"
                  name="searchPatientAadhar">
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">Enter
                        Patient Aadhar number</label>
                    <div class="col-md-4 col-lg-4">
                        <input type="text" class="form-control" name="aadharNo" id="aadharNo"
                               placeholder="Enter Patient Aadhar number">
                    </div>
                    <input type="hidden" name="searchType" value="AADHAR">
                    <div class="col-md-3 col-lg-3">
                        <a class="btn btn-primary form-control" href="#"
                           onclick="submitForm('/account/patientSearchReport.action', 'searchPatientAadhar', 'searchResultdiv');">
                            Search </a>
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
</div>
<div id="searchResultdiv">
</div>

