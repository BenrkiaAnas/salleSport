package servlets.admin.categories;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

import dao.CategorieRepository;
import entities.Categorie;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;

/**
 * Servlet implementation class CreateCategorie
 */
@WebServlet("/createCategorie")
@MultipartConfig
public class CreateCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER =
            Logger.getLogger(CreateCategorie.class.getCanonicalName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Admin/Categorie/create.jsp").forward(request, response);

	}
	


	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
	
	
	

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategorieRepository categorieRepository = new CategorieRepository();
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
				Categorie categorie = new Categorie(null, nom, description, filename, 1l);
				categorieRepository.create(categorie);
				
				//request.getRequestDispatcher("Admin/Categorie/list.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath() + "/listeCategorie");
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
