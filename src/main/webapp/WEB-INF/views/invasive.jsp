<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.ScrollStyle {
	max-height: 150px;
	overflow-y: scroll;
}
</style>

<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">FORM F > SECTION C: To be filled for
			performing invasive Procedures/ Tests only</h3>
	</div>
	<form class="form-horizontal" method="POST" name="invasive"
		id="invasive" modelAttribute="invasive">
		<div class="box-body">
			<div class="form-group">
				<label class="control-label col-sm-2"
					title="Name of the doctor/s performing the procedure/s">Doctor
					Name </label>

				<div class="col-sm-5">
					<input class="form-control" type="text" name="doctorName"
						id="doctorName" value="${invasive.doctorName}" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">History of
					genetic/medical disease in the family (specify)</label>
				<div class="col-sm-5">
					<input class="form-control" type="text"
						name="historyOfGeneticDisease" id="historyOfGeneticDisease"
						value="${invasive.historyOfGeneticDisease}" />
				</div>
			</div>
			<legend></legend>
			<div class="form-group">
				<label class="control-label col-sm-2"
					title="Select appropriate basis of diagnosis">Basis of
					diagnosis:</label>

				<div class="col-sm-5 ScrollStyle">
					<table class="table table-striped">
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnosisBasis.clinical" ${invasive.diagnosisBasis.clinical == 'YES' ? 'checked' : ''}>Clinical</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnosisBasis.biochemical" ${invasive.diagnosisBasis.biochemical == 'YES' ? 'checked' : ''}>Bio-chemical</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnosisBasis.cytogenetic" ${invasive.diagnosisBasis.cytogenetic == 'YES' ? 'checked' : ''}>Cytogenetic</td>
						</tr>
					</table>
				</div>
				<label class="control-label col-sm-2">Any other (specify)</label>
				<div class="col-sm-5">
					<input class="form-control" type="text" name="diagnosisBasis.other"
						id="diagnosisBasis.other" value="${invasive.diagnosisBasis.other}" />
				</div>
			</div>
			<legend></legend>
			<div class="form-group ">
				<label class="control-label col-sm-2"
					title="Select an appropriate indication/s">Indication/s for
					the diagnosis procedure(Previous child/children with):</label>
				<div class="col-sm-5 ScrollStyle">
					<table class="table table-striped"
						title="Previous child/children with">
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnosisIndication.chromosomalDisorders" ${invasive.diagnosisIndication.chromosomalDisorders == 'YES' ? 'checked' : ''}>
								Chromosomal disorders</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnosisIndication.metabolicDisorders" ${invasive.diagnosisIndication.metabolicDisorders == 'YES' ? 'checked' : ''}> Metabolic
								disorders</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnosisIndication.congenitalAnomaly" ${invasive.diagnosisIndication.congenitalAnomaly == 'YES' ? 'checked' : ''}> Congenital
								anomaly</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnosisIndication.singleGeneDisorder" ${invasive.diagnosisIndication.singleGeneDisorder == 'YES' ? 'checked' : ''}> Single
								gene disorder</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnosisIndication.mentalRetardation" ${invasive.diagnosisIndication.mentalRetardation == 'YES' ? 'checked' : ''}> Mental
								retardation</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnosisIndication.haemoglobinopathy" ${invasive.diagnosisIndication.haemoglobinopathy == 'YES' ? 'checked' : ''}>
								Haemoglobinopathy</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="diagnosisIndication.sexLinkedDisorders" ${invasive.diagnosisIndication.sexLinkedDisorders == 'YES' ? 'checked' : ''}> Sex
								linked disorders</td>
						</tr>
					</table>
				</div>
				<label class="control-label col-sm-2">Any other (specify)</label>
				<div class="col-sm-5">
					<input class="form-control" type="text"
						name="diagnosisIndication.anyOther"
						id="diagnosisIndication.anyOther" value="${invasive.diagnosisIndication.anyOther}" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Advanced maternal
					age(35 years): </label>

				<div class="col-sm-5">
					<input class="form-control" type="text" name="advancedMaternalAge"
						id="advancedMaternalAge" value="${invasive.advancedMaternalAge}" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Mother/father/sibling
					has genetic disease (specify): </label>

				<div class="col-sm-5">
					<input class="form-control" type="text" name="geneticDisease"
						id="geneticDisease" value="${invasive.geneticDisease}" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Any Other Specify:</label>
				<div class="col-sm-5">
					<input class="form-control" type="text" name="previousComplication"
						id="previousComplication" value="${invasive.previousComplication}" />
				</div>
			</div>
			<legend></legend>
			<div class="form-group">
				<label class="control-label col-sm-2"
					title="Date on which consent of pregnant woman / person was obtained in Form G prescribed in PC&PNDT Act,1994">Form
					G obtained date :</label>

				<div class="col-sm-5">
					<input class="form-control" type="date" name="formGDate"
						id="formGDate" value="${invasive.formGDate}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2"
					title="Select appropriate indication/s)">Invasive
					procedures carried out: </label>

				<div class="col-sm-5 ScrollStyle">
					<table class="table table-striped">
						<tr>
							<td><input type="checkbox" value="YES"
								name="invasiveProcedures.amniocentesis" ${invasive.invasiveProcedures.amniocentesis == 'YES' ? 'checked' : ''}>Amniocentesis</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="invasiveProcedures.chorionicVilli" ${invasive.invasiveProcedures.chorionicVilli == 'YES' ? 'checked' : ''}>Chorionic Villi
								aspiration</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="invasiveProcedures.fetalBiopsy" ${invasive.invasiveProcedures.fetalBiopsy == 'YES' ? 'checked' : ''}>Foetal biopsy</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="invasiveProcedures.cordocentesis" ${invasive.invasiveProcedures.cordocentesis == 'YES' ? 'checked' : ''}>Cordocentesis</td>
						</tr>
					</table>
				</div>
				<label class="control-label col-sm-2">Any Other Specify:</label>
				<div class="col-sm-5">
					<input class="form-control" type="text"
						name="invasiveProcedures.others" id="invasiveProcedures.others"
						value="${invasive.invasiveProcedures.others}" />

				</div>
			</div>
			<legend></legend>

			<div class="form-group">
				<label class="control-label col-sm-2"
					title="Any complication/s of invasive procedure (specify)">Any
					complication/s :</label>

				<div class="col-sm-5">
					<input class="form-control sysdate" value="${invasive.complication}"
						type="text" name="complication" id="complication" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2"
					title="Please mention if applicable">Additional tests
					recommended : </label>

				<div class="col-sm-5 ScrollStyle">
					<table class="table table-striped">
						<tr>
							<td><input type="checkbox" value="YES"
								name="additionalTests.chromosomalStudies" ${invasive.additionalTests.chromosomalStudies == 'YES' ? 'checked' : ''}>Chromosomal
								studies</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="additionalTests.biochemicalStudies" ${invasive.additionalTests.biochemicalStudies == 'YES' ? 'checked' : ''}>Biochemical
								studies</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="additionalTests.molecularStudies" ${invasive.additionalTests.molecularStudies == 'YES' ? 'checked' : ''}>Molecular
								studies</td>
						</tr>
						<tr>
							<td><input type="checkbox" value="YES"
								name="additionalTests.preImplantationGender" ${invasive.additionalTests.preImplantationGender == 'YES' ? 'checked' : ''}>Pre-implantation
								gender diagnosis</td>
						</tr>
					</table>
				</div>
				<label class="control-label col-sm-2">Any Other Specify:</label>
				<div class="col-sm-5">
					<input class="form-control" type="text"
						name="additionalTests.others" id="additionalTests.others"
						value="${invasive.additionalTests.others}" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2"
					title="Result of the Procedures/ Tests carried out (report in brief of the invasive tests/ procedures carried out">Result
					of the Procedures: </label>

				<div class="col-sm-5">
					<input class="form-control" type="text" name="procedureResult"
						id="procedureResult" value="${invasive.procedureResult}"
						placeholder="Result of the Procedures/ Tests carried out (report in brief of the invasive tests/ procedures carried out" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Procedures carried out
					date:</label>

				<div class="col-sm-2">
					<input class="form-control" value="${invasive.procedureCarriedDate}"
						type="date" name="procedureCarriedDate" id="procedureCarriedDate" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2"
					title="The result of pre-natal diagnostic procedures was conveyed to - Name ">Conveyed
					to name:</label>

				<div class="col-sm-2">
					<input class='form-control' name="conveyDetails.conveyedName"
						type='text' value="${invasive.conveyDetails.conveyedName}" />
				</div>
				<input type="hidden" name="conveyDetails.type" value="INVASIVE"/>
				<label class="control-label col-sm-2"
					title="The result of pre-natal diagnostic procedures was conveyed on - Date">Conveyed
					on date:</label>
				<div class="col-sm-2">
					<input class="form-control" value="${invasive.conveyDetails.conveyedDate}"
						type="date" name="conveyDetails.conveyedDate"
						id="conveyDetails.conveyedDate" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2"
					title="Any indication for MTP as per the abnormality detected in the diagnostic procedures/tests">MTP
					indication:</label>
				<div class="col-sm-2">
					<input class='form-control' name="mtpIndication" type='text'
						value="${invasive.mtpIndication}" />
				</div>
			</div>

			<input type="hidden" name="patientID" value="${invasive.patientID}" />
			<input type="hidden" name="patientName"
				value="${invasive.patientName}" />

			<div class="box-footer">
				<label class="control-label col-sm-2"></label>
				<div class="col-sm-3">
					<a class="btn btn-default col-sm-5" href="#"
						onclick="submitForm('/account/previousInvasiveDetails.action', 'invasiveFormPrevious', 'containerdiv');">Previous</a>
				</div>
				<div class="col-sm-3">
					<a class="btn btn-primary" href="#"
						onclick="submitForm('/account/saveInvasiveDetails.action', 'invasive', 'containerdiv');">Save</a>
				</div>
				<div class="col-sm-3">
					<a class="btn btn-primary" href="#"
						onclick="submitForm('/account/nextInvasiveDetails.action', 'invasive', 'containerdiv');">Next</a>
				</div>
			</div>
		</div>
	</form>
	<form name="invasiveFormPrevious" id="invasiveFormPrevious">
		<input name="patientID" type="hidden" value="${invasive.patientID}" />
		<input type="hidden" id="patientName" name="patientName"
			value="${invasive.patientName}" />
	</form>
</div>