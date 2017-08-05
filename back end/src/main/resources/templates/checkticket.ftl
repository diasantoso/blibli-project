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
                    <a href="/addbooking">Check Room</a>
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
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<div class="login-form">
    <h1>Check Ticket</h1>
    <form ng-submit="ctrlBooking.checkTicket()">
        <div class="form-group">
            <input type="text" ng-model="ctrlBooking.ticket.id" class="form-control" placeholder="Ticket ID" id="ticket">
            <i class="fa fa-user"></i>
        </div>
        <span class="alert">Invalid Credentials</span>
        <input type="submit" value = "Check" class="log-btn">
    </form>
</div>