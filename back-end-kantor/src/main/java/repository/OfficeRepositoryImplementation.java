package repository;

import model.Office;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by ADIN on 3/11/2017.
 */
public class OfficeRepositoryImplementation implements OfficeRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Office> getOffice (String input) {
        List<Office> data = this.entityManager.createNativeQuery(
                "SELECT idOffice,name,address,city,telphone,status FROM OfficeTable where name='" + input + "'", Office.class).getResultList();
        return data;
    }

}
