package com.blibli.repository.roomImage;

import com.blibli.model.RoomImage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by ADIN on 5/10/2017.
 */

public class RoomImageRepositoryImpl implements RoomImageRepositoryCustom {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public List<RoomImage> showImagesForOneRoom(String RoomId) {

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<RoomImage> result = null;
        try {
            result = em.createNativeQuery("SELECT * FROM room_image WHERE room_id = '" + RoomId + "';",RoomImage.class).getResultList();
        }
        catch (Exception ex){}
            return result;
    }

    @Override
    public List<RoomImage> showAllRoomImages() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<RoomImage> result = em.createNativeQuery("SELECT * FROM room_image;",RoomImage.class ).getResultList();
        return result;
    }
}
