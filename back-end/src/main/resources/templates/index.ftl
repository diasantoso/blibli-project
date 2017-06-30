<!doctype html>
<html lang="en" ng-app="bookingApp">
<head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Blibli.com | Booking Meeting Room</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>



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
    <script src="../angular/js/app/EmployeeService.js"></script>
    <script src="../angular/js/app/EmployeeController.js"></script>
    <script src="../angular/js/app/BookingService.js"></script>
    <script src="../angular/js/app/BookingController.js"></script>
    <script src="../angular/js/app/CountService.js"></script>
    <script src="../angular/js/app/CountController.js"></script>

    <#--CSS for Layout Bootstrap - ADMIN PAGE-->
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../assets-custom/custom.min.css" rel="stylesheet" />
    <link href="../assets/css/animate.min.css" rel="stylesheet"/>
    <link href="../assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>
    <link href="../assets/css/demo.css" rel="stylesheet" />
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="../assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

    <#--JS for layout Bootstrap - ADMIN PAGE-->

    <#--<script src="../assets/js/jquery-1.10.2.js" type="text/javascript"></script>-->
    <script src="../assets/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../assets/js/bootstrap-checkbox-radio-switch.js"></script>
    <script src="../assets/js/chartist.min.js"></script>
    <script src="../assets/js/bootstrap-notify.js"></script>
    <#--<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>-->
    <script src="../assets/js/light-bootstrap-dashboard.js"></script>
    <script src="../assets/js/demo.js"></script>

    <#--CSS for Layout Bootstrap - LANDING PAGE-->
    <link href="../assets-landingpage/css/landing-page.css" rel="stylesheet">
    <link href="../assets-landingpage/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <#--CSS & JS for Layout Bootstrap - LOGIN PAGE-->
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="../assets-login/css/style.css">
    <#--<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>-->
    <script src="../assets-login/js/index.js"></script>

    <#--CSS & JS for Datatables-->
    <link rel="stylesheet" type="text/css" href="../assets/DataTables/media/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="../assets/DataTables/media/css/dataTables.bootstrap.css">
    <#--<script type="text/javascript" src="../assets/DataTables/media/js/jquery.js"></script>-->
    <script type="text/javascript" src="../assets/DataTables/media/js/jquery.dataTables.js"></script>

    <#--Image Preview CSS-->

    <style type="text/css">
        .image-preview {
            width: 120px;
            height: 120px;
            display: inline-block;
            position: relative;
            overflow: hidden;
            background-color: #f7f7f8;
            color: #ecf0f1;
            border: 2px solid #dddddd;
            border-radius: 5px;
        }
        .image-preview input {
            line-height: 90px;
            font-size: 90px;
            position: absolute;
            opacity: 0;
            z-index: 10;
        }
        .image-preview label {
            position: absolute;
            z-index: 5;
            opacity: 0.8;
            cursor: pointer;
            background-color: #bdc3c7;
            width: 80px;
            height: 25px;
            font-size: 14px;
            line-height: 25px;
            text-transform: uppercase;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            margin: auto;
            text-align: center;
        }

    </style>

</head>
<body>

    <div ui-view></div>

    <script type="text/javascript">
        $(document).ready(function(){
            $('.data').DataTable();
        });
    </script>



</body>
</html>