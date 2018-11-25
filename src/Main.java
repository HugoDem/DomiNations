import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Création d'une liste de 2 à 4 joueurs :
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		int nbJoueurs = 0;

		while (nbJoueurs < 2 || nbJoueurs > 4) {
			System.out.println("Combien de joueurs vont jouer (2-4) ?");
			try {
				nbJoueurs = Integer.valueOf(scan.nextLine());
			} catch (Exception e) {
				System.out.println("Erreur, veuillez saisir un entier");
			}
		}

		// CInitialisation du jeu :
		Plateau plateau = new Plateau(nbJoueurs);
		
		plateau.recupDominos();

		int aRetirer = 0;
		int nbRoi = 1;

		switch (nbJoueurs) {

		case (2):
			aRetirer = 24;
			nbRoi = 2;
			break;

		case (3):
			aRetirer = 12;
			break;

		case (4):
			aRetirer = 0;
			break;
		}
		plateau.retirerDomino(plateau.choisirDomino(aRetirer));
		String[] couleurs = { "bleu", "rose", "vert", "jaune" };
		Joueur[] joueurs = new Joueur[nbJoueurs];
		for (int i = 0; i < nbJoueurs; i++) {
			joueurs[i] = new Joueur(couleurs[i],nbRoi);
		}


		
		
		// Début du jeu (Tour 1) :

		// Tour (n+1) :

		// Fin du Jeu :

//--------------------------------Affichage (pour test)--------------------------------------------\\		
		
		Domino[] pioche = plateau.piocherDomino(4);
		afficherDomino(pioche);
		afficherDomino(plateau.tousLesDominos);
		
	}
	
	public static void afficherDomino(Domino[] liste) {
		/*
		 * Fonction temporatire utilisée pour afficher une liste de dominos (à des fins de test)
		 */
		for (int i = 0; i < liste.length; i++) {
			try {
				System.out.print(liste[i].nbCouronne1 + "  " + liste[i].type1 + "  "
						+ liste[i].nbCouronne2 + "  " + liste[i].type2 + "  " + liste[i].numeroDomino + "  ");
				System.out.println(" ");
			} catch (Exception NullPointerException) {
				System.out.println(i + 1);
			}
		}
		System.out.println(" ");
	}
}
