'use strict';

angular.module('bookingApp').controller('RoomController',
    ['RoomService', '$scope' , function( RoomService , $scope) {

        var self = this;
        self.room = {};
        self.rooms = [];

        self.submit = submit;
        self.getAllRooms = getAllRooms;
        self.createRoom = createRoom;
        self.updateRoom = updateRoom;
        self.removeRoom = removeRoom;
        self.editRoom = editRoom;
        self.reset = reset;
        self.getOffices = getOffices;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit(){
            console.log('Submitting');
            if(self.room.id === undefined || self.room.id === null) {
                console.log('Saving new room');
                createRoom(self.room);
            } else {
                updateRoom(self.room, self.room.id);
                console.log('rooms updated with id ', self.room.id);
            }
        }

        function createRoom (room){
            console.log('About to create rooms');
            RoomService.createRoom(room)
                .then(
                    function (response){
                      console.log('Room created successfully');
                      self.successMessage = 'Room created successfully';
                      self.errorMessage = '';
                      self.done = true;
                      reset();
                    },

                    function (errResponse){
                        console.log('Error while creating room');
                        self.errorMessage = 'Error while creating room';
                        self.successMessage = '';
                    }
                );
        }

        function updateRoom (room , id){
            console.log('About to update room');
            RoomService.updateRoom(room , id)
                .then(
                    function (response){
                        console.log('Room updated successfully');
                        self.successMessage='Room updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        reset();
                    },

                    function (errResponse){
                        console.log('Error while updating room');
                        self.errorMessage = 'Error while updating room';
                        self.successMessage = '';
                    }
                );
        }

        function removeRoom (id){
            console.log('About to remove Room with id '+id);
            RoomService.removeRoom(id)
                .then(
                    function(){
                        console.log('Room with '+id + ' removed successfully');
                        self.successMessage='Room removed successfully';
                        self.errorMessage='';
                    },
                    function (errResponse){
                        console.error('Error while removing room '+id +', Error :'+errResponse.data);
                    }
                );
        }

        function getAllRooms(){

            return RoomService.getAllRooms();
        }

        function editRoom(id) {
            self.successMessage='';
            self.errorMessage='';
            RoomService.getRoom(id).then(
                function (room) {
                    self.room = room;
                },
                function (errResponse){
                    console.error('Error while editing room'+id +', Error :'+errResponse.data);
                }
            );
        }

        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.room={};
            $scope.myForm.$setPristine(); //reset Form
            self.room={};
            self.room.idRoom='';
            self.room.status=1;
            self.room.isConference=1;
            self.room.isProjector=1;

        }

        function getOffices(){
            return RoomService.getAllOffices();
        }
    }
    ]);