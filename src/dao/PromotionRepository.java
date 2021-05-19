package dao;

import java.util.List;

import entities.Espace;
import entities.Promotion;
import entities.Terrain;

public class PromotionRepository extends Repository<Promotion>{

	public PromotionRepository() {
		super(Promotion.class);
		// TODO Auto-generated constructor stub
	}
	public List<Promotion> findPromoByGerant(Long id)
	{
			
		return  em.createQuery("from "+entityClass.getSimpleName()+ " where id_gerer='"+id+"'").getResultList();
	}

}
