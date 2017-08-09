<!-- Navigation -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
    <#--<div class="navbar-header">-->
    <#--<a class="navbar-brand" href="">Blibli.com</a>-->
    <#--</div>-->
        <ul class="nav navbar-nav">
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

<div class="content-section-a">
    <div class="container">
        <br/>
        <h2 class="section-heading">Available Rooms</h2>
        <p class="category"><h5>You can see list of available rooms to book, based on your given data.</h5></p>
        <br/><br/>
        <div class="content table-responsive table-full-width">
            <table class="table table-hover table-striped data">
                <thead>
                <tr>
                    <th>No.</th>
                    <th>NAME</th>
                    <th>CAPACITY</th>
                    <th>HAVE CONFERENCE</th>
                    <th>HAVE PROJECTOR</th>
                    <th>NUMBER EXTENSION</th>
                    <th>OFFICE</th>
                    <#--<th width="100"></th>-->
                    <th width="100"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrlBooking.getAvailableRoom()">
                    <td>{{$index +1}}</td>
                    <td>{{u.name}}</td>
                    <td>{{u.capacity}}</td>
                    <td>
                        <div ng-switch on="{{u.isConference}}">
                            <div ng-switch-when="1">Yes</div>
                            <div ng-switch-when="0">No</div>
                        </div>
                    </td>
                    <td>
                        <div ng-switch on="{{u.isProjector}}">
                            <div ng-switch-when="1">Yes</div>
                            <div ng-switch-when="0">No</div>
                        </div>
                    </td>
                    <td>{{u.numberExtension}}</td>
                    <td>{{u.office.name}}</td>
                    <#--<td><button type="button" ng-click="ctrlBooking.getRoombyId(u.idRoom)" data-toggle="modal" data-target="#myModalAdd" class="btn btn-success custom-width">Book</button></td>-->
                    <td><button type="button" ng-click="" class="btn btn-danger custom-width">Details</button></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <!-- /.container -->
</div>

<div class="modal fade" id="myModalAdd" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Aditional Booking Data</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" ng-submit="ctrlBooking.submit()" name="myForm">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Description :</label>
                        <div class="col-sm-8">
                            <input type="text" ng-model="ctrlBooking.booking.description" id="description" class="username form-control input-sm" placeholder="Enter Booking Description" required />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Subject :</label>
                        <div class="col-sm-8">
                            <input type="text" ng-model="ctrlBooking.booking.subject" id="subject" class="username form-control input-sm" placeholder="Enter Booking Subject" required />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">PIC contact :</label>
                        <div class="col-sm-8">
                            <input type="text" ng-model="ctrlBooking.booking.picContact" id="picContact" class="username form-control input-sm" placeholder="Enter the Person in Charge Contact" required />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Special Request :</label>
                        <div class="col-sm-8">
                            <input type="text" ng-model="ctrlBooking.booking.specialRequest" id="specialRequest" class="username form-control input-sm" placeholder="Enter Special Request" required />
                        </div>
                    </div>
                    <input type="hidden" ng-model="ctrlRoom.room.status" ng-init="ctrlRoom.room.status=1" id="status" class="username form-control input-sm" />
                    <input type="hidden" ng-model="ctrlRoom.room.idRoom" ng-init="ctrlRoom.room.idRoom=''" id="idRoom" class="username form-control input-sm" />

                    <div class="form-group modal-footer">
                        <input type="submit" data-dismiss="myModalAdd" value="Book" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                    </div>
                </form>

            </div>
        </div>

    </div>
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