'use strict';

angular.module('bookingApp').factory('OfficeService',
    ['$localStorage','$http','$q','urls',
        function ($localStorage,$http,$q,urls){

            var factory = {
                loadAllOffices : loadAllOffices,
                getAllOffices : getAllOffices,
                getOffice : getOffice,
                createOffice : createOffice,
                updateOffice : updateOffice,
                removeOffice : removeOffice
            };

            return factory;

            function loadAllOffices(){
                console.log('Fetching all offices');
                var deferred = $q.defer();
                $http.get(urls.OFFICE_SERVICE_API)
                    .then(
                        function (response){
                            console.log('Fetched successfully all Offices');

                            $localStorage.offices = response.data.value;
                            deferred.resolve(response);
                        },
                        function (errResponse){
                            console.error('Error while Fetching offices');
                            console.error(errResponse);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllOffices(){
                return $localStorage.offices;
            }

            function getOffice(id){
                console.log('Fetching Office with id : ' +id);
                var deferred =  $q.defer();
                $http.get(urls.OFFICE_SERVICE_API + id)
                    .then(
                        function (response){
                            console.log('Fetched successfully office with id : ' + id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading office with id : ' +id);
                            deferred.reject(errResponse);
                        }
                    );
                 return deferred.promise;
            }

            function createOffice(office){
                console.log('Creating Office');
                var deferred = $q.defer();
                $http.post(urls.OFFICE_SERVICE_API, office)
                    .then(
                        function (response){
                            loadAllOffices();
                            deferred.resolve(response.data);
                        },

                        function (errResponse) {
                            console.error('Error while creating Office : ' + errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );

                 return deferred.promise;
            }

            function updateOffice(office , id){
                console.log('Updating Office with id ' + id);
                var deferred = $q.defer();
                $http.put(urls.OFFICE_SERVICE_API + id, user)
                    .then(
                        function (response){
                            loadAllOffices();
                            deferred.resolve(response.data);
                        },
                        function (errResponse){
                            console.error('Error while updating office with id : ' + id);
                            deferred.reject(errResponse);
                        }
                    );
                 return deferred.promise;
            }

            function removeOffice(id){
                console.log('Removing office with id : ' +id);
                var deferred = $q.defer();
                $http.delete(urls.OFFICE_SERVICE_API+"?id="+id)
                    .then(
                        function (response){
                            loadAllOffices();
                            deferred.resolve(response.data);
                        },

                        function (errResponse){
                            console.error('Error while removing office with id : '+ id);
                            deferred.reject(errResponse);
                        }
                    );
                 return deferred.promise;
            }

        }
     ]);