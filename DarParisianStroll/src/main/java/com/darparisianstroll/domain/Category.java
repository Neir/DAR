package com.darparisianstroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modele objet representant la table categories
 * 
 */
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

    /**
     * retourne l'id d'une categorie
     * 
     * @return id d'une categorie
     */
    public int getId_category() {
	return id_category;
    }

    /**
     * modifie l'id d'une categorie
     * 
     * @param id_category
     *            id d'une categorie
     */
    public void setId_category(int id_category) {
	this.id_category = id_category;
    }

    /**
     * modifie le nom d'une categorie
     * 
     * @return nom d'une categorie
     */
    public String getName() {
	return name;
    }

    /**
     * modifie le nom d'une categorie
     * 
     * @param name
     *            nom d'une categorie
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * retourne la visibilite d'une categorie
     * 
     * @return visibilite d'une categorie
     */
    public int getVisibility() {
	return visibility;
    }

    /**
     * modifie la visibilite d'une categorie
     * 
     * @param visibility
     *            visibilite d'une categorie
     */
    public void setVisibility(int visibility) {
	this.visibility = visibility;
    }

}
