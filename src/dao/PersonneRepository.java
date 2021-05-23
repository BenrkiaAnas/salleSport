package dao;

import java.util.List;

import entities.Espace;
import entities.Personne;

public class PersonneRepository extends Repository<Personne>{

	public PersonneRepository() {
		super(Personne.class);
		// TODO Auto-generated constructor stub
	}
	
	public Personne findBy(String email, String password)
	{
		return (Personne) em.createQuery("from "+entityClass.getSimpleName()+ " where email='"+email+"' AND pwd='"+ password +"'").getSingleResult();
	}
	
	public List<Personne> getAllGerant()
	{
		return em.createQuery("from "+entityClass.getSimpleName()+" where id_role = '2'").getResultList();
	}
	
	


}
