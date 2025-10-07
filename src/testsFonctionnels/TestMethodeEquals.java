package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {
	public static void main(String[] args) {
		Borne b1 = new Borne(25);
		Borne b2 = new Borne(25);
		System.out.println("Deux cartes de 25km sont identiques? " + b1.equals(b2));
		Attaque att1 = new Attaque(Type.FEU);
		Attaque att2 = new Attaque(Type.FEU);
		System.out.println("Deux cartes de feu rouge sont identiques? : " + att1.equals(att2));
		Parade att3 = new Parade(Type.FEU);
		System.out.println("La carte feu rouge et la carte feu vert sont identiques? : " + att1.equals(att3));
	}

}
