package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainJoueur {
	private List<Carte> main = new ArrayList<>();

	public void prendre(Carte carte) {
		main.add(carte);
	}
	
	public void jouer(Carte carte) {
		if(main.contains(carte)) {
			main.remove(carte);
		}else {
			throw new IllegalStateException("Le joueur ne possède pas la carte : " + carte);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Iterator<Carte> iterator = main.iterator(); iterator.hasNext();) {
			Carte carte = iterator.next();
			sb.append(carte);
		}
		return sb.toString();
	}
}
