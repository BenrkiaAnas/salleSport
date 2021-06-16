package servlets.client;

import java.io.IOException;
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
 * Servlet implementation class checkoutTournoi
 */
@WebServlet("/checkoutTournoi")
public class checkoutTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkoutTournoi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id_tournoi = Long.parseLong(request.getParameter("tournoi"));
		HttpSession session = request.getSession();
		Personne personne = (Personne) session.getAttribute("personne");
		TournoiRepository tournoiRepository = new TournoiRepository();
		Tournoi tournoi = tournoiRepository.find(id_tournoi);
		request.setAttribute("tournoi", tournoi);
		request.setAttribute("personne", personne);
		request.getRequestDispatcher("Client/checkoutTournoi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom_equipe = request.getParameter("nom_team");
		Long id_tournoi = Long.parseLong(request.getParameter("tournoi"));
		TournoiRepository tournoiRepository = new TournoiRepository();
		Tournoi tournoi = tournoiRepository.find(id_tournoi);
		HttpSession session = request.getSession();
		Personne personne = (Personne) session.getAttribute("personne");
		TeamRepository teamRepository = new TeamRepository();
		Team team = new Team(null, nom_equipe, tournoi, personne);
		teamRepository.create(team);
		response.sendRedirect(request.getContextPath() + "/home");
	}

}
