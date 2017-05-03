var app = angular.module('bookingApp',['ui.router','ngStorage']);

app.constant('urls',{
    BASE : 'http://localhost:8080/offices',
    BASE : 'http://localhost:8080/rooms',
    OFFICE_SERVICE_API : 'http://localhost:8080/api/offices/',
    ROOM_SERVICE_API : 'http://localhost:8080/api/rooms/'
});

app.config(['$stateProvider', '$urlRouterProvider',
               function($stateProvider, $urlRouterProvider){

                    $stateProvider
                        .state('office',{
                            url: '/',
                            templateUrl: 'partials/list',
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
                        });

                     $urlRouterProvider.otherwise('/');


               }]);