<div class="box">
	<div class="box-header with-border">
		<h3 class="box-title">User details</h3>
	</div>
	<!-- /.box-header -->
	<div class="box-body">

		<table class="table table-bordered">
			<tr>
				<th style="width: 10px">#</th>
				<th>Property</th>
				<th>Value</th>
			</tr>
			<tr>
				<td>1</td>
				<td><b>Login id</b></td>
				<td>${user.loginId}
				</td>
			</tr>
			<tr>
				<td>2</td>
				<td><b>Display name</b></td>
				<td>${user.displayName}
				</td>
			</tr>
			<tr>
				<td>3</td>
				<td><b>Role</b></td>
				<td>${user.userRole}
				</td>
			</tr>

			<tr>
				<td>4</td>
				<td><b>Mobile number</b></td>
				<td>${user.mobileNumber}
				</td>
			</tr>
			<tr>
				<td>5</td>
				<td><b>District</b></td>
				<td>${user.district}
				</td>
			</tr>
			<tr>
				<td>6</td>
				<td><b>State</b></td>
				<td>${user.state}
				</td>
			</tr>
			<tr>
				<td>7</td>
				<td><b>Health center type</b></td>
				<td>${user.clinicAddress.type}
				</td>
			</tr>
			<tr>
				<td>8</td>
				<td><b>Clinic Name</b></td>
				<td>${user.clinicAddress.clinicName}
				</td>
			</tr>
			<tr>
				<td>9</td>
				<td><b>Registration No</b></td>
				<td>${user.clinicAddress.registrationNo}
				</td>
			</tr>
			<tr>
				<td>10</td>
				<td><b>Clinic contact no</b></td>
				<td>${user.clinicAddress.contactNum}
				</td>
			</tr>
			<tr>
				<td>11</td>
				<td><b>Clinic Address</b></td>
				<td>${user.clinicAddress.address}
				</td>
			</tr>
			<tr>
				<td>12</td>
				<td><b>Clinic District</b></td>
				<td>${user.clinicAddress.district}
				</td>
			</tr>
			<tr>
				<td>13</td>
				<td><b>Clinic State</b></td>
				<td>${user.clinicAddress.state}</td>
			</tr>
			<tr>
				<td>14</td>
				<td><b>Pincode</b></td>
				<td>${user.clinicAddress.pincode}
				<td>
			</tr>
		</table>
	</div>
</div>