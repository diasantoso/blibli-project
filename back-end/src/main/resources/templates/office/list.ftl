<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Office </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrlOffice.successMessage">{{ctrlOffice.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrlOffice.errorMessage">{{ctrlOffice.errorMessage}}</div>
	            <form ng-submit="ctrlOffice.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrlOffice.office.idOffice" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrlOffice.office.name" id="uname" class="username form-control input-sm" placeholder="Enter new office name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="address">Address</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrlOffice.office.address" id="address" class="username form-control input-sm" placeholder="Enter new Office address" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="city">City</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrlOffice.office.city" id="city" class="username form-control input-sm" placeholder="Enter new Office city Location" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="status">Status</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrlOffice.office.status" ng-init="ctrlOffice.office.status=1" id="status" class="username form-control input-sm" required />
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="Telpne">Telpne</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrlOffice.office.telephone" id="Telpne" class="username form-control input-sm" placeholder="Enter new Office Phone" required />
                            </div>
                        </div>
                    </div>

	                <#--<div class="row">-->
	                    <#--<div class="form-group col-md-12">-->
	                        <#--<label class="col-md-2 control-lable" for="age">Age</label>-->
	                        <#--<div class="col-md-7">-->
	                            <#--<input type="text" ng-model="ctrlOffice.office.age" id="age" class="form-control input-sm" placeholder="Enter your Age." required ng-pattern="ctrl.onlyIntegers"/>-->
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
	                        <input type="submit"  value="{{!ctrlOffice.office.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrlOffice.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Offices </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>ADDRESS</th>
                        <th>CITY</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrlOffice.getAllOffices()">
                        <td>{{u.idOffice}}</td>
                        <td>{{u.name}}</td>
                        <td>{{u.address}}</td>
                        <td>{{u.city}}</td>
                        <td><button type="button" ng-click="ctrlOffice.editOffice(u.idOffice)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrlOffice.removeOffice(u.idOffice)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>