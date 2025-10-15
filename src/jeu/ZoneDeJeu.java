package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.Limite;

public class ZoneDeJeu {
	private List<Limite> pileLimiteFinLimites = new ArrayList<>();
	private List<Bataille> bataille = new ArrayList<>();
	private List<Borne> bornes = new ArrayList<>();
	
	public int donnerLimitationVitesse() {
		ListIterator<Limite> it = pileLimiteFinLimites.listIterator();
		if(!(it.hasNext()) || (it.next().equals("Fin Limite"))) {
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
		return 0;
	}
	
}
