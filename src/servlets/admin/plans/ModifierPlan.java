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
 * Servlet implementation class ModifierPlan
 */
@WebServlet("/modifierPlan")
public class ModifierPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierPlan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Type_abonnementRepository abonnementRepository =new Type_abonnementRepository();
		Long id = Long.parseLong(request.getParameter("update"));
		Type_abonnement plan =abonnementRepository.find(id);
		request.setAttribute("plan", plan);
		request.getRequestDispatcher("Admin/Plan/modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Type_abonnementRepository abonnementRepository = new Type_abonnementRepository();
		Long id = Long.parseLong(request.getParameter("update"));
		String nom = request.getParameter("nom");
	    Double prix = Double.parseDouble(request.getParameter("prix"));
		String description = request.getParameter("description");
		String statut = request.getParameter("statut");
		Type_abonnement plan = abonnementRepository.find(id);
		plan.setNom_type(nom);
		plan.setDesc_type(description);
		plan.setPrix(prix);
		if(statut == null)
		{
			plan.setStatut(0l);
		}else {
			plan.setStatut(1l);
		}
		abonnementRepository.edit(plan);
		response.sendRedirect(request.getContextPath() + "/listPlan");
		}

}
