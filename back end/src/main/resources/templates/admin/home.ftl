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
                <li class="active">
                    <a href="dashboard">
                        <i class="pe-7s-graph"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li>
                    <a href="rooms">
                        <i class="pe-7s-note2"></i>
                        <p>Room Manage</p>
                    </a>
                </li>
                <li>
                    <a href="offices">
                        <i class="pe-7s-note2"></i>
                        <p>Office Manage</p>
                    </a>
                </li>
                <li>
                    <a href="../employees">
                        <i class="pe-7s-note2"></i>
                        <p>Employee Manage</p>
                    </a>
                </li>
                <li>
                    <a href="bookings">
                        <i class="pe-7s-note2 active"></i>
                        <p>Booking Manage</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="#" ng-click="ctrlCount.logout()">
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
                            <h3 class="title"><strong>DASHBOARD | </strong>Control Panel</h3><br/><br/>
                            <p class="category"><h5>Welcome Admin, <br/>
                                This is admin page. In here, you can manage office, room, employee and booking data.</h5></p>
                        </div>
                        <br/><br/><br/>
                        <div class="right_col" role="main">
                            <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="tile-stats">
                                    <a href="rooms">
                                        <div class="icon"><i class="fa fa-university"></i>
                                        </div>
                                        <div class="count">{{ctrlCount.getCountRoom()}}</div>

                                        <h3>ROOM</h3>
                                        <p>Total Room Registered</p>
                                    </a>
                                </div>
                            </div>
                            <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="tile-stats">
                                    <a href="offices">
                                        <div class="icon"><i class="fa fa-university"></i>
                                        </div>
                                        <div class="count">{{ctrlCount.getCountOffice()}}</div>

                                        <h3>OFFICE</h3>
                                        <p>Total Office Registered</p>
                                    </a>
                                </div>
                            </div>
                            <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="tile-stats">
                                    <a href="../employees">
                                        <div class="icon"><i class="fa fa-users"></i>
                                        </div>
                                        <div class="count">{{ctrlCount.getCountEmployee()}}</div>

                                        <h3>EMPLOYEE</h3>
                                        <p>Total Employee Registered</p>
                                    </a>
                                </div>
                            </div>
                            <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="tile-stats">
                                    <a href="bookings">
                                        <div class="icon"><i class="fa fa-exchange"></i>
                                        </div>
                                        <div class="count">{{ctrlCount.getCountBooking()}}</div>

                                        <h3>BOOKING</h3>
                                        <p>Total Booking Registered</p>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>