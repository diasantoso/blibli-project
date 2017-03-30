package com.blibli.controller;

import com.blibli.model.Employee;
import com.blibli.response.ResponseBack;
import com.blibli.response.employee.EmployeeResponse;
import com.blibli.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dias on 3/30/2017.
 */
@Controller
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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
}
