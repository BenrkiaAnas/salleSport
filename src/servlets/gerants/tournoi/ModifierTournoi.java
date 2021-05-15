package servlets.gerants.tournoi;

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

import dao.EspaceRepository;
import dao.TournoiRepository;
import entities.Espace;
import entities.Personne;
import entities.Tournoi;

/**
 * Servlet implementation class ModifierTournoi
 */
@WebServlet("/modifierTournoi")
public class ModifierTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierTournoi() {
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
		TournoiRepository repository = new TournoiRepository();
		Long id = Long.parseLong(request.getParameter("update"));
		Tournoi tournoi = repository.find(id);
		EspaceRepository espaceRepository = new EspaceRepository();
        List<Espace> espaces = espaceRepository.findEspaceByGerant(currentUser.getId_personne());
		request.setAttribute("tournoi", tournoi);
		request.setAttribute("espaces", espaces);
		System.out.println(tournoi);
		request.getRequestDispatcher("Gerant/Tournoi/modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("update"));
		TournoiRepository repository = new TournoiRepository();
		Tournoi tournoi = repository.find(id);
		Long id_espace = Long.parseLong(request.getParameter("espace"));
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		Double prix = Double.parseDouble(request.getParameter("prix"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date_deb = request.getParameter("date_deb");
		String statut = request.getParameter("statut");
		Date date_fine = null;
		Date date_fin_insc = null;
		Date date_debut = null;
		try {
			 date_debut = sdf.parse(date_deb);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		String date_fin = request.getParameter("date_fin");
		try {
			 date_fine = sdf.parse(date_fin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String date_fin_inc = request.getParameter("date_fin_inc");
		try {
			 date_fin_insc = sdf.parse(date_fin_inc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		sdf.applyPattern("yyyy-MM-dd");
		Long nbr_team = Long.parseLong(request.getParameter("nbr_team"));
		EspaceRepository espacerepo = new EspaceRepository();
	    Espace espace = espacerepo.find(id_espace);
	    tournoi.setNom_trn(nom);
	    tournoi.setDescription_trn(description);
	    tournoi.setDate_debut(date_debut);
	    tournoi.setDate_fin(date_fine);
	    tournoi.setDate_fin_ins(date_fin_insc);
	    tournoi.setPrix(prix);
	    tournoi.setEspace(espace);
	    tournoi.setNbr_team(nbr_team);
	    if(statut == null)
		{
			tournoi.setStatut(0l);
		}else {
			tournoi.setStatut(1l);
		}
	    
	    repository.edit(tournoi);
		response.sendRedirect(request.getContextPath() + "/listeTournoi");
		
	}

}
