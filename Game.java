import java.util.Scanner;

public class Game {
	/** I was not able to generate a proper stopping condition for the game using the boolean returned from the Player takeTurn method.  The loop currently
	 * in place is only there for testing to prove that the rest of the game works as intended.  I also struggled to implement the Battleship
	 * subclasses from Task 5.  While I was able to print out each type of ship successfully, I wasn't able to associate the ship with the Squares it was
	 * printed on, meaning I wasn't able to decrease its health when hit or raise the player's score accordingly.  The code for this alternative implementation
	 * with multiple Battleship types is included as comments in the relevant sections and marked with the letters ALT;
	 */
	public static void main(String[] args) {
		
		Board board = new Board(10,10); // creating the game board;
		
		Scanner s = new Scanner(System.in);
		
		// Prompting users for their names and creating new Player object with the provided names;
		System.out.println("Player One, please enter your name: ");
		String oneName = s.nextLine();
		Player playerOne = new Player("jane", board);
		System.out.println("Welcome, " + oneName+".");
		
		System.out.println("Player Two, please enter your name: ");
		String twoName = s.nextLine();
		Player playerTwo = new Player(twoName, board);
		System.out.println("Welcome, " + twoName + ".\n");
		
		
		// Giving instructions and starting the game;
		System.out.println("There are five ships hidden on the board.  You will be prompted for coordinates and must try to sink all of the ships.");
		System.out.println("You will get a point for each ship you sink. The player with the most points at the end wins.");
		System.out.println("Good luck!  Begin. \n");
		
		System.out.println(board);

		int test = 0;
		while (test < 20) { 
			// playerOne's turn;
			System.out.println(oneName+ ", it's your turn.");
			playerOne.takeTurn(); // calling the takeTurn method, which will prompt users for input and update the board as required;

			System.out.println(board);
			System.out.println("Player Score: " + playerOne.getScore());
				
			// playerTwo's turn;
			System.out.println(twoName + ", it's your turn.");
			playerTwo.takeTurn();
		
			System.out.println(board);
			System.out.println("Player Score: " + playerTwo.getScore());
		}

		// Final update at the end of the game
		System.out.println("Final scores: ");
		System.out.println("\t" + oneName + ": " + playerOne.getScore());
		System.out.println("\t" + twoName + ": " + playerTwo.getScore());
		
		if(playerOne.getScore() > playerTwo.getScore()) {
			System.out.println("Congratulations " + oneName + "!  You win!"); // if playerOne's score was higher;
		}
		
		if(playerOne.getScore() < playerTwo.getScore()) {
			System.out.println("Congratulations " + twoName + "!  You win!"); // if playerTwo's score was higher;
		}
		
		/*ALT: denoting a draw if the game is implemented with multiple Battleship types;
		 * 
		if(playerOne.getScore() == playerTwo.getScore()) {
			System.out.println("It's a draw!"); 
		} */
	}
}
		