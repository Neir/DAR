package com.darparisianstroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue
    @Column(name = "route_id")
    private int route_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "user", nullable = false)
    private int user;

    @Column(name = "description", nullable = false)
    private String description;

    public int getRoute_id() {
	return route_id;
    }

    public void setRoute_id(int route_id) {
	this.route_id = route_id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getUser() {
	return user;
    }

    public void setUser(int user) {
	this.user = user;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
