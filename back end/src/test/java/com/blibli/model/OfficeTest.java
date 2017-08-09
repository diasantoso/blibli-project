package com.blibli.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dias on 8/9/2017.
 */
public class OfficeTest {

    Office office = new Office("11111", "Test Office 1");

    @Test
    public void getIdOfficeTest() {
        String result = office.getIdOffice();
        Assert.assertEquals(result, office.getIdOffice());
    }

    @Test
    public void getNameTest() {
        String result = office.getName();
        Assert.assertEquals(result, office.getName());
    }

    @Test
    public void getAddressTest() {
        String result = office.getAddress();
        Assert.assertEquals(result, office.getAddress());
    }

    @Test
    public void getCityTest() {
        String result = office.getCity();
        Assert.assertEquals(result, office.getCity());
    }

    @Test
    public void getTelephoneTest() {
        String result = office.getTelephone();
        Assert.assertEquals(result, office.getTelephone());
    }

    @Test
    public void getStatusTest() {
        Integer result = office.getStatus();
        Assert.assertEquals(result, office.getStatus());
    }

    @Test
    public void getRoomTest() {
        List<Room> result = office.getRooms();
        Assert.assertEquals(result, office.getRooms());
    }

    @Test
    public void setBookingTest() {
        List<Room> list = null;
        office.setRooms(list);
        Assert.assertEquals(list, office.getRooms());
    }

    @Test
    public void setIdOfficeTest() {
        office.setIdOffice("22222");
        Assert.assertEquals("22222", office.getIdOffice());
    }

    @Test
    public void setNameTest() {
        office.setName("22222");
        Assert.assertEquals("22222", office.getName());
    }

    @Test
    public void setAddressTest() {
        office.setAddress("22222");
        Assert.assertEquals("22222", office.getAddress());
    }

    @Test
    public void setCityTest() {
        office.setCity("22222");
        Assert.assertEquals("22222", office.getCity());
    }

    @Test
    public void setTelephoneTest() {
        office.setTelephone("22222");
        Assert.assertEquals("22222", office.getTelephone());
    }

    @Test
    public void setStatusTest() {
        office.setStatus(0);
        Assert.assertEquals((Integer) 0, office.getStatus());
    }
}
