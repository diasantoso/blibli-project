package com.gdn.response.room;

import com.gdn.model.Office;

/**
 * Editted by Audin on 5/8/2017.
 */
public class RoomResponse {
    private String idRoom;
    private String name;
    private Integer capacity;
    private String isConference;
    private String isProjector;
    private String numberExtension;
    private Integer status;

    private Office office;

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String id) {
        this.idRoom = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getIsConference() {
        return isConference;
    }

    public void setIsConference(String isConference) {
        this.isConference = isConference;
    }

    public String getIsProjector() {
        return isProjector;
    }

    public void setIsProjector(String isProjector) {
        this.isProjector = isProjector;
    }

    public String getNumberExtension() {
        return numberExtension;
    }

    public void setNumberExtension(String numberExtension) {
        this.numberExtension = numberExtension;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
