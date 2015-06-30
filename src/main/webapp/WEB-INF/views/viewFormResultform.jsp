<div class="panel panel-primary">
	<div class="panel-heading">Form F Details</div>
	<div class="panel-body">
		<fieldset>
			<form class="form-horizontal" method="POST" name="formEntry"
				id="formEntry">
				<div class="form-group">
					<div class="col-md-7 col-lg-7"></div>
					<div class="col-md-3 col-lg-3">
						<div class="form-group">
							<a class="btn btn-primary"
								href="<%=request.getContextPath()%>/downLoadForm.action">Download
								Details as Excel</a>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">Patient Name
					</label> <label class="control-label col-md-5 col-lg-5">${form.patientName}</label>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">Age</label> <label
						class="control-label col-md-5 col-lg-5">${form.age}</label>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">No Of
						Children</label> <label class="control-label col-md-5 col-lg-5">${form.noOfChildren}</label>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">Guardian
						Name</label> <label class="control-label col-md-5 col-lg-5">${form.guardianName}</label>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">Patient
						Address</label> <label class="control-label col-md-5 col-lg-5">${form.patientAddress}</label>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">Referral
						Address</label> <label class="control-label col-md-5 col-lg-5">${form.referralAddress}</label>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">Menstrual
						Period</label> <label class="control-label col-md-5 col-lg-5">${form.menstrualPeriod}</label>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">MedicalDisease</label>
					<label class="control-label col-md-5 col-lg-5">${form.medicalDisease}</label>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-lg-3">Parental
						Diagnosis</label> <label class="control-label col-md-5 col-lg-5">${form.parentalDiagnosis}</label>
				</div>
				<div class="form-group">
					<label class="control-label col-md-4 col-lg-4">Gynecologist
						Details</label> <label class="control-label col-md-5 col-lg-5">${form.gynecologistDetails}</label>
				</div>
			</form>
		</fieldset>
	</div>
</div>