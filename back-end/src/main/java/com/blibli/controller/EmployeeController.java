package com.blibli.controller;

import com.blibli.configuration.DatabaseSeeder;
import com.blibli.model.Employee;
import com.blibli.response.ResponseBack;
import com.blibli.response.employee.EmployeeResponse;
import com.blibli.response.employee.EmployeeResponseList;
import com.blibli.service.EmployeeService;
import org.hibernate.boot.model.relational.Database;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dias on 3/30/2017.
 */
@Controller
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //Load Employee Dummy Data
    @RequestMapping(value = "/loadEmployees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack loadEmployee() {
        Employee result = employeeService.loadEmployee();

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success adding");
        else
            responseBack.setResponse("failed adding");

        return responseBack;
    }

    //=========================================================================================================
    @Autowired
    DatabaseSeeder databaseSeeder;

    //Load DatabaseSeeder
    @RequestMapping(value = "/load", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack load() {
        databaseSeeder.mockupData();
        ResponseBack responseBack = new ResponseBack();
        responseBack.setResponse("success loading");
        return responseBack;
    }
    //=========================================================================================================

    //Login Employee
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EmployeeResponse doLogin(@RequestBody EmployeeResponse param) {
        Employee employee = employeeService.doLogin(param.getEmail(), param.getPassword());

        if(employee!=null){
            EmployeeResponse result = new EmployeeResponse();
            BeanUtils.copyProperties(employee, result);

            return result;
        } else {
            return null;
        }
    }

    //============================= CRUDS EMPLOYEE ================================

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EmployeeResponseList getAllActiveEmployees() {
        List<Employee> data = employeeService.getAllActive();
        List<EmployeeResponse> response = new ArrayList<>();
        EmployeeResponseList result = new EmployeeResponseList();

        for(Employee emp : data) {
            EmployeeResponse parse = new EmployeeResponse();
            BeanUtils.copyProperties(emp, parse);
            response.add(parse);
        }
        result.setValue(response);
        return result;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack createEmployee(@RequestBody EmployeeResponse param) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(param, emp);
        Employee result = employeeService.create(emp);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success adding");
        else
            responseBack.setResponse("failed adding");

        return responseBack;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack updateEmployee(@RequestBody EmployeeResponse param) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(param, emp);
        Employee result = employeeService.create(emp);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success updating");
        else
            responseBack.setResponse("failed updating");

        return responseBack;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack deleteEmployee(@RequestParam String id) {
        Employee result = employeeService.delete(id);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success delete");
        else
            responseBack.setResponse("failed delete");

        return responseBack;
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EmployeeResponse getOneActiveOffice(@PathVariable("id") String id){
        Employee data = employeeService.getOneActive(id);
        EmployeeResponse result = new EmployeeResponse();

        BeanUtils.copyProperties(data , result);

        return result;
    }
}
