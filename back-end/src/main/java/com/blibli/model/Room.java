package com.blibli.model;

import com.blibli.service.OfficeService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

/**
 * Editted by Audin on 5/8/2017.
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
    private String isConference;
    private String isProjector;
    private String numberExtension;
    private Integer status;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="officeId", nullable = false)
    private Office office;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="roomId" , nullable = false, insertable = false, updatable = false)
    private List<Room> bookings = Collections.emptyList();

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

    public List<Room> getBookings() {
        return bookings;
    }

    public void setBookings(List<Room> bookings) {
        this.bookings = bookings;
    }
}
