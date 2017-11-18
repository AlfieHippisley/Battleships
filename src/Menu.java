import java.util.Scanner;

public class Menu {
	
	public void displayMenu() {

		// Display title
		System.out.println("\nWelcome to Battleships\n"+"---------------------------------------------------------");
		
		// Display menu options
		System.out.println("1 - Start Game\n" + "2 - How to play\n" + "3 - Exit Game\n");

		// Get user input via scanner
		Scanner entry = new Scanner(System.in);
		int userInput = entry.nextInt();
		
		// Process user input
		switch (userInput) {
		
		// Case 1 (Start Game)
		case 1:
			// Create game object
			Game game1 = new Game();
			game1.playGame();
		break;
		
		// Case 3 (How to play)
		case 2:
		break;
		
		// Case 2 (Exit Program)
		case 3:
			System.exit(0);
		break;
		}
		
	}
	
	public static void main(String[] args) {
		
		// Create instance of menu object
		Menu menu = new Menu();
	
		// Run menu with menu object
		menu.displayMenu();
	}

}
