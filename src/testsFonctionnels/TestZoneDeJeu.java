package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Type;
import jeu.Cartes;
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
		
		
		  boolean depotOK = false;
		  zoneDeJeu = new ZoneDeJeu();
		  System.out.println("Deposer carte Feu rouge");
		  depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_ROUGE);
		  System.out.println("depot ok ? " + depotOK);
		  if (depotOK) {
			  zoneDeJeu.deposer(Cartes.FEU_ROUGE); }
		  System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		  System.out.println("Deposer carte attaque - accident");
		  depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
		  System.out.println("depot ok ? " + depotOK); 
		  if (depotOK) {
			  zoneDeJeu.deposer(new Attaque(Type.ACCIDENT)); } //
		  System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		  System.out.println("Deposer carte Feu vert");
		  depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		  System.out.println("depot ok ? " + depotOK);
		  if (depotOK) {
			  zoneDeJeu.deposer(Cartes.FEU_VERT); }
		  System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		  System.out.println("Deposer carte attaque - essence");
		  depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ESSENCE));
		  System.out.println("depot ok ? " + depotOK);
		  if (depotOK) {
			  zoneDeJeu.deposer(new Attaque(Type.ESSENCE)); }
		  System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		  System.out.println("Deposer carte parade - roue de secours");
		  depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.CREVAISON));
		  if(depotOK) { 
			  zoneDeJeu.deposer(new Parade(Type.CREVAISON)); }
		  System.out.println("depot ok ? " + depotOK);
		  System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		  System.out.println("Deposer carte parade - essence");
		  depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.ESSENCE));
		  if (depotOK) {
			  zoneDeJeu.deposer(new Parade(Type.ESSENCE)); }
		  System.out.println("depot ok ? " + depotOK);
		  System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		  System.out.println("Deposer carte Feu vert");
		  depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		  System.out.println("depot ok ? " + depotOK);
		  if (depotOK) {
			  zoneDeJeu.deposer(Cartes.FEU_VERT); }
		  System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		  System.out.println("Deposer carte borne - 100");
		  depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		  System.out.println("depot ok ? " + depotOK);
		  if (depotOK) {
			  zoneDeJeu.deposer(new Borne(100)); }
		  System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		  System.out.println("Deposer carte limite - 50");
		  depotOK = zoneDeJeu.estDepotAutorise(new DebutLimite());
		  System.out.println("depot ok ? " + depotOK);
		  if (depotOK) {
			  zoneDeJeu.deposer(new DebutLimite()); }
		  System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		  System.out.println("Deposer carte borne - 100");
		  depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		  System.out.println("depot ok ? " + depotOK);
		  if (depotOK) {
			  zoneDeJeu.deposer(new Borne(100)); }
		  System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		  System.out.println("Deposer carte borne - 25");
		  depotOK = zoneDeJeu.estDepotAutorise(new Borne(25));
		  System.out.println("depot ok ? " + depotOK);
		  if (depotOK) {
			  zoneDeJeu.deposer(new Borne(25)); }
		  System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		  System.out.println("Deposer carte fin limite - 50");
		  depotOK = zoneDeJeu.estDepotAutorise(new FinLimite());
		  System.out.println("depot ok ? " + depotOK);
		  if (depotOK) {
			  zoneDeJeu.deposer(new FinLimite()); }
		  System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		  System.out.println("Deposer carte borne - 100");
		  depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		  System.out.println("depot ok ? " + depotOK);
		  if (depotOK) {
			  zoneDeJeu.deposer(new Borne(100)); }
		  System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		 
	}
}
