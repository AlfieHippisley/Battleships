import java.util.Scanner;

/**
 * Provides a user menu to access the battleships class
 * and allows the user to run the game.
 * 
 * @author Alfie Hippisley 
 * @version 1.0
 */

public class Menu {
	
	/**
     * Shows the main game menu to the user and processes their input
     * 
     */
	
	public void displayMenu() {

		// Display title & options
		System.out.println("\nBattleships\n"+"---------------------------------------------------------");
		System.out.println("1 - Start Game\n" + "2 - Load Last Saved Game\n" + "3 - How To Play\n" + "4 - Exit Game\n");

		// Take user input & process
		Scanner scanner1 = new Scanner(System.in);
		int userInput = scanner1.nextInt();
		
		switch (userInput) {
		
			// Case 1 (Start new game)
			case 1:
				startNewGame();
			break;
			
			// Case 2 (Start from game save)
			case 2:
				loadGame();
			break;

			// Case 3 (How to play)
			case 3:
				System.out.println("\nHow to play\n"+"---------------------------------------------------------");
				System.out.println("The goal of this game is to sink all of the enemy ships.\nYou can not see the ememy ship locations.\n"
								 + "\nWater is represented by '~'\nA miss is represented by 'o'\nA hit is represented by 'X'"
								 + "\n\nCordinates are entered by first choosing the horizontal "
								 + "\nnumber then the vertical number");
				displayMenu();
			break;
			
			// Case 4 (Exit Program)
			case 4:
				System.exit(0);
			break;
		}
	}
	
	/**
     * Creates a new game board and runs a new game
     * 
     */
	
	public void startNewGame() {

		GameBoard board1 = new GameBoard();
		board1.setGrid();
		board1.generateEnemy();
		board1.playGame();
		
	}
	
	/**
     * Creates a new game board and loads a game
     * 
     */
	
	public void loadGame() {
		
		GameBoard board2 = new GameBoard();

		board2.loadGame();
		board2.playGame();
	}
	
	/**
     * Main Method
     * 
     */
	
	public static void main(String[] args) {
		boolean menuDisplay = true;
		Menu menu = new Menu();
		while(menuDisplay) {
			menu.displayMenu();
		}
	}

}