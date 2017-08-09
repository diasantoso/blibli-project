package com.blibli.model;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Dias on 8/9/2017.
 */
public class EmployeeTest {

    Employee emp = new Employee("1111", "Test Office 1", "emp@mail.com", "emp", "Employee");

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

    @Test
    public void isEnabledTest() {
        Assert.assertEquals(true, emp.isEnabled());
    }

    @Test
    public void isCredentialNonExpired() {
        Assert.assertEquals(true, emp.isCredentialsNonExpired());
    }

    @Test
    public void isAccountNonLocked() {
        Assert.assertEquals(true, emp.isAccountNonLocked());
    }

    @Test
    public void isAccountNonExpired() {
        Assert.assertEquals(true, emp.isAccountNonExpired());
    }

    @Test
    public void getAuthoritiesTest() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(emp.getRole()));

        Assert.assertEquals(authorities, emp.getAuthorities());
    }

    @Test
    public void getUsernameTest() {
        String result = emp.getUsername();
        Assert.assertEquals(result, emp.getUsername());
    }
}
