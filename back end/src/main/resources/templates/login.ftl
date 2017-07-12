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
                    <a href="/listbooking">List Booking</a>
                </li>
                <li>
                    <a href="/addbooking">Add Booking</a>
                </li>
                <li>
                    <a href="/login">Login</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<div class="login-form">
    <h1>Blibli</h1>
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

