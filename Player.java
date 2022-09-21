import java.util.Scanner;

public class Player {
	private Board gameBoard;
	private String name;
	private int score;
	
	
	public Player(String name, Board gameBoard) {
		this.gameBoard = gameBoard;
		this.name = name;
		score = 0;
	}
	
	public boolean takeTurn() {
		
		Square [][] board = new Square[10][10]; // creating an array that the method can manipulate;
		gameBoard.createBoard(board); // creating a board using this new array;
		
		System.out.println("Please enter your coordinates: x y"); // prompting the user for their guess;
				
		Scanner s = new Scanner(System.in);
		int row = s.nextInt(); // storing their input in two separate variables rather than an array for the sake of readability;
		int col = s.nextInt();
	
		// feeding coordinates into a method called userGuess in the board class to update the displayed character depending on whether a ship has been hit;
		board = gameBoard.userGuess(row, col);	
		
		// The following code will update the ship's health and the player's score;
		Square target = board[row][col]; 
		
		Battleship ship = target.getShip(); // calling the ship referenced by the target Square;
		int hiddenShips = 5; // this variable to keep track of how many ships are left on the board;
		
		boolean hit = target.isOccupied() == true && target.isUncovered() == true; // defining what it means when a ship's been hit;
		int health = ship.getHealth();
	
		if(hit && health == 2) { // if the ship was hit at full health;
			ship.setHealth(health-1); // decrement the health by 1;
		}
		
		else if (hit && health == 1){ // if the ship had been hit before;
			ship.setAfloat(false); // set afloat to false because the ship has been sunk;
			
			hiddenShips--; // decrementing this value as there's one less ship on the board;
			score++; // incrementing this value as the player has sunk a ship;
		}
		
		if(hiddenShips > 0) { // return true if there are still ships left on the board;
		return true;			
		}
		
		else {
			return false; // return false if there are no ships left on the board;
		}
	}
	
	// Required getters and setters;
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
