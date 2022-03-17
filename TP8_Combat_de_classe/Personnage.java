import java.util.Random;

public class Personnage {
	private int pv;
	private int pa;
	private boolean competenceSoinUse;
	private int nbProtected;
	private String action;
	
	/**
	 * 
	 */
	public Personnage() {
		this.pv = 5;
		this.pa = 1;
		this.competenceSoinUse = false;
		this.nbProtected = 0;
	}

	/**
	 * @return
	 */
	protected int getPv() {
		return pv;
	}

	/**
	 * @param pv
	 */
	protected void setPv(int pv) {
		this.pv = pv;
	}

	/**
	 * @return
	 */
	protected boolean getCompetenceSoinUse() {
		return competenceSoinUse;
	}

	/**
	 * @param competenceSoinUse
	 */
	protected void setCompetenceSoinUse(boolean competenceSoinUse) {
		this.competenceSoinUse = competenceSoinUse;
	}
	
	/**
	 * @return
	 */
	protected int getNbProtected() {
		return nbProtected;
	}

	/**
	 * @param nbProtected
	 */
	protected void setNbProtected(int nbProtected) {
		this.nbProtected = nbProtected;
	}

	/**
	 * @return
	 */
	protected int getPa() {
		return pa;
	}

	/**
	 * @param pa
	 */
	protected void setPa(int pa) {
		this.pa = pa;
	}
	
	/**
	 * @return
	 */
	protected String getAction() {
		return action;
	}

	/**
	 * @param action
	 */
	protected void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * @param adversaire
	 * 
	 * Le Cavalier gagnera +1 d'attaque s'il est contre un soldat.
	 * L'archer gagnera +1 d'attaque s'il est contre un cavalier.
	 * Le Soldat gagnera +1 d'attaque s'il est contre un archer.
	 */
	protected void competenceSpecial(Personnage adversaire) {
		switch(this.getClass().getSimpleName()) {
			case "Cavalier":
				if (adversaire.getClass().getSimpleName() == "Soldat") {
					this.setPa(this.getPa()+1);
				}
				break;
			case "Archer":
				if (adversaire.getClass().getSimpleName() == "Cavalier") {
					this.setPa(this.getPa()+1);
				}
				break;
			case "Soldat":
				if (adversaire.getClass().getSimpleName() == "Archer") {
					this.setPa(this.getPa()+1);
				}
				break;
		}
	}
	
	/**
	 * @param adversaire
	 * 
	 * Si l'adversaire ne s'est pas protegé l'adversaire perd le nombre de pv correspondant au nombre de pa du personnage
	 * Sinon l'attaque n'a lieu que si le coup critique oppère avec la probabilité qui est de 25% au départ et qui augmente de 25% par nombre de fois où l'advesaire s'est protégé
	 */
	protected void coupCritique(Personnage adversaire) {
		if(adversaire.getNbProtected() == 0) {
			adversaire.setPv(adversaire.getPv()-this.getPa());
		} else {
			int proba = 25;
			for (int i = 1; i<adversaire.getNbProtected(); i++) {
				proba+=25;
			}
			int chance = 100 / proba;
	        Random random = new Random();
	        int hazard = random.nextInt(chance);
	        boolean coupCritique = hazard == 0;
	        if(coupCritique) {
	    		adversaire.setPv(adversaire.getPv()-this.getPa());
	        }
		}
        
	}
	
	/**
	 * reset le nombre de protection à 0
	 * enregistre l'action "attaque" dans l'attribut action
	 */
	protected void attaquer() {
		this.setNbProtected(0);
		this.setAction("attaque");
	}
	
	/**
	 * 
	 * incremente le nombre de protection
	 * enregistre l'action "protege" dans l'attribut action
	 */
	protected void seProteger() {
		this.setNbProtected(this.getNbProtected()+1);
		this.setAction("protege");
	}

	/**
	 * 
	 * reset le nombre de protection à 0
	 * ajoute 2 au nombre de pv total du personnage
	 * affecte à true l'attribut competenceSoinUse
	 * enregistre l'action "soigne" dans l'attribut action
	 */
	protected void seSoigner() {
		this.setNbProtected(0);
		this.setPv(this.getPv()+2);
		this.setCompetenceSoinUse(true);
		this.setAction("soigne");
	}
	
	@Override
	public String toString() {
		return "Personnage [pv=" + pv + ", pa=" + pa + ", competenceSoinUse=" + competenceSoinUse + ", nbProtected="
				+ nbProtected + ", action=" + action + "]";
	}

}
