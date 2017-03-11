package com.blibli.controller;

import com.blibli.model.Room;
import com.blibli.response.ResponseBack;
import com.blibli.response.RoomResponse;
import com.blibli.response.RoomResponseList;
import com.blibli.service.RoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dias on 3/11/2017.
 */
@Controller
public class RoomController {
    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RoomResponseList getAllRooms() {
        List<Room> data = roomService.getAll();
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
}
