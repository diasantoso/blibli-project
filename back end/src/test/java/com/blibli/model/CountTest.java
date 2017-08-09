package com.blibli.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dias on 8/9/2017.
 */
public class CountTest {

    Count count = new Count();

    @Test
    public void getOfficeTest() {
        Long result = count.getOffice();
        Assert.assertEquals(result, count.getOffice());
    }

    @Test
    public void getRoomTest() {
        Long result = count.getRoom();
        Assert.assertEquals(result, count.getRoom());
    }

    @Test
    public void getBookingTest() {
        Long result = count.getBooking();
        Assert.assertEquals(result, count.getBooking());
    }

    @Test
    public void getEmpTest() {
        Long result = count.getEmployee();
        Assert.assertEquals(result, count.getEmployee());
    }

    @Test
    public void setOfficeTest() {
        Long data = 12345678910L;
        count.setOffice(data);
        Assert.assertEquals(data, count.getOffice());
    }

    @Test
    public void setRoomTest() {
        Long data = 12345678910L;
        count.setRoom(data);
        Assert.assertEquals(data, count.getRoom());
    }

    @Test
    public void setBookingTest() {
        Long data = 12345678910L;
        count.setBooking(data);
        Assert.assertEquals(data, count.getBooking());
    }

    @Test
    public void setEmpTest() {
        Long data = 12345678910L;
        count.setEmployee(data);
        Assert.assertEquals(data, count.getEmployee());
    }
}
