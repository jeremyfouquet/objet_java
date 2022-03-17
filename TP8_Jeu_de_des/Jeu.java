import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author webdevelopment
 *
 */
public class Jeu {
	private static Player playerOne;
	private static Player playerTwo;
	private static List<Des> arrayDes = new ArrayList<Des>(3);
	private static Player vainqueur;
	
	/**
	 * @param args
	 * 
	 * Instancie 3 objet Des et les ajouts à la liste arrayDes
	 * Avant d'appeler la methode start
	 */
	public static void main(String[] args) {
		for(int i=0; i<3; i++) {
			Des des = new Des(1);
		    arrayDes.add(des);
		}
		start();
	}

	/**
	 * Instancie les 2 joueurs et démarre la partie
	 */
	public static void start() {
		Scanner sc = new Scanner(System.in);
		playerOne = addPlayer(sc, "joueur 1");
		humanOrAi(sc);
		partie(sc);
	}
	
	/**
	 * @param sc
	 * @param joueur
	 * @return
	 * 
	 * Demande le nom du nouveau player et creer une nouvelle instance de l'objet
	 * player avant de le retourner
	 */
	public static Player addPlayer(Scanner sc, String joueur) {
		System.out.println("Quel est le pseudo du "+joueur+" : ");
		String name = sc.nextLine();
		Player player = new Player(name);
		return player;
	}

	/**
	 * @param sc
	 * 
	 * Demande si le deuxieme joueur est un ami, 
	 * Si oui alors appel la methode pour ajouter un nouveau player
	 * Sinon le joueur 2 est instancié d'un Ia qui est un heritage de l'objet player
	 * 
	 * POUR PLUS DE SIMPLICITE ET EVITER TOUTE ERREUR LORS DE LA QUESTION POUR CHOISIR IA OU PLAYER
	 * SI LE PLAYER ONE REPOND AUTRE CHOSE QUE 'o' CELA EST CONCIDERE COMME UN 'NON' ET DONC CE SERA
	 * UN IA COMME 2eme PLAYER
	 */
	public static void humanOrAi(Scanner sc) {
		System.out.println("Voulez vous jouer contre un ami ? o/n");
		String resp = sc.nextLine();
		char yesOrNo = 0;
		if (resp.length() > 0) { 
			yesOrNo = resp.charAt(0);
		}
		if (yesOrNo == 'o') {
			playerTwo = addPlayer(sc, "joueur 2");
		} else {
			playerTwo = new Ia("IA");
		}
	}
	
	/**
	 * @param sc
	 * 
	 * Tant que tous les joueurs possède des fiches la partie continue Sinon la patie est terminé il est affiché quel est le vainqueur de la partie
	 * Tant qu'il n'y à pas de vainqueur (de tours) les joueurs lances les dés avec la methode randomDes() pour savoir qui commence
	 * Celui qui à le score le plus élevé devient le vainqueur (non de la partie mais du tour)
	 * Puis on appel la methode deroulementPartie();
	 */
	public static void partie(Scanner sc) {
		while(
				playerOne.getFiche() > 0 &&
				playerTwo.getFiche() > 0
		) {
			int totalPlayerOne;
			int totalPlayerTwo;
			while(vainqueur == null) {
				totalPlayerOne = playerOne.randomDes(arrayDes);
				totalPlayerTwo = playerTwo.randomDes(arrayDes);
				if(totalPlayerOne != totalPlayerTwo) {
					vainqueur = totalPlayerOne > totalPlayerTwo ? playerOne : playerTwo;
					System.out.println("\n\nLa Partie Commence !");
				}
			}
			if(vainqueur.equals(playerOne)) {
				deroulementPartie(vainqueur, playerTwo, sc);
			} else {
				deroulementPartie(vainqueur, playerOne, sc);
			}
			
		}
		System.out.println("\n\nPartie Terminé !");
		if (playerOne.getFiche() <= 0) {
			System.out.println("Vainqueur : " + playerOne.toString());
		} else {
			System.out.println("Vainqueur : " + playerTwo.toString());
		}
	}
	
	/**
	 * @param p1
	 * @param p2
	 * @param sc
	 * 
	 * Le vainqueur du tour lance les des et choisi ou non de relancer les dés
	 * Les 2eme joueur lance les dés à sont tour et s'il peut, choisi ou non de relancer les dés
	 * Si le joueur qui n'était pas vainqueur au tour précédent remporte la parie, la variable vainqueur est réaffecté de ce player.
	 */
	public static void deroulementPartie(Player p1, Player p2, Scanner sc) {
		int totalPlayer1 = 0;		
		int totalPlayer2 = 0;	
		p1.randomDes(arrayDes);
		boolean twice = p1.replayDes(arrayDes, sc);
		for (Des des : arrayDes) {
			totalPlayer1 += des.getFace();
		}
		if(arrayDes.get(0).equals(arrayDes.get(2))) {
			totalPlayer1 += 100;
		}
		p2.randomDes(arrayDes);
		if(twice) {
			p2.replayDes(arrayDes, sc);
		}
		for (Des des : arrayDes) {
			totalPlayer2 += des.getFace();
		}
		if(arrayDes.get(0).equals(arrayDes.get(2))) {
			totalPlayer2 += 100;
		}
		if (totalPlayer1 > totalPlayer2) {
			points(totalPlayer1, p1, p2);
		} else if (totalPlayer2 > totalPlayer1) {
			vainqueur = p2;
			points(totalPlayer2, p2, p1);
		} else {
			return;
		}
		System.out.println("\nRésultat du tour : " + p1.toString() + " ; " + p2.toString());
	}
	
	
	 /** 
	 * @param total
	 * @param p1
	 * @param p2
	 * 
	 * Si le vainqueur du tour fait un brelan il perd autant de fiche que le chiffre du brelan qui a été réalisé
	 * ou sinon seulement 1 fiche et en donne le nombre perdu à son adversaire
	 */
	public static void points(int total, Player p1, Player p2) {
		int nbFiche = total > 100 ? ((total - 100) / 3) : 1;
		p1.setFiche(p1.getFiche() - nbFiche);
		p2.setFiche(p2.getFiche() + nbFiche);
	}

}
