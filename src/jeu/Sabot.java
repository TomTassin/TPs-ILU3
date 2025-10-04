package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot <C extends Carte> implements Iterable<C>{
	
	private C[] tabCartes;
	private int nbCartes = 0;
	private int nbOperation = 0;
	
	public Sabot(C... tabCartes) {
		this.tabCartes = tabCartes;
		nbCartes = tabCartes.length;
	}
	
	public boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCarte (C cartes) {
		if(nbCartes<tabCartes.length) {
			tabCartes[nbCartes]= cartes;
			nbCartes++;
			nbOperation++;
		}else {
			throw new IllegalStateException("Le sabot est plein");
		}
	}
	@Override 
	public Iterator<C> iterator(){
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<C>{
		
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nbOpRef = nbOperation;
		
		@Override
		public boolean hasNext() {
			return nbCartes>indiceIterateur;
		}
		
		@Override
		public C next() {
			verificationConcurrence();
			if (hasNext()) {
				C carte = tabCartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			}else {
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public void remove() {
			verificationConcurrence();
			if(nbCartes<1 || !nextEffectue) {
				throw new IllegalStateException();
			}else {
				for (int i = indiceIterateur-1; i < nbCartes-1; i++) {
					tabCartes[i]=tabCartes[i+1];
				}
				nextEffectue = false;
				indiceIterateur--;
				nbCartes--;
			}
		}
		
		private void verificationConcurrence() {
			if(nbOpRef!=nbOperation) {
				throw new ConcurrentModificationException();
			}
		}
	}
	
	public C piocher() {
		Iterator<C> it = iterator();
		if(!it.hasNext()) {
			throw new IllegalStateException("La pioche est vide");
		}else {
			C cartePiochee = it.next();
			it.remove();
			nbOperation++;
			System.out.println("je pioche " + cartePiochee);
			return cartePiochee;
		}
	}
	
}
