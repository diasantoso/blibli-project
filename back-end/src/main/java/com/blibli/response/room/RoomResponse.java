package com.blibli.response.room;

/**
 * Created by Dias on 3/11/2017.
 */
public class RoomResponse {
    private String idRoom;
    private String name;
    private Integer capacity;
    private Integer isConference;
    private Integer isProjector;
    private String numberExtension;
    private Integer status;

    public String getId() {
        return idRoom;
    }

    public void setId(String id) {
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

    public Integer getIsConference() {
        return isConference;
    }

    public void setIsConference(Integer isConference) {
        this.isConference = isConference;
    }

    public Integer getIsProjector() {
        return isProjector;
    }

    public void setIsProjector(Integer isProjector) {
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
}
