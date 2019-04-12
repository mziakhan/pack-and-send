package com.javarnd.pns.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
//    	return entityManager.getReference(persistentClass, key); 
	}

	public void persist(T entity) {
		getSession().persist(entity);
//    	entityManager.persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
//    	entityManager.remove(entity);
	}

	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}
	//// return (Criteria)
	//// entityManager.getCriteriaBuilder().createQuery(persistentClass);
//	}

//	protected Query createEntityQuery() {
//		CriteriaBuilder cb = getSession().getCriteriaBuilder();
//		CriteriaQuery<T> cq = (CriteriaQuery) cb.createQuery(persistentClass);
//		return (Query) getSession().getCriteriaBuilder().createQuery(persistentClass); // entityManager.getCriteriaBuilder().createQuery(persistentClass);
//	}

//	public <T> List<T> findAll(final Class<T> type) {
//		final Session session = getSession();
//		final Criteria crit = session.createCriteria(type);
//		return crit.list();
//	}

	public List<T> findAll() {
		return getSession().createQuery("from " + persistentClass).list();
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

//    @PersistenceContext
//    private EntityManager entityManager;

}
