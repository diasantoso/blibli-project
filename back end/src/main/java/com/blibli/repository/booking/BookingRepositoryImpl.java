package com.blibli.repository.booking;

import com.blibli.model.Booking;
import com.blibli.model.Office;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigInteger;
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
                "SELECT * FROM booking WHERE id_booking='"+id+"'", Booking.class).getResultList();
        return result;
    }

    @Override
    public Booking deleteBooking(String id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Booking result = em.find(Booking.class, id);
        result.setStatus(0);
        em.getTransaction().commit();

        return result;
    }

    @Override
    public List<Booking> showByEmployeeId(String empId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Booking> result = em.createNativeQuery(
                "SELECT * FROM booking WHERE employee_id='"+empId+"' ORDER BY date_meeting DESC;", Booking.class).getResultList();
        return result;
    }

    @Override
    public BigInteger countBooking() {
        EntityManager em = entityManagerFactory.createEntityManager();
        BigInteger result = (BigInteger) em.createNativeQuery(
                "SELECT count (id_booking) FROM booking;").getSingleResult();
        return result;
    }

    @Override
    public Booking getBookingByTicket(String ticket) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Booking result = (Booking) em.createNativeQuery(
                "SELECT * FROM booking WHERE booking_ticket='"+ticket+"'", Booking.class).getSingleResult();
        return result;
    }
}
