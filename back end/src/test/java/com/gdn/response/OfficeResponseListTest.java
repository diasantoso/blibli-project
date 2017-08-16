package com.gdn.response;

import com.gdn.response.office.OfficeResponse;
import com.gdn.response.office.OfficeResponseList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dias on 8/9/2017.
 */
public class OfficeResponseListTest {

    OfficeResponseList list = new OfficeResponseList();

    @Test
    public void getValueTest() {
        List<OfficeResponse> result = list.getValue();
        Assert.assertEquals(result, list.getValue());
    }

    @Test
    public void setValueTest() {
        List<OfficeResponse> data = null;
        list.setValue(data);
        Assert.assertEquals(data, list.getValue());
    }
}
