package dao;

import entities.Espace;
import entities.Personne;

public class EspaceRepository extends Repository<Espace>{

	public EspaceRepository() {
		super(Espace.class);
		// TODO Auto-generated constructor stub
	}
	
	
	public Espace findBy(String nom, Personne gerant)
	{
		return (Espace) em.createQuery("from "+entityClass.getSimpleName()+ " where nom_esp='"+nom+"' AND id_gerer='"+ gerant.getId_personne() +"'").getSingleResult();
	}
	
	public Espace findEspaceByCurrentUser(Long id)
	{
		return (Espace) em.createQuery("from "+entityClass.getSimpleName()+ " where id_gerer='"+id+"'").getSingleResult();
	}


}
