package com.kitestart.menuexample.Model;

import android.media.Image;

public class UsersModel {

    private String name;
    private String status;
    private Image image;
    private Double lat;
    private Double lon;

    public UsersModel(String name, String status, Double lat, Double lon) {
        this.name = name;
        this.status = status;
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
