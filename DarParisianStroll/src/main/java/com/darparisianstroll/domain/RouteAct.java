package com.darparisianstroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modele objet representant la table route_act
 * 
 */
@Entity
@Table(name = "route_act")
public class RouteAct {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "activity", nullable = false)
    private int activity;

    @Column(name = "route", nullable = false)
    private int route;

    @Column(name = "duree", nullable = false)
    private int duree;

    @Column(name = "prix", nullable = false)
    private double prix;

    /**
     * retourne l'id d'une route_act
     * 
     * @return id d'une route_act
     */
    public int getId() {
	return id;
    }

    /**
     * modifie l'id d'une route_act
     * 
     * @param id
     *            id d'une route_act
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * retourne l'id d'une activité d'une route_act
     * 
     * @return id d'une activité d'une route_act
     */
    public int getActivity() {
	return activity;
    }

    /**
     * modifie l'id d'une activité d'une route_act
     * 
     * @param activity
     *            id d'une activité d'une route_act
     */
    public void setActivity(int activity) {
	this.activity = activity;
    }

    /**
     * retourne l'id d'une route d'une route_act
     * 
     * @return id d'une route d'une route_act
     */
    public int getRoute() {
	return route;
    }

    /**
     * modifie l'id d'une route d'une route_act
     * 
     * @param route
     *            id d'une route d'une route_act
     */
    public void setRoute(int route) {
	this.route = route;
    }

    /**
     * retourne la duree d'une route_act
     * 
     * @return duree d'une route_act
     */
    public int getDuree() {
	return duree;
    }

    /**
     * modifie la duree d'une route_act
     * 
     * @param duree
     *            duree d'une route_act
     */
    public void setDuree(int duree) {
	this.duree = duree;
    }

    /**
     * retourne le prix d'une route_act
     * 
     * @return prix d'une route_act
     */
    public double getPrix() {
	return prix;
    }

    /**
     * modifie le prix d'une route_act
     * 
     * @param prix
     *            prix d'une route_act
     */
    public void setPrix(double prix) {
	this.prix = prix;
    }

}
