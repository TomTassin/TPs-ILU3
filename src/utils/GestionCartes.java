package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import cartes.Carte;

public class GestionCartes {
	private static final Random random = new Random();
	
	
	public static <C extends Carte> C extraireV1(List<C> listeCartes){
		if(!listeCartes.isEmpty()) {
			int index = random.nextInt(listeCartes.size());
			return listeCartes.remove(index);
		}else {
			throw new IllegalArgumentException("La liste ne doit pas être vide");
		}
	}
	public static <C extends Carte> C extraireV2(List<C> listeCartes){
		if(!listeCartes.isEmpty()) {
			int index = random.nextInt(listeCartes.size());
			ListIterator<C> iter = listeCartes.listIterator(index);
			C carteExtrait = iter.next();
			iter.remove();
			return carteExtrait;
		}else {
			throw new IllegalArgumentException("La liste ne doit pas être vide");
		}
	}
	
	public static <C extends Carte> List<C> melanger(List<C> listeCartes){
		List<C> listeMelangee = new ArrayList<>();
		while (!listeCartes.isEmpty()) {
			listeMelangee.add(extraireV2(listeCartes));
		}
		return listeMelangee;
	}
	
	public static <C extends Carte> boolean verifierMelange(List<C> l1, List<C> l2) {
		if(l1.size() != l2.size()) {
			return false;
		}
		int nbocc1;
		int nbocc2;
		for (C carte : l1) {
			nbocc1 = Collections.frequency(l1, carte);
			nbocc2 = Collections.frequency(l2, carte);
			if (nbocc1 != nbocc2) {
				return false;
			}
		}
		return true;
	}
	

}
