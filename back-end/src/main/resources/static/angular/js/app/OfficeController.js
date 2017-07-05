'use strict';

angular.module('bookingApp').controller('OfficeController',
    ['OfficeService', '$scope' , function( OfficeService , $scope) {

        var self = this;
        self.office = {};
        self.offices = [];

        self.submit = submit;
        self.getAllOffices = getAllOffices;
        self.createOffice = createOffice;
        self.updateOffice = updateOffice;
        self.removeOffice = removeOffice;
        self.editOffice = editOffice;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit(){
            console.log('Submitting');
            if(self.office.id === undefined || self.office.id === null) {
                console.log('Saving new office');
                createOffice(self.office);
            } else {
                updateOffice(self.office, self.office.id);
                console.log('Office updated with id ', self.office.id);
            }
        }

        function createOffice (office){
            console.log('About to create offices');
            OfficeService.createOffice(office)
                .then(
                    function (response){
                      console.log('Office created successfully');
                      self.successMessage = 'Office created successfully';
                      self.errorMessage = '';
                      self.done = true;
                      self.office={};
                      $scope.myForm.$setPristine();
                    },

                    function (errResponse){
                        console.log('Error while creating office');
                        self.errorMessage = 'Error while creating office';
                        self.successMessage = '';
                    }
                );
        }

        function updateOffice (office , id){
            console.log('About to update offices');
            OfficeService.updateOffice(office , id)
                .then(
                    function (response){
                        console.log('Office updated successfully');
                        self.successMessage='Office updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },

                    function (errResponse){
                        console.log('Error while updating office');
                        self.errorMessage = 'Error while updating office';
                        self.successMessage = '';
                    }
                );
        }

        function removeOffice (id){
            console.log('About to remove Office with id '+id);
            OfficeService.removeOffice(id)
                .then(
                    function(){
                        console.log('Office with '+id + ' removed successfully');
                        self.successMessage='Office removed successfully';
                        self.errorMessage='';
                    },
                    function (errResponse){
                        console.error('Error while removing offices '+id +', Error :'+errResponse.data);
                    }
                );
        }

        function getAllOffices(){
            return OfficeService.getAllOffices();
        }

        function editOffice(id) {
            self.successMessage='';
            self.errorMessage='';
            OfficeService.getOffice(id).then(
                function (office) {
                    self.office = office;
                },
                function (errResponse){
                    console.error('Error while editing offices '+id +', Error :'+errResponse.data);
                }
            );
        }

        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.office={};
            self.office.status=1;
            $scope.myForm.$setPristine(); //reset Form
            
        }
    }
    ]);