package com.blibli.repository.employee;

import com.blibli.model.Employee;

import java.util.List;

/**
 * Created by Dias on 3/30/2017.
 */
public interface EmployeeRepositoryCustom {
    Employee findLogin(String email, String password);
    Employee deleteEmployee(String id);
    List<Employee> showActiveEmployee();
    Employee showOneEmployee(String id);
    Employee findOneByEmail (String email);
    List<Employee> getAllAdmin();
}
