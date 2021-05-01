package entities;

import javax.persistence.*;

@Entity
public class Promotion_categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_promo_cat;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_esp")
	private Personne espace;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cate")
	private Personne categorie;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_promo")
	private Personne promotion;
	
	
	public Promotion_categorie() {
		super();
	}




	public Promotion_categorie(Long id_promo_cat, Personne espace, Personne categorie, Personne promotion) {
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




	public Personne getEspace() {
		return espace;
	}


	public void setEspace(Personne espace) {
		this.espace = espace;
	}


	public Personne getCategorie() {
		return categorie;
	}


	public void setCategorie(Personne categorie) {
		this.categorie = categorie;
	}


	public Personne getPromotion() {
		return promotion;
	}


	public void setPromotion(Personne promotion) {
		this.promotion = promotion;
	}




	@Override
	public String toString() {
		return "Promotion_categorie [id_promo_cat=" + id_promo_cat + ", espace=" + espace + ", categorie=" + categorie
				+ ", promotion=" + promotion + "]";
	}


	
	

}
