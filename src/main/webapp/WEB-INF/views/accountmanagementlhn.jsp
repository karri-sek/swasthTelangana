<script type="text/javascript">	
$(document).ready(function() {
	submitForm('/account/backtohome.action', 'NO-DATA', 'containerdiv');
});
</script><div class="sidebar-nav">
    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-collapse collapse sidebar-navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#"
                       onclick="submitForm('/account/createaccount.action', 'NO-DATA', 'containerdiv');">Create
                    account</a></li>
                <li><a href="#"
                       onclick="submitForm('/account/updateaccount.action', 'NO-DATA', 'containerdiv');">Update
                    account</a></li>
                <li><a href="#"
                       onclick="submitForm('/account/formDateReportDetails.action', 'NO-DATA', 'containerdiv');">Search
                    accounts</a></li>
            </ul>
        </div>
    </div>
</div>