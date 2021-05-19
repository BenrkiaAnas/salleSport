package servlets.gerant.abonnement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Type_abonnementRepository;
import entities.Type_abonnement;

/**
 * Servlet implementation class ConsulterAbonnement
 */
@WebServlet("/consulterAbonnement")
public class ConsulterAbonnement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterAbonnement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("consulter"));
		Type_abonnementRepository abonnementRepository = new Type_abonnementRepository();
		Type_abonnement type_abonnement = abonnementRepository.find(id);
        request.setAttribute("abonnement", type_abonnement);
		request.getRequestDispatcher("Gerant/Abonnement/consulter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
