package com.gdn.controller;

import com.gdn.model.Count;
import com.gdn.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Dias on 5/26/2017.
 */
@Controller
@RequestMapping(value = "/api")
public class CountController {

    @Autowired
    CountService countService;

    @RequestMapping(value = "/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Count count() {
        Count result = new Count();

        result.setOffice(countService.countOffice());
        result.setRoom(countService.countRoom());
        result.setEmployee(countService.countEmployee());
        result.setBooking(countService.countBooking());

        return result;
    }
}
