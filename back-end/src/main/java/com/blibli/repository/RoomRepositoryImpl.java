package com.blibli.repository;

import com.blibli.model.Room;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Dias on 3/11/2017.
 */
public class RoomRepositoryImpl implements RoomRepositoryCustom {
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public Room deleteRoom(String id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Room result = em.find(Room.class, id);
        result.setStatus(0);
        em.getTransaction().commit();

        return result;
    }

    @Override
    public List<Room> showActiveRoom() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Room> result = em.createNativeQuery(
                "SELECT * FROM ROOM WHERE STATUS=1", Room.class).getResultList();
        return result;
    }
}
