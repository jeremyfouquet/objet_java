import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {

	private String nom;
	private int fiche;

	/**
	 * @param nom
	 */
	public Player(String nom) {
		this.nom = nom;
		this.fiche = 10;
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
	protected int getFiche() {
		return fiche;
	}

	/**
	 * @param fiche
	 */
	protected void setFiche(int fiche) {
		this.fiche = fiche;
	}
	
	/**
	 * @param arrayDes
	 * @return
	 * 
	 * Lancé de 3 dés provenant d'une liste passé en paramettre
	 * après le lancé la liste des dés est trié puis le total des 3 faces
	 * est renvoyé par la methode
	 */
	/**
	 * @param arrayDes
	 * @return
	 */
	protected int randomDes(List<Des> arrayDes) {
		System.out.println("\n"+this.getNom()+" jette les dés : ");
		int total = 0;
		for (Des des : arrayDes) {
			des.setFace(roleDice(new Random()));
			total += des.getFace();
		}
		sortDesIncrease(arrayDes);
		System.out.print(arrayDes.toString() + " ; ");
		return total;
	}
	
	/**
	 * @param arrayDes
	 * @param sc
	 * @return
	 * 
	 * Pour chacun des dés de la liste passé en paramettre de la methode
	 * le player à le choix de rejouer ou non le dés, si le player à rejoué au moins
	 * 1 dés la méthode trie la liste de dés puis renvoi true sinon elle renvoi false
	 * 
	 * POUR PLUS DE SIMPLICITE ET EVITER TOUTE ERREUR LORS DE LA QUESTION POUR RELANCER
	 * LES DES SI LE PLAYER REPOND AUTRE CHOSE QUE 'o' CELA EST CONCIDERE COMME UN 'NON'
	 */
	protected boolean replayDes(List<Des> arrayDes, Scanner sc) {
		boolean twice = false;
		int i = 0;
		for (Des des : arrayDes) {
			i++;
			System.out.println("Souhaitez vous rejouer le des n°"+ i + " ? o/n");
			String resp = sc.nextLine();
			char yesOrNo = 0;
			if (resp.length() > 0) { 
				yesOrNo = resp.charAt(0);
			}
			if (yesOrNo == 'o') {
				des.setFace(roleDice(new Random()));
				twice = true;
			}
		}
		if(twice) {
			sortDesIncrease(arrayDes);
			System.out.print(arrayDes.toString());
		}
		return twice;
	}
	
	/**
	 * @param arrayDes
	 * 
	 * Methode qui trie par ordre croissant la liste d'objet Des passé en
	 * paramettre en fonction de la face du dés
	 */
	protected void sortDesIncrease(List<Des> arrayDes) {
		Collections.sort(arrayDes, new Comparator<Des>() {
			public int compare(Des d1, Des d2) {
				   int des1 = d1.getFace();
				   int des2 = d2.getFace();
				   return des1 - des2;
			}
		});
	}
	
	/**
	 * @param random
	 * @return
	 * 
	 * Methode qui retourne un chiffre entre 1 et 6
	 */
	protected int roleDice(Random random) {
		int face = 1+random.nextInt(5);
		return face;
	}

	@Override
	public String toString() {
		return "Player [nom=" + nom + ", fiche=" + fiche + "]";
	}

}
