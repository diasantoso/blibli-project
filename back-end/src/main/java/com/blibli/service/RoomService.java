package com.blibli.service;

import com.blibli.model.Room;
import com.blibli.repository.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adin on 4/24/2017.
 */
@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAllActive() {
        return roomRepository.showActiveRoom();
    }

    public Room getOneActive (String id){ return roomRepository.showOneRoom(id);}

    public Room save(Room room) {
        Room result = roomRepository.save(room);
        return result;
    }

    public Room delete(String id) {
        Room result = roomRepository.deleteRoom(id);
        return result;
    }
}
