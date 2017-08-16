package com.gdn.repository.roomImage;

import com.gdn.model.RoomImage;

import java.util.List;

/**
 * Created by ADIN on 5/10/2017.
 */
public interface RoomImageRepositoryCustom {

    List<RoomImage> showImagesForOneRoom(String RoomId);
    List<RoomImage> showAllRoomImages();
}
