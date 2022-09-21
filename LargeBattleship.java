
public class LargeBattleship extends Battleship{
	private static int numOfShips;

	// specifying input parameters; int extension will extend the length of the ship by one Square;
	public LargeBattleship(int row, int col, int orientation, int extension) { 
		super(row, col, orientation);
		size = 3; 
		health = 3;
		numOfShips = 1; // setting the number of ships allowed on board;
	}
	
	//Requisite getters and setters;
	public static int getNumOfShips() {
		return numOfShips;
	}
}
