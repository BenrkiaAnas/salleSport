package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_res;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_hor")
	private Horraire horraire;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_client")
	private Personne client;
	@ManyToMany
	@JoinTable(name = "reservation_accessoire",joinColumns = @JoinColumn(name = "id_res"),inverseJoinColumns = @JoinColumn(name = "id_acc"))
	private List<Accessoire> accessoires = new ArrayList<Accessoire>();
	
	
	public Reservation() {
		super();
	}


	public Reservation(Long id_res, Horraire horraire, Personne client, List<Accessoire> accessoires) {
		super();
		this.id_res = id_res;
		this.horraire = horraire;
		this.client = client;
		this.accessoires = accessoires;
	}


	public Long getId_res() {
		return id_res;
	}


	public void setId_res(Long id_res) {
		this.id_res = id_res;
	}


	public Horraire getHorraire() {
		return horraire;
	}


	public void setHorraire(Horraire horraire) {
		this.horraire = horraire;
	}


	public Personne getClient() {
		return client;
	}


	public void setClient(Personne client) {
		this.client = client;
	}


	public List<Accessoire> getAccessoires() {
		return accessoires;
	}


	public void setAccessoires(List<Accessoire> accessoires) {
		this.accessoires = accessoires;
	}


	@Override
	public String toString() {
		return "Reservation [id_res=" + id_res + ", horraire=" + horraire + ", client=" + client + ", accessoires="
				+ accessoires + "]";
	}
	
	

	
}
