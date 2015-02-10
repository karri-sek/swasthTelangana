<script type="text/javascript">
    $(document).ready(function() {
        submitForm('/account/backtohome.action', 'NO-DATA', 'containerdiv');
    });
</script>

<div class="nav nav-sidebar">
    <span class="sr-only">Select your option1</span>
    <ul>
        <li>
            <h4>
                <a href="#"
                   onclick="submitForm('/account/enterPatientDetails.action', 'NO-DATA', 'containerdiv');"><strong><br>New
                    Patient entry</strong> </a>
            </h4>
        </li>
        <li>
            <div class="todo-icon fui-eye"></div>
            <div class="todo-content">
                <h4 class="todo-name">
                    <a href="#"
                       onclick="submitForm('/account/patientNameReportDetails.action', 'NO-DATA', 'containerdiv');"><strong><br>Search
                        by name</strong></a>
                </h4>
            </div>
        </li>
        <li>
            <div class="todo-icon fui-eye"></div>
            <div class="todo-content">
                <h4 class="todo-name">
                    <a href="#"
                       onclick="submitForm('/account/patientIdReportDetails.action', 'NO-DATA', 'containerdiv');"><strong><br>Search
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
                        with dates</strong></a>
                </h4>
            </div>
        </li>
        <li>
            <div class="todo-icon fui-eye"></div>
            <div class="todo-content">
                <h4 class="todo-name">
                    <a href="#"
                       onclick="submitForm('/account/patientProfiles.action', 'NO-DATA', 'containerdiv');"><strong><br>Patient
                        Profiles</strong></a>
                </h4>
            </div>
        </li>
    </ul>
</div>