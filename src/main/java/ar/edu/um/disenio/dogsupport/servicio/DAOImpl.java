package ar.edu.um.disenio.dogsupport.servicio;

import javax.persistence.EntityManagerFactory;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.edu.um.disenio.dogsupport.servicioJPA.JPAHelper;

public abstract class DAOImpl<T,ID extends Serializable> implements Crud<T,ID> {
	private final Class<T> persistencia;
	private static final Logger logger = LoggerFactory.getLogger(DAOImpl.class);
	public DAOImpl(Class<T> classz) {
		this.persistencia = classz;
	}
	
	public T create(T entity) {
		
		EntityManagerFactory entityManagerFactory = JPAHelper.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		
		try {
			tx.begin();
			entityManager.persist(entity);
			tx.commit();
		} catch (PersistenceException e){
			tx.rollback();
			logger.error("Error en crear la entidad {}",e.getMessage());
			throw e;
		} finally {
			entityManager.close();
		}
		return entity;
	}

	@Override
	public T remove(T entity) {
		EntityManagerFactory entityManagerFactory = JPAHelper.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		
		try {
			tx.begin();
			entityManager.remove(entityManager.merge(entity));
			tx.commit();
		} catch (PersistenceException e){
			tx.rollback();
			logger.error("Error en borrar la entidad {}",e.getMessage());
			throw e;
		} finally {
			entityManager.close();
		}
		return entity;
	}

	@Override
	public T update(T entity) {
		EntityManagerFactory entityManagerFactory = JPAHelper.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		
		try {
			tx.begin();
			entityManager.merge(entity);
			tx.commit();
		} catch (PersistenceException e){
			tx.rollback();
			logger.error("Error en actualizar la entidad {}",e.getMessage());
			throw e;
		} finally {
			entityManager.close();
		}
		return entity;
	}

	@Override
	public List<T> findAll() {
		EntityManagerFactory entityManagerFactory = JPAHelper.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpl = "SELECT o FROM " + persistencia.getSimpleName() + " o";
		List<T> entities = null;

		try {
			TypedQuery<T> query = entityManager.createQuery(jpl, persistencia);
			entities = query.getResultList();
		} catch (PersistenceException e){
			logger.error("Error en encontrar las entidades {}",e.getMessage());
			throw e;
		} finally {
			entityManager.close();
		}
		return entities;
	}

	@Override
	public T findById(ID id) {
		EntityManagerFactory entityManagerFactory = JPAHelper.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		T entity = null;

		try {
			entity = entityManager.find(persistencia, id);
		} catch (PersistenceException e){
			logger.error("Error en encontrar la entidad {}",e.getMessage());
			throw e;
		} finally {
			entityManager.close();
		}
		return entity;
	}
	
	@Override
	public List<T> findByQuery(String property, String text) {
		EntityManagerFactory entityManagerFactory = JPAHelper.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpl = "SELECT o FROM " + persistencia.getSimpleName() + " o WHERE o." + property + " LIKE ?1";
		List<T> entities = null;

		try {
			TypedQuery<T> query = entityManager.createQuery(jpl, persistencia);
			query.setParameter(1, "%" + text + "%");
			entities = query.getResultList();
		} catch (PersistenceException e){
			logger.error("Error en encontrar las entidades {}",e.getMessage());
			throw e;
		} finally {
			entityManager.close();
		}
		return entities;
	}
	
	public List<T> findAllByForeignKey(String property, Object value) {
		EntityManagerFactory entityManagerFactory = JPAHelper.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpl = "SELECT o FROM " + persistencia.getSimpleName() + " o WHERE o." + property + " = ?1";
		List<T> entities = null;

		try {
			TypedQuery<T> query = entityManager.createQuery(jpl, persistencia);
			query.setParameter(1, value);
			entities = query.getResultList();
		} catch (PersistenceException e){
			logger.error("Error en encontrar las entidades {}",e.getMessage());
			throw e;
		} finally {
			entityManager.close();
		}
		return entities;
	}
}
