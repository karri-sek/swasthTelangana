<div id="patientSearchReport" class="panel panel-default">
    <div class="panel-heading">Get Birth report details with mother name</div>
    <div class="panel-body">
        <fieldset>
            <form class="form-horizontal" id="searchPatientName"
                  name="searchPatientName">
                <div class="form-group">
                    <label class="control-label col-md-3 col-lg-3">Enter
                        Mother Name</label>
                    <div class="col-md-4 col-lg-4">
                        <input class="form-control " type="text" name="motherName"
                               id="motherName"/>
                    </div>
                    <input type="hidden" name="searchType" value="NAME">
                    <div class="col-md-3 col-lg-3">
                        <a class="btn btn-primary form-control" href="#"
                           onclick="submitForm('/account/searchBirthReportDetails.action', 'searchPatientName', 'searchResultdiv');">
                            Search </a>
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
</div>
<div id="searchResultdiv">
</div>
