package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Espace;
import entities.Personne;
import entities.Terrain;
import entities.Tournoi;

public class TerrainRepository extends Repository<Terrain>{

	public TerrainRepository() {
		super(Terrain.class);
		// TODO Auto-generated constructor stub
	}
	
	public Terrain findBy(String nom, Espace espace)
	{
		return (Terrain) em.createQuery("from "+entityClass.getSimpleName()+ " where nom_ter='"+nom+"' AND id_esp='"+ espace.getId_esp() +"'").getSingleResult();
	}
	public List<Terrain> getTerrainsByEspace(Long id)
	{
		EspaceRepository  espaceRepository = new EspaceRepository();
		Espace espace = espaceRepository.findEspaceByCurrentUser(id);
		
		return em.createQuery("from "+entityClass.getSimpleName()+ " where id_esp='"+espace.getId_esp()+"'").getResultList();
	}
	
	public List<Terrain> findTerrainByEspace(Long id)
	{
		EspaceRepository espaceRepository = new EspaceRepository();
		Espace espace = espaceRepository.findEspaceByCurrentUser(id);
		return  em.createQuery("from "+entityClass.getSimpleName()+ " where id_esp='"+espace.getId_esp()+"'").getResultList();
	}
	
	public List<Terrain> getEspaceData(Espace espace)
	{
		List<Terrain> terrains = em.createQuery("from "+entityClass.getSimpleName()+ " where id_esp='"+espace.getId_esp()+"'").getResultList();
		espace.setTerrains(terrains);
		
		return espace.getTerrains();
		
	}
	
	public List<Terrain> getEspaceDataAndCategorie(Espace espace,Long id_cate)
	{
		List<Terrain> terrains = em.createQuery("from "+entityClass.getSimpleName()+ " where id_esp='"+espace.getId_esp()+"'"+ " and id_cate='"+id_cate+"'").getResultList();
		espace.setTerrains(terrains);
		
		return espace.getTerrains();
		
	}
	

}
