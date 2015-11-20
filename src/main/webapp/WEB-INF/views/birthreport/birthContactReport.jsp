<div id="patientSearchReport" class="panel panel-default">
    <div class="panel-heading">Get Birth report details with mother contact number</div>
    <div class="panel-body">
        <fieldset>
            <form class="form-horizontal" id="searchPatientContact"
                  name="searchPatientContact">
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">Enter
                        Mother contact number</label>
                    <div class="col-md-4 col-lg-4">
                        <input type="text" class="form-control" name="contactno" id="contactno"
                               placeholder="Enter Mother Contact number">
                    </div>
                    <input type="hidden" name="searchType" value="CONTACTNO">
                    <div class="col-md-3 col-lg-3">
                        <a class="btn btn-primary form-control" href="#"
                           onclick="submitForm('/account/searchBirthReportDetails.action', 'searchPatientContact', 'searchResultdiv');">
                            Search </a>
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
</div>
<div id="searchResultdiv">
</div>

