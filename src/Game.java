import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
	
	public void playGame() {
		
		// You can set the size of the grid has the value is not hard coded.
		int gridSize = 10;
		
		// Create 2D array which will act as the game board
		String [][] gameBoard = new String [gridSize][gridSize];
		
		// Set the board for use
		setBoard(gameBoard,gridSize);
		displayBoard(gameBoard);
		
		// Get users first shot
		String[] coordinates = getUserShot();
		
		System.out.println(coordinates[0]);
		System.out.println(coordinates[1]);
		
	}
	
	public static void setBoard(String [][] gameBoard, int gridSize) {
		
		// Fill our array with '~' to represent open water
		for(int rows=0 ; rows < gridSize ; rows++ )
            for(int cols=0 ; cols < gridSize ; cols++ )
                gameBoard[rows][cols]="~";
		
		// Add letters to the top of the board to allow user to choose location
		for(int index =1 ; index < gridSize ; index++) {
			gameBoard[index][0]= String.valueOf(index);
		}
		
		// Add numbers to the side of the board to allow user to choose location
		for(int index =1 ; index < gridSize ; index++) {
			gameBoard[0][index]= String.valueOf(index);
		}

		// Tidy up 0,0
		gameBoard[0][0] ="x";
		
	}
	
	public static void displayBoard(String[][] gameBoard) {
		
		// Display the current state of the board
		System.out.println("\nCurrent Board\n"+"---------------------------------------------------------");
		System.out.println("\n"+Arrays.deepToString(gameBoard).replace("], ", "\n").replace("[", "").replace("]", "").replaceAll(",",""));
		
	}
	
	public static String[] getUserShot() {
		
		// Get user shot via scanner
		Scanner entry = new Scanner(System.in);
		System.out.println("\nPlease enter the coordinates where you would like to shoot (eg 1,6):");
		String userShot = entry.nextLine();
		
		// Now split the user entry where a ',' was used and make it an array
		String[] coordinates = userShot.split(Pattern.quote(","));

		// Now return the user shot coordinates
		return coordinates;
		
	}

}
