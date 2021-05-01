package entities;

import javax.persistence.*;

@Entity
public class Abonnement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_abonn;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_type")
	private Type_abonnement type;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_personne")
	private Personne personne;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_ter")
	private Terrain terrain;
	
	
	public Abonnement() {
		super();
	}


	public Abonnement(Long id_abonn, Type_abonnement type, Personne personne, Terrain terrain) {
		super();
		this.id_abonn = id_abonn;
		this.type = type;
		this.personne = personne;
		this.terrain = terrain;
	}


	public Long getId_abonn() {
		return id_abonn;
	}


	public void setId_abonn(Long id_abonn) {
		this.id_abonn = id_abonn;
	}


	public Type_abonnement getType() {
		return type;
	}


	public void setType(Type_abonnement type) {
		this.type = type;
	}


	public Personne getPersonne() {
		return personne;
	}


	public void setPersonne(Personne personne) {
		this.personne = personne;
	}


	public Terrain getTerrain() {
		return terrain;
	}


	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}


	@Override
	public String toString() {
		return "Abonnement [id_abonn=" + id_abonn + ", type=" + type + ", personne=" + personne + ", terrain=" + terrain
				+ "]";
	}
	
	

}
