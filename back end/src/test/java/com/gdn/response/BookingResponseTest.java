package com.gdn.response;

import com.gdn.model.Employee;
import com.gdn.model.Room;
import com.gdn.response.booking.BookingResponse;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Dias on 8/9/2017.
 */
public class BookingResponseTest {


    BookingResponse booking = new BookingResponse();

    @Test
    public void getIdBookingTest() {
        String result = booking.getIdBooking();
        Assert.assertEquals(result, booking.getIdBooking());
    }

    @Test
    public void getSubjectTest() {
        String result = booking.getSubject();
        Assert.assertEquals(result, booking.getSubject());
    }

    @Test
    public void getDescTest() {
        String result = booking.getDescription();
        Assert.assertEquals(result, booking.getDescription());
    }

    @Test
    public void getDateMeetingTest() {
        Date result = booking.getDateMeeting();
        Assert.assertEquals(result, booking.getDateMeeting());
    }

    @Test
    public void getStartTimeTest() {
        Time result = booking.getStartTime();
        Assert.assertEquals(result, booking.getStartTime());
    }

    @Test
    public void getEndTimeTest() {
        Time result = booking.getEndTime();
        Assert.assertEquals(result, booking.getEndTime());
    }

    @Test
    public void getAddedDateTest() {
        Date result = booking.getAddedDate();
        Assert.assertEquals(result, booking.getAddedDate());
    }

    @Test
    public void getStatusTest() {
        Integer result = booking.getStatus();
        Assert.assertEquals(result, booking.getStatus());
    }

    @Test
    public void getPicContactTest() {
        String result = booking.getPicContact();
        Assert.assertEquals(result, booking.getPicContact());
    }

    @Test
    public void getBookingTicketTest() {
        String result = booking.getBookingTicket();
        Assert.assertEquals(result, booking.getBookingTicket());
    }

    @Test
    public void getSpecialReqTest() {
        String result = booking.getSpecialRequest();
        Assert.assertEquals(result, booking.getSpecialRequest());
    }

    @Test
    public void getEmployeeTest() {
        Employee result = booking.getEmployee();
        Assert.assertEquals(result, booking.getEmployee());
    }

    @Test
    public void getRoomTest() {
        Room result = booking.getRoom();
        Assert.assertEquals(result, booking.getRoom());
    }

    @Test
    public void setIdBookingTest() {
        booking.setIdBooking("22222");
        Assert.assertEquals("22222", booking.getIdBooking());
    }

    @Test
    public void setSubjectTest() {
        booking.setSubject("22222");
        Assert.assertEquals("22222", booking.getSubject());
    }

    @Test
    public void setDescTest() {
        booking.setDescription("22222");
        Assert.assertEquals("22222", booking.getDescription());
    }

    @Test
    public void setDateMeetingTest() {
        Date date = null;
        booking.setDateMeeting(date);
        Assert.assertEquals(date, booking.getDateMeeting());
    }

    @Test
    public void setStartTimeTest() {
        Time time = null;
        booking.setStartTime(time);
        Assert.assertEquals(time, booking.getStartTime());
    }

    @Test
    public void setEndTimeTest() {
        Time time = null;
        booking.setEndTime(time);
        Assert.assertEquals(time, booking.getEndTime());
    }

    @Test
    public void setAddedDateTest() {
        Date date = null;
        booking.setAddedDate(date);
        Assert.assertEquals(date, booking.getAddedDate());
    }

    @Test
    public void setStatusTest() {
        booking.setStatus(0);
        Assert.assertEquals((Integer) 0, booking.getStatus());
    }

    @Test
    public void setPicContactTest() {
        booking.setPicContact("22222");
        Assert.assertEquals("22222", booking.getPicContact());
    }

    @Test
    public void setBookingTicketTest() {
        booking.setBookingTicket("22222");
        Assert.assertEquals("22222", booking.getBookingTicket());
    }

    @Test
    public void setSpecialReqTest() {
        booking.setSpecialRequest("22222");
        Assert.assertEquals("22222", booking.getSpecialRequest());
    }

    @Test
    public void setEmployeeTest() {
        Employee emp = null;
        booking.setEmployee(emp);
        Assert.assertEquals(emp, booking.getEmployee());
    }

    @Test
    public void setRoomTest() {
        Room room = null;
        booking.setRoom(room);
        Assert.assertEquals(room, booking.getRoom());
    }
}
