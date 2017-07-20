package com.blibli.controller;

import com.blibli.model.Room;
import com.blibli.model.RoomImage;
import com.blibli.response.ResponseBack;
import com.blibli.response.roomImage.RoomImageResponse;
import com.blibli.response.roomImage.RoomImageResponseList;
import com.blibli.service.RoomImageService;
import com.blibli.service.RoomService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ADIN on 5/11/2017.
 */
@Controller
@RequestMapping(value="/api/rooms")
public class RoomImageController {
    @Autowired
    RoomImageService roomImageService;
    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/images", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RoomImageResponseList getAllImages(){

        List<RoomImage> data = roomImageService.getAllRoomImages();
        List<RoomImageResponse> response = new ArrayList<>();
        RoomImageResponseList result = new RoomImageResponseList();

        for (RoomImage roomImage : data){
            RoomImageResponse parse = new RoomImageResponse();
            BeanUtils.copyProperties(roomImage,parse);
            response.add(parse);
        }
        result.setValue(response);
        return result;
    }

    //Mapping to get images of one room
    @RequestMapping(value = "/images/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RoomImageResponseList getImagesforOneRoom(@PathVariable ("id") String room_id){
        List<RoomImage> data = roomImageService.getAllImagesForOneRoom(room_id);
        List<RoomImageResponse> responseList = new ArrayList<>();
        RoomImageResponseList result = new RoomImageResponseList();

        for(RoomImage roomImage : data){
            RoomImageResponse parse = new RoomImageResponse();
            BeanUtils.copyProperties(roomImage, parse);
            responseList.add(parse);
        }
        result.setValue(responseList);
        return result;
    }

    @PreAuthorize("hasAuthority('Admin')")
    @RequestMapping(value="/images", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack createRoomImages(@RequestBody RoomImageResponse param){


        //Image Room Save to Database
        RoomImage roomImage = new RoomImage();
        BeanUtils.copyProperties(param,roomImage);
        roomImage.setRoom(roomService.getOneActive(roomImage.getRoom().getIdRoom()));
        RoomImage data = roomImageService.create(roomImage);

        ResponseBack responseBack = new ResponseBack();
        if(data!=null)
            responseBack.setResponse("Image Added Successfully!");
        else
            responseBack.setResponse("Failed to add image!");

        return responseBack;
    }

    @PreAuthorize("hasAuthority('Admin')")
    @RequestMapping(value = "/images", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  ResponseBack deleteRoomImage(@RequestParam String id){
        RoomImage data = roomImageService.delete(id);

        ResponseBack responseBack = new ResponseBack();
        if(data!=null)
            responseBack.setResponse("Image Deleted Successfully!");
        else
            responseBack.setResponse("Failed to delete image!");

        return responseBack;
    }


}

