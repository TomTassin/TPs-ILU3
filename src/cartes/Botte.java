package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return getType().getBotte();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Botte botte) {
			Type type = this.type;
			return type.equals(botte.type);
		}
		return false;
	}
}