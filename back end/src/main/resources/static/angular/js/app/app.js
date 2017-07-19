var app = angular.module('bookingApp',['ui.router','ngStorage']);

app.constant('urls',{
    BASE : 'http://localhost:8080/',
    OFFICE_SERVICE_API : 'http://localhost:8080/api/offices/',
    ROOM_SERVICE_API : 'http://localhost:8080/api/rooms/',
    EMPLOYEE_SERVICE_API : 'http://localhost:8080/api/employees',
    REGISTER_EMPLOYEE_SERVICE_API : 'http://localhost:8080/api/register',
    BOOKING_SERVICE_API : 'http://localhost:8080/api/bookings',
    COUNT_SERVICE_API : 'http://localhost:8080/api/count',
    IMAGES_SERVICE_API : 'http://localhost:8080/api/rooms/images',
    IMAGES_UPLOAD_API : 'http://localhost:8080/api/upload',
    LOGIN_API : 'http://localhost:8080/api/login'
});

app.config(['$stateProvider', '$urlRouterProvider', '$locationProvider',
       function($stateProvider, $urlRouterProvider, $locationProvider){

            $stateProvider
                .state('home',{
                    url: '/',
                    templateUrl: '/partials/landingpage'
                })
                .state('access-denied', {
                    url : '/access-denied',
                    templateUrl: '/partials/access-denied'
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
                            BookingService.loadUpcomingBookings()
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
                    templateUrl: '/partials/login',
                    controller: 'LoginController',
                    controllerAs: 'ctrlLogin'
                })

                .state('register',{
                url: '/register',
                templateUrl: '/partials/register',
                controller: 'EmployeeController',
                controllerAs: 'ctrlEmployee'
                })

                .state('dashboard',{
                    url: '/dashboard',
                    //data : {role:'Admin'},
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
                    data : {role:'Admin'},
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
                    data : {role:'Admin'},
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
                    data : {role:'Admin'},
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
       // use the HTML5 History API
       $locationProvider.html5Mode(true);
       $urlRouterProvider.otherwise('/');}]);


app.directive("ngUploadChange",function(){
    return{
        scope:{
            ngUploadChange:"&"
        },
        link:function($scope, $element, $attrs){
            $element.on("change",function(event){
                $scope.ngUploadChange({$event: event})
            })
            $scope.$on("$destroy",function(){
                $element.off();
            });
        }
    }
});

// the following method will run at the time of initializing the module. That
// means it will run only one time.
app.run(function(LoginService, $rootScope, $state) {
    // For implementing the authentication with ui-router we need to listen the
    // state change. For every state change the ui-router module will broadcast
    // the '$stateChangeStart'.
    $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
        // checking the user is logged in or not
        console.log('To State ='+toState.name);
        if(toState.data.role)
        console.log('To State Data Role ='+toState.data.role);
        else
            console.log('ToState Data Role null.')
        if (!LoginService.user) { //Ini buat ngecek user login belum, nah kalau belum dia bakal masuk ke dalam blok if nya
            // To avoiding the infinite looping of state change we have to add a
            // if condition.
            //disini if nya ngecek, kalau belum login halaman apa aja yg boleh dikunjungi
            //(dalam contoh ini cuma boleh ke "state" alias halaman login dan register


            if (toState.name != 'login' && toState.name != 'register' && toState.name != 'home') {
                //selain akses halaman login atau register dia bakal masuk ke blok ini

                event.preventDefault(); //ini buat ngestop paksa (contoh mau kehalamaan office, trus di stop paksa
                $state.go('login'); // dipaksa ke halaman login dulu

            }
        } else {
            // checking the user is authorized to view the states
            if (toState.data && toState.data.role) {
                var hasAccess = false;
                    var role = LoginService.user.role;
                    if (toState.data.role == role) {
                        hasAccess = true;
                    }
                if (!hasAccess) {
                    event.preventDefault();
                    $state.go('access-denied');
                }

            }
        }
    });
});

