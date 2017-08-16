package com.gdn.repository.room;

import com.gdn.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dias on 3/11/2017.
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, String>, RoomRepositoryCustom {
}
