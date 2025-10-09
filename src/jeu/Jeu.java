package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	Sabot<Carte> sabot;

	public Jeu() {
		JeuDeCartes jeu = new JeuDeCartes();
		Carte[] tabCartes = jeu.donnerCartes();

		List<Carte> listeCartes = new ArrayList<>();
        Collections.addAll(listeCartes, tabCartes);
        
        listeCartes = GestionCartes.melanger(listeCartes);
        tabCartes = listeCartes.toArray(new Carte[0]);
        
        sabot = new Sabot<>(tabCartes);
	}
	
	public Sabot<Carte> getSabot(){
		return sabot;
	}
	
}
