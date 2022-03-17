import java.util.Random;
import java.util.Scanner;

public class Ia extends Player {
	
	/**
	 * @param nom
	 */
	public Ia(String nom) {
		super(nom);
	}
	
	/**
	 * @param sc
	 * 
	 * Polymorphisme d'héritage, la méthode random est remplacé par le choix proposé à l'utilisateur puisqu'il s'agit d'une Ia
	 */
	@Override
	protected void choix(Scanner sc) {
		int limit = 3;
		if(getPersonnage().getCompetenceSoinUse()) {
			limit = 2;
		}
        Random random = new Random();
		int action = 0;
		while (action != 1 && action != 2 && action != 3) {
			action = 1+random.nextInt(limit);
			System.out.println("action " + action);
			switch(action) {
				case 1: 
					getPersonnage().attaquer();
					break;
				case 2:
					getPersonnage().seProteger();
					break;
				case 3:
					getPersonnage().seSoigner();
					break;
				default:
					break;
			}
		}
	}

	@Override
	public String toString() {
		return "Player [nom=" + super.getNom() + "]";
	}

}
