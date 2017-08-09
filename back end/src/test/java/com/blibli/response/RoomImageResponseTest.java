package com.blibli.response;

import com.blibli.model.Room;
import com.blibli.model.RoomImage;
import com.blibli.response.roomImage.RoomImageResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dias on 8/9/2017.
 */
public class RoomImageResponseTest {

    RoomImageResponse roomImage = new RoomImageResponse();

    @Test
    public void getIdRoomImageTest() {
        String result = roomImage.getIdRoomImage();
        Assert.assertEquals(result, roomImage.getIdRoomImage());
    }

    @Test
    public void getImageDescriptionTest() {
        String result = roomImage.getImageDescription();
        Assert.assertEquals(result, roomImage.getImageDescription());
    }

    @Test
    public void getImageAddressTest() {
        String result = roomImage.getImageAddress();
        Assert.assertEquals(result, roomImage.getImageAddress());
    }

    @Test
    public void getRoomTest() {
        Room result = roomImage.getRoom();
        Assert.assertEquals(result, roomImage.getRoom());
    }

    @Test
    public void setIdRoomImageTest() {
        roomImage.setIdRoomImage("22222");
        Assert.assertEquals("22222", roomImage.getIdRoomImage());
    }

    @Test
    public void setImageDescriptionTest() {
        roomImage.setImageDescription("22222");
        Assert.assertEquals("22222", roomImage.getImageDescription());
    }

    @Test
    public void setImageAddressTest() {
        roomImage.setImageAddress("22222");
        Assert.assertEquals("22222", roomImage.getImageAddress());
    }

    @Test
    public void setRoomTest() {
        Room room = null;
        roomImage.setRoom(room);
        Assert.assertEquals(room, roomImage.getRoom());
    }
}
