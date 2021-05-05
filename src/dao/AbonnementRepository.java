package dao;

import java.util.List;

import entities.Abonnement;
import entities.Personne;
import entities.Type_abonnement;

public class AbonnementRepository extends Repository<Abonnement>{

	public AbonnementRepository() {
		super(Abonnement.class);
		// TODO Auto-generated constructor stub
	}
	
	
	public Abonnement findByGerant(Long id)
	{
		return (Abonnement) em.createQuery("from "+entityClass.getSimpleName()+ " where id_personne='"+id+"'").getSingleResult();
	}
	
	

}
