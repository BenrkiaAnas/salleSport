package entities;

import javax.persistence.*;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_team;
	private String nom_team;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_trn")
	private Espace tournoi;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_client")
	private Personne client;
	
	
	public Team() {
		super();
	}


	public Team(Long id_team, String nom_team, Espace tournoi, Personne client) {
		super();
		this.id_team = id_team;
		this.nom_team = nom_team;
		this.tournoi = tournoi;
		this.client = client;
	}


	public Long getId_team() {
		return id_team;
	}


	public void setId_team(Long id_team) {
		this.id_team = id_team;
	}


	public String getNom_team() {
		return nom_team;
	}


	public void setNom_team(String nom_team) {
		this.nom_team = nom_team;
	}


	public Espace getTournoi() {
		return tournoi;
	}


	public void setTournoi(Espace tournoi) {
		this.tournoi = tournoi;
	}


	public Personne getClient() {
		return client;
	}


	public void setClient(Personne client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Team [id_team=" + id_team + ", nom_team=" + nom_team + ", tournoi=" + tournoi + ", client=" + client
				+ "]";
	}
	
	

}
