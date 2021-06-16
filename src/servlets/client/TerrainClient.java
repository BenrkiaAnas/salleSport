package servlets.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessoireRepository;
import dao.EspaceRepository;
import dao.HorraireRepository;
import dao.PlanningRepository;
import dao.TerrainRepository;
import entities.Espace;
import entities.Horraire;
import entities.Planning;
import entities.Terrain;

/**
 * Servlet implementation class Terrain
 */
@WebServlet("/terrain")
public class TerrainClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TerrainClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("ter"));
		TerrainRepository repository = new TerrainRepository();
		Terrain terrain = repository.find(id);
		AccessoireRepository accessoireRepository = new AccessoireRepository();
		accessoireRepository.getAccessoireByTerrain(terrain);
		request.setAttribute("terrain",terrain);	
		
		PlanningRepository planningRepository = new PlanningRepository();
		List<Planning> plannings = planningRepository.getAllPlanningByTerrain(terrain.getId_ter());
		
		System.out.println(plannings);
		
		HorraireRepository horraireRepository = new HorraireRepository();
		List<Horraire> horraires = horraireRepository.getAllHorraire(terrain.getId_ter());
		
		EspaceRepository espaceRepository = new EspaceRepository();
		
		List<Espace> espaces = espaceRepository.findAll();
		
		System.out.println(horraires);
		
		request.setAttribute("espaces", espaces);
		
		request.setAttribute("horraires", horraires);
		request.setAttribute("plannings", plannings);
		
		request.getRequestDispatcher("Client/terrain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
