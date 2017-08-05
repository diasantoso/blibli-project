<div class="wrapper">
    <div class="sidebar" data-color="blue" data-image="../assets/img/sidebar-4.jpg">
        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                    <strong>EMP | BOOKING ROOM</strong>
                </a>
            </div>
            <!--NAVIGATION-->
            <ul class="nav">
                <li>
                    <a href="/employees/upcoming">
                        <i class="pe-7s-note2"></i>
                        <p>Upcoming Bookings</p>
                    </a>
                </li>
                <li>
                    <a href="/employees/dashboard">
                        <i class="pe-7s-graph"></i>
                        <p>Your Bookings</p>
                    </a>
                </li>
                <li class="active">
                    <a href="/employees/addbooking">
                        <i class="pe-7s-note2"></i>
                        <p>Add Booking</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="#" ng-click="ctrlBooking.logout()">
                        <i class="pe-7s-user"></i>
                        <p>LOG OUT</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="main-panel">
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card card-plain">
                            <div class="header">
                                <h3 class="title"><strong>ADD BOOKING</strong></h3><br/>
                                <p class="category"><h5>Please input office, date meeting, start time and end time first for checking available room.</h5></p>
                            </div>
                            <br/><br/>
                            <div>
                                <form class="form-horizontal" ng-submit="ctrlBooking.checkForEmployeeSite()" name="myForm">
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
                    </div>

                </div> <!-- row -->
            </div>
        </div>
    </div>
</div>
