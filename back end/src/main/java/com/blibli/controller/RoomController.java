package com.blibli.controller;

import com.blibli.model.Booking;
import com.blibli.model.Office;
import com.blibli.model.Room;
import com.blibli.response.ResponseBack;
import com.blibli.response.office.OfficeResponse;
import com.blibli.response.room.RoomResponse;
import com.blibli.response.room.RoomResponseList;
import com.blibli.service.BookingService;
import com.blibli.service.OfficeService;
import com.blibli.service.RoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Adin on 4/24/2017.
 */
@Controller
@RequestMapping(value = "/api")
public class RoomController {
    @Autowired
    RoomService roomService;
    @Autowired
    OfficeService officeService;
    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RoomResponseList getAllActiveRooms() {
        List<Room> data = roomService.getAllActive();
        List<RoomResponse> response = new ArrayList<>();
        RoomResponseList result = new RoomResponseList();

        for(Room room : data) {
            RoomResponse parse = new RoomResponse();
            BeanUtils.copyProperties(room, parse);
            response.add(parse);
        }
        result.setValue(response);
        return result;
    }

    @PreAuthorize("hasAuthority('Admin')")
    @RequestMapping(value = "/rooms", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack createRoom(@RequestBody RoomResponse param) {
        Room room = new Room();
        BeanUtils.copyProperties(param, room);
        //Make office data not changed to null (because room only have idOffice, it will make other attribute null)
        room.setOffice(officeService.getOneActive(room.getOffice().getIdOffice()));
        Room result = roomService.save(room);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            //Response set to idRoom, so RoomImage can get id Room from here
            responseBack.setResponse(result.getIdRoom());
        else
            responseBack.setResponse("failed adding");

        return responseBack;
    }

    @PreAuthorize("hasAuthority('Admin')")
    @RequestMapping(value = "/rooms", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack updateRoom(@RequestBody RoomResponse param) {
        Room room = new Room();
        BeanUtils.copyProperties(param, room);
        Room result = roomService.save(room);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success updating");
        else
            responseBack.setResponse("failed updating");

        return responseBack;
    }

    @PreAuthorize("hasAuthority('Admin')")
    @RequestMapping(value = "/rooms", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack deleteRoom(@RequestParam String id) {
        Room result = roomService.delete(id);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success delete");
        else
            responseBack.setResponse("failed delete");

        return responseBack;
    }

    //Mapping to get one rooms based on their ID
    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RoomResponse getOneActiveRoom(@PathVariable ("id") String id) {
        Room data = roomService.getOneActive(id);
        RoomResponse result = new RoomResponse();

        if(data!=null)
            BeanUtils.copyProperties(data,result);

        return result;
    }

    @RequestMapping(value = "/rooms/available", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RoomResponseList getAvailableRoom(@RequestParam java.sql.Date date, @RequestParam Time startTime,
                                             @RequestParam Time endTime, @RequestParam String officeId) {

        List<Room> data = roomService.getAllActive();
        List<Room> data_used = new ArrayList<>();
        List<RoomResponse> responses = new ArrayList<>();
        RoomResponseList result = new RoomResponseList();

        //Get Unavailable Room
        List<Booking> data_book = bookingService.getAllBooking();

        for (Booking book : data_book) {
            //(book.startTime >= startTime && book.startTime <endTime)
            //(book.endTime <= endTime && book.endTime > startTime)
            //dia cuma ngecek di date yg equals doang ._.

            if (book.getDateMeeting().equals(date) &&
                    (((book.getStartTime().equals(startTime) || book.getStartTime().before(startTime)) && book.getEndTime().after(startTime)) ||
                    ((book.getEndTime().equals(endTime) || book.getEndTime().after(endTime) && book.getStartTime().before(endTime))))) {
                data_used.add(book.getRoom());
            }
        }

        //Get Available Room
        data.removeAll(data_used);

        for(Room room : data){
            RoomResponse parse = new RoomResponse();
            BeanUtils.copyProperties(room, parse);
            if(officeId.equals(room.getOffice().getIdOffice())) {
                responses.add(parse);
            }
        }

        result.setValue(responses);
        System.out.println("## Room Available : "+data.size());
        System.out.println("## Room Booked    : "+data_used.size());
        return result;

    }

}
