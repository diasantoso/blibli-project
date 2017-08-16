package com.gdn.repository.booking;

import com.gdn.model.Booking;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Dias on 4/8/2017.
 */
public interface BookingRepositoryCustom {
    List<Booking> showAll();
    List<Booking> showById(String id);
    Booking deleteBooking(String id);
    List<Booking> showByEmployeeId(String empId);
    BigInteger countBooking();
    Booking getBookingByTicket(String ticket);
}
