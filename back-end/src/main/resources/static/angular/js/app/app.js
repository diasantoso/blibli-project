var app = angular.module('bookingApp',['ui.router','ngStorage']);

app.constant('urls',{
    BASE : 'http://localhost:8080/',
    OFFICE_SERVICE_API : 'http://localhost:8080/api/offices/',
    ROOM_SERVICE_API : 'http://localhost:8080/api/rooms/',
    BOOKING_SERVICE_API : 'http://localhost:8080/api/bookings'
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

                .state('login',{
                    url: '/login',
                    templateUrl: '/partials/login'
                })

                .state('dashboard',{
                   url: '/dashboard',
                   templateUrl: '/partials/home'
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
                });

       $urlRouterProvider.otherwise('/');}]);