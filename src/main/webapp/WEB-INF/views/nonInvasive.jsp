<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.ScrollStyle {
	max-height: 150px;
	overflow-y: scroll;
}
</style>

<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">FORM F > Section B: To be filled in for
			performing non-invasive diagnostic Procedures/Tests only</h3>
	</div>

	<form class="form-horizontal" method="POST" name="nonInvasive"
		id="nonInvasive" modelAttribute="nonInvasive">
		<div class="box-body">
			<div class="form-group">
				<label class="control-label col-sm-2"
					title="Name of the doctor performing the procedure/s">Doctor
					Name</label>

				<div class="col-sm-5">
					<input class="form-control" type="text" name="doctorName"
						id="doctorName" value="${nonInvasive.doctorName}"
						placeholder="Name of the doctor performing the procedure/s" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2"
					title="(specify with reference to the request made in the referral slip or in a self -referral note)(Ultrasonography prenatal diagnosis during pregnancy should only be performedwhen indicated. The following is the representative list of indications for ultrasound during pregnancy. (Put a Tick against the appropriate indication/s for ultrasound)">Indications
					for diagnosis procedure</label>

				<div class="col-sm-5 ScrollStyle">
					<table class="table table-bordered table-striped">
						<tr>
							<td title=""><input type="checkbox" value="YES"
								name="diagnoseDetails.intrauterine"
								id="diagnoseDetails.intrauterine"
								${nonInvasive.diagnoseDetails.intrauterine == 'YES' ? 'checked' : ''}>
								To diagnose intra-uterine and/or ectopic pregnancy and confirm
								viability</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.gestational"
								id="diagnoseDetails.gestational"
								${nonInvasive.diagnoseDetails.gestational == 'YES' ? 'checked' : ''}>
								Estimation of gestational age (dating)</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.iucdInSitu"
								id="diagnoseDetails.iucdInSitu"
								${nonInvasive.diagnoseDetails.iucdInSitu == 'YES' ? 'checked' : ''}>
								Suspected pregnancy with IUCD in-situ</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.vaginalbleeding"
								id="diagnoseDetails.vaginalbleeding"
								${nonInvasive.diagnoseDetails.vaginalbleeding == 'YES' ? 'checked' : ''}>
								Vaginal bleeding/leaking</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.abortion" id="diagnoseDetails.abortion"
								${nonInvasive.diagnoseDetails.abortion == 'YES' ? 'checked' : ''}>
								Follow-up of cases of abortion</td>
						</tr>

						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.assessmentOfCervical"
								id="diagnoseDetails.assessmentOfCervical"
								${nonInvasive.diagnoseDetails.assessmentOfCervical == 'YES' ? 'checked' : ''}>
								Assessment of cervical canal and diameter of internal os</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.uterineSizeAmenorrhea"
								id="diagnoseDetails.uterineSizeAmenorrhea"
								${nonInvasive.diagnoseDetails.uterineSizeAmenorrhea == 'YES' ? 'checked' : ''}>
								Discrepancy between uterine size and period of amenorrhea</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.suspectedAdenexal"
								id="diagnoseDetails.suspectedAdenexal"
								${nonInvasive.diagnoseDetails.suspectedAdenexal == 'YES' ? 'checked' : ''}>
								Any suspected adenexal or uterine pathology/abnormality</td>
						</tr>
						<tr>
							<td
								title="Detection of chromosomal abnormalities, fetal structural defects and other abnormalities and their follow-up"><input
								type="checkbox" value="YES"
								name="diagnoseDetails.chromosomalAbnormalities"
								id="diagnoseDetails.chromosomalAbnormalities"
								${nonInvasive.diagnoseDetails.chromosomalAbnormalities == 'YES' ? 'checked' : ''}>
								Detection of chromosomal abnormalities follow-up</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.fetalPosition"
								id="diagnoseDetails.fetalPosition"
								${nonInvasive.diagnoseDetails.fetalPosition == 'YES' ? 'checked' : ''}>
								To evaluate fetal presentation and position</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.liquorAmnii"
								id="diagnoseDetails.liquorAmnii"
								${nonInvasive.diagnoseDetails.liquorAmnii == 'YES' ? 'checked' : ''}>
								Assessment of liquor amnii</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.pretermLabor"
								id="diagnoseDetails.pretermLabor"
								${nonInvasive.diagnoseDetails.pretermLabor == 'YES' ? 'checked' : ''}>
								Preterm labor / preterm premature rupture of membranes</td>
						</tr>
						<tr>
							<td
								title="placenta praevia, retro
