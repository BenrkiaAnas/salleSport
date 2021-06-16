package servlets.gerant.promotion_categorie;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Promotion_categorieRepository;
import entities.Personne;
import entities.Promotion_categorie;

/**
 * Servlet implementation class listePromotionCategorie
 */
@WebServlet("/listePromotionCategorie")
public class listePromotionCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listePromotionCategorie() {
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
		Promotion_categorieRepository promotion_categorieRepository =  new Promotion_categorieRepository();
		List<Promotion_categorie> promotion_categories = promotion_categorieRepository.getAllPromotionCategorieByUser(currentUser.getId_personne());
		request.setAttribute("promotion_categories", promotion_categories);
		request.getRequestDispatcher("Gerant/Promotion_Categorie/liste.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
