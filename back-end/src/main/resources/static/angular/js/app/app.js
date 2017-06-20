var app = angular.module('bookingApp',['ui.router','ngStorage']);

app.constant('urls',{
    BASE : 'http://localhost:8080/',
    OFFICE_SERVICE_API : 'http://localhost:8080/api/offices/',
    ROOM_SERVICE_API : 'http://localhost:8080/api/rooms/',
    EMPLOYEE_SERVICE_API : 'http://localhost:8080/api/employees',
    BOOKING_SERVICE_API : 'http://localhost:8080/api/bookings',
    LOGIN_SERVICE_API : 'http://localhost:8080/api/login',
    COUNT_SERVICE_API : 'http://localhost:8080/api/count'
});

app.config(['$stateProvider', '$urlRouterProvider',
       function($stateProvider, $urlRouterProvider){

            $stateProvider
                .state('home',{
                    url: '/',
                    templateUrl: '/partials/landingpage'
                })

                .state('showbooking',{
                    url: '/listbooking',
                    templateUrl: '/partials/showbooking',
                    controller: 'BookingController',
                    controllerAs: 'ctrlBooking',
                    resolve: {
                        offices: function ($q, BookingService) {
                            console.log('Load all bookings');
                            var deferred = $q.defer();
                            BookingService.loadAllBookings()
                                .then(deferred.resolve,deferred.resolve);
                            return deferred.promise;
                        }
                    }
                })

                .state('addbooking',{
                    url: '/addbooking',
                    templateUrl: '/partials/addbooking'
                })

                .state('login',{
                    url: '/login',
                    templateUrl: '/partials/login'
                })

                .state('dashboard',{
                    url: '/dashboard',
                    templateUrl: '/partials/home',
                    controller: 'CountController',
                    controllerAs: 'ctrlCount',
                    resolve: {
                        count: function ($q, CountService) {
                            console.log('Load all count');
                            var deferred = $q.defer();
                            CountService.loadCount()
                                .then(deferred.resolve,deferred.resolve);
                            return deferred.promise;
                        }
                    }
                })

                .state('Office',{
                    url: '/offices',
                    templateUrl: '/partials/offices/office',
                    controller: 'OfficeController',
                    controllerAs: 'ctrlOffice',
                    resolve: {
                        offices: function ($q, OfficeService) {
                            console.log('Load all offices');
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
                                .then(deferred.resolve, deferred.resolve);
                            RoomService.loadOffices()
                                .then(deferred.resolve, deferred.resolve);
                            return deferred.promise;
                        }
                    }
                })

                .state('Employee',{
                    url: '/employees',
                    templateUrl: '/partials/employees/employee',
                    controller: 'EmployeeController',
                    controllerAs: 'ctrlEmployee',
                    resolve: {
                        employees: function ($q, EmployeeService) {
                            console.log('Load all employees');
                            var deferred = $q.defer();
                            EmployeeService.loadAllEmployees()
                                .then(deferred.resolve,deferred.resolve);
                            return deferred.promise;
                        }
                    }
                })

                .state('Booking',{
                    url: '/bookings',
                    templateUrl: '/partials/bookings/booking',
                    controller: 'BookingController',
                    controllerAs: 'ctrlBooking',
                    resolve: {
                        offices: function ($q, BookingService) {
                            console.log('Load all bookings');
                            var deferred = $q.defer();
                            BookingService.loadAllBookings()
                                .then(deferred.resolve,deferred.resolve);
                            return deferred.promise;
                        }
                    }
                })

                .state('BookingAdd',{
                    url: '/bookings/add',
                    templateUrl: '/partials/bookings/addbooking',
                    controller: 'BookingController',
                    controllerAs: 'ctrlBooking',
                    resolve: {
                        offices: function ($q, BookingService) {
                            console.log('Load all bookings');
                            var deferred = $q.defer();
                            BookingService.loadAllBookings()
                                .then(deferred.resolve,deferred.resolve);
                            return deferred.promise;
                        }
                    }
                });

       $urlRouterProvider.otherwise('/');}]);