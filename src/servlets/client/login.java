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
 * Servlet implementation class login
 */
@WebServlet("/loginClient")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("terrain"));
		Long id_planning = Long.parseLong(request.getParameter("planning"));
		Long id_horraire = Long.parseLong(request.getParameter("horraire"));
		Long values = Long.parseLong(request.getParameter("accesoires[]"));
		System.out.println(values);
		HttpSession session = request.getSession();
		
		EspaceRepository espaceRepository = new EspaceRepository();
		List<Espace> espaces = espaceRepository.findAll();
		request.setAttribute("espaces", espaces);
		
		session.setAttribute("id_terrain", id);
		session.setAttribute("id_accessoires", values);
		session.setAttribute("id_planning", id_planning);
		session.setAttribute("id_horraire", id_horraire);
		request.getRequestDispatcher("Client/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		PersonneRepository personneRepository = new PersonneRepository();
		Personne personneLogged = personneRepository.findBy(email, pwd);
		System.out.println(personneLogged);
		if(personneLogged.getStatut() == 1)
		{
			if(personneLogged.getId_role() == 3)
			{
				System.out.println("3andi access role");
				HttpSession session = request.getSession();
				session.setAttribute("personne", personneLogged);
				response.sendRedirect(request.getContextPath() + "/checkout");

			}
		}
	}

}
