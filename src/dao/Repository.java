package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Repository<T> {
	Class<T> entityClass ;
	EntityManagerFactory emf;
	static EntityManager em;
	public Repository(Class<T> entityClass) {
		this.entityClass = entityClass;
		emf = Persistence.createEntityManagerFactory("projetjava");
		if(em==null)
			em = emf.createEntityManager();
	}
	public boolean create(T ... entities) {
		EntityTransaction transaction = null;
		try {
			transaction = em.getTransaction();
			transaction.begin();
			for (T entity : entities) {
				em.persist(entity);
			}			
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
			return false;
		}
		return true;
	}
	public void edit(T entity) {
		EntityTransaction transaction = null;
		try {
			transaction = em.getTransaction();
			transaction.begin();
			em.merge(entity);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}
	public void delete(T entity) {
		EntityTransaction transaction = null;
		try {
			transaction = em.getTransaction();
			transaction.begin();
			em.remove(entity);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}
	
	public T find(Object id) {
		return em.find(entityClass, id);
	}
	
	public List<T> findAll(){
		return em.createQuery("from "+entityClass.getSimpleName()).getResultList();
	}
	
	
	
}
