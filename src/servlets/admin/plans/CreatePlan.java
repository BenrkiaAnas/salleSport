package servlets.admin.plans;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Type_abonnementRepository;
import entities.Type_abonnement;

/**
 * Servlet implementation class CreatePlan
 */
@WebServlet("/createPlan")
public class CreatePlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePlan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Admin/Plan/create.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    Type_abonnementRepository abonnementRepository = new Type_abonnementRepository();
	    String nom = request.getParameter("nom");
	    Double prix = Double.parseDouble(request.getParameter("prix"));
		String description = request.getParameter("description");
	    Type_abonnement plan = new Type_abonnement(null,nom, prix, description, null,1l);
	    abonnementRepository.create(plan);
	    System.out.println(plan);
	    response.sendRedirect(request.getContextPath() + "/listPlan");
	}
	

}
