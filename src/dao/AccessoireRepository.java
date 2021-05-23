package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Accessoire;
import entities.Espace;
import entities.Terrain;

public class AccessoireRepository extends Repository<Accessoire>{

	public AccessoireRepository() {
		super(Accessoire.class);
		// TODO Auto-generated constructor stub
	}
	
	public void getAllDataEspace(Espace espace)
	{
		TerrainRepository repository =new TerrainRepository();
		List<Terrain> terrains = repository.getEspaceData(espace);
		for(Terrain ter : terrains)
		{
			List<Accessoire> accessoire =  em.createQuery("from "+entityClass.getSimpleName()+ " where id_cate='"+ter.getCategorie().getId_cate()+"' and id_gerant = '"+espace.getGerer().getId_personne()+"'").getResultList();
			ter.setAccessoires(accessoire);
		}
		
	}
	
	public void getAllDataEspaceByCate(Espace espace, Long id_cate)
	{
		TerrainRepository repository =new TerrainRepository();
		List<Terrain> terrains = repository.getEspaceDataAndCategorie(espace,id_cate);
		for(Terrain ter : terrains)
		{
			List<Accessoire> accessoire =  em.createQuery("from "+entityClass.getSimpleName()+ " where id_cate='"+ter.getCategorie().getId_cate()+"' and id_gerant = '"+espace.getGerer().getId_personne()+"'").getResultList();
			ter.setAccessoires(accessoire);
		}
		
	}
	
	public void getAccessoireByTerrain(Terrain terrain)
	{
		List<Accessoire> accessoire =  em.createQuery("from "+entityClass.getSimpleName()+ " where id_cate='"+terrain.getCategorie().getId_cate()+"' and id_gerant = '"+terrain.getEspace().getGerer().getId_personne()+"'").getResultList();
		terrain.setAccessoires(accessoire);
	}

}
