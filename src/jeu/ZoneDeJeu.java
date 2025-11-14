package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;

public class ZoneDeJeu {
	private List<Limite> limites = new ArrayList<>();
	private List<Bataille> batailles = new ArrayList<>();
	private List<Borne> bornes = new ArrayList<>();
	private List<Botte> bottes = new ArrayList<>();
	
	public int donnerLimitationVitesse() {
		ListIterator<Limite> it = limites.listIterator();
		if (!it.hasNext()) return 200;
		Limite limite = it.next();
		while (it.hasNext()) {
			limite = it.next();
		}
		FinLimite finLimite = new FinLimite();
		if(limite.equals(finLimite)) {
			return 200;
		}
		return 50;
	}
	
	public int donnerKmParcourus() {
		int km = 0;
		for (Iterator<Borne> iterator = bornes.iterator(); iterator.hasNext();) {
			Borne borne = iterator.next();
			km+=borne.getKm();
		}
		return km;
	}
	
	public void deposer(Carte c) {
		if (c instanceof Borne borne) {
			if (borne.getKm() <= donnerLimitationVitesse()) {
				bornes.add(borne);
			}else {
				System.out.println("1Limite : " + donnerLimitationVitesse());
			}
		} else if (c instanceof Limite limite){
			limites.add(limite);
		} else if (c instanceof Bataille bataille){
			batailles.add(bataille);
		}
	}
	
	public boolean peutAvancer() {
		return !batailles.isEmpty() && batailles.get(batailles.size()-1).equals(Cartes.FEU_VERT);
	}
	
	private boolean estDepotFeuVertAutorise() {
		return batailles.isEmpty() || 
				(batailles.get(batailles.size()-1).equals(Cartes.FEU_ROUGE) 
						|| !batailles.get(batailles.size()-1).equals(Cartes.FEU_VERT));
	}
	
	 private boolean estDepotBorneAutorise(Borne borne) {
		 return peutAvancer() && (borne.getKm() <= donnerLimitationVitesse()) && (donnerKmParcourus()<1000);
	 }
	 
	private boolean estDepotLimiteAutorise(Limite limite) {
		if(limite instanceof DebutLimite debutLimite) {
			return limites.isEmpty() || !limites.get(limites.size()-1).equals(debutLimite);
		}
		if(limite instanceof FinLimite finLimite) {
			return !limites.isEmpty() && !limites.get(limites.size()-1).equals(finLimite);
		}
		return false;
	 }
	 
	 private boolean estDepotBatailleAutorise(Bataille bataille) {
		 Bataille lastBataille = null;
		 if (!batailles.isEmpty()) lastBataille = batailles.get(batailles.size()-1);
		 if(bataille instanceof Attaque attaque) {
			 if(attaque.equals(Cartes.FEU_ROUGE)) {
				 return !batailles.isEmpty() && lastBataille.equals(Cartes.FEU_VERT);
			 }
			 return  !batailles.isEmpty() && !(lastBataille instanceof Attaque);
		 }
		 if(bataille instanceof Parade parade) {
			 if(parade.equals(Cartes.FEU_VERT)) {
				 return estDepotFeuVertAutorise();
			 }else {
				 if (lastBataille instanceof Attaque attaque) {
					 return !batailles.isEmpty() && ((parade.getType()).equals(attaque.getType()));
				 }
			 }
		 }
		 return false;
	 }
	 
	 public boolean estDepotAutorise(Carte carte) {
		if(carte instanceof Borne borne) return estDepotBorneAutorise(borne);
		if(carte instanceof Limite limite) return estDepotLimiteAutorise(limite);
		if(carte instanceof Bataille bataille) return estDepotBatailleAutorise(bataille);
		return false;
	}
}
