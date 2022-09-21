
public class Square {
	
	/**ALT:
	 * While trying to implement task 5, I initialised a new Battleship of each type, to be associated with particular Squares.  I could not get the 
	 * association to work, however. I think it's because of a mismatch in parameters.  Battleship(super) requires 3 ints to be input (row, col, orientation).  
	 * However, SmallBattleships only require 2 and I was setting the third(super) variable to 0.  I thought a viable method would be to change the input type
	 * to an array of integers; that way, the size of the array input for each subclass could differ ([2] for SmallBattleships, [3] for 
	 * MediumBattleships and [4] for LargeBattleships.  However, I couldn't get this to work properly in the code either;
	 * 
	 *
	 * private SmallBattleship sShip = new SmallBattleship(0,0);
	 * private MediumBattleship mShip = new MediumBattleship(0,0,0);
	 * private LargeBattleship lShip = new LargeBattleship(0,0,0,0);
	 * */
	
	private int row;
	private int col;
	private boolean occupied;
	private boolean uncovered;
	private Battleship ship = new Battleship(0,0,0); // creating a new Battleship that can be used by this class;
	
	public Square(int row, int col) {
		this.row = row;
		this.col = col;
		occupied = false;
		uncovered = false;
	}
	
	public String toString() { // a toString method that can be referenced by the Board class;
		String result = "";
		
		if (occupied && uncovered) { // if there's a ship on the board and the Square is attacked;
			result += "x";
		}
		else if (!occupied && uncovered){ // if there's no ship on the board and the square is attacked;
			result += "o";
		}
		else {
			result += "-"; // if the Square has not been attacked;
		}
		return result;
	}
	
	
	// Requisite getters and setters;
	public Battleship getShip() {
		return ship;
	}

	public void setShip(Battleship b) {
		this.ship = b;
	}
	
	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public boolean isUncovered() {
		return uncovered;
	}

	public void setUncovered(boolean uncovered) {
		this.uncovered = uncovered;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	/*ALT: getters and setters;
	 * 
	 * public SmallBattleship getSShip() {
		return sShip;
	}

	public void setSShip(SmallBattleship sShip) {
		this.sShip = sShip;
	}
	
	public MediumBattleship getMShip() {
		return mShip;
	}

	public void setMShip(MediumBattleship sShip) {
		this.mShip = mShip;
	}
	
	public LargeBattleship getLShip() {
		return Ship;
	}

	public void setLShip(LargeBattleship sShip) {
		this.lShip = lShip;
	}
	 */
}