package dao;

import entities.Espace;
import entities.Personne;
import entities.Terrain;

public class TerrainRepository extends Repository<Terrain>{

	public TerrainRepository() {
		super(Terrain.class);
		// TODO Auto-generated constructor stub
	}
	
	public Terrain findBy(String nom, Espace espace)
	{
		return (Terrain) em.createQuery("from "+entityClass.getSimpleName()+ " where nom_ter='"+nom+"' AND id_esp='"+ espace.getId_esp() +"'").getSingleResult();
	}

}
