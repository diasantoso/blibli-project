var app = angular.module('bookingApp',['ui.router','ngStorage']);

app.constant('urls',{
    BASE : 'http://localhost:8080/',
    OFFICE_SERVICE_API : 'http://localhost:8080/api/offices/',
    ROOM_SERVICE_API : 'http://localhost:8080/api/rooms/'
});

// app.config(['$stateProvider', '$urlRouterProvider',function ($routeProvider) {
//
//     $routeProvider.when('/offices', {
//         templateUrl: '/partials/list',
//         controller: 'OfficeController'
//     }).when('/rooms', {
//         templateUrl: '/partials/list',
//         controller: 'RoomController'
//     }).otherwise({
//         redirectTo: "/"
//     });
// }]);

// app.config(function ($stateProvider, $urlRouterProvider) {
//     $urlRouterProvider.otherwise('/daily');
//     $stateProvider
//         .state('hourly', {
//             url: '/hourly',
//             controller: 'WeatherCtrl',
//             templateUrl: 'partials/hourly.html'
//         })
//         .state('daily', {
//             url: '/daily',
//             controller: 'WeatherCtrl',
//             templateUrl: 'partials/daily.html'
//         });
// });

app.config(['$stateProvider', '$urlRouterProvider',
               function($stateProvider, $urlRouterProvider){

                    $stateProvider
                       .state('home',{
                           url: '/',
                           templateUrl: '/partials/home'
                       })

                       .state('Office',{
                            url: '/offices',
                            templateUrl: '/partials/offices/office',
                            controller: 'OfficeController',
                            controllerAs: 'ctrlOffice',
                            resolve: {
                                offices: function ($q, OfficeService) {
                                    console.log('Load all Offices');
                                    var deferred = $q.defer();
                                    OfficeService.loadAllOffices()
                                        .then(deferred.resolve,deferred.resolve);
                                    return deferred.promise;
                                }
                            }
                        })

                       .state('Room',{
                           url: '/rooms',
                           templateUrl: 'partials/rooms/room',
                           controller: 'RoomController',
                           controllerAs: 'ctrlRoom',
                           resolve: {
                               rooms: function ($q, RoomService) {
                                   console.log('Load all rooms');
                                   var deferred = $q.defer();
                                   RoomService.loadAllRooms()
                                       .then(deferred.resolve,deferred.resolve);
                                   return deferred.promise;
                               }
                           }
                        })

                        .state('booking',{
                            url: '/bookings',
                            templateUrl: '/partials/bookings/booking'
                        });

                     $urlRouterProvider.otherwise('/');}]);