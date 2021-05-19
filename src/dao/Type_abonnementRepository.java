package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Terrain;
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
	
	public List<Type_abonnement> getAllAbonnementByUser(Long id)
	{
		TerrainRepository terrainRepository = new TerrainRepository();
		List<Terrain> terrains = terrainRepository.getTerrainsByEspace(id);
		List<Type_abonnement> abonnements = new ArrayList();
		for (Terrain terrain: terrains) {
			
			Type_abonnement abon = (Type_abonnement) em.createQuery("from "+entityClass.getSimpleName()+ " where id_ter='"+terrain.getId_ter()+"'").getSingleResult();
			
			if(abon != null)
			{
				abonnements.add(abon);
			}
		}
		
		return abonnements;
	}

}
