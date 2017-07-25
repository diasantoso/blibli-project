<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
    <div class="container topnav">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/">Home</a>
                </li>
                <li>
                    <a href="/listbooking">List Booking</a>
                </li>
                <li>
                    <a href="/addbooking">Add Booking</a>
                </li>
                <li>
                    <a href="/login">Login</a>
                </li>
                <li>
                    <a href="/register">Register</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<div class="content-section-a">
    <div class="container">
        <br/>
        <h2 class="section-heading">Check Available Room</h2>
        <br/><br/><br/>
        <div>
            <form class="form-horizontal" ng-submit="" name="myForm">
                <div class="form-group">
                    <label class="col-sm-3 control-label">Office :</label>
                    <div class="col-sm-8">
                    <#--<input type="text" ng-model="ctrlRoom.room.office.idOffice" id="office" class="username form-control input-sm" placeholder="Enter Office for the new room" required />-->
                        <select class="username form-control input-sm" ng-model="ctrlBooking.booking.room.office.idOffice" required>
                            <option ng-repeat="u in ctrlBooking.getOffices()" value="{{u.idOffice}}">{{u.name}}</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Date :</label>
                    <div class="col-sm-8">
                        <input type="date" ng-model="ctrlBooking.booking.dateMeeting" id="date" class="username form-control input-sm" placeholder="Enter date meeting" required />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Start Time :</label>
                    <div class="col-sm-8">
                        <input type="text" ng-model="ctrlBooking.booking.startTime" id="starttime" class="username form-control input-sm" placeholder="Enter date start time meeting" required />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">End Time :</label>
                    <div class="col-sm-8">
                        <input type="text" ng-model="ctrlBooking.booking.endTime" id="endtime" class="username form-control input-sm" placeholder="Enter end time meeting" required />
                    </div>
                </div>
                <br/><br/>
                <div class="form-group">
                    <label class="col-sm-3 control-label"></label>
                    <div class="col-sm-8">
                        <input type="submit" value ="Check" class="btn btn-primary" ng-disabled="myForm.$invalid || myForm.$pristine">
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