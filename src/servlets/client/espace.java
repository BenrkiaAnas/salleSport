package servlets.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessoireRepository;
import dao.CategorieRepository;
import dao.EspaceRepository;
import entities.Categorie;
import entities.Espace;
import entities.Terrain;

/**
 * Servlet implementation class espace
 */
@WebServlet("/espace")
public class espace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public espace() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id_esp"));
		AccessoireRepository accessoireRepository = new AccessoireRepository();
		
		EspaceRepository espaceRepository = new EspaceRepository();
		
		
		List<Espace> espaces = espaceRepository.findAll();
		
		request.setAttribute("espaces", espaces);
		
		
		for(Espace espace: espaces)
		{
			accessoireRepository.getAllDataEspace(espace);
		}
		
		Espace espace = espaceRepository.find(id);
		
	
		accessoireRepository.getAllDataEspace(espace);
		
		
		System.out.println(espace);
		
		

		
		request.setAttribute("espace", espace);
		request.getRequestDispatcher("Client/espace.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
