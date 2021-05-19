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
 * Servlet implementation class ModifierAbonnement
 */
@WebServlet("/modifierAbonnement")
public class ModifierAbonnement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierAbonnement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
			// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        Personne currentUser = (Personne) session.getAttribute("personne");
        TerrainRepository terrainrepo = new TerrainRepository();
        List<Terrain> terrains = terrainrepo.getTerrainsByEspace(currentUser.getId_personne());
        request.setAttribute("terrains", terrains);
		Long id = Long.parseLong(request.getParameter("update"));
		Type_abonnementRepository abonnementRepository = new Type_abonnementRepository();
		Type_abonnement type_abonnement = abonnementRepository.find(id);
		request.setAttribute("abonnement", type_abonnement);
		request.getRequestDispatcher("Gerant/Abonnement/modifier.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("update"));
		Type_abonnementRepository abonnementRepository = new Type_abonnementRepository();
		Type_abonnement type_abonnement = abonnementRepository.find(id);
		String nom = request.getParameter("nom");
		Double prix = Double.parseDouble(request.getParameter("prix"));
		String description = request.getParameter("description");
		String statut = request.getParameter("statut");
		Long terrain_id = Long.parseLong(request.getParameter("terrain"));
		TerrainRepository repository2 = new TerrainRepository();
		Terrain terrain = repository2.find(terrain_id);
		
		type_abonnement.setDesc_type(description);
		type_abonnement.setNom_type(nom);
        type_abonnement.setPrix(prix);
        type_abonnement.setTerrain(terrain);
        if(statut == null)
		{
        	type_abonnement.setStatut(0l);
		}else {
			type_abonnement.setStatut(1l);
		}
        
        abonnementRepository.edit(type_abonnement);
        
        response.sendRedirect(request.getContextPath() + "/listeAbonnement");
	}

}
