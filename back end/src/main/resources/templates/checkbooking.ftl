<!-- Navigation -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
    <#--<div class="navbar-header">-->
    <#--<a class="navbar-brand" href="">Blibli.com</a>-->
    <#--</div>-->
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="/listbooking">Upcoming Booking</a></li>
            <li><a href="/addbooking">Check Room</a></li>
            <li><a href="/checkticket">Check Ticket</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Register</a></li>
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>

<div class="content-section-a">
    <div class="container">
        <br/>
        <h2 class="section-heading">Check Available Room</h2>
        <br/><br/><br/>
        <div>
            <form class="form-horizontal" ng-submit="ctrlBooking.check()" name="myForm">
                <div class="form-group">
                    <label class="col-sm-3 control-label">Office :</label>
                    <div class="col-sm-8">
                        <select class="username form-control input-sm" ng-model="ctrlBooking.searchVar.officeId" required>
                            <option ng-repeat="u in ctrlBooking.getOffices()" value="{{u.idOffice}}">{{u.name}}</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Date :</label>
                    <div class="col-sm-8">
                        <input type="text" ng-model="ctrlBooking.searchVar.date" id="date" class="username form-control input-sm" placeholder="Enter date meeting" required />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Start Time :</label>
                    <div class="col-sm-8">
                        <input type="text" ng-model="ctrlBooking.searchVar.startTime" id="starttime" class="username form-control input-sm" placeholder="Enter date start time meeting" required />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">End Time :</label>
                    <div class="col-sm-8">
                        <input type="text" ng-model="ctrlBooking.searchVar.endTime" id="endtime" class="username form-control input-sm" placeholder="Enter end time meeting" required />
                    </div>
                </div>
                <br/><br/>
                <div class="form-group">
                    <label class="col-sm-3 control-label"></label>
                    <div class="col-sm-8">
                        <input type="submit" value ="Check" class="btn btn-primary" />
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- /.container -->

</div>

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <p class="copyright text-muted small">Copyright &copy; Future Program Batch 1 - 2017. All Rights Reserved</p>
            </div>
        </div>
    </div>
</footer>