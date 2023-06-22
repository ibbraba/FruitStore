import com.doranco.dao.DaoFactory;
import com.doranco.daoImpl.UtilisateurDaoImpl;
import com.doranco.metier.Utilisateur;

public class Main {

	public static void main(String[] args) {
		
		//DaoFactory d = new DaoFactory();
		//d.getInstance();
		
		UtilisateurDaoImpl utilisateurdDaoImpl = new UtilisateurDaoImpl();
		Utilisateur utilisateur = utilisateurdDaoImpl.findByCredentials("user@test.com", "test");
		System.out.println(utilisateur.getNom());
	}

}
