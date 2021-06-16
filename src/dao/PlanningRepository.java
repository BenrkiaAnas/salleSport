package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.Espace;
import entities.Personne;
import entities.Planning;
import entities.Terrain;

public class PlanningRepository extends Repository<Planning>{

	public PlanningRepository() {
		super(Planning.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Planning> findPlanningByTerrains(Long id)
	{
		TerrainRepository terrainRepository = new TerrainRepository();
		List<Terrain> terrains = terrainRepository.findTerrainByEspace(id);
		List<Planning> plannings = new ArrayList<Planning>();
		List<Planning> allPlanning = new ArrayList<Planning>();
		for(Terrain terrain: terrains) {
			plannings = em.createQuery("from "+entityClass.getSimpleName()+ " where id_ter='"+terrain.getId_ter()+"'").getResultList();
			
			for(Planning planning: plannings) {
				
				allPlanning.add(planning);
			}
		}
		return allPlanning;
	}
	
	public List<Planning> getAllPlanningByTerrain(Long id_ter)
	{
		return em.createQuery("from "+entityClass.getSimpleName()+" where id_ter = '"+id_ter+"'").getResultList();
	}

}
