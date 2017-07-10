package com.blibli.controller;

import com.blibli.model.Employee;
import com.blibli.model.Office;
import com.blibli.model.Room;
import com.blibli.repository.employee.EmployeeRepository;
import com.blibli.service.EmployeeService;
import com.blibli.service.OfficeService;
import com.blibli.service.RoomService;
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
    private EmployeeService employeeService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private OfficeService officeService;
/**
 * Role Admin and Employee:
 * - /Home
 * - /Login
 * - /Register
 * - /booking (Post,put,get)
 * - /Rooms (get)
 * - /office(get)
 *
 * Role Admin :
 * - /offices (post,delete)
 * - /rooms (post, delete)
 * - /employees
 * - /booking (edit,delete)
 */
/*-------------------------------   ADMIN ---------------------------------------------*/

    /*====================  AUTH FOR EMPLOYEES API ================================*/
    /**
     * Web service for GETTING ALL the appUsers in the application.
     *
     * @return list of all AppUsers
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> users() {
        return employeeService.getAllActive();
    }

    /**
     * Web service for GETTING A USER by his ID
     *
     * @param id
     *            appUser ID
     * @return appUser
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> userById(@PathVariable String id) {
        Employee appUser = employeeService.getOneActive(id);
        if (appUser == null) {
            return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Employee>(appUser, HttpStatus.OK);
        }
    }

    /**
     * Method for DELETING a user by his ID
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteUser(@PathVariable String id) {
        Employee appUser = employeeService.getOneActive(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        if (appUser == null) {
            return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
        } else if (appUser.getUsername().equalsIgnoreCase(loggedUsername)) {
            throw new RuntimeException("You cannot delete your account");
        } else {
            employeeService.delete(id);
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
    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<Employee> createUser(@RequestBody Employee appUser) {
        if (employeeService.findOneByEmail(appUser.getEmail()) != null) {
            throw new RuntimeException("Username already exist");
        }
        return new ResponseEntity<Employee>(employeeService.save(appUser), HttpStatus.CREATED);
    }

    /**
     * Method for editing an user details
     *
     * @param appUser
     * @return modified appUser
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/employees", method = RequestMethod.PUT)
    public Employee updateUser(@RequestBody Employee appUser) {
        if (employeeService.findOneByEmail(appUser.getEmail()) != null
                && employeeService.findOneByEmail(appUser.getEmail()).getIdEmployee() != appUser.getIdEmployee()) {
            throw new RuntimeException("Username already exist");
        }
        return employeeService.save(appUser);
    }
     /*==============================================================================*/

     /*====================  AUTH FOR ROOMS API ================================*/

    /**
     * Web service for GETTING ALL the Rooms in the application.
     *
     * @return list of all Rooms
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<Room> rooms() {
        return roomService.getAllActive();
    }

    /**
     * Web service for GETTING A ROOM by its ID
     *
     * @param id
     *            room ID
     * @return Room
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.GET)
    public ResponseEntity<Room> roomById(@PathVariable String id) {
        Room room = roomService.getOneActive(id);
        if (room == null) {
            return new ResponseEntity<Room>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Room>(room, HttpStatus.OK);
        }
    }

    /**
     * Method for DELETING a room by its ID
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Room> deleteRoom(@PathVariable String id) {
        Room room = roomService.getOneActive(id);
        if (room == null) {
            return new ResponseEntity<Room>(HttpStatus.NO_CONTENT);
        } else {
            roomService.delete(id);
            return new ResponseEntity<Room>(room, HttpStatus.OK);
        }

    }

    /**
     * Method for adding a room
     *
     * @param room
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/rooms", method = RequestMethod.POST)
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {

        return new ResponseEntity<Room>(roomService.save(room), HttpStatus.CREATED);
    }

    /**
     * Method for editing an room details
     *
     * @param room
     * @return modified appUser
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/rooms", method = RequestMethod.PUT)
    public Room updateRoom(@RequestBody Room room) {

        return roomService.save(room);
    }


     /*=========================================================================*/

     /*====================  AUTH FOR OFFICES API ================================*/

    /**
     * Web service for GETTING ALL the Offices in the application.
     *
     * @return list of all Rooms
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
    @RequestMapping(value = "/offices", method = RequestMethod.GET)
    public List<Office> offices() {
        return officeService.getAllActive();
    }

    /**
     * Web service for GETTING A ROOM by its ID
     *
     * @param id
     *            room ID
     * @return Room
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.GET)
    public ResponseEntity<Room> roomById(@PathVariable String id) {
        Room room = roomService.getOneActive(id);
        if (room == null) {
            return new ResponseEntity<Room>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Room>(room, HttpStatus.OK);
        }
    }

    /**
     * Method for DELETING a room by its ID
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Room> deleteRoom(@PathVariable String id) {
        Room room = roomService.getOneActive(id);
        if (room == null) {
            return new ResponseEntity<Room>(HttpStatus.NO_CONTENT);
        } else {
            roomService.delete(id);
            return new ResponseEntity<Room>(room, HttpStatus.OK);
        }

    }

    /**
     * Method for adding a room
     *
     * @param room
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/rooms", method = RequestMethod.POST)
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {

        return new ResponseEntity<Room>(roomService.save(room), HttpStatus.CREATED);
    }

    /**
     * Method for editing an room details
     *
     * @param room
     * @return modified appUser
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/rooms", method = RequestMethod.PUT)
    public Room updateRoom(@RequestBody Room room) {

        return roomService.save(room);
    }


}
