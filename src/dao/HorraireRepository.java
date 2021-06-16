package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Horraire;
import entities.Planning;
import entities.Terrain;

public class HorraireRepository extends Repository<Horraire>{

	public HorraireRepository() {
		super(Horraire.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Horraire> findHorraireByTerrains(Long id)
	{
		
		PlanningRepository planningRepository = new PlanningRepository();
		List<Planning> plannings = planningRepository.findPlanningByTerrains(id);
		List<Horraire> horraires = new ArrayList<Horraire>();
		List<Horraire> all_horarires = new ArrayList<Horraire>();
		for(Planning planning: plannings) {
			horraires = em.createQuery("from "+entityClass.getSimpleName()+ " where id_plann='"+planning.getId_plann()+"'").getResultList();
			
			for(Horraire horraire: horraires) {
				
				all_horarires.add(horraire);
			}
		}
		
		return all_horarires;
		
	}
	
	public List<Horraire> getAllHorraire(Long id_ter)
	{
		PlanningRepository planningRepository = new PlanningRepository();
		List<Planning> plannings = planningRepository.getAllPlanningByTerrain(id_ter);
		List<Horraire> horraires = new ArrayList<Horraire>();
		List<Horraire> all_horraire = new ArrayList<Horraire>();
		for(Planning planning: plannings)
		{
			horraires = em.createQuery("from "+entityClass.getSimpleName()+ " where id_plann='"+planning.getId_plann()+"'").getResultList();
			
			for(Horraire horraire: horraires) {
				
				all_horraire.add(horraire);
			}
		}
		return all_horraire;
	}

}
