package entities;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Planning {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_plann;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_ter")
	private Terrain terrain;
	@Temporal(TemporalType.DATE)
	private Date date;
	private Long status;
	
	
	public Planning() {
		super();
	}


	

	public Planning(Long id_plann, Terrain terrain, Date date, Long status) {
		super();
		this.id_plann = id_plann;
		this.terrain = terrain;
		this.date = date;
		this.status = status;
	}




	public Long getId_plann() {
		return id_plann;
	}


	public void setId_plann(Long id_plann) {
		this.id_plann = id_plann;
	}


	public Terrain getTerrain() {
		return terrain;
	}


	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}


	public Long getStatus() {
		return status;
	}


	public void setStatus(Long status) {
		this.status = status;
	}

	

	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}




	@Override
	public String toString() {
		return "Planning [id_plann=" + id_plann + ", terrain=" + terrain + ", date=" + date + ", status=" + status
				+ "]";
	}



	
	

}
