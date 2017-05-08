<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Room </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrlRoom.successMessage">{{ctrlRoom.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrlRoom.errorMessage">{{ctrlRoom.errorMessage}}</div>
	            <form ng-submit="ctrlRoom.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrlRoom.room.idRoom" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrlRoom.room.name" id="uname" class="username form-control input-sm" placeholder="Enter new Room name" required />
	                        </div>
	                    </div>
	                </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="capacity">Capacity</label>
                            <div class="col-md-7">
                                <input type="number" ng-model="ctrlRoom.room.capacity" id="capacity" class="username form-control input-sm" placeholder="Enter Capacity for new Room" required />
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="isConference">isConference</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrlRoom.room.isConference" ng-init="ctrlRoom.room.isConference=1" id="isConference" class="username form-control input-sm" placeholder="isConference" required />
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="isProjector">isProjector</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrlRoom.room.isProjector" ng-init="ctrlRoom.room.isProjector=1" id="isProjector" class="username form-control input-sm" required />
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="numberExtension">Number Extension</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrlRoom.room.numberExtension" id="numberExtension" class="username form-control input-sm" placeholder="Enter Number Extension for new Room" required />
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="status">Room Status</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrlRoom.room.status" ng-init="ctrlRoom.room.status=1" id="status" class="username form-control input-sm" placeholder="Enter Status for new Room" required />
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="office">Office</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrlRoom.room.office.idOffice" id="office" class="username form-control input-sm" placeholder="Enter Office for the new room" required />
                            </div>
                        </div>
                    </div>

	                <#--<div class="row">-->
	                    <#--<div class="form-group col-md-12">-->
	                        <#--<label class="col-md-2 control-lable" for="age">Age</label>-->
	                        <#--<div class="col-md-7">-->
	                            <#--<input type="text" ng-model="ctrlOffice.offices.age" id="age" class="form-control input-sm" placeholder="Enter your Age." required ng-pattern="ctrl.onlyIntegers"/>-->
	                        <#--</div>-->
	                    <#--</div>-->
	                <#--</div>-->
	<#---->
	                <#--<div class="row">-->
	                    <#--<div class="form-group col-md-12">-->
	                        <#--<label class="col-md-2 control-lable" for="salary">Salary</label>-->
	                        <#--<div class="col-md-7">-->
	                            <#--<input type="text" ng-model="ctrl.user.salary" id="salary" class="form-control input-sm" placeholder="Enter your Salary." required ng-pattern="ctrl.onlyNumbers"/>-->
	                        <#--</div>-->
	                    <#--</div>-->
	                <#--</div>-->

	                <div class="row">
	                    <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrlRoom.room.idRoom ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrlRoom.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Rooms </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>CAPACITY</th>
                        <th>ISCONFERENCE</th>
                        <th>ISPROJECTOR</th>
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
                        <td><button type="button" ng-click="ctrlRoom.editRoom(u.idRoom)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrlRoom.removeRoom(u.idRoom)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>