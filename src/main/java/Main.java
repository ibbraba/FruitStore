import com.doranco.dao.DaoFactory;

public class Main {

	public static void main(String[] args) {
		//Implémenter Class Role et Enum (Admin, Client, Magasinier)
		
		DaoFactory dao = new DaoFactory();
		dao.getInstance();
	}

}
