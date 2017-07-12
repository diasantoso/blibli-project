'use strict';

angular.module('bookingApp').controller('CountController',
    ['CountService', '$scope' , function( CountService , $scope) {

        var self = this;
        self.getCountOffice = getCountOffice;
        self.getCountRoom = getCountRoom;
        self.getCountEmployee = getCountEmployee;
        self.getCountBooking = getCountBooking;

        function getCountOffice(){
            return CountService.getCountOffice();
        }

        function getCountRoom(){
            return CountService.getCountRoom();
        }

        function getCountEmployee(){
            return CountService.getCountEmployee();
        }

        function getCountBooking(){
            return CountService.getCountBooking();
        }
    }
    ]);