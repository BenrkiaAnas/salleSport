package servlets.gerant.horraire;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HorraireRepository;
import dao.PlanningRepository;
import entities.Horraire;
import entities.Personne;
import entities.Planning;

/**
 * Servlet implementation class createHorraire
 */
@WebServlet("/createHorraire")
public class createHorraire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createHorraire() {
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
        PlanningRepository planningRepository = new PlanningRepository();
        List<Planning> list = planningRepository.findPlanningByTerrains(currentUser.getId_personne());
        request.setAttribute("plannings", list);
		request.getRequestDispatcher("Gerant/Horraire/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long idplanning = Long.parseLong(request.getParameter("planning"));
		PlanningRepository planningRepository = new PlanningRepository();
		Planning planning = planningRepository.find(idplanning);
		String heure_depart = request.getParameter("heure_depart");
		String heure_fin = request.getParameter("heure_fin");
		HorraireRepository horraireRepository = new HorraireRepository();
		Horraire horraire = new Horraire(null, heure_depart, heure_fin, planning, 1l);
		horraireRepository.create(horraire);
		response.sendRedirect(request.getContextPath() + "/listeHorraire");
		
			
	}

}