placental hemorrhage, abnormal adherence etc"><input
								type="checkbox" value="YES"
								name="diagnoseDetails.placentalPosition"
								id="diagnoseDetails.placentalPosition"
								${nonInvasive.diagnoseDetails.placentalPosition == 'YES' ? 'checked' : ''}>
								Evaluation of placental position, thickness, grading and
								abnormalities</td>
						</tr>
						<tr>
							<td
								title="presentation, insertion, nuchal encirclement, number of vessels and presence of true knot"><input
								type="checkbox" value="YES" name="diagnoseDetails.umbilicalCord"
								id="diagnoseDetails.umbilicalCord"
								${nonInvasive.diagnoseDetails.umbilicalCord == 'YES' ? 'checked' : ''}>
								Evaluation of umbilical cord</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.previousCaesarean"
								id="diagnoseDetails.previousCaesarean"
								${nonInvasive.diagnoseDetails.previousCaesarean == 'YES' ? 'checked' : ''}>
								Evaluation of previous Caesarean Section scars</td>
						</tr>

						<tr>
							<td
								title="Evaluation of fetal growth parameters, fetal weight and fetal well being"><input
								type="checkbox" value="YES" name="diagnoseDetails.fetalGrowth"
								id="diagnoseDetails.fetalGrowth"
								${nonInvasive.diagnoseDetails.fetalGrowth == 'YES' ? 'checked' : ''}>
								Evaluation of fetal growth parameters</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.duplexDoppler"
								id="diagnoseDetails.duplexDoppler"
								${nonInvasive.diagnoseDetails.duplexDoppler == 'YES' ? 'checked' : ''}>
								Color flow mapping and duplex Doppler studies</td>
						</tr>
						<tr>
							<td
								title="Ultrasound guided procedures such as medical termination of pregnancy, external cephalic version etc. and their follow-up"><input
								type="checkbox" value="YES"
								name="diagnoseDetails.terminationOfPregnancy"
								id="diagnoseDetails.terminationOfPregnancy"
								${nonInvasive.diagnoseDetails.terminationOfPregnancy == 'YES' ? 'checked' : ''}>
								Medical termination of pregnancy, external cephalic version etc</td>
						</tr>
						<tr>
							<td
								title="Adjunct to diagnostic and therapeutic invasive interventions such as chorionic villus sampling (CVS),amniocenteses, fetal blood sampling, fetal skin biopsy, amnio-infusion, intrauterine infusion,placement of shunts etc"><input
								type="checkbox" value="YES"
								name="diagnoseDetails.chorionicVillus"
								id="diagnoseDetails.chorionicVillus"
								${nonInvasive.diagnoseDetails.chorionicVillus == 'YES' ? 'checked' : ''}>
								Chorionic villus sampling (CVS)</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.intraPartumEvents"
								id="diagnoseDetails.intraPartumEvents"
								${nonInvasive.diagnoseDetails.intraPartumEvents == 'YES' ? 'checked' : ''}>
								Observation of intra-partum events</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.complicatingPregnancy"
								id="diagnoseDetails.complicatingPregnancy"
								${nonInvasive.diagnoseDetails.complicatingPregnancy == 'YES' ? 'checked' : ''}>
								Medical/surgical conditions complicating pregnancy</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnoseDetails.researchScientific"
								id="diagnoseDetails.researchScientific"
								${nonInvasive.diagnoseDetails.researchScientific == 'YES' ? 'checked' : ''}>
								Research/scientific studies in recognized institutions</td>
						</tr>
					</table>
				</div>
			</div>
			<legend></legend>
			<div class="form-group">
				<label class="control-label col-sm-2"
					title="Procedures carried out (Non-Invasive) (Put a Tick on the appropriate procedure)">
					Procedures: </label>
				<div class="col-sm-5">
					<table class="table table-striped">
						<tr>
							<td
								title="Important Note: Ultrasound is not indicated/advised/performed to determine the sex of fetusexcept for diagnosis of sex-linked diseases such as Duchene Muscular Dystrophy, Hemophilia A & B etc."><input
								type="checkbox" value="YES" name="procedures.ultrasound" ${nonInvasive.procedures.ultrasound == 'YES' ? 'checked' : ''}>Ultrasound</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Any other Specify</label>
				<div class="col-sm-5">
					<input class="form-control" type="text" name="otherDiagnoseDetails"
						id="otherDiagnoseDetails" value="${nonInvasive.otherDiagnoseDetails}" />
				</div>
			</div>
			<legend></legend>
			<div class="form-group">
				<label class="control-label col-sm-2"
					title="Date on which declaration of pregnant woman/ person was obtained">Declaration
					obtained date</label>

				<div class="col-sm-2">
					<input class="form-control" value="${nonInvasive.declarationDate}" type="date"
						name="declarationDate" id="declarationDate" />
				</div>
				<label class="control-label col-sm-2"
					title="Date on which procedures carried out">Procedure
					carried date</label>
				<div class="col-sm-2">
					<input class="form-control" value="${nonInvasive.procedureCarriedDate}"
						type="date" name="procedureCarriedDate" id="procedureCarriedDate" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2"
					title="Result of the non-invasive procedure carried out (report in brief of the test including ultrasound carried out">Procedure
					Result</label>

				<div class="col-sm-5">
					<input class='form-control' name="procedureResult" type='text'
						value="${nonInvasive.procedureResult}" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2"
					title="The result of pre-natal diagnostic procedures was conveyed to - Name">conveyed
					to (Name):</label>
				<div class="col-sm-2">
					<input class='form-control' name="conveyDetails.conveyedName"
						type='text' value="${nonInvasive.conveyDetails.conveyedName}" />
				</div>

				<label class="control-label col-sm-2"
					title="The result of pre-natal diagnostic procedures was conveyed to - Date">conveyed
					on (Date):</label>
				<div class="col-sm-2">
					<input class="form-control" value="${nonInvasive.conveyDetails.conveyedDate}" type="date"
						name="conveyDetails.conveyedDate" id="conveyDetails.conveyedDate"/>
				</div>
			</div>
			<input type="hidden" id="conveyDetails.type"
				name="conveyDetails.type" value="NONINVASIVE" />
			<div class="form-group">
				<label class="control-label col-sm-2"
					title="Any indication for MTP as per the abnormality detected in the diagnostic procedures/tests">Mtp
					Indication:</label>
				<div class="col-sm-5">
					<input class='form-control' name="mtpIndication" type='text'
						value="${nonInvasive.mtpIndication}" />
				</div>
			</div>
			<input type="hidden" id="patientID" name="patientID"
				value="${nonInvasive.patientID}" /> <input type="hidden"
				id="patientName" name="patientName"
				value="${nonInvasive.patientName}"> <input type="hidden"
				id="operation" name="operation" value="${nonInvasive.operation}" />

			<div class="form-actions">
				<label class="control-label col-sm-2" />
				<div class="col-sm-3">
					<a class="btn btn-primary" href="#"
						onclick="submitForm('/account/previousNonInvasiveDetails.action', 'noninvasiveFormPrevious', 'containerdiv');">Previous</a>
				</div>
				<label class="control-label col-sm-1" />
				<div class="col-sm-3">
					<a class="btn btn-primary" href="#"
						onclick="submitForm('/account/saveNonInvasiveDetails.action', 'nonInvasive', 'containerdiv');">Save</a>
				</div>
				<label class="control-label col-sm-1" />
				<div class="col-sm-3">
					<a class="btn btn-primary" href="#"
						onclick="submitForm('/account/nextNonInvasiveDetails.action', 'nonInvasive', 'containerdiv');">Next</a>
				</div>
			</div>
	</form>
	<form name="noninvasiveFormPrevious" id="noninvasiveFormPrevious">
		<input name="patientID" type="hidden" value="${nonInvasive.patientID}" />
		<input type="hidden" id="patientName" name="patientName"
			value="${nonInvasive.patientName}" />
	</form>
</div>
