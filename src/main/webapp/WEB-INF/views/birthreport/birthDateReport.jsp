<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="panel panel-default">
    <div class="panel-heading">Search MTP Patient Profiles by
		Date Range</div>
    <div class="panel-body">
        <fieldset>
            <form class="form-horizontal" id="searchFormByDate"
                  name="searchFormByDate">
                <div class="form-group mandatory">
				<label class="control-label col-sm-2">From Date:</label>
				<div class="col-sm-2">
					<input class="form-control required" value="${fromDate}" type="date"
						name="fromDate" id="fromDate" />
				</div>
				<label class="control-label col-sm-2">Till Date:</label>

				<div class="col-sm-2">
					<input class="form-control required" value="${toDate}" type="date"
						name="toDate" id="toDate" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4"></label>

				<div class="col-sm-3">
					<div class="input-group margin">
						<span class="input-group-btn"> <a
							class="btn btn-primary form-control" href="#"
							onclick="submitForm('/account/listBirthReportsByDate.action', 'searchFormByDate', 'searchResultdiv')"
							class="btn btn-info btn-flat">Search!</a>
						</span>
					</div>
				</div>
			</div>
            </form>
        </fieldset>
    </div>
</div>
<div id="searchResultdiv">
</div>


