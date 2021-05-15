package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PersonneRepository;
import entities.Personne;

/**
 * Servlet implementation class ProfileGerant
 */
@WebServlet("/gerant")
public class ProfileGerant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileGerant() {
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
		request.setAttribute("currentUser", currentUser);
		request.getRequestDispatcher("Admin/profileGerant.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		HttpSession session = request.getSession();
		Personne currentUser = (Personne) session.getAttribute("personne");
		System.out.println(currentUser);
		PersonneRepository personneRepository = new PersonneRepository();
		Personne personne = personneRepository.find(currentUser.getId_personne());	
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setEmail(email);
		if (mdp!="")
		{
			personne.setPwd(mdp);
		}
		
		
		
		personneRepository.edit(personne);
		response.sendRedirect(request.getContextPath() + "/dashboardGerant");
	}

}
