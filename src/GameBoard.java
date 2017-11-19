import java.util.Arrays;
import java.util.Random;

public class GameBoard {

	public void setBoard(String [][] gameBoard, int gridSize) {

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
	
	public void generateShips(String [][] gameBoard) {
		
		// Set sizes of ship
		int battleshipLength = 4;
		int cruiserLength = 3;
		int destroyerLength = 2;
		int subLength = 1;
		
		// Generate battleship
		createShip(gameBoard, battleshipLength, false);
				
		// Generate cruisers
		createShip(gameBoard, cruiserLength, false);
		createShip(gameBoard, cruiserLength, false);
				
		// Generate destroyers
		createShip(gameBoard,destroyerLength, false);
		createShip(gameBoard,destroyerLength, false);
		createShip(gameBoard,destroyerLength, false);
				
		// Generate subs
		createShip(gameBoard,subLength, false);
		createShip(gameBoard,subLength, false);
		createShip(gameBoard,subLength, false);
	}
	
	public static void createShip(String [][] gameBoard,int lengthOfShip, boolean runAgain) {

		
		// Test variable
		
		if (runAgain == true) {
			System.out.println("It ran again");
		}
		
		
		// Generate random point
		Random numberGen = new Random();
		
		// Create variables to store random point
		int randomNumber = 0;
		int randomNumber2 = 0;
		int storedRandomNumber = 0;
		int storedRandomNumber2 = 0;
		
		// Generate random point
		randomNumber = numberGen.nextInt(6) + 1;
		randomNumber2 = numberGen.nextInt(9) + 1;
		
		storedRandomNumber = randomNumber;
		storedRandomNumber2 = randomNumber2;
		
		storedRandomNumber= storedRandomNumber - 1;
		
		for(int index = 0; index < lengthOfShip; index++) {
			storedRandomNumber= storedRandomNumber + 1;
			if(gameBoard[storedRandomNumber][storedRandomNumber2] == ("S")) {
				System.out.println("Overlay Alert!! Kernal Panic");
				runAgain = true;
				createShip(gameBoard, lengthOfShip, runAgain);
				
			}
		}
		
		randomNumber = randomNumber - 1;
		
		// Draw ship according to its size
		for(int index = 0; index < lengthOfShip; index++) {
			randomNumber = randomNumber+1;
			gameBoard[randomNumber][randomNumber2] = "S";
			
		}
	}

	public void displayBoard(String[][] gameBoard) {
		
		// Display the current state of the board
		System.out.println("\nCurrent Board\n"+"---------------------------------------------------------");
		System.out.println("\n"+Arrays.deepToString(gameBoard).replace("], ", "\n").replace("[", "").replace("]", "").replaceAll(",",""));
		
	}
}
