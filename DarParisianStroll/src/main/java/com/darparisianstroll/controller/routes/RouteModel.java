package com.darparisianstroll.controller.routes;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteAct;
import com.darparisianstroll.domain.User;
import com.darparisianstroll.service.RouteActService;
import com.darparisianstroll.service.UserService;

public class RouteModel {
    private int id;
    private String nom;
    private User auteur;
    private String description;
    private ArrayList<Activity> activites;
    private double cout;
    private int duree;

    @Autowired
    UserService userService;
    @Autowired
    RouteActService routeActService;

    public RouteModel(Route route, User user) {
	this.id = route.getRoute_id();
	this.nom = route.getName();
	System.out.println("before");
	this.auteur = user;
	System.out.println("after");
	this.description = route.getDescription();
	this.activites = (ArrayList<Activity>) routeActService
		.findAllActivitiesByRoute(route);

	ArrayList<RouteAct> raList = (ArrayList<RouteAct>) routeActService
		.getByRoute(route);

	this.cout = compteCout(raList);
	this.duree = compteDuree(raList);
    }

    private double compteCout(ArrayList<RouteAct> raList) {
	double coutCpt = 0;
	for (RouteAct ra : raList) {
	    coutCpt += ra.getPrix();
	}
	return coutCpt;
    }

    private int compteDuree(ArrayList<RouteAct> raList) {
	int dureeCpt = 0;
	for (RouteAct ra : raList) {
	    dureeCpt += ra.getDuree();
	}
	return dureeCpt;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public User getAuteur() {
	return auteur;
    }

    public void setAuteur(User auteur) {
	this.auteur = auteur;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public ArrayList<Activity> getActivites() {
	return activites;
    }

    public void setActivites(ArrayList<Activity> activites) {
	this.activites = activites;
    }

    public double getCout() {
	return cout;
    }

    public void setCout(double cout) {
	this.cout = cout;
    }

    public int getDuree() {
	return duree;
    }

    public void setDuree(int duree) {
	this.duree = duree;
    }

}
