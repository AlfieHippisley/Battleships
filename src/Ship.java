import java.util.concurrent.ThreadLocalRandom;

/**
 * Ship object, places ships onto array making sure they do not
 * overlap each other.
 * 
 * @author Alfie Hippisley 
 * @version 1.0
 */

public class Ship {
	
	/** Length of ship being placed */
	private int lengthOfShip;
	
	/**
     * Constructor - sets size to lengthOfShip
     * 
     * @param size length of the ship being placed
     */
	
	public Ship(int size) {
		lengthOfShip = size;
	}
	
	/**
     * Generates random values then checks if the generated
     * position is valid. If not valid it will generate position
     * again. If valid it stores the ships location in the array
     * 
     * @param shipData array holding information on ship positions
     */
	
	public void placeShip(String[][] shipData) {

		boolean shipPlaced = false;
		
		while(!shipPlaced) {
			// Declare variables
			int shipPoint1 = 0;
			int shipPoint2 = 0;
			boolean validShipLocation = false;
			boolean shipRotation = false;
			
			// Get values and check location
			shipPoint1 = getRandom();
			shipPoint2 = getRandom();
			shipRotation = getBoolean();
			validShipLocation = checkLocation(lengthOfShip, shipData, shipPoint1, shipPoint2, shipRotation);

			if (validShipLocation) {
				// Vertical rotation
				if (shipRotation) {
					shipPoint1 = shipPoint1 - 1;
					for(int index =0 ; index<lengthOfShip; index++) {
						shipPoint1++;
						shipData[shipPoint1][shipPoint2] = "S";
					}
					shipPlaced = true;
					break;
				}
				// horizontal rotation
				if (!shipRotation) {
					shipPoint1 = shipPoint2 - 1;
					for(int index =0 ; index<lengthOfShip; index++) {
						shipPoint2++;
						shipData[shipPoint1][shipPoint2] = "S";
					}
					
				shipPlaced = true;
				break;
				}	
			}
		}
	}
	
	/**
     * Generates random values then checks if the generated
     * position is valid. If not valid it will generate position
     * again. If valid it returns valid
     * 
     * @param lengthOfShip the length of the ship being placed
     * @param shipData array holding information on ship positions
     * @param shipPoint1 first array position of ship
     * @param shipPoint2 second array position of ship
     * @param shipRotation a randomly generated boolean choosing rotation of the ship being placed
     * 
     * @return valid boolean telling placeShip if position is valid or not
     */
	
	public static boolean checkLocation(int lengthOfShip, String[][] shipData, int shipPoint1, int shipPoint2, boolean shipRotation) {
		
		boolean valid = true;
		// Vertical rotation
		if(shipRotation) {
			shipPoint1 = shipPoint1 -1;
			for (int index = 0; index < lengthOfShip; index++) {
				shipPoint1 = shipPoint1 + 1;
				
				// Vertical rotation
				if(shipPoint1 > (9 - lengthOfShip+1)) {
					valid = false;
					return valid;
				}
					
				// If location is not water then it is invalid.
				if(shipData[shipPoint1][shipPoint2] != "~") {
					valid = false;
					return valid;
				}
			}
		}
		
		// Horizontal rotation
		if(!shipRotation) {
			shipPoint2 = shipPoint2 -1;
			for (int index = 0; index < lengthOfShip; index++) {
				shipPoint2 = shipPoint2 + 1;
				
				// Vertical rotation
				if(shipPoint2 > (9 - lengthOfShip+1)) {
					valid = false;
					return valid;
				}
					
				// If location is not water then it is invalid.
				if(shipData[shipPoint1][shipPoint2] != "~") {
					valid = false;
					return valid;
				}
			}
		}	
		return valid;
	}

	/**
     *  get a random number between 1 and 8
     *  
     *  @return point random number
     */
	
	public static int getRandom() {
		// Generate random number
		int point = ThreadLocalRandom.current().nextInt(1, 8);
		return point;
	}
	
	/**
     *  get a boolean value
     *  
     *  @return Math.random true or false boolean value
     */
	
	public static boolean getBoolean() {
		// Generate random boolean
	       return Math.random() < 0.5;
	}

}