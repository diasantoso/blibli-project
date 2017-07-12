package com.blibli.service;

import com.blibli.model.RoomImage;
import com.blibli.repository.roomImage.RoomImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ADIN on 5/11/2017.
 */
@Service
public class RoomImageService {

    @Autowired
    RoomImageRepository roomImageRepository;

    public List<RoomImage> getAllRoomImages(){
        return roomImageRepository.showAllRoomImages();
    }

    public List<RoomImage> getAllImagesForOneRoom(String roomId){
        return roomImageRepository.showImagesForOneRoom(roomId);
    }

    public RoomImage create(RoomImage roomImage){
        RoomImage data = roomImageRepository.save(roomImage);
        return data;
    }

    public RoomImage delete (String id){
        RoomImage data = roomImageRepository.findOne(id);
        roomImageRepository.delete(data);
        return data;
    }
}
