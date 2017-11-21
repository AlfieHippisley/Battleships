import java.util.Arrays;

public class GameBoard {
	
	private int gridSize;
	private String[][] gameBoard;
	
	public GameBoard(){
		gridSize = 9;
		
		// Create array with our grid size restrictions
		gameBoard = new String[gridSize][gridSize];

		// Fill array with 'water'
		for(int rows=0 ; rows < gridSize ; rows++ ) {
			for(int cols=0 ; cols < gridSize ; cols++ ) {
				gameBoard[rows][cols]="~";
			}
		}
		
		// Add letters to the top of the board to allow user to choose location
		for(int index =1 ; index < gridSize ; index++) {
			gameBoard[index][0]= String.valueOf(index);
		}
						
		// Add numbers to the side of the board to allow user to choose location
		for(int index =1 ; index < gridSize ; index++) {
			gameBoard[0][index]= String.valueOf(index);
		}

		// Tidy up 0,0
		gameBoard[0][0] =".";
	}
		
	public void displayGameBoard() {
		// Display the current state of the board
		System.out.println("\nCurrent Board\n"+"---------------------------------------------------------");
		System.out.println("\n"+Arrays.deepToString(gameBoard).replace("], ", "\n").replace("[", "").replace("]", "").replaceAll(",",""));
	}
	
	public void generateEnemy() {
		Ship battleship = new Ship(4);
		Ship cruiser1 = new Ship(3);
		Ship cruiser2 = new Ship(3);
		Ship destroyer1 = new Ship(2);
		Ship destroyer2 = new Ship(2);
		Ship destroyer3 = new Ship(2);
		Ship Sub1 = new Ship(1);
		Ship Sub2 = new Ship(1);
		Ship Sub3 = new Ship(1);
		
		battleship.placeShip(gameBoard);
		cruiser1.placeShip(gameBoard);
		cruiser2.placeShip(gameBoard);
		destroyer1.placeShip(gameBoard);
		destroyer2.placeShip(gameBoard);
		destroyer3.placeShip(gameBoard);
		Sub1.placeShip(gameBoard);
		Sub2.placeShip(gameBoard);
		Sub3.placeShip(gameBoard);
	}
}