'use strict';

angular.module('bookingApp').controller('EmployeeController',
    ['$state', 'EmployeeService', 'LoginService', '$scope' , function( $state, EmployeeService, LoginService, $scope) {

        var self = this;
        self.employee = {};
        self.employees = [];

        self.submit = submit;
        self.getAllEmployees = getAllEmployees;
        self.createEmployee = createEmployee;
        self.updateEmployee = updateEmployee;
        self.removeEmployee = removeEmployee;
        self.editEmployee = editEmployee;
        self.reset = reset;
        self.logout = logout;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit(){
            console.log('Submitting');
            if(self.employee.id === undefined || self.employee.id === null) {
                console.log('Saving new employee');
                createEmployee(self.employee);
            } else {
                updateEmployee(self.employee, self.employee.id);
                console.log('Office employee with id ', self.employee.id);
            }
        }

        function createEmployee (employee){
            console.log('About to create employee');
            EmployeeService.createEmployee(employee)
                .then(
                    function (response){
                        console.log('Employee created successfully');
                        self.successMessage = 'Employee created successfully';
                        self.errorMessage = '';
                        self.done = true;
                        self.employee={};
                        $scope.myForm.$setPristine();
                    },

                    function (errResponse){
                        console.log('Error while creating employee');
                        self.errorMessage = 'Error while creating employee';
                        self.successMessage = '';
                    }
                );
        }

        function updateEmployee (employee , id){
            console.log('About to update employee');
            EmployeeService.updateEmployee(employee , id)
                .then(
                    function (response){
                        console.log('Employee updated successfully');
                        self.successMessage='Employee updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },

                    function (errResponse){
                        console.log('Error while updating employee');
                        self.errorMessage = 'Error while updating employee';
                        self.successMessage = '';
                    }
                );
        }

        function removeEmployee (id){
            console.log('About to remove employee with id '+id);
            EmployeeService.removeEmployee(id)
                .then(
                    function(){
                        console.log('Employee with '+id + ' removed successfully');
                        self.successMessage='Employee removed successfully';
                        self.errorMessage='';
                    },
                    function (errResponse){
                        console.error('Error while removing employee '+id +', Error :'+errResponse.data);
                    }
                );
        }

        function getAllEmployees(){
            return EmployeeService.getAllEmployees();
        }

        function editEmployee(id) {
            self.successMessage='';
            self.errorMessage='';
            EmployeeService.getEmployee(id).then(
                function (employee) {
                    self.employee = employee;
                },
                function (errResponse){
                    console.error('Error while editing employee '+id +', Error :'+errResponse.data);
                }
            );
        }

        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.employee={};
            $scope.myForm.$setPristine(); //reset Form
        }

        function logout (){
            LoginService.user = null;

            // setting session token & user become null (logout)
            $sessionStorage.token = null;
            $sessionStorage.user = null;

            console.log("Logout Successfully");
            $state.go('home');
        };
    }
    ]);