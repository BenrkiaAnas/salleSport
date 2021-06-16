package entities;

import javax.persistence.*;

@Entity
public class Promotion_categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_promo_cat;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_esp")
	private Espace espace;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cate")
	private Categorie categorie;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_promo")
	private Promotion promotion;
	
	
	public Promotion_categorie() {
		super();
	}




	public Promotion_categorie(Long id_promo_cat, Espace espace, Categorie categorie, Promotion promotion) {
		super();
		this.id_promo_cat = id_promo_cat;
		this.espace = espace;
		this.categorie = categorie;
		this.promotion = promotion;
	}
	
	


	public Long getId_promo_cat() {
		return id_promo_cat;
	}




	public void setId_promo_cat(Long id_promo_cat) {
		this.id_promo_cat = id_promo_cat;
	}




	public Espace getEspace() {
		return espace;
	}


	public void setEspace(Espace espace) {
		this.espace = espace;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public Promotion getPromotion() {
		return promotion;
	}


	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}




	@Override
	public String toString() {
		return "Promotion_categorie [id_promo_cat=" + id_promo_cat + ", espace=" + espace + ", categorie=" + categorie
				+ ", promotion=" + promotion + "]";
	}


	
	

}
