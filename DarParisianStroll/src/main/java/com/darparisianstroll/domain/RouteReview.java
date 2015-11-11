package com.darparisianstroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.darparisianstroll.domain.enums.Note;

@Entity
@Table(name = "route_reviews")
public class RouteReview {

    @Id
    @GeneratedValue
    @Column(name = "id_review")
    private int id_review;

    @Column(name = "itineraire", nullable = false)
    private int itineraire;

    @Column(name = "user", nullable = false)
    private int user;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "note", nullable = false)
    @Enumerated(EnumType.STRING)
    private Note note;

    public int getId_review() {
	return id_review;
    }

    public void setId_review(int id_review) {
	this.id_review = id_review;
    }

    public int getItineraire() {
	return itineraire;
    }

    public void setItineraire(int itineraire) {
	this.itineraire = itineraire;
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

    public Note getNote() {
	return note;
    }

    public void setNote(Note note) {
	this.note = note;
    }

}
