package servlets.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccessoireRepository;
import dao.CategorieRepository;
import dao.EspaceRepository;
import dao.PersonneRepository;
import entities.Categorie;
import entities.Espace;
import entities.Personne;
import entities.Terrain;

/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
AccessoireRepository accessoireRepository = new AccessoireRepository();
		
		EspaceRepository espaceRepository = new EspaceRepository();
		
		List<Espace> espaces = espaceRepository.findAll();
		
		for(Espace espace: espaces)
		{
			accessoireRepository.getAllDataEspace(espace);
		}
		
		for(Espace espace: espaces)
		{
			System.out.println(espace.getTerrains());
			
			for(Terrain ter: espace.getTerrains())
			{
				System.out.println(ter.getAccessoires());
			}
		}
		
		CategorieRepository categorieRepository = new CategorieRepository();
		List<Categorie> categories = categorieRepository.findAll();
		
		request.setAttribute("categories", categories);
		
		request.setAttribute("espaces", espaces);
		request.getRequestDispatcher("Client/home.jsp").forward(request, response);
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
				response.sendRedirect(request.getContextPath() + "/home");

			}
		}
	}

}
