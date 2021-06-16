package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="espace")
public class Espace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_esp;
	private String nom_esp;
	private Long pub;
	@Column(columnDefinition = "LONGTEXT")
	private String desc_esp;
	private String img_esp;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_create")
	private Personne create;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_gerer")
	private Personne gerer;
	private Long liked;
	private Long deslike;
	@Transient
	private List<Terrain> terrains = new ArrayList<Terrain>();
	@Transient
	private List<Tournoi> tournois = new ArrayList<Tournoi>();
	
	public Espace() {
		super();
	}
	
	

	public Espace(Long id_esp, String nom_esp, Long pub, String desc_esp, String img_esp, Personne create,
			Personne gerer, Long liked, Long deslike) {
		super();
		this.id_esp = id_esp;
		this.nom_esp = nom_esp;
		this.pub = pub;
		this.desc_esp = desc_esp;
		this.img_esp = img_esp;
		this.create = create;
		this.gerer = gerer;
		this.liked = liked;
		this.deslike = deslike;
	}



	public Long getId_esp() {
		return id_esp;
	}

	public void setId_esp(Long id_esp) {
		this.id_esp = id_esp;
	}

	public String getNom_esp() {
		return nom_esp;
	}

	public void setNom_esp(String nom_esp) {
		this.nom_esp = nom_esp;
	}

	public Long getPub() {
		return pub;
	}

	public void setPub(Long pub) {
		this.pub = pub;
	}

	public String getDesc_esp() {
		return desc_esp;
	}

	public void setDesc_esp(String desc_esp) {
		this.desc_esp = desc_esp;
	}

	public String getImg_esp() {
		return img_esp;
	}

	public void setImg_esp(String img_esp) {
		this.img_esp = img_esp;
	}

	public Long getLiked() {
		return liked;
	}

	public void setLiked(Long liked) {
		this.liked = liked;
	}

	public Long getDeslike() {
		return deslike;
	}

	public void setDeslike(Long deslike) {
		this.deslike = deslike;
	}

	public Personne getCreate() {
		return create;
	}

	public void setCreate(Personne create) {
		this.create = create;
	}

	public Personne getGerer() {
		return gerer;
	}

	public void setGerer(Personne gerer) {
		this.gerer = gerer;
	}
	
	



	public List<Terrain> getTerrains() {
		return terrains;
	}



	public void setTerrains(List<Terrain> terrains) {
		this.terrains = terrains;
	}



	public List<Tournoi> getTournois() {
		return tournois;
	}



	public void setTournois(List<Tournoi> tournois) {
		this.tournois = tournois;
	}



	@Override
	public String toString() {
		

		
		return "Espace [id_esp=" + id_esp + ", nom_esp=" + nom_esp + ", pub=" + pub + ", desc_esp=" + desc_esp
				+ ", img_esp=" + img_esp + ", create=" + create + ", gerer=" + gerer + ", liked=" + liked + ", deslike="
				+ deslike + ", terrains=" + terrains.toArray().toString() + tournois.toArray().toString() +"]";
	}




	
	
	

}
