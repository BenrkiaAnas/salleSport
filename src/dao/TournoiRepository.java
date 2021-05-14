package dao;

import entities.Espace;
import entities.Tournoi;

public class TournoiRepository extends Repository<Tournoi>{

	public TournoiRepository() {
		super(Tournoi.class);
		// TODO Auto-generated constructor stub
	}
	
	public Tournoi findEspaceByTournoi(Long id)
	{
		EspaceRepository espaceRepository = new EspaceRepository();
		Espace espace = espaceRepository.findEspaceByCurrentUser(id);
		return (Tournoi) em.createQuery("from "+entityClass.getSimpleName()+ " where id_esp='"+espace.getId_esp()+"'").getSingleResult();
	}

}
