package servlets.gerant.accessoire;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccessoireRepository;
import entities.Accessoire;
import entities.Personne;
@WebServlet("/listAccessoire")
public class ListAccessoire extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public ListAccessoire() {
		// TODO Auto-generated constructor stub
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccessoireRepository accessoireRepository = new AccessoireRepository();
		HttpSession session = request.getSession();
        Personne currentUser = (Personne) session.getAttribute("personne");
		List<Accessoire> accessoires = accessoireRepository.getAccessoireByGerant(currentUser);
		//List<Accessoire> accessoires = accessoireRepository.findAll();
		request.setAttribute("accessoire", accessoires);
		request.getRequestDispatcher("Gerant/Accessoire/list.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
