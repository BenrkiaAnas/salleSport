package app;

import java.util.List;

import dao.AbonnementRepository;
import dao.CategorieRepository;
import dao.EspaceRepository;
import dao.PersonneRepository;
import dao.PromotionRepository;
import dao.TournoiRepository;
import dao.Type_abonnementRepository;
import entities.Abonnement;
import entities.Espace;
import entities.Personne;
import entities.Tournoi;
import entities.Type_abonnement;

public class Application {
	public static void main(String[] args) {
		PersonneRepository personneRepository = new PersonneRepository();
		
		//Type_abonnementRepository abonnementRepo = new Type_abonnementRepository();
		//List<Type_abonnement> plan = abonnementRepo.getAllPlans();
		
	
		
		//Personne personne = personneRepository.find(1l);
		//Personne personneFind = personneRepository.findBy("anas@gmail.com", "123456");
		//System.out.println(personne);
		//System.out.println(personneFind);
		
		/*Personne p1 = new Personne(null, "anas", "ben", "anas@gmail.com", "123456", 1l, 1l);
		Personne p2 = new Personne(null, "aissa", "nd", "nadi@gmail.com", "123456", 2l, 1l);
		Personne p3 = new Personne(null, "ayoub", "bk", "baki@gmail.com", "123456", 1l, 0l);
		Personne p4 = new Personne(null, "aymane", "abdl", "aymane@gmail.com", "123456", 3l, 0l);
		personneRepository.create(p1,p2,p3,p4);*/
		
		/*Personne personneModifier = personneRepository.find(1l);
		personneModifier.setEmail("anas123@gmail.com");
		personneModifier.setStatut(0l);
		personneRepository.edit(personneModifier);*/
		
		/*Personne personneDelete = personneRepository.find(2l);
		personneRepository.delete(personneDelete);*/

		//CategorieRepository categorieRepository = new CategorieRepository();
		PromotionRepository promotionRepository = new PromotionRepository();
		
		
		
		
		
		
	}
}
