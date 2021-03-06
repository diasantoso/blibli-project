package com.gdn.response.employee;

import com.gdn.model.Booking;

import java.util.List;

/**
 * Created by Dias on 3/30/2017.
 */
public class EmployeeResponse {
    private String idEmployee;
    private String name;
    private String email;
    private String password;
    private String role;
    private Integer status;
    private List<Booking> bookings;

//    private Map<String, Object> tokenMap;

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

//    public Map<String, Object> getTokenMap() {
//        return tokenMap;
//    }
//
//    public void setTokenMap(Map<String, Object> tokenMap) {
//        this.tokenMap = tokenMap;
//    }
}
