import java.util.Scanner;

public class Menu {
	
	public void displayMenu() {

		// Display title
		System.out.println("\nBattleships\n"+"---------------------------------------------------------");
		
		// Display menu options
		System.out.println("1 - Play\n");
		
		// Display end of menu
		System.out.println("---------------------------------------------------------");
		
		// Get user input via scanner
		Scanner entry = new Scanner(System.in);
		int userInput = entry.nextInt();
		
		// Process user input
		switch (userInput) {
		
		// Case 1
		case 1:
		break;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		// Create objects
		Menu menu = new Menu();
	
		// Use Objects
		menu.displayMenu();
	}

}
