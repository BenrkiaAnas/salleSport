package servlets.gerant.promotion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PromotionRepository;
import entities.Promotion;

/**
 * Servlet implementation class ModificationPromotion
 */
@WebServlet("/modificationPromotion")
public class ModificationPromotion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationPromotion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("update"));
		PromotionRepository promo = new PromotionRepository();
		Promotion promotion = promo.find(id);
		request.setAttribute("promotion", promotion);
		request.getRequestDispatcher("Gerant/Promotion/modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("update"));
		PromotionRepository promo = new PromotionRepository();
		Promotion promotion = promo.find(id);
		Double discount = Double.parseDouble(request.getParameter("discount"));	
		String statut = request.getParameter("statut");
		promotion.setDiscount(discount);
		if(statut == null)
		{
			promotion.setStatut(0l);
		}else {
			promotion.setStatut(1l);
		}
		
		promo.edit(promotion);
		response.sendRedirect(request.getContextPath() + "/listePromotion");
		
		
	}

}
