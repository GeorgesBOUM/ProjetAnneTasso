import java.util.Scanner;

public class AnneTassoBank {
	
	static Scanner clavier = new Scanner(System.in);
	static byte choixMenu = 5;
	
	public static void main(String [] args) {
		Compte c = null;
		String typeCompte;
		
		do {
			menuPrincipal();
			AnneTassoBank.choixMenu = clavier.nextByte();
			
			switch (AnneTassoBank.choixMenu) {
			case 1:
				System.out.println("***** Créer un compte *****");
				typeCompte = controleTypeCompte();
				if (typeCompte.equals("epargne")) {
					c = new CompteEpargne();
				} else {
					c = new Compte(typeCompte);
				}
				
				break;
			case 2:
				System.out.println("***** Afficher un compte *****");
				if (c == null) {
					System.out.println("Compte inexistant!");
				} else {
					c.afficherCompte();
				}
				break;
			case 3:
				System.out.println("***** Créer une ligne comptable *****");
				if (c == null) {
					System.out.println("Compte inexistant!");
				} else {
					c.creerLigne();
					//lc = new LigneComptable(c.getNumeroCompte());
					//c.setLigneComptable(lc);
				}
				break;
			case 4:
				sortir();
				break;
			case 5:
				System.out.println("***** Bienvenu dans l'aide *****");
				alAide();
				break;
			}
		} while (choixMenu != 4);
				
		clavier.close();
	}
	
	public static void menuPrincipal() {
		System.out.println("***** MENU PRINCIPAL *****");
		System.out.println("1. Créer un compte");
		System.out.println("2. Afficher un compte");
		System.out.println("3. Créer une ligne comptable");
		System.out.println("4. Sortir");
		System.out.println("5. De l'aide");
		System.out.print("Votre choix :");
	}
	
	public static void sortir() {
		System.out.println("Au revoir!!");
		System.exit(0);
	}
	
	public static void alAide() {
		System.out.println("Aide...");
	}
	
	public static String controleTypeCompte() {
		String type;
		do {
			System.out.println("Type du compte [Types possibles :  "
					+ "courant, joint, epargne] : ");
			type = clavier.next();
			if (!type.equals("courant") && !type.equals("joint") && 
					!type.equals("epargne")) {
				System.out.println("Erreur de saisie du type");
			}
		} while (!type.equals("courant") && !type.equals("joint") && 
				!type.equals("epargne"));
		return type;
	}
}
