package com.darparisianstroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.darparisianstroll.domain.enums.State;

/**
 * Modele objet representant la table user
 * 
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "password", nullable = false)
    private String password;

    /**
     * retourne l'id d'un user
     * 
     * @return id d'un user
     */
    public int getUser_id() {
	return user_id;
    }

    /**
     * modifie l'id d'un user
     * 
     * @param user_id
     *            id d'un user
     */
    public void setUser_id(int user_id) {
	this.user_id = user_id;
    }

    /**
     * retourne l'etat d'un user
     * 
     * @return etat d'un user
     */
    public State getState() {
	return state;
    }

    /**
     * modifie l'etat d'un user
     * 
     * @param state
     *            etat d'un user
     */
    public void setState(State state) {
	this.state = state;
    }

    /**
     * retourne le username d'un user
     * 
     * @return username d'un user
     */
    public String getUsername() {
	return username;
    }

    /**
     * modifie le username d'un user
     * 
     * @param username
     *            username d'un user
     */
    public void setUsername(String username) {
	this.username = username;
    }

    /**
     * retourne l'adresse mail d'un user
     * 
     * @return adresse mail d'un user
     */
    public String getMail() {
	return mail;
    }

    /**
     * modifie l'adresse mail d'un user
     * 
     * @param mail
     *            adresse mail d'un user
     */
    public void setMail(String mail) {
	this.mail = mail;
    }

    /**
     * retourne le mot de passe d'un user
     * 
     * @return mot de passe d'un user
     */
    public String getPassword() {
	return password;
    }

    /**
     * modifie le mot de passe d'un user
     * 
     * @param password
     *            mot de passe d'un user
     */
    public void setPassword(String password) {
	this.password = password;
    }

}
