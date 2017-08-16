package com.gdn.repository.office;

import com.gdn.model.Office;

import java.util.List;

/**
 * Created by Dias on 3/30/2017.
 */
public interface OfficeRepositoryCustom {
    Office deleteOffice(String id);
    List<Office> showActiveOffice();
    Office showOneOffice(String id);
}
