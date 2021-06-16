package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Horraire;
import entities.Personne;
import entities.Planning;
import entities.Reservation;
import entities.Terrain;

public class ReservationRepository extends Repository<Reservation>{

	public ReservationRepository() {
		super(Reservation.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Reservation> getAllReservation(Long id)
	{
		HorraireRepository horraireRepository = new HorraireRepository();
		List<Horraire> horraires = horraireRepository.findHorraireByTerrains(id);
		
		
		List<Reservation> reservations = new ArrayList<Reservation>();
		
		List<Reservation> reservations_all = new ArrayList<Reservation>();
		
		for(Horraire horraire: horraires) {
			reservations = em.createQuery("from "+entityClass.getSimpleName()+ " where id_hor='"+horraire.getId_hor()+"'").getResultList();
			
			for(Reservation reservation: reservations) {
				
				reservations_all.add(reservation);
			}
		}
		
		return reservations_all;
	}

}
