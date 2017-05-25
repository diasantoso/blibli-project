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
                    <a href="#">
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
                            <h4 class="title"><strong>BOOKING DATA</strong></h4><br/>
                            <p class="category">This is booking data from Blibli.com. You can see list of booking meeting room.</p>
                        </div>
                        <br/><br/>
                        <div class="content table-responsive table-full-width">
                            <table class="table table-hover table-striped data">
                                <thead>
                                <tr>
                                    <th width="100">ID</th>
                                    <th width="200">SUBJECT</th>
                                    <th width="250">DESCRIPTION</th>
                                    <th width="200">ROOM</th>
                                    <th width="180">DATE MEETING</th>
                                    <th width="200">START TIME</th>
                                    <th width="200">END TIME</th>
                                    <th width="200">ADDED DATE</th>
                                    <th width="200">STATUS</th>
                                    <th width="100"></th>
                                    <th width="100"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr ng-repeat="u in ctrlBooking.getAllBookings()">
                                    <td>{{u.idBooking}}</td>
                                    <td>{{u.subject}}</td>
                                    <td>{{u.description}}</td>
                                    <td>{{u.room.name}}</td>
                                    <td>{{u.dateMeeting}}</td>
                                    <td>{{u.startTime}}</td>
                                    <td>{{u.endTime}}</td>
                                    <td>{{u.addedDate}}</td>
                                    <td>{{u.status}}</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
