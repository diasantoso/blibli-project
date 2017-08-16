package com.gdn.response;

import com.gdn.response.booking.BookingResponse;
import com.gdn.response.booking.BookingResponseList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dias on 8/9/2017.
 */
public class BookingResponseListTest {

    BookingResponseList list = new BookingResponseList();

    @Test
    public void getValueTest() {
        List<BookingResponse> result = list.getValue();
        Assert.assertEquals(result, list.getValue());
    }

    @Test
    public void setValueTest() {
        List<BookingResponse> data = null;
        list.setValue(data);
        Assert.assertEquals(data, list.getValue());
    }
}
