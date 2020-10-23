import java.util.Scanner;

/**
 * <p>
 * Classe modélisant une ligne Comptable pour un compte donné. 
 * Une ligne comptable est le détail d'une opération bancaire. 
 * On peut ainsi savoir en une ligne  quel est le motif de la
 * l'opération (paiement par CB, virement, dépot de liquidité,
 * salaire, etc), s'il s'agit d'un débit ou d'un crédit, 
 * quel est le montant de la transaction, ainsi que sa date.
 * 
 * @author gregoire
 * @version 1.0
 *
 */
public class LigneComptable {
	private String typeOperation;
	private double somme;
	private String date;
	private String motifOperation;
	private String modePaiement;
	
	private Scanner clavier = new Scanner(System.in);
	
	/**
	 * Getter du type d'opération
	 * @return le type d'opération
	 */
	public String getTypeOperation () {
		return typeOperation;
	}
	
	/**
	 * Getter du montant de la transaction
	 * @return le montant de la transaction
	 */
	public double getSomme() {
		return somme;
	}
	
	public LigneComptable() {
		double som;
		//this.numeroCompte = numCo;
		this.typeOperation = controleTypeOperation();
		System.out.println("Entrer un montant: ");
		som = clavier.nextDouble();
		if (this.typeOperation.equals("credit")) {
			this.somme = som;
		} else {
			this.somme = - som;
		}
		this.date = "**/**/****";
		this.motifOperation = lectureMotifOperation();
		this.modePaiement = controleModePaiement();
	}
	
	public LigneComptable(String typeOperation, 
			double somme, String date, String motifOperation,
			String modePaiement) {
		this.typeOperation = typeOperation;
		this.somme = somme;
		this.date = date;
		this.motifOperation = motifOperation;
		this.modePaiement = modePaiement;
	}
	
	/**
	 * Controle le type d'opération. Une opération ne peut être qu'un 
	 * "credit" ou un "debit"
	 * @return le type de l'opération
	 */
	private String controleTypeOperation() {
		String typeOp;
		do {
			System.out.println("Entrez le type d'opération"
					+ " ('credit' ou 'debit' :)");
			typeOp = clavier.next();
			if (!typeOp.equals("credit") && !typeOp.equals("debit")) {
				System.out.println("Vous n'avez pas saisi le bon type");
			}
		} while (!typeOp.equals("credit") && !typeOp.equals("debit"));
		return typeOp;
	}
	
	/**
	 * Lecture du motif de l'opération
	 * @return le motif de l'opération
	 */
	private String lectureMotifOperation() {
		String motif;
		// possibilité de if et de do while
		System.out.println("Entrez un motif de paiement");
		motif = clavier.next();
		return motif;
	}
	
	/**
	 * Controle le mode de paiement utlisé lors de l'opération.
	 * Il ne peut s'agir que de "CB", "virement", ou "cheque"
	 * @return mode de paiement utilisé lors de l'opération
	 */
	private String controleModePaiement() {
		String mode;
		do {
			System.out.println("Choisissez un mode de paiement :");
			mode = clavier.next();
			if (mode.equals("CB") && mode.equals("virement") && mode.equals("cheque")) {
				System.out.println("Vous n'avez pas choisi le bon mode "
						+ "de paiement !");
			}
		} while (mode.equals("CB") && mode.equals("virement") && mode.equals("cheque"));
		return mode;
	}
	
	/**
	 * Affiche une ligne comptable lié à un compte donné
	 */
	public void afficherLigne() {
		System.out.println("***************************************************");
		if (this.typeOperation.equals("credit")) {
			System.out.println("La somme à créditer: " + this.somme);
		} else {
			System.out.println("La somme à débiter: " + this.somme);
		}
		System.out.println("La date de l'opération: " + this.date);
		System.out.println("Le motif de l'opération: " + this.motifOperation);
		System.out.println("Le mode de paiement: " + this.modePaiement);
		System.out.println("***************************************************");
	}
}
