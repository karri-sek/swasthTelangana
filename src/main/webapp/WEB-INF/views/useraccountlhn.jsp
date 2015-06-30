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
                       onclick="submitForm('/account/enterPatientDetails.action', 'NO-DATA', 'containerdiv');">Account
                    details </a></li>
                <li><a href="#"
                       onclick="submitForm('/account/patientNameReportDetails.action', 'NO-DATA', 'containerdiv');">Account
                    history</a></li>
            </ul>
        </div>
    </div>
</div>