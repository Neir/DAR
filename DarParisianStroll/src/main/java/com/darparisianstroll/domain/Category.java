package com.darparisianstroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @Column(name = "id_category", nullable = false)
    private int id_category;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "visibility", nullable = false)
    private int visibility;

    public int getId_category() {
	return id_category;
    }

    public void setId_category(int id_category) {
	this.id_category = id_category;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getVisibility() {
	return visibility;
    }

    public void setVisibility(int visibility) {
	this.visibility = visibility;
    }

}
