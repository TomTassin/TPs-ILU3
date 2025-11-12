package jeu;

import java.util.Iterator;

import cartes.Carte;

public class Joueur {
	private String nom;
	private MainJoueur main;
	private ZoneDeJeu zoneDeJeu;
	
	public Joueur(String nom, ZoneDeJeu zoneDeJeu) {
		this.nom = nom;
		this.zoneDeJeu = zoneDeJeu;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot<Carte> sabot) {
		Iterator<Carte> it = sabot.iterator();
		if(it.hasNext()) {
			Carte c =it.next();
			donner(c);
			it.remove();
			return c;
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur joueur) {
			return nom.equals(joueur.getNom());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	
	public int donnerKmParcourus() {
		return zoneDeJeu.donnerKmParcourus();
	}
	
	public void deposer(Carte c) {
		zoneDeJeu.deposer(c);
	}
}
