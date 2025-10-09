package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import cartes.Carte;
import cartes.JeuDeCartes;

public class GestionCartes {
	private static final Random random = new Random();
	
	
	public static <C> C extraireV1(List<C> listeCartes){
		if(!listeCartes.isEmpty()) {
			int index = random.nextInt(listeCartes.size());
			return listeCartes.remove(index);
		}else {
			throw new IllegalArgumentException("La liste ne doit pas être vide");
		}
	}
	public static <C> C extraireV2(List<C> listeCartes){
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
	
	public static <C> List<C> melanger(List<C> listeCartes){
		List<C> listeMelangee = new ArrayList<>();
		while (!listeCartes.isEmpty()) {
			listeMelangee.add(extraireV2(listeCartes));
		}
		return listeMelangee;
	}
	
	public static <C> boolean verifierMelange(List<C> l1, List<C> l2) {
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
	
	public static <C> List<C> rassembler(List<C> l){
		List<C> listeRassemblee = new ArrayList<>();
		for (Iterator<C> iterator = l.iterator(); iterator.hasNext();) {
			C c1 = iterator.next();
			if(!listeRassemblee.contains(c1)) {
				for (C c2 : l) {
					if(c2.equals(c1)) {
						listeRassemblee.add(c2);
					}
				}
			}
		}
		return listeRassemblee;
	}
	
	public static <C> boolean verifierRassembler(List<C> l) {
		if(l.isEmpty()) {
			return true;
		}
		ListIterator<C> it1 = l.listIterator();
		C ancienneCarte = it1.next();
		while(it1.hasNext()) {
			C nouvelleCarte = it1.next();
			if(!nouvelleCarte.equals(ancienneCarte)) {
				ListIterator<C> it2 = l.listIterator(it1.nextIndex());
				while (it2.hasNext()) {
					C c = it2.next();
					if(c.equals(ancienneCarte)) {
						return false;
					}
					
				}
			}
			ancienneCarte = nouvelleCarte;
		}	
		return true;
	}
	
	public static void main(String[] args) {

        JeuDeCartes jeu = new JeuDeCartes();


        List<Carte> listeCarteNonMelangee = new LinkedList<>();
        for (Carte carte : jeu.donnerCartes()) {
            listeCarteNonMelangee.add(carte);
        }


        List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);

        System.out.println("Avant mélange :");
        System.out.println(listeCartes);

        listeCartes = GestionCartes.melanger(listeCartes);

        System.out.println("\nAprès mélange :");
        System.out.println(listeCartes);


        System.out.println("\nListe mélangée sans erreur ? "
                + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));

        listeCartes = GestionCartes.rassembler(listeCartes);

        System.out.println("\nAprès rassemblement :");
        System.out.println(listeCartes);

        System.out.println("Liste rassemblée sans erreur ? "
                + GestionCartes.verifierRassembler(listeCartes));

        testRassemblementSurListesSimples();
    }

    public static <C> boolean verifierMelangeGenerique(List<C> liste1, List<C> liste2) {
        if (liste1.size() != liste2.size()) return false;

        for (C c : liste1) {
            if (Collections.frequency(liste1, c) != Collections.frequency(liste2, c)) {
                return false;
            }
        }
        return true;
    }

    private static void testRassemblementSurListesSimples() {
        System.out.println("\n=== TESTS SIMPLES ===");

        System.out.println("[] -> " + GestionCartes.verifierRassembler(Collections.emptyList()));

        List<Integer> l1 = Arrays.asList(1,1,2,1,3);
        System.out.println("[1,1,2,1,3] -> " + verifierRassembler(l1));

        List<Integer> l2 = Arrays.asList(1,4,3,2);
        System.out.println("[1,4,3,2] -> " + verifierRassembler(l2));

        List<Integer> l3 = Arrays.asList(1,1,2,3,1);
        System.out.println("[1,1,2,3,1] -> " + verifierRassembler(l3));
    }
}
