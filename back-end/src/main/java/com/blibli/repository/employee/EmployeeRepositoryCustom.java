package com.blibli.repository.employee;

import com.blibli.model.Employee;

/**
 * Created by Dias on 3/30/2017.
 */
public interface EmployeeRepositoryCustom {
    Employee findLogin(String email, String password);
}
