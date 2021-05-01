package entities;

import javax.persistence.*;

@Entity
public class Type_abonnement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_type_abon;
	private String nom_type;
	private Double prix;
	@Column(columnDefinition = "LONGTEXT")
	private String desc_type;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_ter")
	private Terrain terrain;
	private Long statut;
	
	
	public Type_abonnement() {
		super();
	}


	public Type_abonnement(Long id_type_abon, String nom_type, Double prix, String desc_type, Terrain terrain,
			Long statut) {
		super();
		this.id_type_abon = id_type_abon;
		this.nom_type = nom_type;
		this.prix = prix;
		this.desc_type = desc_type;
		this.terrain = terrain;
		this.statut = statut;
	}


	public Long getId_type_abon() {
		return id_type_abon;
	}


	public void setId_type_abon(Long id_type_abon) {
		this.id_type_abon = id_type_abon;
	}


	public String getNom_type() {
		return nom_type;
	}


	public void setNom_type(String nom_type) {
		this.nom_type = nom_type;
	}


	public Double getPrix() {
		return prix;
	}


	public void setPrix(Double prix) {
		this.prix = prix;
	}


	public String getDesc_type() {
		return desc_type;
	}


	public void setDesc_type(String desc_type) {
		this.desc_type = desc_type;
	}


	public Terrain getTerrain() {
		return terrain;
	}


	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}


	public Long getStatut() {
		return statut;
	}


	public void setStatut(Long statut) {
		this.statut = statut;
	}


	@Override
	public String toString() {
		return "Type_abonnement [id_type_abon=" + id_type_abon + ", nom_type=" + nom_type + ", prix=" + prix
				+ ", desc_type=" + desc_type + ", terrain=" + terrain + ", statut=" + statut + "]";
	}
	
	

}
