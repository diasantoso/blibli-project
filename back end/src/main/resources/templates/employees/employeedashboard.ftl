<div class="wrapper">
    <div class="sidebar" data-color="blue" data-image="../assets/img/sidebar-4.jpg">
        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                    <strong>BOOKING ROOM</strong>
                </a>
            </div>
            <!--NAVIGATION-->
            <ul class="nav">
                <li>
                    <a href="home">
                        <i class="pe-7s-note2"></i>
                        <p>Home</p>
                    </a>
                </li>
                <li >
                    <a href="">
                        <i class="pe-7s-note2"></i>
                        <p>Upcoming Bookings</p>
                    </a>
                </li>
                <li class="active">
                    <a href="">
                        <i class="pe-7s-graph"></i>
                        <p>Your Bookings</p>
                    </a>
                </li>
                <li>
                    <a href="">
                        <i class="pe-7s-note2"></i>
                        <p>Add Booking</p>
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
                                <h3 class="title"><strong>YOUR BOOKING</strong></h3><br/>
                                <p class="category"><h5>This is Your Past and future Booking Data</h5></p>
                            </div>
                            <br/><br/>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped data">
                                    <thead>
                                    <tr>
                                        <th width="180">MEETING DATE</th>
                                        <th width="200">START</th>
                                        <th width="200">END</th>
                                        <th width="200">ROOM</th>
                                        <th width="200">SUBJECT</th>
                                        <th width="200">DESCRIPTION</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr ng-repeat="u in ctrlBooking.getAllBookingPerUser()">
                                        <!--<td>{{u.idEmployee}}</td>-->
                                        <td>{{u.dateMeeting}}</td>
                                        <td>{{u.startTime}}</td>
                                        <td>{{u.endTime}}</td>
                                        <td>{{u.room.name}}</td>
                                        <td>{{u.subject}}</td>
                                        <td>{{u.description}}</td>
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

