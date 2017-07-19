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
                <li>
                    <a href="/register">Register</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

    <div class="content-section-a">
        <div class="container">
            <br/>
            <h2 class="section-heading">Register</h2>
            <br/><br/><br/>
        </div>

        <form class="form-horizontal" ng-submit="ctrlEmployee.submit()" name="myForm">
            <div class="form-group">
                <label class="col-sm-3 control-label">Name :</label>
                <div class="col-sm-8">
                    <input type="text" ng-model="ctrlEmployee.employee.name" id="uname" class="username form-control input-sm" placeholder="Enter new employee name" style="width:200px;"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Email :</label>
                <div class="col-sm-8">
                    <input type="text" ng-model="ctrlEmployee.employee.email" id="email" class="username form-control input-sm" placeholder="Enter new employee email" style="width:300px;"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Password :</label>
                <div class="col-sm-8">
                    <input type="password" ng-model="ctrlEmployee.employee.password" id="password" class="username form-control input-sm" placeholder="Enter new employee password" style="width:200px;"/>
                </div>
            </div>

            <input type="hidden" ng-model="ctrlEmployee.employee.status" ng-init="ctrlEmployee.employee.status=1" id="status" class="username form-control input-sm" style="width:200px;"/>
            <input type="hidden" ng-model="ctrlEmployee.employee.role" ng-init="ctrlEmployee.employee.role=Employee" id="role" class="username form-control input-sm" style="width:200px;"/>

            <div class="form-group">
                <label class="col-sm-3 control-label"></label>
                <div class="col-sm-8">
                    <input type="submit" value = "{{!ctrlEmployee.employee.id ? 'Add' : 'Update'}}" class="btn btn-primary" ng-disabled="myForm.$invalid || myForm.$pristine">
                </div>
            </div>

        </form>
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


