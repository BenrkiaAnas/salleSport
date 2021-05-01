package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AbonnementRepository;
import dao.EspaceRepository;
import dao.PersonneRepository;
import dao.TerrainRepository;
import dao.Type_abonnementRepository;
import entities.Abonnement;
import entities.Espace;
import entities.Personne;
import entities.Terrain;
import entities.Type_abonnement;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Type_abonnementRepository abonnementRepository = new Type_abonnementRepository();
		List<Type_abonnement> plans = abonnementRepository.getAllPlans();
		request.setAttribute("plans", plans);
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Long plan = Long.parseLong(request.getParameter("plan"));
		String espace = request.getParameter("espace");
		String terrain = request.getParameter("terrain");
		
		
		Type_abonnementRepository type_repo = new Type_abonnementRepository();
		Type_abonnement type_abonnement = type_repo.find(plan);
		
		PersonneRepository personneRepository = new PersonneRepository();
		
		Personne personne = new Personne(null, nom, prenom, email, password, 2l, 1l);
		
		if(personneRepository.create(personne))
		{
			Personne personnePlan = personneRepository.findBy(email, password);
			
			EspaceRepository espaceRepository = new EspaceRepository();
			Espace espaceSportif = new Espace(null, espace, null, null, null, personnePlan, personnePlan, null, null);
			
			if(espaceRepository.create(espaceSportif))
			{
				Espace espaceCreated = espaceRepository.findBy(espace, personnePlan);
				
				TerrainRepository terrainRepository = new TerrainRepository();
				Terrain terrainSportif = new Terrain(null, terrain, null, null, espaceCreated, null, null);
				
				if(terrainRepository.create(terrainSportif))
				{
					Terrain terrainCreated = terrainRepository.findBy(terrain, espaceCreated);
					
					AbonnementRepository abonnementRepository = new AbonnementRepository();
					
					Abonnement abonnement = new Abonnement(null, type_abonnement, personnePlan, terrainCreated);
					abonnementRepository.create(abonnement);
					
					HttpSession session = request.getSession();
					session.setAttribute("personne", personnePlan);
					
					request.getRequestDispatcher("Admin/dashboard.jsp").forward(request, response);
					
					
				}
				
			}
			
			
			
		}
		
		
		
	}

}
