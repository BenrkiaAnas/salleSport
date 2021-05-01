package entities;

import javax.persistence.*;


import java.util.Date;

import javax.persistence.*;

@Entity 
public class Horraire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_hor;
	@Temporal(TemporalType.TIME)
	private Date heure_depart;
	@Temporal(TemporalType.TIME)
	private Date heure_fin;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_plann")
	private Planning planning;
	private Long statut;
	
	
	public Horraire() {
		super();
	}


	public Horraire(Long id_hor, Date heure_depart, Date heure_fin, Planning planning, Long statut) {
		super();
		this.id_hor = id_hor;
		this.heure_depart = heure_depart;
		this.heure_fin = heure_fin;
		this.planning = planning;
		this.statut = statut;
	}


	public Long getId_hor() {
		return id_hor;
	}


	public void setId_hor(Long id_hor) {
		this.id_hor = id_hor;
	}


	public Date getHeure_depart() {
		return heure_depart;
	}


	public void setHeure_depart(Date heure_depart) {
		this.heure_depart = heure_depart;
	}


	public Date getHeure_fin() {
		return heure_fin;
	}


	public void setHeure_fin(Date heure_fin) {
		this.heure_fin = heure_fin;
	}


	public Planning getPlanning() {
		return planning;
	}


	public void setPlanning(Planning planning) {
		this.planning = planning;
	}


	public Long getStatut() {
		return statut;
	}


	public void setStatut(Long statut) {
		this.statut = statut;
	}


	@Override
	public String toString() {
		return "Horraire [id_hor=" + id_hor + ", heure_depart=" + heure_depart + ", heure_fin=" + heure_fin
				+ ", planning=" + planning + ", statut=" + statut + "]";
	}
	
	

}
