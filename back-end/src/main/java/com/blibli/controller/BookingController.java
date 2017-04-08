package com.blibli.controller;

import com.blibli.model.Booking;
import com.blibli.response.ResponseBack;
import com.blibli.response.booking.BookingResponse;
import com.blibli.response.booking.BookingResponseList;
import com.blibli.service.BookingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dias on 4/8/2017.
 */
@Controller
@RequestMapping(value = "/api")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "/bookings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BookingResponseList getAllBooking() {
        List<Booking> data = bookingService.getAllBooking();
        List<BookingResponse> response = new ArrayList<>();
        BookingResponseList result = new BookingResponseList();

        for(Booking room : data) {
            BookingResponse parse = new BookingResponse();
            BeanUtils.copyProperties(room, parse);
            response.add(parse);
        }
        result.setValue(response);
        return result;
    }

    @RequestMapping(value = "/bookings/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BookingResponseList getById(@PathVariable String id) {
        List<Booking> data = bookingService.getById(id);
        List<BookingResponse> response = new ArrayList<>();
        BookingResponseList result = new BookingResponseList();

        for(Booking room : data) {
            BookingResponse parse = new BookingResponse();
            BeanUtils.copyProperties(room, parse);
            response.add(parse);
        }
        result.setValue(response);
        return result;
    }

    @RequestMapping(value = "/bookings", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack createRoom(@RequestBody BookingResponse param) {
        Booking booking = new Booking();
        BeanUtils.copyProperties(param, booking);
        Booking result = bookingService.create(booking);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success adding");
        else
            responseBack.setResponse("failed adding");

        return responseBack;
    }
}
