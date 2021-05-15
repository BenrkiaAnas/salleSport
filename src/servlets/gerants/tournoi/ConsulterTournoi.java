package servlets.gerants.tournoi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EspaceRepository;
import dao.TournoiRepository;
import entities.Espace;
import entities.Personne;
import entities.Tournoi;

/**
 * Servlet implementation class ConsulterTournoi
 */
@WebServlet("/consulterTournoi")
public class ConsulterTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterTournoi() {
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
		TournoiRepository repository = new TournoiRepository();
		Long id = Long.parseLong(request.getParameter("consulter"));
		Tournoi tournoi = repository.find(id);
		EspaceRepository espaceRepository = new EspaceRepository();
        List<Espace> espaces = espaceRepository.findEspaceByGerant(currentUser.getId_personne());
		request.setAttribute("tournoi", tournoi);
		request.setAttribute("espaces", espaces);
		System.out.println(tournoi);
		request.getRequestDispatcher("Gerant/Tournoi/consulter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
