package com.blibli.controller;

import com.blibli.model.Booking;
import com.blibli.model.Employee;
import com.blibli.model.Room;
import com.blibli.response.ResponseBack;
import com.blibli.response.booking.BookingResponse;
import com.blibli.response.booking.BookingResponseList;
import com.blibli.response.employee.EmployeeResponse;
import com.blibli.response.room.RoomResponse;
import com.blibli.response.room.RoomResponseList;
import com.blibli.service.BookingService;
import com.blibli.service.EmployeeService;
import com.blibli.service.RoomService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import java.math.BigInteger;
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
    @Autowired
    EmployeeService employeeService;
    @Autowired
    RoomService roomService;

    @Autowired
    private JavaMailSender sender;

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

        //set the employee
        System.out.println("Print ID Employee : "+param.getEmployee().getIdEmployee());
        Employee employee = employeeService.getOneActive(booking.getEmployee().getIdEmployee());
        booking.setEmployee(employee);

        //set The room
        System.out.println("Print ID room : "+param.getRoom().getIdRoom());
        Room room = roomService.getOneActive(booking.getRoom().getIdRoom());
        booking.setRoom(room);


        //set status and statusbooking to 1
        booking.setStatus(1);
        booking.setStatusBooking("1");

        //set the booking ticket
        BigInteger addingNumber;
        addingNumber = new BigInteger("1");
        BigInteger number = bookingService.count().add(addingNumber);
        String ticket = "BOOK-"+ number;
        booking.setBookingTicket(ticket);

        Booking result = bookingService.save(booking);

        //notification email admin
        List<Employee> listAllAdmin = employeeService.getAllAdmin();

        for(Employee e:listAllAdmin) {
            try {
                MimeMessage message = sender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message);

                helper.setTo(e.getEmail());
                helper.setSubject("Booking Meeting Information");
                helper.setText("Attention,\n" +
                        "Has done the process of booking a meeting room, with information such as the following:\n"+
                        "Subject        : "+booking.getSubject()+"\n"+
                        "Description    : "+booking.getDescription()+"\n"+
                        "Date           : "+booking.getDateMeeting()+"\n"+
                        "Start Time     : "+booking.getStartTime()+"\n"+
                        "End Time       : "+booking.getEndTime()+"\n"+
                        "Room           : "+booking.getRoom().getName()+"\n"+
                        "PIC Contact    : "+booking.getPicContact()+"\n"+
                        "Special Req    : "+booking.getSpecialRequest()+"\n\n"+
                        "YOUR TICKET ID : "+booking.getBookingTicket()+"\n"+
                        "With your ticket id, you can check your detail of your booking in our system");
                sender.send(message);
            }catch(Exception ex) { }
        }

        //notification user yang melakukan booking
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setTo(employee.getEmail());
            helper.setSubject("Booking Meeting Information");
            helper.setText("Attention,\n" +
                    "Has done the process of booking a meeting room, with information such as the following:\n"+
                    "Subject        : "+booking.getSubject()+"\n"+
                    "Description    : "+booking.getDescription()+"\n"+
                    "Date           : "+booking.getDateMeeting()+"\n"+
                    "Start Time     : "+booking.getStartTime()+"\n"+
                    "End Time       : "+booking.getEndTime()+"\n"+
                    "Room           : "+booking.getRoom().getName()+"\n"+
                    "PIC Contact    : "+booking.getPicContact()+"\n"+
                    "Special Req    : "+booking.getSpecialRequest()+"\n"+
                    "Ticket ID      : "+booking.getBookingTicket());
            sender.send(message);
        }catch(Exception ex) { }

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success adding");
        else
            responseBack.setResponse("failed adding");

        return responseBack;
    }

    @RequestMapping(value = "/bookings/cancel/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack updateBooking(@RequestBody BookingResponse param) {
        Booking booking = new Booking();
        BeanUtils.copyProperties(param, booking);
        booking.setStatusBooking("0");
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

//    //Untuk menampilkan data booking sesuai tanggal dan waktu yang dimasukkan user
//    @RequestMapping(value = "bookings/used", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public BookingResponseList getBookingByDateTime(@RequestParam Date date, @RequestParam Time startTime,
//                                                    @RequestParam Time endTime){
//        List<Booking> data = bookingService.getAllBooking();
//        List<BookingResponse> responses = new ArrayList<>();
//        BookingResponseList result = new BookingResponseList();
//
//        for(Booking book : data){
//            //(book.startTime >= startTime && book.startTime <endTime)
//            //(book.endTime <= endTime && book.endTime > startTime)
//
//            if( (book.getDateMeeting().equals(date) &&
//                    (((book.getStartTime().equals(startTime) || book.getStartTime().before(startTime))&& book.getEndTime().after(startTime))||
//                            ((book.getEndTime().equals(endTime) || book.getEndTime().after(endTime) && book.getStartTime().before(endTime)))))
//                    && book.getStatusBooking().equalsIgnoreCase("1")){
//                BookingResponse parse = new BookingResponse();
//                BeanUtils.copyProperties(book,parse);
//                responses.add(parse);
//            }
//
//
//        }
//        result.setValue(responses);
//        return result;
//    }

    //Untuk menampilkan jadwal booking yang belum kadaluarsa
    @RequestMapping(value = "bookings/schedule", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
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

    //Untuk menampilkan booking per-User (lewat idEmployee)
    //@PreAuthorize("hasAuthority('Employee')")
    @RequestMapping(value = "bookings/employee/{employee_id}", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BookingResponseList showBookingForOneUser(@PathVariable String employee_id) {

        List<Booking> data = bookingService.getByEmpId(employee_id);
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

    //Untuk menampilkan booking berdasarkan ticketID yang diinput
    @RequestMapping(value = "bookings/ticket", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BookingResponseList showBookingByTicket(@RequestParam String ticket) {

        Booking book = bookingService.getBookingByTicket(ticket);
        List<Booking> data = new ArrayList<>();
        data.add(book);
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

    @RequestMapping(value = "/bookings/extend/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack extendBooking(@PathVariable String id, @RequestParam Time newEndTime) {
        Booking booking;
        booking = bookingService.find(id);
        Boolean check_room = false;
        Booking result = null;

        List<Room> data = roomService.getAllActive();
        List<Room> data_used = new ArrayList<>();
        List<RoomResponse> responses = new ArrayList<>();
        RoomResponseList listOfRooms = new RoomResponseList();

        //Check Room Available or not
        List<Booking> data_book = bookingService.getAllBooking();

        for (Booking used : data_book) {
            //(book.startTime >= startTime && book.startTime <endTime)
            //(book.endTime <= endTime && book.endTime > startTime)

            //pertama, jika tanggal dari booking dalam perulangan = booking extend
            //kedua, jika (jam mulai book perulangan SETELAH jam selesai book extend) DAN (jam mulai book perulangan SEBELUM jam selesai yang baru)
            //ketiga, jika (ruangan dari book perulangan SAMA dengan ruangan dari book extend) DAN (status dari book perulanagan adalah 1(Aktif))
            if(used.getDateMeeting().equals(booking.getDateMeeting())){
                if(used.getStartTime().after(booking.getEndTime()) && used.getStartTime().before(newEndTime)){
                    if ((used.getRoom().getIdRoom().equalsIgnoreCase(booking.getRoom().getIdRoom()) && used.getStatusBooking().equalsIgnoreCase("1"))){
                        check_room = true;
                    }
                }
            }

        }

        //Jika ruangan yang dia gunakan saat itu kosong,
        //Maka akan dibuat booking baru , dengan data yang sama dan beberapa data baru
        //Data yang baru adalah start Time (diambil dari endTime booking sebelumnya) dan
        //endTime (Merupakan input baru dari user)
        if(check_room==false) {
            Booking newbooking = new Booking();

            //set added data to current date
            LocalDate localDate = LocalDate.now();
            java.sql.Date date = java.sql.Date.valueOf(localDate);
            newbooking.setAddedDate(date);

            //set the booking ticket
            newbooking.setDateMeeting(booking.getDateMeeting());

            //set Description
            newbooking.setDescription(booking.getDescription()+" (extend)");

            //set endTime
            newbooking.setEndTime(newEndTime);

            //set PIC Contact
            newbooking.setPicContact(booking.getPicContact());

            //Set Special Request
            newbooking.setSpecialRequest(booking.getSpecialRequest());

            //set start Time
            newbooking.setStartTime(booking.getEndTime());

            //set subject
            newbooking.setSubject(booking.getSubject());

            //set the employee
            Employee employee = employeeService.getOneActive(booking.getEmployee().getIdEmployee());
            newbooking.setEmployee(booking.getEmployee());

            //set The room
            newbooking.setRoom(booking.getRoom());


            //set status and statusbooking to 1
            newbooking.setStatus(1);
            newbooking.setStatusBooking("1");

            //set the booking ticket
            BigInteger addingNumber;
            addingNumber = new BigInteger("1");
            BigInteger number = bookingService.count().add(addingNumber);
            String ticket = "BOOK-"+ number;
            newbooking.setBookingTicket(ticket);

            result = bookingService.save(newbooking);
        }
        //Jika ruangan yang dia gunakan saat itu telah digunakan (tidak bisa untuk extend),
        //Maka akan ditampilkan daftar ruangan yang kosong saat itu

        else if (check_room==true){

            result=null;
//            //get the office id for getAvailable / unavailable Room
//            String roomId = booking.getRoom().getIdRoom();
//            Room usedRoom = roomService.getOneActive(roomId);
//            String officeId = usedRoom.getOffice().getIdOffice();
//
//            //Get Unavailable Room
//            for (Booking book : data_book) {
//                //(book.startTime >= startTime && book.startTime <endTime)
//                //(book.endTime <= endTime && book.endTime > startTime)
//
//                if ((book.getDateMeeting().equals(booking.getDateMeeting()) &&
//                        (((book.getStartTime().equals(booking.getEndTime()) || book.getStartTime().before(booking.getEndTime())) && book.getEndTime().after(booking.getEndTime())) ||
//                                ((book.getEndTime().equals(newEndTime) || book.getEndTime().after(newEndTime) && book.getStartTime().before(newEndTime)))))
//                        && book.getStatusBooking().equalsIgnoreCase("1")) {
//                    data_used.add(book.getRoom());
//                }
//            }
//
//            //Get Available Room
//            data.removeAll(data_used);
//
//            for(Room room : data){
//                RoomResponse parse = new RoomResponse();
//                BeanUtils.copyProperties(room, parse);
//                if(officeId.equals(room.getOffice().getIdOffice())) {
//                    responses.add(parse);
//                }
//            }


        }

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success extending");
        else
            responseBack.setResponse("failed extending");

        return responseBack;
    }

}
