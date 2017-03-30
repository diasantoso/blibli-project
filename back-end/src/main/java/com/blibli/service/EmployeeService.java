package com.blibli.service;

import com.blibli.model.Employee;
import com.blibli.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dias on 3/30/2017.
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee doLogin(String email, String password) {
        Employee result = employeeRepository.findLogin(email, password);
        return result;
    }

    public Employee loadEmployee() {
        Employee employee = new Employee();
        employee.setName("Dias");
        employee.setEmail("dias@gmail.com");
        employee.setPassword("dias");
        employee.setRole("Engineer");

        Employee result = employeeRepository.save(employee);
        return result;
    }
}
