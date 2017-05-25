package com.blibli.service;

import com.blibli.model.Employee;
import com.blibli.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        employee.setStatus(1);

        Employee result = employeeRepository.save(employee);
        return result;
    }

    public List<Employee> getAllActive() {
        return employeeRepository.showActiveEmployee();
    }

    public Employee getOneActive(String id){
        return employeeRepository.showOneEmployee(id);
    }

    public Employee create(Employee room) {
        Employee result = employeeRepository.save(room);
        return result;
    }

    public Employee delete(String id) {
        Employee result = employeeRepository.deleteEmployee(id);
        return result;
    }
}
