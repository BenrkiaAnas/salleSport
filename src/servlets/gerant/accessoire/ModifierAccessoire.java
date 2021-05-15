package servlets.gerant.accessoire;

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
import javax.servlet.http.Part;

import dao.AccessoireRepository;
import dao.CategorieRepository;
import entities.Accessoire;
import entities.Categorie;
import servlets.admin.categories.ModifierCategorie;
@WebServlet("/modifierAccessoire")
@MultipartConfig
public class ModifierAccessoire extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER =
            Logger.getLogger(ModifierAccessoire.class.getCanonicalName());

	public ModifierAccessoire() {
		// TODO Auto-generated constructor stub
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("update"));
		CategorieRepository categorieRepository = new CategorieRepository();
		List<Categorie> categories = categorieRepository.findAll();
		request.setAttribute("categories", categories);
		AccessoireRepository accessoireRepository = new AccessoireRepository();
		Accessoire accessoire = accessoireRepository.find(id);
		request.setAttribute("accessoire", accessoire);
		
		request.getRequestDispatcher("Gerant/Accessoire/modifier.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("update"));
		AccessoireRepository accessoireRepository = new AccessoireRepository();
		Accessoire accessoire = accessoireRepository.find(id);
		String image = accessoire.getImage_acc();
		String nom = request.getParameter("nom");
		Double prix = Double.parseDouble(request.getParameter("prix"));
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
			
			accessoire.setNom_acc(nom);
			accessoire.setDescription(description);
			accessoire.setPrix_acc(prix);
			System.out.println(filename);
			if(statut == null)
			{
				accessoire.setStatut(0l);
			}else {
				accessoire.setStatut(1l);
			}
			
			accessoire.setImage_acc(filename);
			accessoireRepository.edit(accessoire);
			
			
			System.out.println("hna");
			System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath() + "/listAccessoire");
			
			
			
			
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
