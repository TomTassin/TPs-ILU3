package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return getType().getAttaque();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Attaque att) {
			Type type = this.type;
			return type.equals(att.type);
		}
		return false;
	}
}
