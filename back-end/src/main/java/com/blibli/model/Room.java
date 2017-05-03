package com.blibli.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Dias on 3/11/2017.
 */
@Entity
@Table(name="Room")
public class Room {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String idRoom;
    private String name;
    private Integer capacity;
    private Integer isConference;
    private Integer isProjector;
    private String numberExtension;
    private Integer status;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Office office;

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
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

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
