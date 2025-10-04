package testsFonctionnels;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		Carte[] cartes = jeu.donnerCartes();
		Sabot<Carte> sabot = new Sabot<Carte>(cartes);
		Iterator<Carte> iter = sabot.iterator();
		try {
			sabot.piocher();
			while (iter.hasNext()) {
				sabot.ajouterCarte(new Botte(Type.ACCIDENT));
				Carte cartePiochee = iter.next();
				System.out.println("je pioche " + cartePiochee);
				sabot.piocher();
				iter.remove();
			}
		} catch (ConcurrentModificationException e) {
			e.printStackTrace();
		}
		
	}
}
