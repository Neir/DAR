package com.darparisianstroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.darparisianstroll.domain.enums.Note;

/**
 * Modele objet representant la table route_reviews
 * 
 */
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

    /**
     * retourne l'id d'une route_reviews
     * 
     * @return id d'une route_reviews
     */
    public int getId_review() {
	return id_review;
    }

    /**
     * modifie l'id d'une route_reviews
     * 
     * @param id_review
     *            id d'une route_reviews
     */
    public void setId_review(int id_review) {
	this.id_review = id_review;
    }

    /**
     * retourne id d'une route d'une route_reviews
     * 
     * @return id d'une route d'une route_reviews
     */
    public int getItineraire() {
	return itineraire;
    }

    /**
     * modifie l'id d'une route id d'une route_reviews
     * 
     * @param itineraire
     *            id d'une route d'une route_reviews
     */
    public void setItineraire(int itineraire) {
	this.itineraire = itineraire;
    }

    /**
     * retourne id du user ayant cree la route_reviews
     * 
     * @return id du user ayant cree la route_reviews
     */
    public int getUser() {
	return user;
    }

    /**
     * modifie l'id du user ayant cree la route_reviews
     * 
     * @param user
     *            id du user ayant cree la route_reviews
     */
    public void setUser(int user) {
	this.user = user;
    }

    /**
     * retourne le commentaire d'une route_reviews
     * 
     * @return commentaire d'une route_reviews
     */
    public String getDescription() {
	return description;
    }

    /**
     * modifie le commentaire d'une route_reviews
     * 
     * @param description
     *            commentaire d'une route_reviews
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * retourne la note d'une route_reviews
     * 
     * @return note d'une route_reviews
     */
    public Note getNote() {
	return note;
    }

    /**
     * modifie la note d'une route_reviews
     * 
     * @param note
     *            note d'une route_reviews
     */
    public void setNote(Note note) {
	this.note = note;
    }

}
