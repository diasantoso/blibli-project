package com.blibli.response;

import com.blibli.model.RoomImage;
import com.blibli.response.office.OfficeResponse;
import com.blibli.response.office.OfficeResponseList;
import com.blibli.response.roomImage.RoomImageResponse;
import com.blibli.response.roomImage.RoomImageResponseList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dias on 8/9/2017.
 */
public class RoomImageResponseListTest {

    RoomImageResponseList list = new RoomImageResponseList();

    @Test
    public void getValueTest() {
        List<RoomImageResponse> result = list.getValue();
        Assert.assertEquals(result, list.getValue());
    }

    @Test
    public void setValueTest() {
        List<RoomImageResponse> data = null;
        list.setValue(data);
        Assert.assertEquals(data, list.getValue());
    }
}
