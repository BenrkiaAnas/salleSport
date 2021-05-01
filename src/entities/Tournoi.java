package entities;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Tournoi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_trn;
	private String nom_trn;
	@Column(columnDefinition = "LONGTEXT")
	private String description_trn;
	private Double prix;
	@Temporal(TemporalType.DATE)
	private Date date_debut;
	@Temporal(TemporalType.DATE)
	private Date date_fin;
	@Temporal(TemporalType.DATE)
	private Date date_fin_ins;
	private Long nbr_team;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_esp")
	private Espace espace;
	private Long statut;
	
	
	public Tournoi() {
		super();
	}


	public Tournoi(Long id_trn, String nom_trn, String description_trn, Double prix, Date date_debut, Date date_fin,
			Date date_fin_ins, Long nbr_team, Espace espace, Long statut) {
		super();
		this.id_trn = id_trn;
		this.nom_trn = nom_trn;
		this.description_trn = description_trn;
		this.prix = prix;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.date_fin_ins = date_fin_ins;
		this.nbr_team = nbr_team;
		this.espace = espace;
		this.statut = statut;
	}


	public Long getId_trn() {
		return id_trn;
	}


	public void setId_trn(Long id_trn) {
		this.id_trn = id_trn;
	}


	public String getNom_trn() {
		return nom_trn;
	}


	public void setNom_trn(String nom_trn) {
		this.nom_trn = nom_trn;
	}


	public String getDescription_trn() {
		return description_trn;
	}


	public void setDescription_trn(String description_trn) {
		this.description_trn = description_trn;
	}


	public Double getPrix() {
		return prix;
	}


	public void setPrix(Double prix) {
		this.prix = prix;
	}


	public Date getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}


	public Date getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}


	public Date getDate_fin_ins() {
		return date_fin_ins;
	}


	public void setDate_fin_ins(Date date_fin_ins) {
		this.date_fin_ins = date_fin_ins;
	}


	public Long getNbr_team() {
		return nbr_team;
	}


	public void setNbr_team(Long nbr_team) {
		this.nbr_team = nbr_team;
	}


	public Espace getEspace() {
		return espace;
	}


	public void setEspace(Espace espace) {
		this.espace = espace;
	}


	public Long getStatut() {
		return statut;
	}


	public void setStatut(Long statut) {
		this.statut = statut;
	}


	@Override
	public String toString() {
		return "Tournoi [id_trn=" + id_trn + ", nom_trn=" + nom_trn + ", description_trn=" + description_trn + ", prix="
				+ prix + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", date_fin_ins=" + date_fin_ins
				+ ", nbr_team=" + nbr_team + ", espace=" + espace + ", statut=" + statut + "]";
	}
	
	

}
