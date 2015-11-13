package com.darparisianstroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.darparisianstroll.domain.enums.Note;

@Entity
@Table(name = "activity_reviews")
public class ActivityReview {

    @Id
    @GeneratedValue
    @Column(name = "rev_act_id")
    private int id_review;

    @Column(name = "activity", nullable = false)
    private int activity;

    @Column(name = "user", nullable = false)
    private int user;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "note", nullable = false)
    private Note note;

    public int getId_review() {
	return id_review;
    }

    public void setId_review(int id_review) {
	this.id_review = id_review;
    }

    public int getActivity() {
	return activity;
    }

    public void setActivity(int activity) {
	this.activity = activity;
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

    public void setNote(int note) {
	if (note == 0)
	    this.note = Note.zero;
	if (note == 1)
	    this.note = Note.un;
	if (note == 2)
	    this.note = Note.deux;
	if (note == 3)
	    this.note = Note.trois;
	if (note == 4)
	    this.note = Note.quatre;
	if (note == 5)
	    this.note = Note.cinq;

    }

}
