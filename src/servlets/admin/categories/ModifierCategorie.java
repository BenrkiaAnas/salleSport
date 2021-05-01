package servlets.admin.categories;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CategorieRepository;
import entities.Categorie;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileOutputStream;


/**
 * Servlet implementation class ModifierCategorie
 */
@WebServlet("/modifierCategorie")
@MultipartConfig
public class ModifierCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER =
            Logger.getLogger(ModifierCategorie.class.getCanonicalName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Long id = Long.parseLong(request.getParameter("update"));
		CategorieRepository categorieRepository = new CategorieRepository();
		Categorie categorie = categorieRepository.find(id);
		request.setAttribute("categorie", categorie);
		
		request.getRequestDispatcher("Admin/Categorie/modifier.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Long id = Long.parseLong(request.getParameter("update"));
		CategorieRepository categorieRepository = new CategorieRepository();
		Categorie categorie = categorieRepository.find(id);
		String image = categorie.getImg_cate();
		
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		String statut = request.getParameter("statut");
		
		Part part = request.getPart("file");
		String filename = part.getSubmittedFileName(); 
		
		try (PrintWriter out = response.getWriter()) {
			
			
			if(filename != "")
			{
				//String path = getServletContext().getRealPath("/"+"images"+File.separator+filename);
				String path = System.getenv("HOMEDRIVE")+System.getenv("HOMEPATH")+File.separator+"eclipse"+File.separator+"salleSport"+File.separator+"WebContent"+File.separator+"images"+File.separator+filename;
				InputStream ins = part.getInputStream();
				boolean success = uploadFile(ins, path);
				System.out.println();
				
			}
			else {
				
				filename = image;
				
			}
			
			categorie.setNom_cate(nom);
			categorie.setDesc_cate(description);
			System.out.println(filename);
			if(statut == null)
			{
				categorie.setStatut(0l);
			}else {
				categorie.setStatut(1l);
			}
			
			categorie.setImg_cate(filename);
			categorieRepository.edit(categorie);
			
			
			System.out.println("hna");
			System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath() + "/listeCategorie");
			
			
			
			
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
