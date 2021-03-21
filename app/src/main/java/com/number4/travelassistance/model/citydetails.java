package com.number4.travelassistance.model;

import java.io.Serializable;

public class citydetails implements Serializable {
    public int Id;
    public String Namelocation;
    public String Imagelocation;
    public String Detail;
    public String Marker;
    public int Idcity;

    public citydetails(int id, String namelocation, String imagelocation, String detail, String marker, int idcity) {
        Id = id;
        Namelocation = namelocation;
        Imagelocation = imagelocation;
        Detail = detail;
        Marker = marker;
        Idcity = idcity;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNamelocation() {
        return Namelocation;
    }

    public void setNamelocation(String namelocation) {
        Namelocation = namelocation;
    }

    public String getImagelocation() {
        return Imagelocation;
    }

    public void setImagelocation(String imagelocation) {
        Imagelocation = imagelocation;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getMarker() {
        return Marker;
    }

    public void setMarker(String marker) {
        Marker = marker;
    }

    public int getIdcity() {
        return Idcity;
    }

    public void setIdcity(int idcity) {
        Idcity = idcity;
    }
}
