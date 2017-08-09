package com.blibli.response;

import com.blibli.response.office.OfficeResponse;
import com.blibli.response.office.OfficeResponseList;
import com.blibli.response.room.RoomResponse;
import com.blibli.response.room.RoomResponseList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dias on 8/9/2017.
 */
public class RoomResponseListTest {

    RoomResponseList list = new RoomResponseList();

    @Test
    public void getValueTest() {
        List<RoomResponse> result = list.getValue();
        Assert.assertEquals(result, list.getValue());
    }

    @Test
    public void setValueTest() {
        List<RoomResponse> data = null;
        list.setValue(data);
        Assert.assertEquals(data, list.getValue());
    }
}
