import java.util.Scanner;

/**
 * 
 * <p>
 * Classe modélisant un compte bancaire. <br>
 * L'utilisateur peut:
 * <ul>
 * 	<li>Créer un compte</li>
 * 	<li>Afficher un compte, notamment son solde et les lignes comptables</li>
 * </ul>
 * 
 * @author GB
 * @version 1.0
 *
 */
public class Compte {
	protected String numeroCompte;
	private String typeCompte;
	protected double montantSurLeCompte;
	private LigneComptable [] ligneComptable;
	
	public static final int NOMBRE_DE_LIGNES = 10;
	public static int nombreLigneReel = 0;
	
	Scanner clavier = new Scanner(System.in);
	
	public Compte(String tc) {
		System.out.println("Entrez un numéro de compte");
		this.numeroCompte = clavier.next();
		this.typeCompte = tc;
		this.montantSurLeCompte = controlePremierDepot();
		this.ligneComptable = new LigneComptable [NOMBRE_DE_LIGNES];
		this.ligneComptable[0] = new LigneComptable( "credit", this.montantSurLeCompte,
				"**/**/****", "premier depot","premier depot");
	}
	
	/**
	 * Controle la validité du premier dépot. Le premier dépot ne peut
	 * être négatif
	 * @return le montant du premier dépot
	 */
	private double controlePremierDepot() {
		double premierDepot;
		do {
			System.out.println("Montant du premier dépôt: ");
			premierDepot = clavier.nextDouble();
			if (premierDepot < 0) {
				System.out.println("Le premier dépôt ne peut être négatif");
			}
		} while (premierDepot < 0);
		return premierDepot;
	}
	
	/**
	 * Affiche l'état du compte, notamment son
	 * type (courant, joint), son numéro, son solde,
	 * et les différentes lignes comptables.
	 */
	public void afficherCompte() {
		String numeroCompteLu;
		System.out.println("Quel compte souhaitez vous afficher ? ");
		numeroCompteLu = clavier.next();
		System.out.println("Vous avez saisi le compte "
				+ "numéro " + numeroCompteLu);
		if (numeroCompteLu.equals(this.numeroCompte)) {
			switch (this.typeCompte) {
			case "courant":
				System.out.println("C'est un compte courant");
				break;
			case "joint":
				System.out.println("C'est un compte joint");
				break;
			}
			//this.ligneComptable = creerLigne();
			for (int i = 0; i < nombreLigneReel; i++) {
				System.out.println("Ligne " + i);
				this.ligneComptable[i].afficherLigne();
			}
			//this.ligneComptable.afficherLigne();
			System.out.println("Vous avez "
					+ this.montantSurLeCompte
					+ " euro(s) sur votre compte");
		} else {
			System.out.println("Numéro de compte invalide");
		}
	}
	
	/**
	 * controle la validité du numéro de compte saisi par l'utilisateur
	 * @return le numéro de compte
	 */
	public String controleNumeroCompte() {
		String numCo;
		do {
			System.out.println("Entrer un numéro de compte: ");
			numCo = clavier.next();
			if (!this.numeroCompte.equals(numCo)) {
				System.out.println("Le numéro saisi est incorrect ");
			}
		} while (!this.numeroCompte.equals(numCo));
		return numCo;
	}
	
	/**
	 * Crée une ligne comptable et met à jour le solde du compte.
	 * @return la ligne comptable créée. 
	 */
	public LigneComptable creerLigne() {
		//String numCo = controleNumeroCompte();
		this.ligneComptable[nombreLigneReel] = new LigneComptable();		
		if (this.ligneComptable[nombreLigneReel].getTypeOperation().equals("credit")) {
			this.montantSurLeCompte += this.ligneComptable[nombreLigneReel].getSomme();
		} else {
			this.montantSurLeCompte -= this.ligneComptable[nombreLigneReel].getSomme();
		}
		nombreLigneReel += 1;
		return this.ligneComptable[nombreLigneReel];
	}
}
