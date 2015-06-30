<header class="masthead">
    <div class="masthead-inner">
        <div class="center"><h1>Select Action</h1></div>
        <div id="cssmenu">
            <ul>
                <li class="active"><a href="#"
                                      onclick="submitForm('/account/enterPatientDetails.action', 'NO-DATA', 'containerdiv');"><span>New
                    Patient entry</span></a></li>
                <li class='has-sub'><a href="#"
                                       onclick="submitForm('/account/patientNameReportDetails.action', 'NO-DATA', 'containerdiv');"><span>Search
                    by name</span></a>
                    <ul style="display: none;">
                        <li><a href="#"
                               onclick="submitForm('/account/patientIdReportDetails.action', 'NO-DATA', 'containerdiv');">
                            <span>Search by ID</span></a></li>
                        <li><a href='NodeManager.html'><span>Node Manager</span></a></li>
                        <li><a href='ResourceManager.html'><span>Resource Manager</span></a></li>
                        <li class='last'><a href='ApplicationMaster.html'><span>Application Master</span></a></li>
                    </ul>
                </li>
                <li><a href="#"
                       onclick="submitForm('/account/patientIdReportDetails.action', 'NO-DATA', 'containerdiv');"><span>Search
                    by ID</span></a></li>
                <li><a href="#"
                       onclick="submitForm('/account/formDateReportDetails.action', 'NO-DATA', 'containerdiv');"><span>Search
                    with dates</span></a></li>
                <li><a href="#"
                       onclick="submitForm('/account/patientProfiles.action', 'NO-DATA', 'containerdiv');"><span>Patient
                    Profiles</span></a></li>
            </ul>
        </div>
    </div>
</header>