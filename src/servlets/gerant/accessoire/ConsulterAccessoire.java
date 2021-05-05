package servlets.gerant.accessoire;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessoireRepository;
import entities.Accessoire;
@WebServlet("/consulterAccessoire")
public class ConsulterAccessoire extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public ConsulterAccessoire() {
		// TODO Auto-generated constructor stub
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("consulter"));
		AccessoireRepository accessoireRepository = new AccessoireRepository();
		Accessoire accessoire =  accessoireRepository.find(id);
		request.setAttribute("accessoire", accessoire);
		
		request.getRequestDispatcher("Gerant/Accessoire/consulter.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
