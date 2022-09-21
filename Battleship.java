
public class Battleship {
	// some variables are set to protected so that they can be accessed by objects of the Battleship subclasses
	protected int size; 
	protected int health;
	private boolean afloat;
	
	// I think my choice of input parameters as 3 ints is what prevented me from being able to associate the subclass objects with Squares;
	public Battleship(int row, int location, int orientation) {
		size = 2;
		health = 2;
		afloat = true;
	}
	
	// Requisite getters and setters;	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isAfloat() {
		return afloat;
	}

	public void setAfloat(boolean afloat) {
		this.afloat = afloat;
	}
}