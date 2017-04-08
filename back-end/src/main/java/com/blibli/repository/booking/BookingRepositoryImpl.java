package com.blibli.repository.booking;

import com.blibli.model.Booking;
import com.blibli.model.Office;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Dias on 4/8/2017.
 */
public class BookingRepositoryImpl implements BookingRepositoryCustom {
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public List<Booking> showById(String id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Booking> result = em.createNativeQuery(
                "SELECT * FROM BOOKING WHERE IDBOOKING='"+id+"'", Office.class).getResultList();
        return result;
    }
}
