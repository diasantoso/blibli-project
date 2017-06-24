package com.blibli.controller;

import com.blibli.model.Room;
import com.blibli.response.ResponseBack;
import com.blibli.response.office.OfficeResponse;
import com.blibli.response.room.RoomResponse;
import com.blibli.response.room.RoomResponseList;
import com.blibli.service.OfficeService;
import com.blibli.service.RoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @RequestMapping(value = "/rooms", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack createRoom(@RequestBody RoomResponse param) {
        Room room = new Room();
        BeanUtils.copyProperties(param, room);
        Room result = roomService.create(room);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success adding");
        else
            responseBack.setResponse("failed adding");

        return responseBack;
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack updateRoom(@RequestBody RoomResponse param) {
        Room room = new Room();
        BeanUtils.copyProperties(param, room);
        Room result = roomService.create(room);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success updating");
        else
            responseBack.setResponse("failed updating");

        return responseBack;
    }

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

        BeanUtils.copyProperties(data,result);

        return result;
    }
}
