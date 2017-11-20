import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
	
	public void playGame() {
		
		// Create a game board object
		GameBoard gameBoard1 = new GameBoard();
		
		// You can set the size of the grid has the value is not hard coded
		int gridSize = 10;
		
		// Create 2D array which will act as the game board
		String [][] gameBoard = new String [gridSize][gridSize];
		
		// Set the board for use
		gameBoard1.setBoard(gameBoard,gridSize);
		
		gameBoard1.displayBoard(gameBoard);
		
		// Get users first shot
		String[] coordinates = getUserShot();
		
		// Take a shot at the users desired location
		takeShot(coordinates,gameBoard);
		gameBoard1.displayBoard(gameBoard);
		
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
	public static void takeShot(String[] coordinates, String [][] gameBoard) {
		
		// Make string array into integer array so we can use the user coordinates
		int[] coordinatesInteger = Arrays.stream(coordinates).mapToInt(Integer::parseInt).toArray();
		
		// Mark the grid with a miss
		gameBoard[coordinatesInteger[0]][coordinatesInteger[1]] = "x";
	}


}
