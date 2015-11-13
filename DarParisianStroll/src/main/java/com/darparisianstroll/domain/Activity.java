package com.darparisianstroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @Column(name = "id_activity", nullable = false)
    private int id_activity;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "zipcode", nullable = false)
    private int zip_code;

    @Column(name = "lat", nullable = true)
    private Double lat;

    @Column(name = "lon", nullable = true)
    private Double lon;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "category", nullable = false)
    private int category;

    public int getId_activity() {
	return id_activity;
    }

    public void setId_activity(int id_activity) {
	this.id_activity = id_activity;
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

    public int getZip_code() {
	return zip_code;
    }

    public void setZip_code(int zip_code) {
	this.zip_code = zip_code;
    }

    public Double getLat() {
	return lat;
    }

    public void setLat(double lat) {
	this.lat = lat;
    }

    public Double getLon() {
	return lon;
    }

    public void setLon(double lon) {
	this.lon = lon;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public int getCategory() {
	return category;
    }

    public void setCategory(int category) {
	this.category = category;
    }

}
