package com.blibli.controller;

import com.blibli.model.Employee;
import com.blibli.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ADIN on 7/9/2017.
 */
@RestController
@RequestMapping(value = "/api")
public class AuthorizationController {
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Web service for getting all the appUsers in the application.
     *
     * @return list of all AppUser
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Employee> users() {
        return employeeRepository.findAll();
    }

    /**
     * Web service for getting a user by his ID
     *
     * @param id
     *            appUser ID
     * @return appUser
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> userById(@PathVariable String id) {
        Employee appUser = employeeRepository.findOne(id);
        if (appUser == null) {
            return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Employee>(appUser, HttpStatus.OK);
        }
    }

    /**
     * Method for deleting a user by his ID
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteUser(@PathVariable String id) {
        Employee appUser = employeeRepository.findOne(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        if (appUser == null) {
            return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
        } else if (appUser.getUsername().equalsIgnoreCase(loggedUsername)) {
            throw new RuntimeException("You cannot delete your account");
        } else {
            employeeRepository.delete(appUser);
            return new ResponseEntity<Employee>(appUser, HttpStatus.OK);
        }

    }

    /**
     * Method for adding a appUser
     *
     * @param appUser
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Employee> createUser(@RequestBody Employee appUser) {
        if (employeeRepository.findOneByEmail(appUser.getEmail()) != null) {
            throw new RuntimeException("Username already exist");
        }
        return new ResponseEntity<Employee>(employeeRepository.save(appUser), HttpStatus.CREATED);
    }

    /**
     * Method for editing an user details
     *
     * @param appUser
     * @return modified appUser
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public Employee updateUser(@RequestBody Employee appUser) {
        if (employeeRepository.findOneByEmail(appUser.getEmail()) != null
                && employeeRepository.findOneByEmail(appUser.getEmail()).getIdEmployee() != appUser.getIdEmployee()) {
            throw new RuntimeException("Username already exist");
        }
        return employeeRepository.save(appUser);
    }

}
