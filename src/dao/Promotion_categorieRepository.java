package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Categorie;
import entities.Espace;
import entities.Personne;
import entities.Promotion;
import entities.Promotion_categorie;

public class Promotion_categorieRepository extends Repository<Promotion_categorie>{

	public Promotion_categorieRepository() {
		super(Promotion_categorie.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Promotion_categorie> getAllPromotionCategorieByUser(Long id)
	{
		EspaceRepository espaceRepository = new EspaceRepository();
		List<Espace> espaces = espaceRepository.findEspaceByGerant(id);
		List<Promotion_categorie> promotion_categories = new ArrayList<Promotion_categorie>();
		List<Promotion_categorie> all_promotion_categories = new ArrayList<Promotion_categorie>();
		for(Espace espace: espaces) {
			promotion_categories = em.createQuery("from "+entityClass.getSimpleName()+" where id_esp ='"+espace.getId_esp()+"'").getResultList();
			
			for(Promotion_categorie promotion_categorie: promotion_categories)
			{
				all_promotion_categories.add(promotion_categorie);
			}
		}
		
		return all_promotion_categories;
	}
	
	public Promotion_categorie findPromotionCategorieByTerrain(Espace espace,Categorie categorie)
	{
		return (Promotion_categorie) em.createQuery("from "+entityClass.getSimpleName()+ " where id_esp='"+espace.getId_esp()+"' AND id_cate='"+ categorie.getId_cate() +"'").getSingleResult();
	}

}
