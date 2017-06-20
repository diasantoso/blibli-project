<div class="wrapper">
    <div class="sidebar" data-color="blue" data-image="../assets/img/sidebar-4.jpg">
        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                    <strong>ADMIN | BOOKING ROOM</strong>
                </a>
            </div>
            <!--NAVIGATION-->
            <ul class="nav">
                <li>
                    <a href="#dashboard">
                        <i class="pe-7s-graph"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li>
                    <a href="#rooms">
                        <i class="pe-7s-note2"></i>
                        <p>Room Manage</p>
                    </a>
                </li>
                <li>
                    <a href="#offices">
                        <i class="pe-7s-note2"></i>
                        <p>Office Manage</p>
                    </a>
                </li>
                <li>
                    <a href="#employees">
                        <i class="pe-7s-note2"></i>
                        <p>Employee Manage</p>
                    </a>
                </li>
                <li class="active">
                    <a href="#bookings">
                        <i class="pe-7s-note2"></i>
                        <p>Booking Manage</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="#">
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
                                <h3 class="title"><strong>BOOKING DATA</strong></h3><br/>
                                <p class="category"><h5>Add New Booking Data</h5></p>
                            </div>
                            <br/><br/>
                            <div>
                                <form class="form-horizontal" ng-submit="" name="myForm">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Date :</label>
                                        <div class="col-sm-8">
                                            <input type="date" ng-model="" id="date" class="username form-control input-sm" placeholder="Enter date meeting" required />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Start Time :</label>
                                        <div class="col-sm-8">
                                            <input type="text" ng-model="" id="starttime" class="username form-control input-sm" placeholder="Enter date start time meeting" required />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">End Time :</label>
                                        <div class="col-sm-8">
                                            <input type="text" ng-model="" id="endtime" class="username form-control input-sm" placeholder="Enter end time meeting" required />
                                        </div>
                                    </div>
                                    <br/><br/>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label"></label>
                                        <div class="col-sm-8">
                                            <input type="submit" value = "Check" class="btn btn-primary" ng-disabled="myForm.$invalid || myForm.$pristine">
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
