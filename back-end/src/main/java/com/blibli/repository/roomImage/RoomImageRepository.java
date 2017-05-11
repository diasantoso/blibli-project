package com.blibli.repository.roomImage;

import com.blibli.model.RoomImage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ADIN on 5/10/2017.
 */
public interface RoomImageRepository extends JpaRepository<RoomImage,String> , RoomImageRepositoryCustom {
}
