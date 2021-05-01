package dao;

import java.util.List;

import entities.Type_abonnement;

public class Type_abonnementRepository extends Repository<Type_abonnement>{

	public Type_abonnementRepository() {
		super(Type_abonnement.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Type_abonnement> getAllPlans()
	{
		return em.createQuery("from "+entityClass.getSimpleName()+" where id_ter = null").getResultList();
	}

}
