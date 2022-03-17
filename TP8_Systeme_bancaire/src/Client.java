import java.util.ArrayList;
import java.util.List;

public class Client {
	public static List<Compte> mesComptes = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub();
	}
	
	/**
	 * @param typeCompte
	 * 
	 * ouvrir un compte de type : SI
	 * 1 = Individuel
	 * 2 = Conjoint
	 */
	public static void ouvrirCompte(String typeCompte) {
		Compte nouveauCompte = null;
		if (typeCompte == "Individuel") {
			nouveauCompte = new Individuel();
		} else if (typeCompte == "Conjoint"){
			nouveauCompte = new Conjoint();
		} else {
			return;
		}
		mesComptes.add(nouveauCompte);
	}
	
	/**
	 * @param idCompte
	 * 
	 * cloturer un compte à partir d'un id si l'id n'existe pas alors rien ne se passe
	 */
	public static void cloturerCompte(int idCompte) {
		int i = 0;
		int toRemove = -1;
		boolean closed = false;
		while(i != toRemove && i < mesComptes.size()) {
		    if (mesComptes.get(i).getId() == idCompte) {
		    	toRemove = i;
		    	closed = true;
		    }
		    i++;
		}
		if(closed) {
			mesComptes.remove(mesComptes.get(toRemove));
		}
	}

}
