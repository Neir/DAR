package com.darparisianstroll.dao;

import java.util.List;

import com.darparisianstroll.domain.User;

/**
 * DAO d'un user
 * 
 */
public interface UserDao {

    /**
     * retourune un user a par son id
     * 
     * @param user_id
     *            id du user
     * @return user
     */
    User findById(int user_id);

    /**
     * sauvegarde un user
     * 
     * @param user
     *            user
     */
    void saveUser(User user);

    /**
     * supprimer un user
     * 
     * @param user_id
     *            id du user
     */
    void deleteUser(int user_id);

    /**
     * retourne une liste user
     * 
     * @param mail
     *            mail des user
     * @return liste des user
     */
    List<User> getByMail(String mail);

    /**
     * verifie si un user existe dans la base
     * 
     * @param username
     *            username du user
     * @param password
     *            mot de passe du user
     * @return true si enregistree false sinon
     */
    boolean isRegistred(String username, String password);

    /**
     * retourne une liste de suer filtrees par le username
     * 
     * @param username
     *            username des user
     * @return liste des user
     */
    List<User> getByUsername(String username);
}
