package com.blibli.service;

import com.blibli.model.Booking;
import com.blibli.repository.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dias on 4/8/2017.
 */
@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    public List<Booking> getById(String id) {
        return bookingRepository.showById(id);
    }

    public Booking create(Booking booking) {
        Booking result = bookingRepository.save(booking);
        return result;
    }

    public Booking delete(String id) {
        Booking result = bookingRepository.deleteBooking(id);
        return result;
    }
}
