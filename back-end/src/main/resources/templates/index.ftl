<!doctype html>
<html lang="en" ng-app="bookingApp">
<head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Booking Room | BLIBLI</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <#--AngularJS Source Scripts-->
    <script src="../angular/js/lib/angular.min.js" ></script>
    <script src="../angular/js/lib/angular-ui-router.min.js" ></script>
    <script src="../angular/js/lib/localforage.min.js" ></script>
    <script src="../angular/js/lib/ngStorage.min.js"></script>
    <script src="../angular/js/app/app.js"></script>
    <script src="../angular/js/app/OfficeService.js"></script>
    <script src="../angular/js/app/OfficeController.js"></script>
    <script src="../angular/js/app/RoomService.js"></script>
    <script src="../angular/js/app/RoomController.js"></script>
    <script src="../angular/js/app/BookingService.js"></script>
    <script src="../angular/js/app/BookingController.js"></script>

    <#--CSS for Layout Bootstrap-->
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../assets/css/animate.min.css" rel="stylesheet"/>
    <link href="../assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>
    <link href="../assets/css/demo.css" rel="stylesheet" />
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="../assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

    <#--JS for layout Bootstrap-->
    <script src="../assets/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="../assets/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../assets/js/bootstrap-checkbox-radio-switch.js"></script>
    <script src="../assets/js/chartist.min.js"></script>
    <script src="../assets/js/bootstrap-notify.js"></script>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <script src="../assets/js/light-bootstrap-dashboard.js"></script>
    <script src="../assets/js/demo.js"></script>

    <#--CSS & JS for Datatables-->
    <link rel="stylesheet" type="text/css" href="../assets/DataTables/media/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="../assets/DataTables/media/css/dataTables.bootstrap.css">
    <script type="text/javascript" src="../assets/DataTables/media/js/jquery.js"></script>
    <script type="text/javascript" src="../assets/DataTables/media/js/jquery.dataTables.js"></script>
</head>
<body>
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
                    <a href="#">
                        <i class="pe-7s-graph"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li>
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
    <div ui-view></div>

    <script type="text/javascript">
        $(document).ready(function(){
            $('.data').DataTable();
        });
    </script>
</body>
</html>