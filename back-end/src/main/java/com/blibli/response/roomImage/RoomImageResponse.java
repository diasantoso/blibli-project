package com.blibli.response.roomImage;

import com.blibli.model.Room;

/**
 * Created by ADIN on 5/9/2017.
 */
public class RoomImageResponse {
    private String idRoomImage;
    private String imageDescription;
    private String imageAddress;
    private Room room;

    public String getIdRoomImage() {
        return idRoomImage;
    }

    public void setIdRoomImage(String idRoomImage) {
        this.idRoomImage = idRoomImage;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
