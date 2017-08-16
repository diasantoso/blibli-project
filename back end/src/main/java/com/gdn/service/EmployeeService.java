package com.gdn.service;

import com.gdn.model.Employee;
import com.gdn.repository.employee.EmployeeRepository;
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

    public List<Employee> getAllActive() {
        return employeeRepository.showActiveEmployee();
    }

    public List<Employee> getAll() { return employeeRepository.findAll(); }

    public Employee getOneActive(String id){
        return employeeRepository.showOneEmployee(id);
    }

    public Employee save(Employee employee) {
        Employee result = employeeRepository.save(employee);
        return result;
    }

    public Employee delete(String id) {
        Employee result = employeeRepository.deleteEmployee(id);
        return result;
    }

    public Employee findOneByEmail (String email){return employeeRepository.findOneByEmail(email);}

    public List<Employee> getAllAdmin() {
        return employeeRepository.getAllAdmin();
    }
}
