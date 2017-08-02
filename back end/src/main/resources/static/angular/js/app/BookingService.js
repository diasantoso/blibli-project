'use strict';

angular.module('bookingApp').factory('BookingService' ,
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
                getAllOffices : getAllOffices,

                getAvailableRooms : getAvailableRooms,
                getAllAvailableRooms : getAllAvailableRooms,
                getSearchVar : getSearchVar,

                getBookingPerUser : getBookingPerUser,
                getAllBookingPerUser : getAllBookingPerUser,
                getLoggedUser : getLoggedUser,

                getBookingByTicket : getBookingByTicket
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

            function getAvailableRooms(searchVar){
                var date = searchVar.date;
                var startTime = searchVar.startTime;
                var endTime = searchVar.endTime;
                var officeId = searchVar.officeId;

                $localStorage.searchVar = searchVar;

                console.log('Fetching All available rooms in office with id : '+officeId+
                    ' on date : ' + date +
                    ' with start Time : '+startTime+
                    ' And end Time : '+endTime);
                //var deferred =  $q.defer();
                //available?date=8/20/2017&startTime=20:00:00&endTime=22:00:00&officeId=ff8080815c04eb2f015c04ecaa920004
                $http.get(urls.ROOM_SERVICE_API+"available?date="+date+
                                                    '&startTime='+startTime+
                                                    '&endTime='+endTime+
                                                    '&officeId='+officeId)
                    .then(
                        function (response){
                            console.log('Fetched successfully All available rooms in office with id : '+officeId+
                                ' on date : ' + date +
                                ' with start Time : '+startTime+
                                ' And end Time : '+endTime);
                            $localStorage.rooms = response.data.value;
                           ////deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading All available rooms in office with id : '+officeId+
                                ' on date : ' + date +
                                ' with start Time : '+startTime+
                                ' And end Time : '+endTime);
                            ////deferred.reject(errResponse);
                        }
                    );
                return $localStorage.rooms;
                ////return deferred.promise();
            }

            function getAllAvailableRooms(){
                return $localStorage.rooms;
            }

            function getSearchVar(){
                return $localStorage.searchVar;
            }

            function getLoggedUser(){
                return $localStorage.user;
            }
            
            function getBookingPerUser(empid) {
                console.log('Fetching bookings owned by employee id : ' +empid);
                //var deferred =  $q.defer();

                $http.get(urls.BOOKING_SERVICE_API +'/employee/' + empid)
                    .then(
                        function (response){
                            console.log('Fetched successfully bookings owned by employee id : ' + empid);
                            $localStorage.userBookings = response.data.value;
                            //$localStorage.user = response.data.value.employee;
                            //deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading bookings owned by employee id : ' + empid);
                            //deferred.reject(errResponse);
                        }
                    );
                return $localStorage.userBookings;
                //return deferred.promise;
            }

            function getAllBookingPerUser(){
                return $localStorage.userBookings;
            }

            function getBookingByTicket(ticket) {
                console.log('Fetching bookings by ticket id : ' +ticket);

                $http.get(urls.BOOKING_SERVICE_API +'/ticket')
                    .then(
                        function (response){
                            console.log('Fetched successfully bookings by ticket id : ' + ticket);
                            $localStorage.bookingByTicket = response.data.value;
                        },
                        function (errResponse) {
                            console.error('Error while loading bookings by ticket id : ' + ticket);
                        }
                    );
                return $localStorage.bookingByTicket;
            }
        }
    ]);