public class Compte {
	private static int count = 0; 
	private int id;
	private float solde;

	/**
	 * 
	 */
	public Compte() {
		this.id = ++count; 
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return
	 */
	protected int getId() {
		return id;
	}

	/**
	 * @return
	 */
	protected float getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 */
	protected void setSolde(float solde) {
		this.solde = solde;
	}

	/**
	 * @param depot
	 */
	protected void crediter(float depot) {
		this.setSolde(this.getSolde()+depot);
	}
	
	/**
	 * @param besoin
	 */
	protected void debiter(float besoin) {
		this.setSolde(this.getSolde()-besoin);
	}
	
	/**
	 * @param transfert
	 * @param compte
	 * 
	 * Appelle la methode debiter avec le montant passé en paramettre de la methode dans un premier temps
	 * puis appelle sur le compte passer en deuxieme paramettre la methode crediter avec ce même montant
	 */
	protected void transfert(float transfert, Compte compte) {
		debiter(transfert);
		compte.crediter(transfert);
	}
	
	@Override
	public String toString() {
		return "Compte [id=" + id + ", credit=" + solde + ", type=" + this.getClass().getSimpleName() + "]";
	}

}
