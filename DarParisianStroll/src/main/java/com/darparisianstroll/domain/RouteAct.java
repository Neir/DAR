package com.darparisianstroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActivity() {
		return activity;
	}

	public void setActivity(int activity) {
		this.activity = activity;
	}

	public int getRoute() {
		return route;
	}

	public void setRoute(int route) {
		this.route = route;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}


}
