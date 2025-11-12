package testsFonctionnels;

import cartes.Borne;
import cartes.DebutLimite;
import cartes.FinLimite;
import jeu.Joueur;
import jeu.ZoneDeJeu;

public class TestZoneDeJeu {
	
	public static void main(String[] args) {
		ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
		Joueur joueur = new Joueur("Tom", zoneDeJeu);
		
		System.out.println("Deposer carte 25 km");
		joueur.deposer(new Borne(25));
		System.out.println("Deposer carte 50 km");
		joueur.deposer(new Borne(50));
		System.out.println("Deposer carte 75 km");
		joueur.deposer(new Borne(75));
		int totalBornes = joueur.donnerKmParcourus();
		System.out.println("Total des bornes : " + totalBornes);
		System.out.println("Limite : " + zoneDeJeu.donnerLimitationVitesse());
		joueur.deposer(new DebutLimite());
		System.out.println("Limite : " + zoneDeJeu.donnerLimitationVitesse());
		joueur.deposer(new FinLimite());
		System.out.println("Limite : " + zoneDeJeu.donnerLimitationVitesse());
	}
}
