package com.blibli.response;

import com.blibli.model.Office;
import com.blibli.model.Room;
import com.blibli.response.room.RoomResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dias on 8/9/2017.
 */
public class RoomResponseTest {

    RoomResponse room = new RoomResponse();

    @Test
    public void getIdRoomTest() {
        String result = room.getIdRoom();
        Assert.assertEquals(result, room.getIdRoom());
    }

    @Test
    public void getNameTest() {
        String result = room.getName();
        Assert.assertEquals(result, room.getName());
    }

    @Test
    public void getCapacityTest() {
        Integer result = room.getCapacity();
        Assert.assertEquals(result, room.getCapacity());
    }

    @Test
    public void getIsConferenceTest() {
        String result = room.getIsConference();
        Assert.assertEquals(result, room.getIsConference());
    }

    @Test
    public void getIsProjectorTest() {
        String result = room.getIsProjector();
        Assert.assertEquals(result, room.getIsProjector());
    }

    @Test
    public void getNumberExtensionTest() {
        String result = room.getNumberExtension();
        Assert.assertEquals(result, room.getNumberExtension());
    }

    @Test
    public void getStatusTest() {
        Integer result = room.getStatus();
        Assert.assertEquals(result, room.getStatus());
    }

    @Test
    public void getBookingTest() {
        Office result = room.getOffice();
        Assert.assertEquals(result, room.getOffice());
    }

    @Test
    public void setBookingTest() {
        Office data = null;
        room.setOffice(data);
        Assert.assertEquals(data, room.getOffice());
    }

    @Test
    public void setIdRoomTest() {
        room.setIdRoom("22222");
        Assert.assertEquals("22222", room.getIdRoom());
    }

    @Test
    public void setNameTest() {
        room.setName("22222");
        Assert.assertEquals("22222", room.getName());
    }

    @Test
    public void setCapacityTest() {
        room.setCapacity(5);
        Assert.assertEquals((Integer) 5, room.getCapacity());
    }

    @Test
    public void setIsConferenceTest() {
        room.setIsConference("22222");
        Assert.assertEquals("22222", room.getIsConference());
    }

    @Test
    public void setIsProjectorTest() {
        room.setIsProjector("22222");
        Assert.assertEquals("22222", room.getIsProjector());
    }

    @Test
    public void setNumberExtensionTest() {
        room.setNumberExtension("22222");
        Assert.assertEquals("22222", room.getNumberExtension());
    }

    @Test
    public void setStatusTest() {
        room.setStatus(0);
        Assert.assertEquals((Integer) 0, room.getStatus());
    }
}
