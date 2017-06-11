'use strict';

angular.module('bookingApp').factory('BookingService',
    ['$localStorage','$http','$q','urls',
        function ($localStorage,$http,$q,urls){

            var factory = {
                loadAllBookings : loadAllBookings,
                getAllBookings : getAllBookings,
                getBooking : getBooking,
                createBooking : createBooking,
                updateBooking : updateBooking,
                removeBooking : removeBooking
            };

            return factory;

            function loadAllBookings(){
                console.log('Fetching all bookings');
                var deferred = $q.defer();
                $http.get(urls.BOOKING_SERVICE_API)
                    .then(
                        function (response){
                            console.log('Fetched successfully all bookings');

                            $localStorage.bookings = response.data.value;
                            deferred.resolve(response);
                        },
                        function (errResponse){
                            console.error('Error while Fetching bookings');
                            console.error(errResponse);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllBookings(){
                return $localStorage.bookings;
            }

            function getBooking(id){
                console.log('Fetching bookings with id : ' +id);
                var deferred =  $q.defer();
                $http.get(urls.BOOKING_SERVICE_API + id)
                    .then(
                        function (response){
                            console.log('Fetched successfully bookings with id : ' + id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading bookings with id : ' +id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createBooking(booking){
                console.log('Creating booking');
                var deferred = $q.defer();
                $http.post(urls.BOOKING_SERVICE_API, booking)
                    .then(
                        function (response){
                            loadAllBookings();
                            deferred.resolve(response.data);
                        },

                        function (errResponse) {
                            console.error('Error while creating booking : ' + errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );

                return deferred.promise;
            }

            function updateBooking(booking , id){
                console.log('Updating booking with id ' + id);
                var deferred = $q.defer();
                $http.put(urls.BOOKING_SERVICE_API + id, user)
                    .then(
                        function (response){
                            loadAllBookings();
                            deferred.resolve(response.data);
                        },
                        function (errResponse){
                            console.error('Error while updating booking with id : ' + id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeBooking(id){
                console.log('Removing booking with id : ' +id);
                var deferred = $q.defer();
                $http.delete(urls.BOOKING_SERVICE_API+"?id="+id)
                    .then(
                        function (response){
                            loadAllBookings();
                            deferred.resolve(response.data);
                        },

                        function (errResponse){
                            console.error('Error while removing booking with id : '+ id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);