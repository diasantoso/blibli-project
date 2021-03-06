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
                <li class="active">
                    <a href="/employees/dashboard">
                        <i class="pe-7s-graph"></i>
                        <p>Your Bookings</p>
                    </a>
                </li>
                <li>
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
                                <h3 class="title"><strong>Sorry, The room is used at your requested extend-booking-time!</strong></h3><br/>
                            </div>
                            <br/><br/>
                            <p>Here is the available room at your given extend-time {{ctrlBooking.getSearchVar()}}</p>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped data">
                                    <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>NAME</th>
                                        <th>CAPACITY</th>
                                        <th>HAVE CONFERENCE</th>
                                        <th>HAVE PROJECTOR</th>
                                        <th>NUMBER EXTENSION</th>
                                        <th>OFFICE</th>
                                        <th width="100"></th>
                                        <th width="100"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr ng-repeat="u in ctrlBooking.getAvailableRoom()">
                                        <td>{{$index +1}}</td>
                                        <td>{{u.name}}</td>
                                        <td>{{u.capacity}}</td>
                                        <td>{{u.isConference}}</td>
                                        <td>{{u.isProjector}}</td>
                                        <td>{{u.numberExtension}}</td>
                                        <td>{{u.office.name}}</td>
                                        <td><button type="button" ng-click="ctrlBooking.extend(u.idRoom)" data-toggle="modal" data-target="#myModalAdd" class="btn btn-success custom-width">Book</button></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div> <!-- row -->
            </div>
        </div>
    </div>
</div>