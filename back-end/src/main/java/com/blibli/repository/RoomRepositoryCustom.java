package com.blibli.repository;

import com.blibli.model.Room;

import java.util.List;

/**
 * Created by Dias on 3/11/2017.
 */
public interface RoomRepositoryCustom {
    Room deleteRoom(String id);
    List<Room> showActiveRoom();
}
