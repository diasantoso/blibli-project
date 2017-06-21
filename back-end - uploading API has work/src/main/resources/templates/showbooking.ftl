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
                    <a href="#">Home</a>
                </li>
                <li>
                    <a href="#listbooking">List Booking</a>
                </li>
                <li>
                    <a href="#addbooking">Add Booking</a>
                </li>
                <li>
                    <a href="#login">Login</a>
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
        <h2 class="section-heading">List Booking</h2>
        <br/><br/>
        <div class="content table-responsive table-full-width">
            <table class="table table-hover table-striped data">
                <thead>
                <tr>
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