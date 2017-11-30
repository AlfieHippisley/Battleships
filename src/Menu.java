import java.util.Scanner;

public class Menu {
	
	public void displayMenu(Boolean displayMenu) {
		
		// Display title
		System.out.println("\nBattleships\n"+"---------------------------------------------------------");
		
		// Display menu options
		System.out.println("1 - Start Game\n" + "2 - Load Last Saved Game\n" + "3 - How To Play\n" + "4 - Exit Game\n");

		// Get user input via scanner
		Scanner entry = new Scanner(System.in);
		int userInput = entry.nextInt();
		
		// Process user input
		switch (userInput) {
		
		// Case 1 (Start Game)
		case 1:
			displayMenu = false;
			
			// Create game object
			Battleships game1 = new Battleships();
			game1.startNewGame();
			System.exit(0);

		break;
		
		// Case 3 (Load Save)
		case 2:
			Battleships game2 = new Battleships();
			game2.loadGame();
		break;
		
		// Case 3 (How to play)
		case 3:
			System.out.println("\nHow to play\n"+"---------------------------------------------------------");
			System.out.println("The goal of this game is to sink all of the enemy ships.\nYou can not see the ememy ship locations.\n"
							 + "\nWater is represented by '~'\nA miss is represented by 'o'\nA hit is represented by 'X'");
		break;
		
		// Case 4 (Exit Program)
		case 4:
			System.exit(0);
		break;
		}
	}
	
	public static void main(String[] args) {
		// Declare variables
		Boolean displayMenu = true;
		
		// Create instance of menu object
		Menu menu = new Menu();
	
		// Run menu when we want it to run
		while (displayMenu = true) {
			// Display menu
			menu.displayMenu(displayMenu);
		}
		
	}

}