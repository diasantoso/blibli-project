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
                <li class="active">
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
                <li>
                    <a href="bookings">
                        <i class="pe-7s-note2"></i>
                        <p>Booking Manage</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="#" ng-click="ctrlOffice.logout()">
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
                            <h3 class="title"><strong>OFFICE DATA</strong></h3><br/>
                            <p class="category"><h5>This is office data from Blibli.com. You can manage to add, update, delete and restore data office.</h5></p>
                        </div>
                        <br/><br/>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalAdd">Add New Data</button>
                        <br>
                        <div class="content table-responsive table-full-width">
                            <table class="table table-hover table-striped data">
                                <thead>
                                <tr>
                                    <th width="100">No.</th>
                                    <th width="200">NAME</th>
                                    <th width="250">ADDRESS</th>
                                    <th width="180">CITY</th>
                                    <th width="200">TELEPHONE</th>
                                    <th width="200">STATUS</th>
                                    <th width="100"></th>
                                    <th width="100"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr ng-repeat="u in ctrlOffice.getAllOffices()">
                                    <!--<td>{{u.idOffice}}</td>-->
                                    <td>{{$index +1}}</td>
                                    <td>{{u.name}}</td>
                                    <td>{{u.address}}</td>
                                    <td>{{u.city}}</td>
                                    <td>{{u.telephone}}</td>
                                    <td>
                                        <div ng-switch on="{{u.status}}">
                                            <div ng-switch-when="1">Active</div>
                                            <div ng-switch-when="0">Deactive</div>
                                        </div>
                                    </td>
                                    <td>
                                        <div ng-switch on="{{u.status}}">
                                            <div ng-switch-when="1">
                                                <button type="button" ng-click="ctrlOffice.editOffice(u.idOffice)" data-toggle="modal" data-target="#myModalAdd" class="btn btn-primary custom-width">Edit</button>
                                            </div>
                                            <div ng-switch-when="0">

                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <div ng-switch on="{{u.status}}">
                                            <div ng-switch-when="1">
                                                <button type="button" ng-click="ctrlOffice.removeOffice(u.idOffice)" class="btn btn-danger custom-width">Delete</button>
                                            </div>
                                            <div ng-switch-when="0">
                                                <button type="button" ng-click="ctrlOffice.removeOffice(u.idOffice)" class="btn btn-primary custom-width">Restore</button>
                                            </div>
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

<div class="modal fade" id="myModalAdd" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add / Update Data</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" ng-submit="ctrlOffice.submit()" name="myForm">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Name :</label>
                        <div class="col-sm-8">
                            <input type="text" ng-model="ctrlOffice.office.name" id="uname" class="username form-control input-sm" placeholder="Enter new office name" style="width:200px;"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Address :</label>
                        <div class="col-sm-8">
                            <input type="text" ng-model="ctrlOffice.office.address" id="address" class="username form-control input-sm" placeholder="Enter new office address" style="width:300px;"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">City :</label>
                        <div class="col-sm-8">
                            <input type="text" ng-model="ctrlOffice.office.city" id="city" class="username form-control input-sm" placeholder="Enter new office city location" style="width:200px;"/>
                        </div>
                    </div>

                    <input type="hidden" ng-model="ctrlOffice.office.status" ng-init="ctrlOffice.office.status=1" id="status" class="username form-control input-sm" style="width:200px;"/>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Telephone :</label>
                        <div class="col-sm-8">
                            <input type="number" ng-model="ctrlOffice.office.telephone" id="Telpne" class="username form-control input-sm" placeholder="Enter new office telephone" style="width:200px;"/>
                        </div>
                    </div>
                    <div class="form-group modal-footer">
                        <input type="submit"  value="{{!ctrlOffice.office.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>
