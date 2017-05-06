<!DOCTYPE html>

<html lang="en" ng-app="bookingApp">
    <head>
        <title>${title}</title>
        <link href="../angular/css/bootstrap.css" rel="stylesheet"/>
        <link href="../angular/css/app.css" rel="stylesheet"/>
    </head>
    <body>
        <#-- Nav Bar -->
        <nav class="navbar navbar-default"
             <div class="container">
                 <div class="navbar-header">
                     <a class="navbar-brand" href="/">Blibli Booking Room Application</a>
                 </div>
                 <ul class="nav navbar-nav navbar-right">
                     <#--This #.... follows url=/ in app.js-->
                     <li><a href="#"><i class="fa fa-home"></i></a></li>
                     <li><a href="#offices"><i class="fa fa-shield"></i></a></li>
                     <li><a href="#rooms"><i class="fa fa-comment"></i></a></li>
                 </ul>
             </div>

        <#-- Content -->
        <div class="row">
            <div ui-view></div>
        </div>

        <#--Source Scripts-->
        <script src="../angular/js/lib/angular.min.js" ></script>
        <script src="../angular/js/lib/angular-ui-router.min.js" ></script>
        <script src="../angular/js/lib/localforage.min.js" ></script>
        <script src="../angular/js/lib/ngStorage.min.js"></script>
        <script src="../angular/js/app/app.js"></script>
        <script src="../angular/js/app/OfficeService.js"></script>
        <script src="../angular/js/app/OfficeController.js"></script>
        <script src="../angular/js/app/RoomService.js"></script>
        <script src="../angular/js/app/RoomController.js"></script>
    </body>
</html>