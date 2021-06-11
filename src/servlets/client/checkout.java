package servlets.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccessoireRepository;
import dao.PersonneRepository;
import dao.ReservationRepository;
import dao.TerrainRepository;
import entities.Accessoire;
import entities.Horraire;
import entities.Personne;
import entities.Reservation;
import entities.Terrain;

/**
 * Servlet implementation class checkout
 */
@WebServlet("/checkout")
public class checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Long id_ter = (Long) session.getAttribute("id_terrain");
		Long id_access = (Long) session.getAttribute("id_accessoires");
		TerrainRepository terrainRepository = new TerrainRepository();
		System.out.println(id_ter);
		Terrain terrain = terrainRepository.find(id_ter);
		AccessoireRepository accessoireRepository = new AccessoireRepository();
		accessoireRepository.getAccessoireByTerrain(terrain);
		request.setAttribute("terrain", terrain);
		Accessoire accessoire = accessoireRepository.find(id_access);
		System.out.println(terrain.getAccessoires());
		request.setAttribute("accessoire", accessoire);
		Personne personne =   (Personne) session.getAttribute("personne");
		request.setAttribute("personne", personne);
		Double prix_total = terrain.getPrix() + accessoire.getPrix_acc();
		
		request.setAttribute("prix_total", prix_total);
		request.getRequestDispatcher("Client/checkout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Long id_ter = (Long) session.getAttribute("id_terrain");
		Long id_access = (Long) session.getAttribute("id_accessoires");
		
		TerrainRepository terrainRepository = new TerrainRepository();
		Terrain terrain = terrainRepository.find(id_ter);
		AccessoireRepository accessoireRepository = new AccessoireRepository();
		Accessoire accessoire = accessoireRepository.find(id_access);
		ReservationRepository reservationRepository = new ReservationRepository();
		
		accessoireRepository.getAccessoireByTerrain(terrain);
		
		Personne client = (Personne) session.getAttribute("personne");
		
		PersonneRepository personneRepository = new PersonneRepository();
		

		
		List<Accessoire> accessoires = new ArrayList<Accessoire>();
		accessoires.add(accessoire);
		
		Horraire horraire = new Horraire();
		

		Reservation reservation = new Reservation(null, horraire, client, accessoires);
		reservationRepository.create(reservation);
		
		response.sendRedirect(request.getContextPath() + "/home");
		
		
	}

}
