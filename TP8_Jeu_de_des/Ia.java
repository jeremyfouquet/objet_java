import java.util.List;
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
	 * @param arrayDes
	 * @param arrayDes
	 * @return
	 * 
	 * Si les 3 faces sont identiques alors ne fait rien
	 * Sinon Si les 2 premiers dés de la liste passé en paramettre (plus faibles chiffres) sont identiques
	 * L'Ia relance le dernier dés uniquement
	 * Sinon Si les 2 derniers dés de la liste passé en paramettre (plus fort chiffres) sont identiques
	 * L'Ia relance le premier dés uniquement
	 * Sinon L'Ia relance le 2 dés les plus faibles
	 * Si l'Ia à rejoué au moins 1 dés la méthode trie la liste de dés puis renvoi true sinon elle renvoi false
	 * 
	 * Réponse Question 6 :
	 * 
	 * IA Efficace : La solution est bonne et permet de résoudre le problème
	 * rapidement ou en utilisant peu de ressources. Ça marche, c'est pas
	 * mal mais, on peut l'améliorer.
	 * En effet si il y à 2 paires de 1 l'IA tentera de relancer le troisième dés pour faire un brelant, mais la probabilité de le réaliser est 
	 * faible et cela n'en vaudra pas la peine comparer à relancer tous les dés. Puisque bien qu'il s'agisse d'une combinaison spéciale elle ne donne qu'une seule fiche.
	 * Et cela n'est pas pris en compte.
	 */
	@Override
	protected boolean replayDes(List<Des> arrayDes, Scanner sc) {
		boolean twice = false;
		if(arrayDes.get(0).equals(arrayDes.get(2))) {
			return twice;
		} else if(arrayDes.get(0).equals(arrayDes.get(1))) {
			arrayDes.get(2).setFace(roleDice(new Random()));
			twice = true;	
		} else if (arrayDes.get(1).equals(arrayDes.get(2))) {
			arrayDes.get(0).setFace(roleDice(new Random()));
			twice = true;	
		} else {	
			for (int i=0; i<2; i++) {
				Random random = new Random();
				int face = 1+random.nextInt(5);
				arrayDes.get(i).setFace(face);
				twice = true;
			}
		}
		if(twice) {
			sortDesIncrease(arrayDes);
			System.out.print(arrayDes.toString());
		}
		return twice;
	}

	@Override
	public String toString() {
		return "Ia [nom=" + super.getNom() + ", fiche=" + super.getFiche() + "]";
	}


}
