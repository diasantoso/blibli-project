<!-- Navigation -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
    <#--<div class="navbar-header">-->
    <#--<a class="navbar-brand" href="">Blibli.com</a>-->
    <#--</div>-->
        <ul class="nav navbar-nav">
            <li>
                <a href="/" class="logo"><img src="https://www.blibli.com/page/wp-content/uploads/logo-blibli.png" alt="logo karir" width="100" height="25"></a>
            </li>
            <li class="active"><a href="/">Home</a></li>
            <li><a href="/listbooking">Upcoming Booking</a></li>
            <li><a href="/checkroom">Check Room</a></li>
            <li><a href="/checkticket">Check Ticket</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Register</a></li>
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>

<div class="login-form">
    <h1>Login</h1>
    <form ng-submit="login()">
        <div class="form-group ">
            <input type="text" class="form-control" placeholder="Email" ng-model="email" id="email">
            <i class="fa fa-user"></i>
        </div>
        <div class="form-group log-status">
            <input type="password" class="form-control" placeholder="Password" ng-model="password" id="password">
            <i class="fa fa-lock"></i>
        </div>
        <span class="alert">Invalid Credentials</span>
        <button type="submit" class="log-btn" >Log in</button>
    </form>
</div>

