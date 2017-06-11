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
                    <a href="#dashboard">
                        <i class="pe-7s-graph"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li class="active">
                    <a href="#rooms">
                        <i class="pe-7s-note2"></i>
                        <p>Room Manage</p>
                    </a>
                </li>
                <li>
                    <a href="#offices">
                        <i class="pe-7s-note2"></i>
                        <p>Office Manage</p>
                    </a>
                </li>
                <li>
                    <a href="#employees">
                        <i class="pe-7s-note2"></i>
                        <p>Employee Manage</p>
                    </a>
                </li>
                <li>
                    <a href="#bookings">
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
                            <h3 class="title"><strong>ROOM DATA</strong></h3><br/>
                            <p class="category"><h5>This is office data from Blibli.com. You can manage to add, update, delete data office.</h5></p>
                        </div>
                        <br/><br/>
                        <div class="content table-responsive table-full-width">
                            <table class="table table-hover table-striped data">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>NAME</th>
                                    <th>CAPACITY</th>
                                    <th>HAVE CONFERENCE</th>
                                    <th>HAVE PROJECTOR</th>
                                    <th>NUMBER EXTENSION</th>
                                    <th>STATUS</th>
                                    <th>OFFICE</th>
                                    <th width="100"></th>
                                    <th width="100"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr ng-repeat="u in ctrlRoom.getAllRooms()">
                                    <td>{{u.idRoom}}</td>
                                    <td>{{u.name}}</td>
                                    <td>{{u.capacity}}</td>
                                    <td>{{u.isConference}}</td>
                                    <td>{{u.isProjector}}</td>
                                    <td>{{u.numberExtension}}</td>
                                    <td>{{u.status}}</td>
                                    <td>{{u.office.name}}</td>
                                    <td><button type="button" ng-click="ctrlRoom.editRoom(u.idRoom)" data-toggle="modal" data-target="#myModalAdd" class="btn btn-success custom-width">Edit</button></td>
                                    <td><button type="button" ng-click="ctrlRoom.removeRoom(u.idRoom)" class="btn btn-danger custom-width">Remove</button></td>
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
                <form class="form-horizontal" ng-submit="ctrlRoom.submit()" name="myForm">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Name :</label>
                        <div class="col-sm-8">
                            <input type="text" ng-model="ctrlRoom.room.name" id="uname" class="username form-control input-sm" placeholder="Enter new Room name" required />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Capacity :</label>
                        <div class="col-sm-8">
                            <input type="number" ng-model="ctrlRoom.room.capacity" id="capacity" class="username form-control input-sm" placeholder="Enter Capacity for new Room" required />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Have Conference :</label>
                        <div class="col-sm-8">
                            <input type="text" ng-model="ctrlRoom.room.isConference" ng-init="ctrlRoom.room.isConference=1" id="isConference" class="username form-control input-sm" placeholder="isConference" required />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Have Projector :</label>
                        <div class="col-sm-8">
                            <input type="text" ng-model="ctrlRoom.room.isProjector" ng-init="ctrlRoom.room.isProjector=1" id="isProjector" class="username form-control input-sm" required />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Number Extension :</label>
                        <div class="col-sm-8">
                            <input type="text" ng-model="ctrlRoom.room.numberExtension" id="numberExtension" class="username form-control input-sm" placeholder="Enter Number Extension for new Room" required />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Office :</label>
                        <div class="col-sm-8">
                            <#--<input type="text" ng-model="ctrlRoom.room.office.idOffice" id="office" class="username form-control input-sm" placeholder="Enter Office for the new room" required />-->
                            <select class="username form-control input-sm" ng-model="ctrlRoom.room.office.idOffice">
                                <option ng-repeat="u in ctrlRoom.getOffices()" value="{{u.idOffices}}">{{u.name}}</option>
                            </select>
                        </div>
                    </div>

                    <input type="hidden" ng-model="ctrlRoom.room.status" ng-init="ctrlRoom.room.status=1" id="status" class="username form-control input-sm" />

                    <div class="form-group modal-footer">
                        <input type="submit"  value="{{!ctrlRoom.room.idRoom ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>
