package com.blibli.response.office;

import com.blibli.model.Room;

import java.util.List;

/**
 * Created by Dias on 3/30/2017.
 */
public class OfficeResponse {
    private String idOffice;
    private String name;
    private String address;
    private String city;
    private String telephone;
    private Integer status;

    private List<Room> rooms;

    public String getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(String idOffice) {
        this.idOffice = idOffice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
