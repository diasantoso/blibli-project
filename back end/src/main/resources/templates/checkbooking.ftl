<!-- Navigation -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
    <#--<div class="navbar-header">-->
    <#--<a class="navbar-brand" href="">Blibli.com</a>-->
    <#--</div>-->
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="/listbooking">Upcoming Booking</a></li>
            <li><a href="/addbooking">Check Room</a></li>
            <li><a href="/checkticket">Check Ticket</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Register</a></li>
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>

<div class="login-form">
    <h1>Check Available Room</h1>
    <form ng-submit="ctrlBooking.check()">
        <div class="form-group ">
            <select class="username form-control input-sm" ng-model="ctrlBooking.searchVar.officeId" required>
                <option ng-repeat="u in ctrlBooking.getOffices()" value="{{u.idOffice}}">{{u.name}}</option>
            </select>
        </div>
        <div class="form-group ">
            <input type="text" class="form-control" placeholder="Date Meeting" ng-model="ctrlBooking.searchVar.date" id="date">
        </div>
        <div class="form-group ">
            <input type="text" class="form-control" placeholder="Start Time" ng-model="ctrlBooking.searchVar.startTime" id="starttime">
        </div>
        <div class="form-group ">
            <input type="text" class="form-control" placeholder="End Time" ng-model="ctrlBooking.searchVar.endTime" id="endtime">
        </div>
        <span class="alert">Invalid Credentials</span>
        <button type="submit" class="log-btn2" >Check</button>
    </form>
</div>

