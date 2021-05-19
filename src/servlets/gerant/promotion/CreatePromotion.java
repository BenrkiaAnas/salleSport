package servlets.gerant.promotion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PersonneRepository;
import dao.PromotionRepository;
import entities.Personne;
import entities.Promotion;

/**
 * Servlet implementation class CreatePromotion
 */
@WebServlet("/createPromotion")
public class CreatePromotion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePromotion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("Gerant/Promotion/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        Personne currentUser = (Personne) session.getAttribute("personne");	
		PromotionRepository promo = new PromotionRepository();
		Double discount = Double.parseDouble(request.getParameter("discount"));		
		PersonneRepository personneRepository = new PersonneRepository();
		Personne personne = personneRepository.find(currentUser.getId_personne());
		Promotion promotion = new Promotion(null, discount, 1l, personne);
		promo.create(promotion);
		response.sendRedirect(request.getContextPath() + "/listePromotion");
		
	}
	

}
