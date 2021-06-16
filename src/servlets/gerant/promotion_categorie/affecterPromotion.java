package servlets.gerant.promotion_categorie;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategorieRepository;
import dao.EspaceRepository;
import dao.PromotionRepository;
import dao.Promotion_categorieRepository;
import entities.Categorie;
import entities.Espace;
import entities.Personne;
import entities.Promotion;
import entities.Promotion_categorie;

/**
 * Servlet implementation class affecterPromotion
 */
@WebServlet("/affecterPromotion")
public class affecterPromotion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public affecterPromotion() {
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
		List<Espace> espaces = espaceRepository.findEspaceByGerant(currentUser.getId_personne());
		
		PromotionRepository promotionRepository = new PromotionRepository();
		List<Promotion> promotions = promotionRepository.getAllPromotionByUser(currentUser.getId_personne());
		
		CategorieRepository categorieRepository = new CategorieRepository();
		List<Categorie> categories = categorieRepository.findAll();
		
		request.setAttribute("promotions", promotions);
		request.setAttribute("espaces", espaces);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("Gerant/Promotion_Categorie/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long categorie = Long.parseLong(request.getParameter("categorie"));
		Long promotion = Long.parseLong(request.getParameter("promotion")); 
		Long espace = Long.parseLong(request.getParameter("espace"));
		
		CategorieRepository categorieRepository = new CategorieRepository();
		Categorie categorie2 = categorieRepository.find(categorie);
		
		PromotionRepository promotionRepository = new PromotionRepository();
		Promotion promotion2 = promotionRepository.find(promotion);
		
		EspaceRepository espaceRepository = new EspaceRepository();
		Espace espace2 = espaceRepository.find(espace);
		
		Promotion_categorieRepository promotion_categorieRepository = new Promotion_categorieRepository();
		Promotion_categorie promotion_categorie = new Promotion_categorie(null, espace2, categorie2, promotion2);
		promotion_categorieRepository.create(promotion_categorie);
		
		response.sendRedirect(request.getContextPath() + "/listePromotionCategorie");
		
		
		
	}

}
