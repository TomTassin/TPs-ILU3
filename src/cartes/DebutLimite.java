package cartes;

public class DebutLimite extends Limite {

	@Override
	public String toString() {
		return "Limite 50";
	}
	
	@Override
	public boolean equals (Object obj) {
		if(obj instanceof DebutLimite debut) {
			return this.equals(debut.toString());
		}
		return false;
	}
}
