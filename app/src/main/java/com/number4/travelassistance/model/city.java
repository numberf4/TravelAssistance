package com.number4.travelassistance.model;

public class city extends Throwable {
    public int Id;
    public String NameCity;
    public String ImageCity;
    public String Location;



    public city(int id, String nameCity, String imageCity, String location) {
        Id = id;
        NameCity = nameCity;
        ImageCity = imageCity;
        Location = location;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNameCity() {
        return NameCity;
    }

    public void setNameCity(String nameCity) {
        NameCity = nameCity;
    }

    public String getImageCity() {
        return ImageCity;
    }

    public void setImageCity(String imageCity) {
        ImageCity = imageCity;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
