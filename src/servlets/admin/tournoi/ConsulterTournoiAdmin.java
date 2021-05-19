package servlets.admin.tournoi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TournoiRepository;
import entities.Tournoi;

/**
 * Servlet implementation class ConsulterTournoiAdmin
 */
@WebServlet("/consulterTournoiAdmin")
public class ConsulterTournoiAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterTournoiAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TournoiRepository repository = new TournoiRepository();
		Long id = Long.parseLong(request.getParameter("consulter"));
		Tournoi tournoi = repository.find(id);		
		request.setAttribute("tournoi", tournoi);
		request.getRequestDispatcher("Admin/Tournoi/consulter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
