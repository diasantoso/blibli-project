package com.blibli.repository.room;

import com.blibli.model.Room;

import java.util.List;

/**
 * Created by Adin on 4/24/2017.
 */
public interface RoomRepositoryCustom {
    Room deleteRoom(String id);
    List<Room> showActiveRoom();
    Room showOneRoom(String id);
}
