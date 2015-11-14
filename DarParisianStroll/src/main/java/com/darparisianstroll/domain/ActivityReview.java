package com.darparisianstroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.darparisianstroll.domain.enums.Note;

/**
 * Modele objet representant la table activity_reviews
 * 
 */
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

    /**
     * retourne l'id d'une activite review
     * 
     * @return id d'une activite review
     */
    public int getId_review() {
	return id_review;
    }

    /**
     * modifie l'id d'une activite review
     * 
     * @param id_review
     *            id d'une activite review
     */
    public void setId_review(int id_review) {
	this.id_review = id_review;
    }

    /**
     * retourne id d'une activite
     * 
     * @return id d'une activite
     */
    public int getActivity() {
	return activity;
    }

    /**
     * modifie l'activite
     * 
     * @param activity
     *            id de l'activite
     */
    public void setActivity(int activity) {
	this.activity = activity;
    }

    /**
     * retourne id d'un user
     * 
     * @return id user
     */
    public int getUser() {
	return user;
    }

    /**
     * modifie id d'un user
     * 
     * @param user
     *            id user
     */
    public void setUser(int user) {
	this.user = user;
    }

    /**
     * retourne la description d'une activite review
     * 
     * @return description d'une activite review
     */
    public String getDescription() {
	return description;
    }

    /**
     * modifie la description d'une activite review
     * 
     * @param description
     *            description d'une activite review
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * retourne la note d'une activite review
     * 
     * @return note d'une activite review
     */
    public Note getNote() {
	return note;
    }

    /**
     * modifie la note d'une activite review
     * 
     * @param note
     *            note d'une activite review
     */
    public void setNote(Note note) {
	this.note = note;
    }

    /**
     * modifie la note d'une activite review
     * 
     * @param note
     *            note d'une activite review
     */
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
