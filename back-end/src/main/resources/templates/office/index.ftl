<!DOCTYPE html>

<html lang="en" ng-app="bookingApp">
    <head>
        <title>${title}</title>
        <link href="../angular/css/bootstrap.css" rel="stylesheet"/>
        <link href="../angular/css/app.css" rel="stylesheet"/>
    </head>
    <body>

        <div ui-view></div>
        <script src="../angular/js/lib/angular.min.js" ></script>
        <script src="../angular/js/lib/angular-ui-router.min.js" ></script>
        <script src="../angular/js/lib/localforage.min.js" ></script>
        <script src="../angular/js/lib/ngStorage.min.js"></script>
        <script src="../angular/js/app/app.js"></script>
        <script src="../angular/js/app/OfficeService.js"></script>
        <script src="../angular/js/app/OfficeController.js"></script>
    </body>
</html>