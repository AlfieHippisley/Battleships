import java.util.Scanner;

public class Menu {
	
	public void displayMenu() {

		// Display title
		System.out.println("\nWelcome to Battleships\n"+"---------------------------------------------------------");
		
		// Display menu options
		System.out.println("1 - Start Game\n" + "2 - Exit Game\n");
		
		// Display end of menu
		System.out.println("---------------------------------------------------------");
		
		// Get user input via scanner
		Scanner entry = new Scanner(System.in);
		int userInput = entry.nextInt();
		
		// Process user input
		switch (userInput) {
		
		// Case 1 (Start Game)
		case 1:
		break;
		
		// Case 2 (Exit Program)
		case 2:
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
