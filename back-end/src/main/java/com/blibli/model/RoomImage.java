package com.blibli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by ADIN on 5/9/2017.
 */
@Entity
@Table(name="RoomImage")
public class RoomImage {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")

    private String idRoomImage;
    private String imageDescription;
    private String imageAddress;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="roomId", nullable = false)
    private Room room;

    public String getIdRoomImage() {
        return idRoomImage;
    }

    public void setIdRoomImage(String idRoomImage) {
        this.idRoomImage = idRoomImage;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
