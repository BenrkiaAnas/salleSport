package servlets.gerant.espaces;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EspaceRepository;
import entities.Espace;
import entities.Personne;

/**
 * Servlet implementation class ListeEspace
 */
@WebServlet("/listeEspace")
public class ListeEspace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeEspace() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EspaceRepository espaceRepository = new EspaceRepository();
		
		HttpSession session = request.getSession();
        Personne currentUser = (Personne) session.getAttribute("personne");
        
        List<Espace> espaces = espaceRepository.findEspaceByGerant(currentUser.getId_personne());
        request.setAttribute("espaces", espaces);
        System.out.print(espaces);
        request.getRequestDispatcher("Gerant/Espace/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
