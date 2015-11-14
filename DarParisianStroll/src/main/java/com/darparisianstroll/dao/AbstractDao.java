package com.darparisianstroll.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * Classe abstraite mère de toutes les classes DAO, la classe principale celle
 * effectuant les interactions avec la base de donnee
 *
 * @param <PK>
 *            type 1
 * @param <T>
 *            type table
 */
public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    /**
     * Constructeur
     */
    @SuppressWarnings("unchecked")
    public AbstractDao() {
	this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
		.getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * retourne la variable SessionFactory
     * 
     * @return variable SessionFactory
     */
    protected Session getSession() {
	return sessionFactory.getCurrentSession();
    }

    /**
     * retourne element d'une table a partir de son identifiant
     * 
     * @param key
     *            identifiant
     * @return element d'une table
     */
    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
	return (T) getSession().get(persistentClass, key);
    }

    /**
     * sauvegarde un element dans une table
     * 
     * @param entity
     *            element
     */
    public void persist(T entity) {
	getSession().persist(entity);
    }

    /**
     * met a jout un element dans une table
     * 
     * @param entity
     *            element
     */
    public void update(T entity) {
	getSession().update(entity);
    }

    /**
     * supprime un element dans une table
     * 
     * @param entity
     *            element
     */
    public void delete(T entity) {
	getSession().delete(entity);
    }

    /**
     * retourne un objet permettant d'effectuer des requetes sql securisees
     * 
     * @return objet Criteria
     */
    protected Criteria createEntityCriteria() {
	return getSession().createCriteria(persistentClass);
    }

}
