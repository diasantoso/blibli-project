package com.blibli.controller;

import com.blibli.model.Booking;
import com.blibli.response.ResponseBack;
import com.blibli.response.booking.BookingResponse;
import com.blibli.response.booking.BookingResponseList;
import com.blibli.service.BookingService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.*;


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
    public ResponseBack createBooking(@RequestBody BookingResponse param) {
        Booking booking = new Booking();
        BeanUtils.copyProperties(param, booking);

        //set added data to current date
        LocalDate localDate = LocalDate.now();
        java.sql.Date date = java.sql.Date.valueOf(localDate);
        booking.setAddedDate(date);

        //set status and statusbooking to 1
        booking.setStatus(1);
        booking.setStatusBooking("1");

        //set the booking ticket
        Timestamp timestampNow = new Timestamp(System.currentTimeMillis());
        Timestamp timestampMeet =  new Timestamp(booking.getDateMeeting().getTime());

        Booking result = bookingService.save(booking);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success adding");
        else
            responseBack.setResponse("failed adding");

        return responseBack;
    }

    @PreAuthorize("hasAuthority('Admin')")
    @RequestMapping(value = "/bookings", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack updateBooking(@RequestBody BookingResponse param) {
        Booking booking = new Booking();
        BeanUtils.copyProperties(param, booking);
        Booking result = bookingService.save(booking);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success updating");
        else
            responseBack.setResponse("failed updating");

        return responseBack;
    }

    @RequestMapping(value = "/bookings", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack deleteBooking(@RequestParam String id) {
        Booking result = bookingService.delete(id);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success delete");
        else
            responseBack.setResponse("failed delete");

        return responseBack;
    }

    //Untuk menampilkan data booking sesuai tanggal dan waktu yang dimasukkan user
    @RequestMapping(value = "bookings/used", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BookingResponseList getBookingByDateTime(@RequestParam Date date, @RequestParam Time startTime,
                                                    @RequestParam Time endTime){
        List<Booking> data = bookingService.getAllBooking();
        List<BookingResponse> responses = new ArrayList<>();
        BookingResponseList result = new BookingResponseList();

        for(Booking book : data){
            //(book.startTime >= startTime && book.startTime <endTime)
            //(book.endTime <= endTime && book.endTime > startTime)

            if(book.getDateMeeting().equals(date) &&
                    ((book.getStartTime().equals(startTime) || book.getStartTime().before(startTime))&& book.getEndTime().after(startTime))||
                    ((book.getEndTime().equals(endTime) || book.getEndTime().after(endTime) && book.getStartTime().before(endTime))) ){
                BookingResponse parse = new BookingResponse();
                BeanUtils.copyProperties(book,parse);
                responses.add(parse);
            }
        }
        result.setValue(responses);
        return result;
    }

    @RequestMapping(value = "bookings/schedule", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    //Untuk menampilkan jadwal booking yang belum kadaluarsa
    public BookingResponseList getBookingSchedule (){

        List<Booking> data = bookingService.getAllBooking();
        List<BookingResponse> responses = new ArrayList<>();
        BookingResponseList result = new BookingResponseList();

        //DateTimeFormatter dtf = new DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        for(Booking book : data){

            if((localDate.isBefore(book.getDateMeeting().toLocalDate())) || ( localDate.isEqual(book.getDateMeeting().toLocalDate()) &&
                            localTime.isBefore(book.getEndTime().toLocalTime()))) {

                BookingResponse parse = new BookingResponse();
                BeanUtils.copyProperties(book,parse);
                responses.add(parse);
            }
        }
        result.setValue(responses);
        return result;
    }
}
