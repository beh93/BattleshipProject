
public class MediumBattleship extends Battleship{
	private static int numOfShips;

	/** This is the only subclass object I might have been able to implement properly because its input parameters mirror the parameters of the 
	 * Battleship superclass; */
	public MediumBattleship(int row, int col, int orientation) { 
		super(row, col, orientation); 
		numOfShips = 2; // setting the number of ships allowed on board;
	}
	
	//Requisite getters and setters;
	public static int getNumOfShips() {
		return numOfShips;
	}

}
