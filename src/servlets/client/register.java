package servlets.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EspaceRepository;
import dao.PersonneRepository;
import entities.Espace;
import entities.Personne;

/**
 * Servlet implementation class register
 */
@WebServlet("/registerClient")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EspaceRepository espaceRepository = new EspaceRepository();
		List<Espace> espaces = espaceRepository.findAll();
		request.setAttribute("espaces", espaces);
		request.getRequestDispatcher("Client/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		PersonneRepository personneRepository = new PersonneRepository();
		Personne personne = new Personne(null, nom, prenom, email, pwd, 3l, 1l);
		personneRepository.create(personne);
		HttpSession session = request.getSession();
		session.setAttribute("personne", personne);
		response.sendRedirect(request.getContextPath() + "/checkout");
	}

}
