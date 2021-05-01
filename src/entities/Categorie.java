package entities;

import javax.persistence.*;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_cate;
	private String nom_cate;
	@Column(columnDefinition = "LONGTEXT")
	private String desc_cate;
	private String img_cate;
	private Long statut;
	
	public Categorie() {
		super();
	}

	public Categorie(Long id_cate, String nom_cate, String desc_cate, String img_cate, Long statut) {
		super();
		this.id_cate = id_cate;
		this.nom_cate = nom_cate;
		this.desc_cate = desc_cate;
		this.img_cate = img_cate;
		this.statut = statut;
	}

	public Long getId_cate() {
		return id_cate;
	}

	public void setId_cate(Long id_cate) {
		this.id_cate = id_cate;
	}

	public String getNom_cate() {
		return nom_cate;
	}

	public void setNom_cate(String nom_cate) {
		this.nom_cate = nom_cate;
	}

	public String getDesc_cate() {
		return desc_cate;
	}

	public void setDesc_cate(String desc_cate) {
		this.desc_cate = desc_cate;
	}

	public String getImg_cate() {
		return img_cate;
	}

	public void setImg_cate(String img_cate) {
		this.img_cate = img_cate;
	}

	public Long getStatut() {
		return statut;
	}

	public void setStatut(Long statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Categorie [id_cate=" + id_cate + ", nom_cate=" + nom_cate + ", desc_cate=" + desc_cate + ", img_cate="
				+ img_cate + ", statut=" + statut + "]";
	}
	
	

}
