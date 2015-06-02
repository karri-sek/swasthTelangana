<script type="text/javascript">
    $(document).ready(function() {
        submitForm('/account/backtohome.action', 'NO-DATA', 'containerdiv');
    });
</script>

<div class="sidebar-nav">
    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-collapse collapse sidebar-navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#"
                       onclick="submitForm('/account/enterFormDetails.action', 'NO-DATA', 'containerdiv');">Create
                    Form F</a></li>
                <li><a href="#"
                       onclick="submitForm('/account/formIdReportDetails.action', 'NO-DATA', 'containerdiv');">Search
                    by ID</a></li>
                <li><a href="#"
                       onclick="submitForm('/account/formDateReportDetails.action', 'NO-DATA', 'containerdiv');">Search
                    by Date</a></li>
            </ul>
        </div>
    </div>
</div>