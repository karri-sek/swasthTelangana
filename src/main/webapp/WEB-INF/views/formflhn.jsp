<script type="text/javascript">	
$(document).ready(function() {
	submitForm('/account/backtohome.action', 'NO-DATA', 'containerdiv');
});
</script>

<div class="todo">
	<div class="todo-search">
		<span class="todo-search-field"> Select your option</span>
	</div>
	<ul>
		<li class="todo-done">
			<div class="todo-icon fui-user"></div>
			<div class="todo-content">
				<h4 class="todo-name">
					<a href="#"
						onclick="submitForm('/account/enterFormDetails.action', 'NO-DATA', 'containerdiv');"><strong><br>Create
							Form F</strong> </a>
				</h4>
			</div>
		</li>
		<li>
			<div class="todo-icon fui-eye"></div>
			<div class="todo-content">
				<h4 class="todo-name">
					<a href="#"
						onclick="submitForm('/account/formIdReportDetails.action', 'NO-DATA', 'containerdiv');"><strong><br>Search
							by ID</strong></a>
				</h4>
			</div>
		</li>
		<li>
			<div class="todo-icon fui-eye"></div>
			<div class="todo-content">
				<h4 class="todo-name">
					<a href="#"
						onclick="submitForm('/account/formDateReportDetails.action', 'NO-DATA', 'containerdiv');"><strong><br>Search
							by Date</strong></a>
				</h4>
			</div>
		</li>
	</ul>
</div>
<!-- /.todo -->