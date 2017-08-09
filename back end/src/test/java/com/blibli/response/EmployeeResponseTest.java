package com.blibli.response;

import com.blibli.model.Booking;
import com.blibli.model.Employee;
import com.blibli.response.employee.EmployeeResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dias on 8/9/2017.
 */
public class EmployeeResponseTest {

    EmployeeResponse emp = new EmployeeResponse();

    @Test
    public void getIdEmployeeTest() {
        String result = emp.getIdEmployee();
        Assert.assertEquals(result, emp.getIdEmployee());
    }

    @Test
    public void getNameTest() {
        String result = emp.getName();
        Assert.assertEquals(result, emp.getName());
    }

    @Test
    public void getEmailTest() {
        String result = emp.getEmail();
        Assert.assertEquals(result, emp.getEmail());
    }

    @Test
    public void getPasswordTest() {
        String result = emp.getPassword();
        Assert.assertEquals(result, emp.getPassword());
    }

    @Test
    public void getRoleTest() {
        String result = emp.getRole();
        Assert.assertEquals(result, emp.getRole());
    }

    @Test
    public void getStatusTest() {
        Integer result = emp.getStatus();
        Assert.assertEquals(result, emp.getStatus());
    }

    @Test
    public void getBookingTest() {
        List<Booking> result = emp.getBookings();
        Assert.assertEquals(result, emp.getBookings());
    }

    @Test
    public void setBookingTest() {
        List<Booking> list = null;
        emp.setBookings(list);
        Assert.assertEquals(list, emp.getBookings());
    }

    @Test
    public void setIdEmployeeTest() {
        emp.setIdEmployee("22222");
        Assert.assertEquals("22222", emp.getIdEmployee());
    }

    @Test
    public void setNameTest() {
        emp.setName("22222");
        Assert.assertEquals("22222", emp.getName());
    }

    @Test
    public void setEmailTest() {
        emp.setEmail("22222");
        Assert.assertEquals("22222", emp.getEmail());
    }

    @Test
    public void setPasswordTest() {
        emp.setPassword("22222");
        Assert.assertEquals("22222", emp.getPassword());
    }

    @Test
    public void setRoleTest() {
        emp.setRole("22222");
        Assert.assertEquals("22222", emp.getRole());
    }

    @Test
    public void setStatusTest() {
        emp.setStatus(0);
        Assert.assertEquals((Integer) 0, emp.getStatus());
    }
}
