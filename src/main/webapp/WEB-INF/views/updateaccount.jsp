<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">Update account</h3>
    </div>
    <form name="updateaccount" id="updateaccount" commandName="updateaccount" enctype="multipart/form-data"
          method="POST" class="form-horizontal">
        <div class="box-body">
            <div class="form-group">
                <label class="control-label col-sm-2" for="login-name">Login
                    id</label>

                <div class="col-sm-5">
                    <input type="text" class="form-control login-field" value=""
                           name="loginId" id="loginId" placeholder="Enter Login Id"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="login-pass">Password</label>

                <div class="col-sm-5">
                    <input type="password" class="form-control login-field" value=""
                           placeholder="Password" name="password" id="password"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="login-pass">Confirm password</label>

                <div class="col-sm-5">
                    <input type="password" class="form-control login-field" value=""
                           placeholder="Confirm password" name="conPassword"
                           id="conPassword"/>
                </div>
            </div>

            <div class="box-footer">
                <label class="control-label col-sm-2"></label>

                <div class=" col-sm-3">
                    <a class="btn btn-primary" href="#"
                       onclick="submitForm('/account/updateaccountsubmission.action', 'updateaccount', 'containerdiv');">Update
                        existing account</a>
                </div>
            </div>
        </div>
    </form>
</div>
