package com.blibli.controller;

import com.blibli.model.Office;
import com.blibli.response.ResponseBack;
import com.blibli.response.office.OfficeResponse;
import com.blibli.response.office.OfficeResponseList;
import com.blibli.service.OfficeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dias on 3/30/2017.
 */
@Controller
@RequestMapping(value = "/api")
public class OfficeController {

    @Autowired
    OfficeService officeService;

    @RequestMapping(value = "/offices", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OfficeResponseList getAllActiveOffices() {
        List<Office> data = officeService.getAllActive();
        List<OfficeResponse> response = new ArrayList<>();
        OfficeResponseList result = new OfficeResponseList();

        for(Office room : data) {
            OfficeResponse parse = new OfficeResponse();
            BeanUtils.copyProperties(room, parse);
            response.add(parse);
        }
        result.setValue(response);
        return result;
    }

    @RequestMapping(value = "/offices", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack createOffice(@RequestBody OfficeResponse param) {
        Office office = new Office();
        BeanUtils.copyProperties(param, office);
        Office result = officeService.create(office);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success adding");
        else
            responseBack.setResponse("failed adding");

        return responseBack;
    }

    @RequestMapping(value = "/offices", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack updateOffice(@RequestBody OfficeResponse param) {
        Office office = new Office();
        BeanUtils.copyProperties(param, office);
        Office result = officeService.create(office);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success updating");
        else
            responseBack.setResponse("failed updating");

        return responseBack;
    }

    @RequestMapping(value = "/offices", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseBack deleteOffice(@RequestParam String id) {
        Office result = officeService.delete(id);

        ResponseBack responseBack = new ResponseBack();
        if(result!=null)
            responseBack.setResponse("success delete");
        else
            responseBack.setResponse("failed delete");

        return responseBack;
    }
}
