package com.darparisianstroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modele objet representant la table activities
 * 
 */
@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @Column(name = "id_activity", nullable = false)
    private int id_activity;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "zipcode", nullable = false)
    private int zip_code;

    @Column(name = "lat", nullable = true)
    private Double lat;

    @Column(name = "lon", nullable = true)
    private Double lon;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "category", nullable = false)
    private int category;

    /**
     * retourne l'id d'une activite
     * 
     * @return id_activity
     */
    public int getId_activity() {
	return id_activity;
    }

    /**
     * modifie l'id d'une activite
     * 
     * @param id_activity
     *            id de l'activite
     */
    public void setId_activity(int id_activity) {
	this.id_activity = id_activity;
    }

    /**
     * retourne le nom d'une activite
     * 
     * @return name
     */
    public String getName() {
	return name;
    }

    /**
     * modifie le nom d'une activite
     * 
     * @param name
     *            nom d'une activite
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * retourne l'adresse d'une activite
     * 
     * @return address adresse d'une activite
     */
    public String getAddress() {
	return address;
    }

    /**
     * 
     * @param address
     */
    public void setAddress(String address) {
	this.address = address;
    }

    /**
     * retourne le code postal d'une activite
     * 
     * @return zip_code code postal d'une activite
     */
    public int getZip_code() {
	return zip_code;
    }

    /**
     * modifie modifie l'id d'une activite
     * 
     * @param zip_code
     *            code postal d'une activite
     */
    public void setZip_code(int zip_code) {
	this.zip_code = zip_code;
    }

    /**
     * retourne la latitude d'une activite
     * 
     * @return lat latitude d'une activite
     */
    public Double getLat() {
	return lat;
    }

    /**
     * modifie la latitude d'une activite
     * 
     * @param lat
     *            latitude d'une activite
     */
    public void setLat(double lat) {
	this.lat = lat;
    }

    /**
     * retourne la latitude d'une activite
     * 
     * @return longitude d'une activite
     */
    public Double getLon() {
	return lon;
    }

    /**
     * modifie la longitude d'une activite
     * 
     * @param lon
     *            longitude d'une activite
     */
    public void setLon(double lon) {
	this.lon = lon;
    }

    /**
     * retourne la description d'une activite
     * 
     * @return description d'une activite
     */
    public String getDescription() {
	return description;
    }

    /**
     * modifie la description d'une activite
     * 
     * @param description
     *            description d'une activite
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * retourne la categorie d'une activite
     * 
     * @return la categorie d'une activite
     */
    public int getCategory() {
	return category;
    }

    /**
     * modifie la categorie d'une activite
     * 
     * @param category
     *            categorie d'une activite
     */
    public void setCategory(int category) {
	this.category = category;
    }

}
