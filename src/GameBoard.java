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
		
		// Set sizes of ship
		int battleshipLength = 4;
		int cruiserLength = 3;
		int destroyerLength = 2;
		int subLength = 1;
		
		// Generate battleship
		placeShip(gameBoard, battleshipLength);
		displayBoard(gameBoard);
				
						
		// Generate cruisers
		placeShip(gameBoard, cruiserLength);
		placeShip(gameBoard, cruiserLength);
				
						
		// Generate destroyers
		placeShip(gameBoard,destroyerLength);
		placeShip(gameBoard,destroyerLength);
		placeShip(gameBoard,destroyerLength);
						
		// Generate subs
		placeShip(gameBoard,subLength);
		placeShip(gameBoard,subLength);		
		placeShip(gameBoard,subLength);
	}
	
	public void placeShip(String [][] gameBoard,int lengthOfShip) {
		// Declare variables
		int point1 = 0;
		int point2 = 0;
		int point1Copy = 0;
		int point2Copy = 0;
		boolean valid = true;
		
		// Define random number range
		int colsRange = 7;
		int rowsRange = 7;
		
		// Get random number
		point1 = getRandom(colsRange);
		point2 = getRandom(rowsRange);
		
		// Make a copy of that random number
		point1Copy = point1;
		point2Copy = point2;
		
		point1Copy = point1Copy - 1;
		for(int index = 0; index < lengthOfShip;index++) {
			point1Copy ++;
			
			// Check if position is equal to a ship
			if(gameBoard[point1Copy][point2Copy] != "~") {
				valid = false;
			}
			// If valid is equal to false then restart again
			if(valid == false) {
				placeShip(gameBoard, index);
			}
			
		}
		
		System.out.println(valid);
		// The ships generated position is valid and will not overlay another ship
		// So we can generate place our ship
		if(valid == true) {
			point1 = point1- 1;
			for(int index = 0; index < lengthOfShip; index++) {
				point1 = point1 + 1;
				if(lengthOfShip == 4) {
					gameBoard[point1][point2] = "B";
				}
				if(lengthOfShip == 3) {
					gameBoard[point1][point2] = "C";
				}
				if(lengthOfShip == 2) {
					gameBoard[point1][point2] = "D";
				}
				if(lengthOfShip == 1) {
					gameBoard[point1][point2] = "S";
				}	
			}
		}
	}
	public static int getRandom(int range) {
		
		// Generate 
		Random rn = new Random();
		int point = rn.nextInt(range) + 1;
		return point;
	}
	
	public void displayBoard(String[][] gameBoard) {
		
		// Display the current state of the board
		System.out.println("\nCurrent Board\n"+"---------------------------------------------------------");
		System.out.println("\n"+Arrays.deepToString(gameBoard).replace("], ", "\n").replace("[", "").replace("]", "").replaceAll(",",""));
		
	}

}
