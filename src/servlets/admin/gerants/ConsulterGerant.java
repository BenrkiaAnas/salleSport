package servlets.admin.gerants;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AbonnementRepository;
import entities.Abonnement;
import entities.Personne;
import entities.Type_abonnement;

/**
 * Servlet implementation class ConsulterGerant
 */
@WebServlet("/consulterGerant")
public class ConsulterGerant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterGerant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("consulter"));
		AbonnementRepository abonnementRepository = new AbonnementRepository();
		Abonnement abonnement = abonnementRepository.findByGerant(id); 
		Personne gerant = abonnement.getPersonne();
		Type_abonnement plan = abonnement.getType();
		request.setAttribute("gerant", gerant);
		request.setAttribute("abonnement", plan);
		request.getRequestDispatcher("Admin/Gerant/consulter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
