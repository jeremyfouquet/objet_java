import java.util.Scanner;

public class Player {

	private String nom;
	private Personnage personnage;

	/**
	 * @param nom
	 */
	public Player(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return
	 */
	protected String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	protected void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return
	 */
	protected Personnage getPersonnage() {
		return personnage;
	}

	/**
	 * @param personnage
	 */
	protected void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}
	
	/**
	 * @param sc
	 * 
	 * Tant que le joueur n'a pas choisi une action parmis 1, 2 ou 3 il lui est demandé
	 * de choisir l'une des 3 actions correspondantes :
	 * Si le personnage à déjà utilisé soigné une fois dans la partie l'option 3 n'est pas proposé
	 * 1 = Attaquer
	 * 2 = Proteger
	 * 3 = Soigner
	 * Puis la methode du personnage coorespondante est éxecuté
	 */
	protected void choix(Scanner sc) {
		int action = 0;
		while (action != 1 && action != 2 && action != 3) {
			System.out.println("Choisissez une action : ");
			System.out.println("Attaquer => tapez 1");
			System.out.println("Proteger => tapez 2");
			if(!getPersonnage().getCompetenceSoinUse()) {System.out.println("Soigner => tapez 3");};
			action = sc.nextInt();
			sc.nextLine();
			switch(action) {
				case 1: 
					getPersonnage().attaquer();
					break;
				case 2:
					getPersonnage().seProteger();
					break;
				case 3:
					if(getPersonnage().getCompetenceSoinUse()) {
						System.out.println("Choisissez 1 ou 2");
						action = 0;
					} else {
						getPersonnage().seSoigner();
					}
					break;
				default:
					System.out.println("Choisissez 1, 2 ou 3");
					break;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Player [nom=" + nom + "]";
	}
	
}
