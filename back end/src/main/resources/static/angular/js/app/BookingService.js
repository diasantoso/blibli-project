'use strict';

angular.module('bookingApp').factory('BookingService',
    ['$localStorage','$http','$q','urls',
        function ($localStorage,$http,$q,urls){

            var factory = {
                loadAllBookings : loadAllBookings,
                loadUpcomingBookings : loadUpcomingBookings,
                getAllBookings : getAllBookings,
                getUpcomingBookings : getUpcomingBookings,
                getBooking : getBooking,
                createBooking : createBooking,
                updateBooking : updateBooking,
                removeBooking : removeBooking,

                loadOffices : loadOffices,
                getAllOffices : getAllOffices()
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


            function loadUpcomingBookings(){
                console.log('Fetching upcoming bookings');
                var deferred = $q.defer();
                $http.get(urls.BOOKING_SERVICE_API+'/schedule')
                    .then(
                        function (response){
                            console.log('Fetched successfully all upcoming bookings');

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

            function getUpcomingBookings(){
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

            //------------Return the office to chose along with date, startTime and endTime Input ------------------//
            function loadOffices(){
                console.log('Fetching all offices');
                var deferred = $q.defer();
                $http.get(urls.OFFICE_SERVICE_API)
                    .then(
                        function (response){
                            console.log('Fetched successfully all offices');

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
        }
    ]);