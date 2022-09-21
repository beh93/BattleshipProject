import java.util.Random;
import java.util.Scanner;

public class Board {
	private Square[][] board;
	
	public Board(int row, int col) {
		board = new Square[row][col];
		createBoard(board);	// initialising the board;	
	}
	
	public Square[][] createBoard(Square[][] board){ // this takes in the array from the constructor;
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					board[i][j] = new Square(i,j); // iterating through each offset and filling it with a new Squares;
				}
			}
			return generateShips(board); // this links to the two methods so that the board will be initialised with ships already generated;
	}
	
	public Square[][] generateShips(Square[][] board){
		
		Random r = new Random(); 
		int placedShips = 0; // this will keep track of how many ships have been placed on the board;
		
		while(placedShips < 5) { // to ensure that 5 are placed on the board;
			int row = r.nextInt(9); // generating a random coordinate for the row of the Square the ship will be placed on;
			int col = r.nextInt(9); // generating a random coordinate for the column of the Square the ship will be placed on;
			
			Square location = board[row][col]; // the Square picked by the random coordinates generate above;
			Square nextHor =  board[row + 1][col]; // the other Square the ship will occupy if it's generated horizontally;
			Square nextVert =  board[row][col + 1]; // the other Square the ship will occupy if it's generated vertically;
			
			//the boolean below is to ensure that no ships overlap.  A ship can only be placed if the Squares it would occupy are !occupied;
			boolean valid = location.isOccupied() == false && nextHor.isOccupied() == false && nextVert.isOccupied() == false; 
			boolean horizontal = r.nextBoolean(); // randomising the orientation of the ship;
			
			if(horizontal && valid) { // this will generate horizontal ships;
				location.setOccupied(true);
				nextHor.setOccupied(true); // setting these locations to occupied to indicate that a ship is now on them;
				
				Battleship ship = new Battleship(row, col, row+1); //new Battleship created horizontally;
				location.setShip(ship);
				nextHor.setShip(ship); // associating the above battleship with these Squares;
				
				placedShips++; // incrementing the counter when a horizontal ship is placed;
			}
			
			else if(valid) { // this will generate vertical ships;
				location.setOccupied(true);
				nextVert.setOccupied(true); 
				
				Battleship ship = new Battleship(row, col, col+1); // this is col+1 rather than row+1 to ensure the ship is vertical;
				location.setShip(ship);
				nextVert.setShip(ship);
				
				placedShips++; // incrementing the counter when a vertical ship is placed;
			}
		}
		return board;
	}
	
	public Square[][] userGuess(int row, int col){ // this method is taking in the coordinates the player input in their takeTurn method;
				
		Square target = board[row][col]; // targeting the Square at the specified coordinates;
		Battleship ship = target.getShip();
		boolean occupied = target.isOccupied();
		boolean uncovered = target.isUncovered();
		int health = ship.getHealth();
		
			if(occupied && !uncovered && health == 2) { // if there's a ship on the Square and is at full health;
				target.setUncovered(true); // uncovering the Squares to indicate they've been hit;
				System.out.println("Hit!"); // printing an update message;
			}
			else if(occupied && !uncovered && health == 1) { // if there's a ship on the Square and it's been hit before;
				target.setUncovered(true);
				System.out.println("You sunk a ship!"); // the takeTurn method will set the ship's afloat status to false in this instance;
			}
			else if(!occupied && !uncovered) { // if there's no ship on the square
				target.setUncovered(true);
				System.out.println("Miss!");
			}
			else if (uncovered){ // if this Square has been hit before and is already uncovered;
				target.setUncovered(true); 
				System.out.println("This location has already been hit!  You lose a turn."); 
			}
			
		return board;
	}
	
	public String toString() { // a toString method to print out the board;
	String output = "";
	for(int i = 0; i < 10; i++) {
		for (int j = 0; j < 10; j++){
			output += (String.format("%3s", board[i][j]));
		}
		output+= "\n";
	}
	return output;
	}
}
/*ALT: method for generating multiple types of Battleship. I couldn't get this to work as intended as it wouldn't associate the ships with the correct
 * Squares and felt too verbose to be usable.  I've included it to try and get some extra marks for Task 5 and for future reference if detailed feedback is 
 * given on this exercise;
 * 
 * public Square[][] generateShips(Square[][] board){
	
	Random r = new Random(); 
	int row = r.nextInt(9); 
	int col = r.nextInt(9); 
	
	int placedShips = 0; // this will keep track of how many ships have been placed on the board;
	
	SmallBattleship sShip = new SmallBattleship(0, 0);
	MediumBattleship mShip = new MediumBattleship(0, 0, 0);
	LargeBattleship lShip = LargeBattleship lShip = new LargeBattleship(0, 0, 0, 0);
	
	Square location = board[row][col]; // the Square picked by the random coordinates generate above;
	
	// Small ships
	while(placedShips < sShip.getNumOfShips()) { 
	
		boolean valid = location.isOccupied() == false; // checking if a Square is already occupied to ensure no overlap;

		if(valid) { 
			sShip = new Battleship(row, col); //new SmallBattleship created on the right Square;
			
			location.setShip(ship); // associating the ship with the right Square;
			location.setOccupied(true);
			
			placedShips++; // incrementing the counter ship is placed;
		}
	}
		
	// Medium ships
	while(placedShips < mShip.getNumOfShips()) { =
		
		Square nextHor =  board[row + 1][col]; // the other Square the ship will occupy if it's generated horizontally;
		Square nextVert =  board[row][col + 1]; // the other Square the ship will occupy if it's generated vertically;
		
		boolean valid = location.isOccupied() == false && nextHor.isOccupied() == false && nextVert.isOccupied() == false; 
		boolean horizontal = r.nextBoolean();
		
		if(horizontal && valid) { // this will generate horizontal ships;
			
			mShip = new Battleship(row, col, row+1); // creating a new ship horizontally;
			
			location.setShip(ship);
			nextHor.setShip(ship); 
			
			location.setOccupied(true);
			nextHor.setOccupied(true); 
			
			placedShips++; // incrementing the counter when a horizontal ship is placed;
		}
		
		else if(valid) { // this will generate vertical ships;
			
			mShip = new Battleship(row, col, col+1); // this is col+1 rather than row+1 to ensure the ship is vertical;
			
			location.setShip(ship);
			nextVert.setShip(ship);
			
			location.setOccupied(true);
			nextVert.setOccupied(true); 
			
			placedShips++; // incrementing the counter when a vertical ship is placed;
		}
	}
	
	// Large ship			
		
		Square nextHor =  board[row + 1][col]; 
		Square lastHor =  nextHor[row+1][col]; // a third Square that the ship will occupy; 
		
		Square nextVert =  board[row + 1][col]; 
		Square lastVert =  nextVert[row][col + 1]; // allowing for a ship to be created vertically across 3 squares;

		boolean horizontal = r.nextBoolean(); 
		boolean valid = location.isOccupied() == false && nextHor.isOccupied() == false && lastHor.isOccupied() == false; && nextVert.isOccupied() == false && lastVert.isOccupied() == false;
			
		if(horizontal && valid) {
			lShip = new LargeBattleship(row, col, row+1, row+2); //new Battleship created horizontally across 3 Squares;
				
			location.setLShip(lShip);
			nextHor.setLShip(lShip); 
			lastHor.setLShip(lShip); // associating the above battleship with these Squares;
			
			location.setOccupied(true);
			nextHor.setOccupied(true); 
			lastHor.setOccupied(true); // setting all to 'occupied' to indicate that the ship takes up 3 Squares;
			
			placedShips++; // 
		}
	}
		else if(valid) { // this will generate vertical ships;		
			lShip = new LargeBattleship(row, col, col+1, col+2); //new LargeBattleship created horizontally across 3 Squares;
							
			location.setLShip(lShip);
			nextVert.setLShip(lShip); 
			lastVert.setLShip(lShip); // associating the above ship with these Squares;
			
			location.setOccupied(true);
			nextVert.setOccupied(true); 
			lastVert.setOccupied(true);
			
			placedShips++; 
		}	
	}
	
	return board;
}
 */				