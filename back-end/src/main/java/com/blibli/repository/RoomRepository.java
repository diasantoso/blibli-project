package com.blibli.repository;

import com.blibli.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dias on 3/11/2017.
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, String>, RoomRepositoryCustom {
}
