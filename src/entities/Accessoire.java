package entities;

import javax.persistence.*;

@Entity
public class Accessoire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_acc;
	private String nom_acc;
	private Double prix_acc;
	private String image_acc;
	@Column(columnDefinition = "LONGTEXT")
	private String description;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cate")
	private Categorie categorie;
	private Long statut;
	
	
	public Accessoire() {
		super();
	}


	


	public Accessoire(Long id_acc, String nom_acc, Double prix_acc, String image_acc, String description,
			Categorie categorie, Long statut) {
		super();
		this.id_acc = id_acc;
		this.nom_acc = nom_acc;
		this.prix_acc = prix_acc;
		this.image_acc = image_acc;
		this.description = description;
		this.categorie = categorie;
		this.statut = statut;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public Long getId_acc() {
		return id_acc;
	}


	public void setId_acc(Long id_acc) {
		this.id_acc = id_acc;
	}


	public String getNom_acc() {
		return nom_acc;
	}


	public void setNom_acc(String nom_acc) {
		this.nom_acc = nom_acc;
	}


	public Double getPrix_acc() {
		return prix_acc;
	}


	public void setPrix_acc(Double prix_acc) {
		this.prix_acc = prix_acc;
	}


	public String getImage_acc() {
		return image_acc;
	}


	public void setImage_acc(String image_acc) {
		this.image_acc = image_acc;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public Long getStatut() {
		return statut;
	}


	public void setStatut(Long statut) {
		this.statut = statut;
	}





	@Override
	public String toString() {
		return "Accessoire [id_acc=" + id_acc + ", nom_acc=" + nom_acc + ", prix_acc=" + prix_acc + ", image_acc="
				+ image_acc + ", description=" + description + ", categorie=" + categorie + ", statut=" + statut + "]";
	}


	
	
	

}
