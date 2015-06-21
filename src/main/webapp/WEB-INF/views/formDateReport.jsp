<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box box-info">
    <div class="box-header with-border">Search Patient Profiles by Date Range</div>
    <form class="form-horizontal" id="searchFormByDate" name="searchFormByDate">
        <div class="box-body">
            <!-- Date range -->
            <%-- <div class="form-group">
                 <label>Date range:</label>
                 <div class="input-group">
                     <div class="input-group-addon">
                         <i class="fa fa-calendar"></i>
                     </div>
                     <input type="text" class="form-control pull-right" id="reservation"/>
                 </div>
                 <!-- /.input group -->
             </div>--%>
            <!-- /.form group -->
            <div class="form-group">

                <label class="control-label col-sm-2">From Date:</label>

                <div class="col-sm-2">
                    <input class="form-control" value="2014-12-20" type="date" name="fromDate" id="fromDate"/>
                </div>
                <label class="control-label col-sm-2">Till Date:</label>

                <div class="col-sm-2">
                    <input class="form-control" value="2014-12-22" type="date" name="toDate" id="toDate"/>
                </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-4"></label>

                    <div class="col-sm-3">
                        <div class="input-group margin">
                    <span class="input-group-btn">
                      <a class="btn btn-primary form-control" href="#"
                         onclick="submitForm('/account/listPatientProfilesByDate.action', 'searchFormByDate', 'searchResultdiv')"
                         class="btn btn-info btn-flat">Search!</a>
                    </span>
                        </div>
                    </div>
                </div>

            <%-- <div class="col-md-4 col-lg-4"></div>
                     <div class="col-md-7 col-lg-7">
                         <br><a class="btn btn-primary" href="#"
                                onclick="submitForm('/account/listPatientProfilesByDate.action', 'searchFormByDate', 'searchResultdiv')">Search</a>--%>
            <%--<a class="btn btn-primary"
                href="<%=request.getContextPath()%>/downLoadForm.action">Search
                & Download Details as Excel</a>--%>
            <!-- <br> <a class="btn btn-primary form-control" href="#"
                onclick="submitForm('/account/downLoadForm.action', 'searchFormByDate', 'searchResultdiv');">
                Search </a> -->
        </div>
        <c:if test="${Failed}">
            <div class="form-group">
                <label class="control-label col-sm-2 col-sm-3">Error:</label>

                <div class="col-sm-5">
                    <label class="control-label col-sm-2 col-sm-3">${Failed}</label>
                </div>
            </div>
        </c:if>
    </form>
</div>
<%--<script type="text/javascript">
    $(function () {
        $('#reservation').daterangepicker();
    });
</script>--%>
