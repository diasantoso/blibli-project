<!-- Navigation -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
    <#--<div class="navbar-header">-->
    <#--<a class="navbar-brand" href="">Blibli.com</a>-->
    <#--</div>-->
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="/listbooking">Upcoming Booking</a></li>
            <li><a href="/addbooking">Check Room</a></li>
            <li><a href="/checkticket">Check Ticket</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Register</a></li>
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
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