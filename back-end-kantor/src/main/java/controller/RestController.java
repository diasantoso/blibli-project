package controller;

import model.Office;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import response.OfficeResponse;
import response.OfficeResponses;
import service.OfficeServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADIN on 3/11/2017.
 */
@Controller
public class RestController {

    @Autowired
    private OfficeServices officeServices;

    @RequestMapping(value="/offices",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OfficeResponses getAllOffices(){

        OfficeResponses response = new OfficeResponses();

        List<Office> officeList = officeServices.getAllOffice();
        List<OfficeResponse> officeResponseList = new ArrayList<>();
        for(Office officedb:officeList){
            OfficeResponse dataRest = new OfficeResponse();
            BeanUtils.copyProperties(officedb,dataRest);
            officeResponseList.add(dataRest);
        }
        response.setData(officeResponseList);
        return response;
    }

    @RequestMapping(value="/offices",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OfficeResponse createOffice(@RequestBody OfficeResponse newOfficeData){

        Office office = new Office();
        //beanutils ini buat ngopi data dari
        // tipe json ke data bentuk database
        BeanUtils.copyProperties(newOfficeData, office);

        officeServices.saveOrUpdateOffice(office);

        return newOfficeData;
    }
}
