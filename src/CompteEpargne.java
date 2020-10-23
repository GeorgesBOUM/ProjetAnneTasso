/**
 * <p>
 * Classe modélisant un compte epargne. Elle hérite donc de 
 * la classe compte. <br>
 * Un compte epargne a la spécificité par rapport aux autres types de
 * comptes possibles (joint et courant) d'avoir en plus des autres 
 * attributs hérités, un taux d'épargne fixé à l'ouverture du compte.
 * @see "Classe Compte"
 * 
 * @author gregoire
 * @version 1.0
 *
 */
public class CompteEpargne extends Compte{
	private double tauxPlacement;
	
	public CompteEpargne() {
		super("epargne");
		this.tauxPlacement = controleTauxDePlacement();
	}
	
	/**
	 * Controle que le taux d'épargne n'est jamais négatif.
	 * @return le taux d'épargne
	 */
	private double controleTauxDePlacement() {
		double taux;
		do {
			System.out.println("Quel est le taux de placement ? ");
			taux = clavier.nextDouble();
			if (taux < 0) {
				System.out.println("Le taux de placement ne peut être négatif");
			}
		} while (taux < 0);
		return taux;
	}
	
	/**
	 * Affiche l'état du compte, notamment son
	 * type (épargne), son numéro, son solde,
	 * et les différentes lignes comptables.
	 */
	@Override
	public void afficherCompte() {
		String numeroCompteLu;
		System.out.println("Quel compte souhaitez vous afficher ? ");
		numeroCompteLu = clavier.next();
		System.out.println("Vous avez saisi le compte "
				+ "numéro " + numeroCompteLu);
		if (numeroCompteLu.equals(this.numeroCompte)) {
			System.out.println("C'est un compte épargne");
			System.out.println("Le taux de placement "
					+ "est " + this.tauxPlacement + "%");
			//this.ligneComptable = creerLigne();
			//this.ligneComptable.afficherLigne();
			System.out.println("Vous avez "
					+ this.montantSurLeCompte
					+ " euro(s) sur votre compte");
		} else {
			System.out.println("Numéro de compte invalide");
		}
	}
}
