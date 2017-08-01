package com.blibli.repository.booking;

import com.blibli.model.Booking;

import java.util.List;

/**
 * Created by Dias on 4/8/2017.
 */
public interface BookingRepositoryCustom {
    List<Booking> showById(String id);
    Booking deleteBooking(String id);
    List<Booking> showByEmployeeId(String empId);
    Integer countBooking();
}
