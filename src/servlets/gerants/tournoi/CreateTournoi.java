package servlets.gerants.tournoi;

import java.awt.desktop.SystemEventListener;
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
 * Servlet implementation class TournoiGerant
 */
@WebServlet("/createTournoi")
public class CreateTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTournoi() {
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
        EspaceRepository espaceRepository = new EspaceRepository();
        System.out.println(currentUser);
        List<Espace> espaces = espaceRepository.findEspaceByGerant(currentUser.getId_personne());
        System.out.println(espaces);
        request.setAttribute("espaces", espaces);
		request.getRequestDispatcher("Gerant/Tournoi/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TournoiRepository repository = new TournoiRepository();
		Long id_espace = Long.parseLong(request.getParameter("espace"));
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		Double prix = Double.parseDouble(request.getParameter("prix"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date_deb = request.getParameter("date_deb");
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
		Long nbr_team = Long.parseLong(request.getParameter("nbr_team"));
		EspaceRepository espacerepo = new EspaceRepository();
	    Espace espace = espacerepo.find(id_espace);
	    Tournoi tournoi = new Tournoi(null, nom, description, prix, date_debut, date_fine, date_fin_insc, nbr_team, espace, 1l);
	    repository.create(tournoi);
		response.sendRedirect(request.getContextPath() + "/listTournoi");
		
		
	}

}
