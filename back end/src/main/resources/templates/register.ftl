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
    </div>
</nav>

<div class="login-form">
    <h1>Register</h1>
    <form ng-submit="ctrlEmployee.submit()">
        <div class="form-group">
            <input type="text" ng-model="ctrlEmployee.employee.name" class="form-control" placeholder="Name" id="name">
            <i class="fa fa-user"></i>
        </div>
        <div class="form-group">
            <input type="text" ng-model="ctrlEmployee.employee.email" class="form-control" placeholder="Email" id="email">
            <i class="fa fa-user"></i>
        </div>
        <div class="form-group log-status">
            <input type="password" ng-model="ctrlEmployee.employee.password" class="form-control" placeholder="Password" id="password">
            <i class="fa fa-lock"></i>
        </div>
        <span class="alert">Invalid Credentials</span>
        <input type="submit" value = "Register" class="log-btn" ng-disabled="myForm.$invalid || myForm.$pristine">
    </form>
</div>


