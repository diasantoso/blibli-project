package com.blibli.service;

import com.blibli.model.Room;
import com.blibli.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dias on 3/11/2017.
 */
@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAllActive() {
        return roomRepository.showActiveRoom();
    }

    public Room create(Room room) {
        Room result = roomRepository.save(room);
        return result;
    }

    public Room delete(String id) {
        Room result = roomRepository.deleteRoom(id);
        return result;
    }
}
