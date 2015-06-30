<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">Create Account</h3>
    </div>
    <form name="createaccount" id="createaccount" enctype="multipart/form-data"
          method="POST" class="form-horizontal">
        <div class="box-body">
            <div class="form-group">
                <label class="control-label col-sm-2">Login id</label>

                <div class="col-sm-5">
                    <input type="text" class="required form-control" value="" name="loginId"
                           id="loginId"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Display name</label>

                <div class="col-sm-5">
                    <input type="text" class="required form-control login-field" value=""
                           name="displayName" id="displayName"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Role</label>

                <div class="col-sm-5">
                    <select class="form-control login-field" id="userRole"
                            name="userRole">
                        <option class="login-field-icon fui-user"
                                value="HealthCenterUser">HealthCenterUser
                        </option>
                        <option class="login-field-icon fui-user" value="DistrictUser">DistrictUser</option>
                        <option class="login-field-icon fui-user" value="StateUser">StateUser</option>
                        <option class="login-field-icon fui-user" value="Administrator">Administrator</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2">Mobile number</label>

                <div class="col-sm-5">
                    <input type="text" class="onlyMobileNum form-control login-field" value=""
                           name="mobileNumber" id="mobileNumber"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">District</label>

                <div class="col-sm-5">
                    <select class="form-control" id="district"
                            name="district"
                            value="${district}">
                        <option>Hyderabad</option>
                        <option>RangaReddy</option>
                        <option>Karimnagar</option>
                        <option>Kamamam</option>
                        <option>Warangal</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">State</label>

                <div class="col-sm-5">
                    <select class="form-control" id="state" name="state"
                            value="${state}">
                        <option>Telangana</option>
                        <option>Karnataka</option>
                        <option>Madhya Pradesh</option>
                        <option>Maharastra</option>
                        <option>Orissa</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2">Password</label>

                <div class="col-sm-5">
                    <input type="password" class="form-control login-field" value=""
                           name="password" id="password"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Confirm
                    password</label>

                <div class="col-sm-5">
                    <input type="password" class="form-control login-field" value=""
                           name="conPassword" id="conPassword"/>
                </div>
            </div>
            <div class="box-footer">
                <label class="control-label col-sm-2"></label>

                <div class=" col-sm-3">
                    <a class="btn btn-primary" href="#"
                       onclick="submitForm('/account/createaccountsubmission.action', 'createaccount', 'containerdiv');">Create
                        new account</a>
                </div>
            </div>
            <%--<span class="login-link">All fields are mandatory</span>--%>
        </div>
    </form>
</div>