'use strict';

angular.module('bookingApp').controller('BookingController',
    ['BookingService', '$scope' , function( BookingService , $scope) {

        var self = this;
        self.booking = {};
        self.bookings = [];

        self.submit = submit;
        self.getAllBookings = getAllBookings;
        self.createBooking = createBooking;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit(){
            console.log('Submitting');
            if(self.booking.id === undefined || self.booking.id === null) {
                console.log('Saving new booking');
                createBooking(self.booking);
            }
        }

        function createBooking (booking){
            console.log('About to create booking');
            BookingService.createBooking(booking)
                .then(
                    function (response){
                        console.log('Booking created successfully');
                        self.successMessage = 'Booking created successfully';
                        self.errorMessage = '';
                        self.done = true;
                        self.booking={};
                        $scope.myForm.$setPristine();
                    },

                    function (errResponse){
                        console.log('Error while creating booking');
                        self.errorMessage = 'Error while creating booking';
                        self.successMessage = '';
                    }
                );
        }

        function getAllBookings(){
            return BookingService.getAllBookings();
        }

        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.booking={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
    ]);