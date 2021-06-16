package dao;

import java.util.ArrayList;
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
	
	public List<Espace> getAllEspaceAndTerrain()
	{
		List<Espace> allespaces = new ArrayList<Espace>();
		EspaceRepository espaceRepository = new EspaceRepository();
		List<Espace> espaces = espaceRepository.findAll();
		List<Tournoi> tournois = new ArrayList<Tournoi>();
		List<Tournoi> all_tournois = new ArrayList<Tournoi>();
		for(Espace espace: espaces)
		{
			tournois = em.createQuery("from "+entityClass.getSimpleName()+ " where id_esp='"+espace.getId_esp()+"'").getResultList();
			
			for(Tournoi tournoi: tournois)
			{
				all_tournois.add(tournoi);
			}
			if(!tournois.isEmpty()) 
			{
			  allespaces.add(espace);
			}
			espace.setTournois(all_tournois);
			
			all_tournois = new ArrayList<Tournoi>();
			
		}
		
		
		return allespaces;
		
		
	}
	
	

}
