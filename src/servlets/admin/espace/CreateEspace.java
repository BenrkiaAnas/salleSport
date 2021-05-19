package servlets.admin.espace;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.EspaceRepository;
import dao.PersonneRepository;
import entities.Espace;
import entities.Personne;

/**
 * Servlet implementation class CreateEspace
 */
@WebServlet("/createEspace")
@MultipartConfig
public class CreateEspace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER =
            Logger.getLogger(CreateEspace.class.getCanonicalName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEspace() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersonneRepository personneRepository = new PersonneRepository();
		List<Personne> gerants = personneRepository.getAllGerant();
		request.setAttribute("gerants", gerants);
		request.getRequestDispatcher("Admin/Espace/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		Long id_personne = Long.parseLong(request.getParameter("gerant"));
		PersonneRepository personneRepository = new PersonneRepository();
		Personne gerant = personneRepository.find(id_personne);
		
		response.setContentType("text/html;charset=UTF-8");
		EspaceRepository espaceRepository = new EspaceRepository();
		
		HttpSession session = request.getSession();
        Personne currentUser = (Personne) session.getAttribute("personne");	
        
		Personne creator = personneRepository.find(currentUser.getId_personne());
		
		try (PrintWriter out = response.getWriter()) {
			
			Part part = request.getPart("file");
			String filename = part.getSubmittedFileName();
			//String path = getServletContext().getRealPath("/"+"images"+File.separator+filename);
			String path = System.getenv("HOMEDRIVE")+System.getenv("HOMEPATH")+File.separator+"eclipse"+File.separator+"salleSport"+File.separator+"WebContent"+File.separator+"images"+File.separator+filename;
			InputStream ins = part.getInputStream();
			boolean success = uploadFile(ins, path);
			System.out.println();
			if(success)
			{
				Espace espace = new Espace(null, nom, null, description, filename, creator, gerant, 0l, 0l);
		
				
				//request.getRequestDispatcher("Admin/Categorie/list.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath() + "/espaces");
			}else {
				System.out.println("Error Upload");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public boolean uploadFile(InputStream is, String path)
	{
		boolean test = false;
		
		try {
			byte[] byt = new byte[is.available()];
			is.read();
			FileOutputStream fops = new FileOutputStream(path);
			fops.write(byt);
			fops.flush();
			fops.close();
			
			test = true;
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
		return test;
	}

}
