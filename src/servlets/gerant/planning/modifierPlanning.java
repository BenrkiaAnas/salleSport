package servlets.gerant.planning;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlanningRepository;
import dao.TerrainRepository;
import entities.Personne;
import entities.Planning;
import entities.Terrain;

/**
 * Servlet implementation class modifierPlanning
 */
@WebServlet("/modifierPlanning")
public class modifierPlanning extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifierPlanning() {
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
		Long id = Long.parseLong(request.getParameter("update"));
		PlanningRepository planningRepository = new PlanningRepository();
		Planning planning = planningRepository.find(id);
		TerrainRepository terrainRepository = new TerrainRepository();
        List<Terrain> terrains = terrainRepository.findTerrainByEspace(currentUser.getId_personne());
        request.setAttribute("terrains", terrains);
		request.setAttribute("planning", planning);
		request.getRequestDispatcher("Gerant/Planning/modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("update"));
		PlanningRepository planningRepository = new PlanningRepository();
		Planning planning = planningRepository.find(id);
		String statut = request.getParameter("statut");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = request.getParameter("date");
		Date date1 = null;
		try {
			 date1 = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Long idterrain = Long.parseLong(request.getParameter("terrain"));
		TerrainRepository repository = new TerrainRepository();
		Terrain terrain = repository.find(idterrain);
		planning.setTerrain(terrain);
		planning.setDate(date1);
		if(statut == null)
		{
			planning.setStatus(0l);
		}else {
			planning.setStatus(1l);
		}
		planningRepository.edit(planning);
		response.sendRedirect(request.getContextPath() + "/listePlanning");
		
	}

}
