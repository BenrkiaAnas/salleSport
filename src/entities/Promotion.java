package entities;

import javax.persistence.*;

@Entity
public class Promotion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_promo;
	private Double discount;
	private Long statut;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_gerer")
	private Personne gerant;
	
	
	public Promotion() {
		super();
	}


	public Promotion(Long id_promo, Double discount, Long statut, Personne gerant) {
		super();
		this.id_promo = id_promo;
		this.discount = discount;
		this.statut = statut;
		this.gerant = gerant;
	}


	public Long getId_promo() {
		return id_promo;
	}


	public void setId_promo(Long id_promo) {
		this.id_promo = id_promo;
	}


	public Double getDiscount() {
		return discount;
	}


	public void setDiscount(Double discount) {
		this.discount = discount;
	}


	public Long getStatut() {
		return statut;
	}


	public void setStatut(Long statut) {
		this.statut = statut;
	}


	public Personne getGerant() {
		return gerant;
	}


	public void setGerant(Personne gerant) {
		this.gerant = gerant;
	}


	@Override
	public String toString() {
		return "Promotion [id_promo=" + id_promo + ", discount=" + discount + ", statut=" + statut + ", gerant="
				+ gerant + "]";
	}


	
	

}
