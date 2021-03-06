package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.Repository;
import dao.PersonneRepository;
import entities.Personne;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonneRepository personneRepository = new PersonneRepository();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Personne personneLogged = personneRepository.findBy(email, password);
		System.out.println(personneLogged);
		if(personneLogged.getStatut() == 1)
		{
			if(personneLogged.getId_role() == 1)
			{
				System.out.println("3andi access role");
				HttpSession session = request.getSession();
				session.setAttribute("personne", personneLogged);
				response.sendRedirect(request.getContextPath() + "/dashboard");

			}else {
				System.out.println("3andi access role");
				HttpSession session = request.getSession();
				session.setAttribute("personne", personneLogged);
				response.sendRedirect(request.getContextPath() + "/dashboardGerant");
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
