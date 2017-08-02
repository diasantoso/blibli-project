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
                    <a href="/listbooking">All Booking</a>
                </li>
                <li>
                    <a href="/addbooking">Add Booking</a>
                </li>
                <li>
                    <a href="/checkticket">Check Ticket</a>
                </li>
                <li>
                    <a href="/login">Login</a>
                </li>
                <li>
                    <a href="/register">Register</a>
                </li>
                <li>
                    <a href="/employees/dashboard">Employe Dashboard</a>
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
        <h2 class="section-heading">Check Ticket Booking</h2>
        <br/><br/><br/>
        <div>
            <form class="form-horizontal" ng-submit="ctrlBooking.checkTicket()" name="myForm">
                <div class="form-group">
                    <label class="col-sm-3 control-label">Ticket ID :</label>
                    <div class="col-sm-8">
                        <input type="text" ng-model="ctrlBooking.ticket" id="ticket" class="username form-control input-sm" placeholder="Enter your booking ticket id" required />
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