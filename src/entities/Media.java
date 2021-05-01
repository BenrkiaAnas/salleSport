package entities;

import javax.persistence.*;

@Entity
public class Media {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_media;
	private String chemin_img;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_esp")
	private Espace espace;
	
	
	public Media() {
		super();
	}


	public Media(Long id_media, String chemin_img, Espace espace) {
		super();
		this.id_media = id_media;
		this.chemin_img = chemin_img;
		this.espace = espace;
	}


	public Long getId_media() {
		return id_media;
	}


	public void setId_media(Long id_media) {
		this.id_media = id_media;
	}


	public String getChemin_img() {
		return chemin_img;
	}


	public void setChemin_img(String chemin_img) {
		this.chemin_img = chemin_img;
	}


	public Espace getEspace() {
		return espace;
	}


	public void setEspace(Espace espace) {
		this.espace = espace;
	}


	@Override
	public String toString() {
		return "Media [id_media=" + id_media + ", chemin_img=" + chemin_img + ", espace=" + espace + "]";
	}
	
	
	

}
