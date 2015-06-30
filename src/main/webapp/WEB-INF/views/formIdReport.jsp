<div class="panel panel-default">
	<div class="panel-heading">Search</div>
	<div class="panel-body">
		<fieldset>
			<form class="form-horizontal" id="searchFormById"
				name="searchFormById">
				<div class="form-group">
					<label class="control-label col-md-5 col-lg-5">Enter Form
						Id</label>
					<div class="col-md-4 col-lg-4">
						<input class="form-control " type="text" name="searchFormId"
							id="searchFormId" />
					</div>
					<div class="col-md-3 col-lg-3">
						<a class="btn btn-primary form-control" href="#"
							onclick="submitForm('/account/searchReportByFormId.action', 'searchFormById', 'searchResultdiv');">
							Search </a>
					</div>
				</div>
			</form>
		</fieldset>
	</div>
</div>

