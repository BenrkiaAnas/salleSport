package servlets.gerant.abonnement;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TerrainRepository;
import dao.Type_abonnementRepository;
import entities.Personne;
import entities.Terrain;
import entities.Type_abonnement;

/**
 * Servlet implementation class CreateAbonnement
 */
@WebServlet("/createAbonnement")
public class CreateAbonnement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAbonnement() {
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
        TerrainRepository terrainrepo = new TerrainRepository();
        List<Terrain> terrains = terrainrepo.getTerrainsByEspace(currentUser.getId_personne());
        request.setAttribute("terrains", terrains);
        
		request.getRequestDispatcher("Gerant/Abonnement/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Type_abonnementRepository abonnementRepository = new Type_abonnementRepository();
		String nom = request.getParameter("nom");
	    Double prix = Double.parseDouble(request.getParameter("prix"));
		String description = request.getParameter("description");
	    Long id = Long.parseLong(request.getParameter("terrain"));
	    TerrainRepository terrainRepo = new TerrainRepository();
	    Terrain terrain = terrainRepo.find(id);
	    Type_abonnement abonnement = new Type_abonnement(null, nom, prix, description, terrain, 1l);
	    abonnementRepository.create(abonnement);
	    response.sendRedirect(request.getContextPath() + "/listeAbonnement");	}

}
