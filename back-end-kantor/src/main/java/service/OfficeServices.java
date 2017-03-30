package service;

import model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import repository.OfficeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ADIN on 3/11/2017.
 */
public class OfficeServices {
    @Autowired
    OfficeRepository officeRepository;

    public List<Office> getAllOffice (){
        List<Office> list = officeRepository.findAll();
        return list;
    }

    public Office saveOrUpdateOffice(Office office){
        Office office1 = officeRepository.save(office);
        return office1;
    }

    public Office getOfficeId (Integer id){
        Office office = officeRepository.findOne(id);
        return office;
    }


}
