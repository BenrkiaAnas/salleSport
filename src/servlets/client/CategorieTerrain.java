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
 * Servlet implementation class CategorieTerrain
 */
@WebServlet("/categorieTerrain")
public class CategorieTerrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorieTerrain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("categorie"));
		
        AccessoireRepository accessoireRepository = new AccessoireRepository();
		
		EspaceRepository espaceRepository = new EspaceRepository();
		
		List<Espace> espaces = espaceRepository.findAll();
		
		for(Espace espace: espaces)
		{
			accessoireRepository.getAllDataEspaceByCate(espace,id);
		}
		
		for(Espace espace: espaces)
		{
			System.out.println(espace.getTerrains());
			
			for(Terrain ter: espace.getTerrains())
			{
				System.out.println(ter.getAccessoires());
			}
		}
				
		request.setAttribute("espaces", espaces);
		
		request.getRequestDispatcher("Client/categorie_terrain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
