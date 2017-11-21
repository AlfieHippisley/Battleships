import java.util.Random;

public class Ship {
	
	private int lengthOfShip;
	private boolean alive;
	
	public Ship(int size) {
		lengthOfShip = size;
	}
	
	public void placeShip(String[][] gameBoard) {
		// Declare variables
		int point1 = 0;
		int point2 = 0;
		int point1Copy = 0;
		int point2Copy = 0;
		boolean valid = true;
				
		// Define random number range
		int colsRange = 6;
		int rowsRange = 6;
				
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
				placeShip(gameBoard);
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
}