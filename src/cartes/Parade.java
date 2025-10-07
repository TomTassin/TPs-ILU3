package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return getType().getParade();
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Parade par) {
			Type type = this.type;
			return type.equals(par.type);
		}
		return false;
	}

}
