package dao;

import java.util.List;

import entities.Espace;
import entities.Tournoi;
import entities.Type_abonnement;

public class TournoiRepository extends Repository<Tournoi>{

	public TournoiRepository() {
		super(Tournoi.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Tournoi> findEspaceByTournoi(Long id)
	{
		EspaceRepository espaceRepository = new EspaceRepository();
		Espace espace = espaceRepository.findEspaceByCurrentUser(id);
		return  em.createQuery("from "+entityClass.getSimpleName()+ " where id_esp='"+espace.getId_esp()+"'").getResultList();
	}

}
