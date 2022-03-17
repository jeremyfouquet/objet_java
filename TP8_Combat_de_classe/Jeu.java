import java.util.Random;
import java.util.Scanner;

public class Jeu {
	private static Player playerOne;
	private static Player playerTwo;

	/**
	 * @param args
	 * 
	 * Appel pour chacun des 2 joueur addPlayer puis lance la partie
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		playerOne = addPlayer(sc, "joueur 1");
		playerTwo = addPlayer(sc, "joueur 2");
		playerOne.getPersonnage().competenceSpecial(playerTwo.getPersonnage());
		playerTwo.getPersonnage().competenceSpecial(playerOne.getPersonnage());
		System.out.println("joueur 1 : " + playerOne.toString() + " " + playerOne.getClass().getTypeName()+ " " + playerOne.getPersonnage().getClass().getTypeName());
		System.out.println("Personnage choisi : " + playerOne.getPersonnage().toString());
		System.out.println("joueur 2 : " + playerTwo.toString() + " " + playerTwo.getClass().getTypeName() + " " + playerTwo.getPersonnage().getClass().getTypeName());
		System.out.println("Personnage choisi : " + playerTwo.getPersonnage().toString() + "\n");
		partie(sc);
	}
	
	/**
	 * @param sc
	 * 
	 * Tant que l'un des personnages ont encore des pv la partie continue
	 * Sinon on affiche le vainqueur
	 */
	public static void partie(Scanner sc) {
		while(playerOne.getPersonnage().getPv() > 0 && playerTwo.getPersonnage().getPv() > 0) {
			playerOne.choix(sc);
			playerTwo.choix(sc);
			if(playerOne.getPersonnage().getAction() == "attaque") {
				playerOne.getPersonnage().coupCritique(playerTwo.getPersonnage());
			}
			if(playerTwo.getPersonnage().getAction() == "attaque") {
				playerTwo.getPersonnage().coupCritique(playerOne.getPersonnage());
			}
			System.out.println("Résultat ; ");
			System.out.println("joueur 1 : " + playerOne.getNom());
			System.out.println("joueur 1 : " + playerOne.getPersonnage().toString());
			System.out.println("joueur 2 : " + playerTwo.getNom());
			System.out.println("joueur 2 : " + playerTwo.getPersonnage().toString() + "\n");
		}
		System.out.println("\n\nPartie Terminé !");
		if (playerOne.getPersonnage().getPv() <= 0) {
			System.out.println("Vainqueur : " + playerTwo.toString());
		} else {
			System.out.println("Vainqueur : " + playerOne.toString());
		}
	}
	
	/**
	 * @Param sc
	 * 
	 * Demande un pseudo, un Type de Player (Ia/Humain) et un Type de personnage (Archer/Cavalier/Soldat)
	 * Puis renvoie le Player instancier à partir des choix précédent
	 */
	public static Player addPlayer(Scanner sc, String joueur) {
		boolean human = joueur == "joueur 2" ? humanOrAi(sc) : true;
		Player player = null;
		String name;
		System.out.println(joueur + " : ");
		if(human) {
			System.out.println("Choisissez un pseudo : ");
			name = sc.nextLine();
			while(!(name.length() > 0)) {
				System.out.println("Choisissez un pseudo : ");
				name = sc.nextLine();
			}
			player = new Player(name);
		} else {
			name = "IA";
			System.out.println(name);
			player = new Ia(name);
		}
		player.setPersonnage(choixPersonnage(sc, player.getClass().getSimpleName()));
		return player;
	}
	
	/**
	 * @param sc
	 * 
	 * Demande à l'utilisateur s'il souhaite que le joueur 2 soit un Ia ou un Humain et retourn un boolean en fonction de la reponse choisi
	 */
	public static boolean humanOrAi(Scanner sc) {
		char yesOrNo = 0;
		while(yesOrNo != 'o' && yesOrNo != 'n') {
			System.out.println("Voulez vous jouer contre un ami ? o/n");
			String resp = sc.nextLine();
			if (resp.length() > 0) { 
				yesOrNo = resp.charAt(0);
			} 
			if (resp.length() <= 0 || (yesOrNo != 'o' && yesOrNo != 'n')) {
				System.out.println("Répondre incorrecte ! o ou n");
				yesOrNo = 0;
			}
		}
		return yesOrNo == 'o' ? true : false;
	}
	
	/**
	 * @param sc
	 * 
	 * 	Demande au joueur s'il souhaite que son personnage soit un 
	 *  Archer, Soldat ou Cavalier et retourn l'instance du Personnage choisi
	 *  Si le joueur est une Ia alors le choix est fait par random
	*/
	public static Personnage choixPersonnage(Scanner sc, String type) {
		int resp = 0;
		Personnage personnage = null;
		while (resp != 1 && resp != 2 && resp != 3) {
			if (type == "Player") {
				System.out.println("Choisissez un personnage : ");
				System.out.println("Cavalier => tapez 1");
				System.out.println("Archer => tapez 2");
				System.out.println("Soldat => tapez 3");
				resp = sc.nextInt();
				sc.nextLine();
			} else {
		        Random random = new Random();
		        resp = 1+random.nextInt(3);
			}
			switch(resp) {
				case 1:
					personnage = new Cavalier();
					break;
				case 2:
					personnage = new Archer();
					break;
				case 3:
					personnage = new Soldat();
					break;
				default:
					System.out.println("Choisissez 1, 2 ou 3");
					break;
			}
		}
		return personnage;
	}


}
