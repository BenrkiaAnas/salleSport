package servlets.gerant.reservation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservationRepository;
import dao.TerrainRepository;
import entities.Reservation;
import entities.Terrain;

/**
 * Servlet implementation class consulterReservation
 */
@WebServlet("/consulterReservation")
public class consulterReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consulterReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReservationRepository reservationRepository = new ReservationRepository();
		Long id = Long.parseLong(request.getParameter("consulter"));
		Reservation reservation = reservationRepository.find(id);
		request.setAttribute("reservation", reservation);
		request.getRequestDispatcher("Gerant/Reservation/consulter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
