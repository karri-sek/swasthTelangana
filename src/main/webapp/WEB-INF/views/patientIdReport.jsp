<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">Get Patient Details with Patient ID</h3>
    </div>
    <form class="form-horizontal" id="searchPatientId"
          name="searchPatientId">
        <div class="box-body">
            <div class="form-group">
                <label class="control-label col-sm-2">Enter Patient Id</label>
                <%--<div class="col-sm-5">
                    <input class="form-control " type="text" name="patientId" id="patientId" />
                </div>--%>
                <div class="col-sm-5">
                    <div class="input-group margin">
                        <input type="text" class="form-control" name="patientId" id="patientId"
                               placeholder="Enter Patient ID">
                    <span class="input-group-btn">
                      <a class="btn btn-primary form-control" href="#"
                         onclick="submitForm('/account/searchReportByPatientId.action', 'searchPatientId', 'searchResultdiv');"
                         class="btn btn-info btn-flat">Go!</a>
                    </span>
                    </div>
                </div>
                <!-- /input-group -->
                <%--<div class="col-md-3 col-lg-3">
                    <a class="btn btn-primary form-control" href="#"
                        onclick="submitForm('/account/searchReportByPatientId.action', 'searchPatientId', 'searchResultdiv');">
                        Search </a>
                </div>--%>
            </div>
        </div>
    </form>
</div>
