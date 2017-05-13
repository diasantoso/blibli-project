'use strict';

angular.module('bookingApp').factory('RoomService',
    ['$localStorage','$http','$q','urls',
        function ($localStorage,$http,$q,urls){

            var factory = {
                loadAllRooms : loadAllRooms,
                getAllRooms : getAllRooms,
                getRoom : getRoom,
                createRoom : createRoom,
                updateRoom : updateRoom,
                removeRoom : removeRoom
            };

            return factory;

            function loadAllRooms(){
                console.log('Fetching all rooms');
                var deferred = $q.defer();
                $http.get(urls.ROOM_SERVICE_API)
                    .then(
                        function (response){
                            console.log('Fetched successfully all rooms');

                            $localStorage.rooms = response.data.value;
                            deferred.resolve(response);
                        },
                        function (errResponse){
                            console.error('Error while Fetching rooms');
                            console.error(errResponse);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllRooms(){
                return $localStorage.rooms;
            }

            function getRoom(id){
                console.log('Fetching room with id : ' +id);
                var deferred =  $q.defer();
                $http.get(urls.ROOM_SERVICE_API + id)
                    .then(
                        function (response){
                            console.log('Fetched successfully room with id : ' + id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading room with id : ' +id);
                            deferred.reject(errResponse);
                        }
                    );
                 return deferred.promise;
            }

            function createRoom(room){
                console.log('Creating room');
                var deferred = $q.defer();
                $http.post(urls.ROOM_SERVICE_API, room)
                    .then(
                        function (response){
                            loadAllRooms();
                            deferred.resolve(response.data);
                        },

                        function (errResponse) {
                            console.error('Error while creating room: ' + errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );

                 return deferred.promise;
            }

            function updateRoom(room, id){
                console.log('Updating room with id ' + id);
                var deferred = $q.defer();
                $http.put(urls.ROOM_SERVICE_API + id, user)
                    .then(
                        function (response){
                            loadAllRooms();
                            deferred.resolve(response.data);
                        },
                        function (errResponse){
                            console.error('Error while updating room with id : ' + id);
                            deferred.reject(errResponse);
                        }
                    );
                 return deferred.promise;
            }

            function removeRoom(id){
                console.log('Removing room with id : ' +id);
                var deferred = $q.defer();
                $http.delete(urls.ROOM_SERVICE_API+"?id="+id)
                    .then(
                        function (response){
                            loadAllRooms();
                            deferred.resolve(response.data);
                        },

                        function (errResponse){
                            console.error('Error while removing room with id : '+ id);
                            deferred.reject(errResponse);
                        }
                    );
                 return deferred.promise;
            }

        }
     ]);