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
import servlets.admin.categories.CreateCategorie;
@WebServlet("/createAccessoire")
@MultipartConfig
public class CreateAccessoire extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER =
            Logger.getLogger(CreateAccessoire.class.getCanonicalName());
	public CreateAccessoire() {
		// TODO Auto-generated constructor stub
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategorieRepository categorieRepository = new CategorieRepository();
		List<Categorie> categories = categorieRepository.findAll();
		request.setAttribute("categorie", categories);
		request.getRequestDispatcher("Gerant/Accessoire/create.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String nom = request.getParameter("nom");
	String description = request.getParameter("description");
	Double prix = Double.parseDouble(request.getParameter("prix"));
	Long idcategorie = Long.parseLong(request.getParameter("categorie"));
	CategorieRepository categorierepo = new CategorieRepository();
	Categorie categorie = categorierepo.find(idcategorie);
	
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
		    AccessoireRepository accessoireRepository = new AccessoireRepository();
			Accessoire accessoire = new Accessoire(null, nom, prix, filename,description, categorie, 1l);
		    accessoireRepository.create(accessoire);
			response.sendRedirect(request.getContextPath() + "/listAccessoire");
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
