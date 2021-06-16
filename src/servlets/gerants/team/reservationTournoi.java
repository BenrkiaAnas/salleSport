package servlets.gerants.team;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TeamRepository;
import dao.TournoiRepository;
import entities.Personne;
import entities.Team;
import entities.Tournoi;

/**
 * Servlet implementation class reservationTournoi
 */
@WebServlet("/reservationTournoi")
public class reservationTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservationTournoi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        Personne currentUser = (Personne) session.getAttribute("personne");	
        
        TournoiRepository tournoiRepository = new TournoiRepository();
		List<Tournoi> tournois = tournoiRepository.findEspaceByTournoi(currentUser.getId_personne());
		
        TeamRepository teamRepository = new TeamRepository();
        List<Team> teams = teamRepository.getAllTeamsByUser(currentUser.getId_personne());
        request.setAttribute("teams", teams);
        System.out.println(tournois);
        System.out.println(teams);
        System.out.println("hhhhhhhhhhh");
        request.getRequestDispatcher("Gerant/Reservation/tournoi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
