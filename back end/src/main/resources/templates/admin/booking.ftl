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
                    <a href="employees">
                        <i class="pe-7s-note2"></i>
                        <p>Employee Manage</p>
                    </a>
                </li>
                <li class="active">
                    <a href="bookings">
                        <i class="pe-7s-note2"></i>
                        <p>Booking Manage</p>
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
                            <h3 class="title"><strong>BOOKING DATA</strong></h3><br/>
                            <p class="category"><h5>This is booking data from Blibli.com. You can manage data booking meeting room.</h5></p>
                        </div>
                        <br/><br/>
                        <div class="content table-responsive table-full-width">
                            <table class="table table-hover table-striped data">
                                <thead>
                                <tr>
                                    <th width="100">No.</th>
                                    <th width="200">SUBJECT</th>
                                    <th width="250">DESCRIPTION</th>
                                    <th width="200">ROOM</th>
                                    <th width="180">DATE MEETING</th>
                                    <th width="200">START TIME</th>
                                    <th width="200">END TIME</th>
                                    <th width="200">ADDED DATE</th>
                                    <th width="200">STATUS</th>
                                    <th width="100"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr ng-repeat="u in ctrlBooking.getAllBookings()">
                                    <td>{{$index +1}}</td>
                                    <td>{{u.subject}}</td>
                                    <td>{{u.description}}</td>
                                    <td>{{u.room.name}}</td>
                                    <td>{{u.dateMeeting}}</td>
                                    <td>{{u.startTime}}</td>
                                    <td>{{u.endTime}}</td>
                                    <td>{{u.addedDate}}</td>
                                    <td>
                                        <div ng-switch on="{{u.status}}">
                                            <div ng-switch-when="1">Active</div>
                                            <div ng-switch-when="0">Deactive</div>
                                        </div>
                                    </td>
                                    <td>
                                        <div ng-switch on="{{u.status}}">
                                            <div ng-switch-when="1"><button type="button" ng-click="ctrlBooking.removeBooking(u.idBooking)" class="btn btn-danger custom-width">Delete</button></div>
                                            <div ng-switch-when="0"><button type="button" ng-click="ctrlBooking.removeBooking(u.idBooking)" class="btn btn-primary custom-width">Restore</button></div>
                                        </div>
                                    </td>
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
