package com.darparisianstroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modele objet representant la table routes
 * 
 */
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

    /**
     * retourne l'id d'une route
     * 
     * @return id d'une route
     */
    public int getRoute_id() {
	return route_id;
    }

    /**
     * modifie l'id d'une route
     * 
     * @param route_id
     *            id d'une route
     */
    public void setRoute_id(int route_id) {
	this.route_id = route_id;
    }

    /**
     * retourne le nom d'une route
     * 
     * @return nom d'une route
     */
    public String getName() {
	return name;
    }

    /**
     * modifie le nom d'une route
     * 
     * @param name
     *            nom d'une route
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * retourne l'id du user ayant cree l'itineraire
     * 
     * @return id du user
     */
    public int getUser() {
	return user;
    }

    /**
     * modifie l'id du user ayant cree l'itineraire
     * 
     * @param user
     *            id du user
     */
    public void setUser(int user) {
	this.user = user;
    }

    /**
     * retourne la description d'une route
     * 
     * @return description d'une route
     */
    public String getDescription() {
	return description;
    }

    /**
     * modifie la description d'une route
     * 
     * @param description
     *            description d'une route
     */
    public void setDescription(String description) {
	this.description = description;
    }

}
