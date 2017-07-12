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
                <li class="active">
                    <a href="employees">
                        <i class="pe-7s-note2"></i>
                        <p>Employee Manage</p>
                    </a>
                </li>
                <li>
                    <a href="bookings">
                        <i class="pe-7s-note2"></i>
                        <p>Booking Manage</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="#">
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
                                <h3 class="title"><strong>EMPLOYEE DATA</strong></h3><br/>
                                <p class="category"><h5>This is employee data from Blibli.com. You can manage to add, update, delete data employee.</h5></p>
                            </div>
                            <br/><br/>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped data">
                                    <thead>
                                    <tr>
                                        <th width="100">ID</th>
                                        <th width="200">NAME</th>
                                        <th width="250">EMAIL</th>
                                        <th width="180">ROLE</th>
                                        <th width="100"></th>
                                        <th width="100"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr ng-repeat="u in ctrlEmployee.getAllEmployees()">
                                        <td>{{u.idEmployee}}</td>
                                        <td>{{u.name}}</td>
                                        <td>{{u.email}}</td>
                                        <td>{{u.role}}</td>
                                        <td><button type="button" ng-click="ctrlEmployee.editEmployee(u.idEmployee)" data-toggle="modal" data-target="#myModalAdd" class="btn btn-success custom-width">Edit</button></td>
                                        <td><button type="button" ng-click="ctrlEmployee.removeEmployee(u.idEmployee)" class="btn btn-danger custom-width">Remove</button></td>
                                    </tr>
                                    </tbody>
                                </table>

                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalAdd">Add New Data</button><br/><br/>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModalAdd" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add / Update Data</h4>
            </div>
            <div class="modal-body">
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
                            <input type="text" ng-model="ctrlEmployee.employee.password" id="password" class="username form-control input-sm" placeholder="Enter new employee password" style="width:200px;"/>
                        </div>
                    </div>

                    <input type="hidden" ng-model="ctrlEmployee.employee.status" ng-init="ctrlEmployee.employee.status=1" id="status" class="username form-control input-sm" style="width:200px;"/>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Role :</label>
                        <div class="col-sm-8">
                            <input type="text" ng-model="ctrlEmployee.employee.role" id="role" class="username form-control input-sm" placeholder="Enter new employee role" style="width:200px;"/>
                        </div>
                    </div>
                    <div class="form-group modal-footer">
                        <input type="submit"  value="{{!ctrlEmployee.employee.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>
