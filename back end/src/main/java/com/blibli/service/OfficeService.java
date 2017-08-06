package com.blibli.service;

import com.blibli.model.Office;
import com.blibli.repository.office.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adin on 4/24/2017.
 */
@Service
public class OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    public List<Office> getAllActive() {
        return officeRepository.showActiveOffice();
    }

    public List<Office> getAll() { return officeRepository.findAll(); }

    public Office getOneActive(String id){
        return officeRepository.showOneOffice(id);
    }

    public Office save(Office office) {
        Office result = officeRepository.save(office);
        return result;
    }

    public Office delete(String id) {
        Office result = officeRepository.deleteOffice(id);
        return result;
    }
}
