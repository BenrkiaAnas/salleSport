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
 * Servlet implementation class modifierHorraire
 */
@WebServlet("/modifierHorraire")
public class modifierHorraire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifierHorraire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("update"));
		HttpSession session = request.getSession();
        Personne currentUser = (Personne) session.getAttribute("personne");
        HorraireRepository horraireRepository = new HorraireRepository();
        Horraire horraire = horraireRepository.find(id);
        request.setAttribute("horraire", horraire);
        PlanningRepository planningRepository = new PlanningRepository();
        List<Planning> list = planningRepository.findPlanningByTerrains(currentUser.getId_personne());
        request.setAttribute("plannings", list);
		request.getRequestDispatcher("Gerant/Horraire/modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("update"));
		Long idplanning = Long.parseLong(request.getParameter("planning"));
		HorraireRepository horraireRepository = new HorraireRepository();
		PlanningRepository planningRepository = new PlanningRepository();
		Planning planning = planningRepository.find(idplanning);
		String heure_depart = request.getParameter("heure_depart");
		String heure_fin = request.getParameter("heure_fin");
		String statut = request.getParameter("statut");
		Horraire horraire = horraireRepository.find(id);
		if(statut == null)
		{
			horraire.setStatut(0l);
		}else {
			horraire.setStatut(1l);
		}	
		
		horraire.setPlanning(planning);
		horraire.setHeure_depart(heure_depart);
		horraire.setHeure_fin(heure_fin);
		horraireRepository.edit(horraire);
		response.sendRedirect(request.getContextPath() + "/listeHorraire");
	}

}
