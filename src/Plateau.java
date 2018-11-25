import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plateau {
	public int nbJoueurs;
	public static Domino[] tousLesDominos = new Domino[48];

	Plateau(int nbJoueurs) {
		/*
		 * Au moment de l'instantiation du plateau, on r�cup�re le bon nombre de dominos
		 */
		this.nbJoueurs = nbJoueurs;

		recupDominos();

		int aRetirer = 0;

		switch (nbJoueurs) {

		case (2):
			aRetirer = 24;
			break;

		case (3):
			aRetirer = 12;
			break;

		case (4):
			aRetirer = 0;
			break;
		}
		retirerDomino(choisirDomino(aRetirer)); // On retire un nombre de dominos en ad�quation avec le nombre de
												// joueurs
	}

	public void recupDominos() {
		/*
		 * Cette fonction a pour but de r�cup�rer les dominos du fichier dominos.csv
		 * Elle les stockera dans le tableau tousLesDominos introduit au pr�alable
		 */
		Path orderPath = Paths.get("dominos.csv");
		List<String> lines = null;
		try {
			lines = Files.readAllLines(orderPath);
		} catch (IOException e) {
			System.out.println("Impossible de lire le fichier de dominos");
		}

		for (int i = 0; i < lines.size(); i++) {
			String[] split = lines.get(i).split(",");
			Domino domino = new Domino(Integer.valueOf(split[0]), split[1], Integer.valueOf(split[2]), split[3],
					Integer.valueOf(split[4]));
			tousLesDominos[i] = domino;

		}
	}

	public Domino[] piocherDomino(int nbAPiocher) {
		/*
		 * Cette fonction a pour but de piocher nbAPiocher dominos al�atoirement
		 * Retourne une liste de dominos (qui sont retir�s de tousLesDominos par la m�me occasion)
		 */
		List<Integer> aPiocher = choisirDomino(nbAPiocher);

		Domino[] pioche = new Domino[nbAPiocher];
		for (int i = 0; i < nbAPiocher; i++) {
			pioche[i] = tousLesDominos[aPiocher.get(i)];
		}
		retirerDomino(aPiocher);
		return pioche;
	}

	public void retirerDomino(List<Integer> aRetirer) {
		/*
		 * Cette fonction a pour but de retirer les dominos voulus Les dominos retir�s
		 * sont ceux dont le num�ro est dans la liste aRetirer
		 */
		for (int i = 0; i < aRetirer.size(); i++) {
			tousLesDominos[aRetirer.get(i)] = null;
		}
	}

	public static List<Integer> choisirDomino(int nbchoisi) {
		/*
		 * Cette fonction a pour but de choisir une liste de dominos au hasard Il ne
		 * faut pas qu'un domino soir choisi 2 fois
		 */
		List<Integer> choisi = new ArrayList<Integer>();
		while (choisi.size() < nbchoisi) {
			choisi.add((int) (Math.random() * 48));
			if (choisi.subList(0, choisi.size() - 1).contains(choisi.get(choisi.size() - 1)) || tousLesDominos[choisi.get(choisi.size()-1)] == null) { // Condition pour
																															   // �liminer les doublons
				choisi.remove(choisi.size() - 1); // si le dernier �l�ment de la liste est en pr�sent dans la sous-liste
												  // (de 0 � n-1), on l'enl�ve avec le remove
			}
		}
		Collections.sort(choisi);
		return choisi;
	}
}
