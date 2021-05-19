package servlets.admin.espace;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.EspaceRepository;
import entities.Espace;

/**
 * Servlet implementation class ModifierEspaceAdmin
 */
@WebServlet("/modifierEspaceAdmin")
@MultipartConfig
public class ModifierEspaceAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER =
            Logger.getLogger(ModifierEspaceAdmin.class.getCanonicalName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierEspaceAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EspaceRepository espaceRepository = new EspaceRepository();
		Long id = Long.parseLong(request.getParameter("update"));
		Espace espace = espaceRepository.find(id);
		request.setAttribute("espace", espace);
		request.getRequestDispatcher("Admin/Espace/modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("update"));
		EspaceRepository espaceRepository = new EspaceRepository();
		Espace espace = espaceRepository.find(id);
		
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		
		response.setContentType("text/html;charset=UTF-8");
		
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
				espace.setNom_esp(nom);
				espace.setDesc_esp(description);
				espace.setImg_esp(filename);
				if(espace.getLiked() == null)
				{
					espace.setLiked(0l);
				}
				if(espace.getDeslike() == null)
				{
					espace.setDeslike(0l);
				}
				espaceRepository.edit(espace);
				
				//request.getRequestDispatcher("Admin/Categorie/list.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath() + "/listeEspace");
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
