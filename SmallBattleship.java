
public class SmallBattleship extends Battleship{
	private static int numOfShips;

	public static void setNumOfShips(int numOfShips) {
		SmallBattleship.numOfShips = numOfShips;
	}

	public SmallBattleship(int row, int col) { 
		super(row, col, 0); // This may be the offending line of code that prevented me from being able to associate SmallBattleships with Squares;
		size = 1; 
		health = 1;
		numOfShips = 3; // setting the number of ships allowed on board;
	}
	
	//Requisite getters and setters;
	public static int getNumOfShips() {
		return numOfShips;
	}
}
