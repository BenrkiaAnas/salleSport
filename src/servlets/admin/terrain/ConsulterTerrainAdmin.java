package servlets.admin.terrain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TerrainRepository;
import entities.Terrain;

/**
 * Servlet implementation class ConsulterTerrainAdmin
 */
@WebServlet("/consulterTerrainAdmin")
public class ConsulterTerrainAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterTerrainAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TerrainRepository repository =new TerrainRepository();
		Long id = Long.parseLong(request.getParameter("consulter"));
		Terrain terrain = repository.find(id);
		request.setAttribute("terrain", terrain);
		request.getRequestDispatcher("Admin/Terrain/consulter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
