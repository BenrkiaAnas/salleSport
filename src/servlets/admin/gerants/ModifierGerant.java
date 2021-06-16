package servlets.admin.gerants;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AbonnementRepository;
import dao.PersonneRepository;
import entities.Abonnement;
import entities.Personne;

/**
 * Servlet implementation class ModifierGerant
 */
@WebServlet("/modifierGerant")
public class ModifierGerant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierGerant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("update"));
		AbonnementRepository abonnementRepository = new AbonnementRepository();
		Abonnement abonnements = abonnementRepository.findByGerant(id);
		request.setAttribute("gerant", abonnements.getPersonne());
		request.getRequestDispatcher("Admin/Gerant/modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("update"));
		AbonnementRepository abonnementRepository =new AbonnementRepository();
		Abonnement abonnement = abonnementRepository.findByGerant(id);
		PersonneRepository personneRepository = new PersonneRepository();
		Personne personne = personneRepository.find(abonnement.getPersonne().getId_personne());	
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		String statut = request.getParameter("Status");
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setEmail(email);
		System.out.println(personne);
		if (mdp!="")
		{
			personne.setPwd(mdp);
		}
		if(statut == null)
		{
			personne.setStatut(0l);
		}
		else 
		{
			personne.setStatut(1l);
		}
		
		personneRepository.edit(personne);
		response.sendRedirect(request.getContextPath() + "/listeGerant");
		
		
		}
		
		
		
	}
	

