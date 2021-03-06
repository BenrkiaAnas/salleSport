package servlets.gerants.tournoi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TournoiRepository;
import entities.Personne;
import entities.Tournoi;

/**
 * Servlet implementation class ListeTournoi
 */
@WebServlet("/listeTournoi")
public class ListeTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeTournoi() {
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
		List<Tournoi> list = repository.findEspaceByTournoi(currentUser.getId_personne());
		request.setAttribute("list", list);
		System.out.println(list);
		request.getRequestDispatcher("Gerant/Tournoi/liste.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
