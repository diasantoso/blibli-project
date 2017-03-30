package repository;

import model.Office;

import java.util.List;

/**
 * Created by ADIN on 3/11/2017.
 */
public interface OfficeRepositoryCustom {
    List<Office> getOffice(String input);
}
