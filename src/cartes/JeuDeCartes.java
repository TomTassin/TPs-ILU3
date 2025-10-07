package cartes;

public class JeuDeCartes {
	private Configuration[] typesDeCartes;
	
	
	
	public JeuDeCartes() {
		typesDeCartes = new Configuration[] {
				new Configuration(10, new Borne(25)),
				new Configuration(10, new Borne(50)),
				new Configuration(10, new Borne(75)),
				new Configuration(12, new Borne(100)),
				new Configuration(4, new Borne(200)),
				
				new Configuration(14, new Parade(Type.FEU)),
				new Configuration(6, new Parade(Type.ACCIDENT)),
				new Configuration(6, new Parade(Type.CREVAISON)),
				new Configuration(6, new Parade(Type.ESSENCE)),
				new Configuration(6, new FinLimite()),
				
				new Configuration(5, new Attaque(Type.FEU)),
				new Configuration(3, new Attaque(Type.ACCIDENT)),
				new Configuration(3, new Attaque(Type.CREVAISON)),
				new Configuration(3, new Attaque(Type.ESSENCE)),
				new Configuration(4, new DebutLimite()),
				
				new Configuration(1, new Botte(Type.ACCIDENT)),
				new Configuration(1, new Botte(Type.CREVAISON)),
				new Configuration(1, new Botte(Type.ESSENCE)),
				new Configuration(1, new Botte(Type.FEU))
		};
				
				
	}

	public String afficherJeuDeCarte() {
		StringBuilder sb = new StringBuilder();
		sb.append("JEU:\n");
		for (int i = 0; i < typesDeCartes.length; i++) {
			sb.append(typesDeCartes[i].getNbExemplaires() 
					+ " " + typesDeCartes[i].getCarte() + "\n");
		}
		return sb.toString();
	}
	
	public Carte[] donnerCartes() {
		int total = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			total+=typesDeCartes[i].getNbExemplaires();
		}
		
		Carte[] jeuCartes = new Carte[total];
		
		int index = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			int nbTypeCarte = typesDeCartes[i].getNbExemplaires();
			for (int j = 0; j < nbTypeCarte; j++) {
				jeuCartes[index++] = typesDeCartes[i].getCarte();
			}
		}
		return jeuCartes;
	}
	
	public boolean checkCount() {
		Carte[] check = donnerCartes();
		int index = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			for (int j = 0; j < typesDeCartes[i].getNbExemplaires(); j++) {
				if(!check[index].equals(typesDeCartes[i].getCarte())) {
					return false;
				}
				index++;
			}
		}
		return true;
	}

	private static class Configuration{
		private int nbExemplaires;
		private Carte carte;
		public Configuration(int nbExemplaires, Carte carte) {
			super();
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}
		public int getNbExemplaires() {
			return nbExemplaires;
		}
		public Carte getCarte() {
			return carte;
		}
		
		
		
	}

}
