package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

@Entity
public class Terrain {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_ter;
	private String nom_ter;
	private Double prix;
	private String img_ter;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_esp")
	private Espace espace;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cate")
	private Categorie categorie;
	private Long statut;
	@Transient
	private List<Accessoire> accessoires = new ArrayList<Accessoire>();
	
	public Terrain() {
		super();
	}

	public Terrain(Long id_ter, String nom_ter, Double prix, String img_ter, Espace espace, Categorie categorie,
			Long statut) {
		super();
		this.id_ter = id_ter;
		this.nom_ter = nom_ter;
		this.prix = prix;
		this.img_ter = img_ter;
		this.espace = espace;
		this.categorie = categorie;
		this.statut = statut;
	}

	public Long getId_ter() {
		return id_ter;
	}

	public void setId_ter(Long id_ter) {
		this.id_ter = id_ter;
	}

	public String getNom_ter() {
		return nom_ter;
	}

	public void setNom_ter(String nom_ter) {
		this.nom_ter = nom_ter;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getImg_ter() {
		return img_ter;
	}

	public void setImg_ter(String img_ter) {
		this.img_ter = img_ter;
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

	public Long getStatut() {
		return statut;
	}

	public void setStatut(Long statut) {
		this.statut = statut;
	}

	public List<Accessoire> getAccessoires() {
		return accessoires;
	}

	public void setAccessoires(List<Accessoire> accessoires) {
		this.accessoires = accessoires;
	}

	@Override
	public String toString() {
		
		
	
		return "Terrain [id_ter=" + id_ter + ", nom_ter=" + nom_ter + ", prix=" + prix + ", img_ter=" + img_ter
				+ ", espace=" + espace + ", categorie=" + categorie + ", statut=" + statut + ", accessoires="
				+ accessoires.toArray().toString() + "]";
	}

	

	

	

	
	
	

}
