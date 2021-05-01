package entities;

import javax.persistence.*;

@Entity
public class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_personne;
	private String nom;
	private String prenom;
	private String email;
	private String pwd;
	private Long id_role;
	private Long statut;
	
	public Personne() {
		super();
	}

	public Personne(Long id_personne, String nom, String prenom, String email, String pwd, Long id_role,
			Long statut) {
		super();
		this.id_personne = id_personne;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pwd = pwd;
		this.id_role = id_role;
		this.statut = statut;
	}

	public Long getId_personne() {
		return id_personne;
	}

	public void setId_personne(Long id_personne) {
		this.id_personne = id_personne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Long getId_role() {
		return id_role;
	}

	public void setId_role(Long id_role) {
		this.id_role = id_role;
	}

	public Long getStatut() {
		return statut;
	}

	public void setStatut(Long statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Personne [id_personne=" + id_personne + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", pwd=" + pwd + ", id_role=" + id_role + ", statut=" + statut + "]";
	}
	
	
	
	
	

}
