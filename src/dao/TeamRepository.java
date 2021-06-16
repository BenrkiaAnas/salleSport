package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Espace;
import entities.Team;
import entities.Tournoi;

public class TeamRepository extends Repository<Team>{

	public TeamRepository() {
		super(Team.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Team> getAllTeamsByUser(Long id)
	{
		TournoiRepository tournoiRepository = new TournoiRepository();
		List<Tournoi> tournois = tournoiRepository.findEspaceByTournoi(id);
		List<Team> teams = new ArrayList<Team>();
		List<Team> all_teams = new ArrayList<Team>();
		
		for(Tournoi tournoi: tournois)
		{
			teams =  em.createQuery("from "+entityClass.getSimpleName()+ " where id_trn='"+tournoi.getId_trn()+"'").getResultList();
	
			
			for(Team team: teams)
			{
			
				all_teams.add(team);
			}
		}
		return  all_teams;
	}

}
