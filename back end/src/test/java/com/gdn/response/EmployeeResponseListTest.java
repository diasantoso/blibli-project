package com.gdn.response;

import com.gdn.response.employee.EmployeeResponse;
import com.gdn.response.employee.EmployeeResponseList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dias on 8/9/2017.
 */
public class EmployeeResponseListTest {

    EmployeeResponseList list = new EmployeeResponseList();

    @Test
    public void getValueTest() {
        List<EmployeeResponse> result = list.getValue();
        Assert.assertEquals(result, list.getValue());
    }

    @Test
    public void setValueTest() {
        List<EmployeeResponse> data = null;
        list.setValue(data);
        Assert.assertEquals(data, list.getValue());
    }
}
