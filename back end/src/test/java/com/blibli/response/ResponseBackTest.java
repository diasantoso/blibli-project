package com.blibli.response;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dias on 8/9/2017.
 */
public class ResponseBackTest {

    ResponseBack responseBack = new ResponseBack();

    @Test
    public void getResponseTest() {
        String result = responseBack.getResponse();
        Assert.assertEquals(result, responseBack.getResponse());
    }

    @Test
    public void setResponseTest() {
        String data = "111111";
        responseBack.setResponse(data);
        Assert.assertEquals(data, responseBack.getResponse());
    }
}
