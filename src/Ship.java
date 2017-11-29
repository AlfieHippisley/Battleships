import java.util.concurrent.ThreadLocalRandom;

public class Ship {
	
	private int lengthOfShip;
	
	public Ship(int size) {
		lengthOfShip = size;
	}
	
	public void placeShip(String[][] gameBoard) {
		
		boolean placed = false;
		
		while(!placed) {
			// Declare variables
			int point1 = 0;
			int point2 = 0;
			point1 = getRandom();
			point2 = getRandom();
			boolean rotation = getBoolean();
			boolean valid = false;
			valid = checkLocation(lengthOfShip, gameBoard, point1, point2, rotation);
			
			if (valid) {
				// Vertical rotation
				if (rotation) {
					point1 = point1 - 1;
					for(int index =0 ; index<lengthOfShip; index++) {
						point1++;
						
						if(lengthOfShip == 4) {
							gameBoard[point1][point2] = "B";
						}
						else if(lengthOfShip == 3) {
							gameBoard[point1][point2] = "C";
						}
						else if(lengthOfShip == 2) {
							gameBoard[point1][point2] = "D";
						}
						else if(lengthOfShip == 1) {
							gameBoard[point1][point2] = "S";
						}
					}
					placed = true;
					break;
				}
					
				// horizontal rotation
				if (!rotation) {
					point2 = point2 - 1;
					for(int index =0 ; index<lengthOfShip; index++) {
						point2++;
						if(lengthOfShip == 4) {
							gameBoard[point1][point2] = "B";
						}
						else if(lengthOfShip == 3) {
							gameBoard[point1][point2] = "C";
						}
						else if(lengthOfShip == 2) {
							gameBoard[point1][point2] = "D";
						}
						else if(lengthOfShip == 1) {
							gameBoard[point1][point2] = "S";
						}
					}
					placed = true;
					break;
				}	
			}
		}
	}
	
	public static boolean checkLocation(int lengthOfShip, String[][] gameBoard, int pointA, int pointB, boolean rotation) {
		
		String rot = null;
		
		if(rotation) {
			rot = "Vertical";
		}
		
		if(!rotation) {
			rot = "Horizontal";
		}
		
		//System.out.println("Checking Ship Position for " + rot);
		
		boolean valid = true;
		
		if(rotation) {
			pointA = pointA -1;
			for (int index = 0; index < lengthOfShip; index++) {
				pointA = pointA + 1;
				
				// Vertical rotation
				if(pointA > (9 - lengthOfShip+1)) {
					valid = false;
					return valid;
				}
					
				// If location is not water then it is invalid.
				if(gameBoard[pointA][pointB] != "~") {
					valid = false;
					return valid;
				}
			}
		}
		
		if(!rotation) {
			pointB = pointB -1;
			for (int index = 0; index < lengthOfShip; index++) {
				pointB = pointB + 1;
				
				// Vertical rotation
				if(pointB > (9 - lengthOfShip+1)) {
					valid = false;
					return valid;
				}
					
				// If location is not water then it is invalid.
				if(gameBoard[pointA][pointB] != "~") {
					valid = false;
					return valid;
				}
			}
		}	
		
		return valid;
	}
	
	public static int getRandom() {
		// Generate random number
		int point = ThreadLocalRandom.current().nextInt(1, 8);
		return point;
	}
	
	public static boolean getBoolean() {
		// Generate random boolean
	       return Math.random() < 0.5;
	}
}