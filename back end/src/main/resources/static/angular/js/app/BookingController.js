'use strict';

angular.module('bookingApp').controller('BookingController',
    ['BookingService', '$scope' , function( BookingService , $scope) {

        var self = this;
        self.booking = {};
        self.bookings = [];
        //For loading Offices
        self.office = {};
        self.offices = [];

        self.submit = submit;
        self.getAllBookings = getAllBookings;
        self.getUpcomingBookings = getUpcomingBookings;
        self.createBooking = createBooking;
        self.updateBooking = updateBooking;
        self.removeBooking = removeBooking;
        self.editBooking = editBooking;
        self.reset = reset;

        self.getOffices=getOffices;

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

        function updateBooking (booking , id){
            console.log('About to update booking');
            BookingService.updateBooking(booking , id)
                .then(
                    function (response){
                        console.log('Booking updated successfully');
                        self.successMessage='Booking updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },

                    function (errResponse){
                        console.log('Error while updating booking');
                        self.errorMessage = 'Error while updating booking';
                        self.successMessage = '';
                    }
                );
        }

        function removeBooking (id){
            console.log('About to remove booking with id '+id);
            BookingService.removeBooking(id)
                .then(
                    function(){
                        console.log('Booking with '+id + ' removed successfully');
                        self.successMessage='Booking removed successfully';
                        self.errorMessage='';
                    },
                    function (errResponse){
                        console.error('Error while removing booking '+id +', Error :'+errResponse.data);
                    }
                );
        }

        function getAllBookings(){
            return BookingService.getAllBookings();
        }

        function getUpcomingBookings(){
            return BookingService.getUpcomingBookings();
        }

        function editBooking(id) {
            self.successMessage='';
            self.errorMessage='';
            BookingService.getBooking(id).then(
                function (booking) {
                    self.booking = booking;
                },
                function (errResponse){
                    console.error('Error while editing booking '+id +', Error :'+errResponse.data);
                }
            );
        }

        function getOffices(){
            return BookingService.getAllOffices();
        }

        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.booking={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
    ]);