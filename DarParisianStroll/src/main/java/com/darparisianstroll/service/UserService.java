package com.darparisianstroll.service;

import com.darparisianstroll.domain.User;

/**
 * Service de la table user
 *
 */
public interface UserService {

    /**
     * Appel a la methode findById du DAO
     * 
     * @param user_id
     *            id du user
     * @return user
     */
    User findById(int user_id);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param user
     *            user
     */
    void saveUser(User user);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param user
     *            user
     */
    void updateUser(User user);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param user_id
     *            id du user
     */
    void deleteUser(int user_id);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param mail
     *            mail du user
     * @return true si user dans bdd false sinon
     */
    boolean isRegistred(String mail);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param username
     *            username du user
     * @param password
     *            password du user
     * @return true si user dans bdd false sinon
     */
    boolean isRegistred(String username, String password);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param mail
     *            adresse mail du user
     * @return user
     */
    User findByEmail(String mail);

    /**
     * Appel a la methode findById du DAO
     * 
     * @param username
     *            username du user
     * @return user
     */
    User findByUsername(String username);

}
