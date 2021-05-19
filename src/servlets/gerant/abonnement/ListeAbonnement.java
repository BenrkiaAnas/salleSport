package servlets.gerant.abonnement;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Type_abonnementRepository;
import entities.Personne;
import entities.Type_abonnement;

/**
 * Servlet implementation class ListeAbonnement
 */
@WebServlet("/listeAbonnement")
public class ListeAbonnement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeAbonnement() {
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
        Type_abonnementRepository type_abonnement = new Type_abonnementRepository();
		List<Type_abonnement> abonements = type_abonnement.getAllAbonnementByUser(currentUser.getId_personne());
		request.setAttribute("abonements", abonements);
		System.out.println(abonements);
		request.getRequestDispatcher("Gerant/Abonnement/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
