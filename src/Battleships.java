
public class Battleships {
	
	public Battleships(){
	}
	
	public void startNewGame() {
		int shots = 0;
		
		// Create game board
		GameBoard game1 = new GameBoard();
				
		// Generate enemy
		game1.generateEnemy();
		
		// Play game
		game1.playGame();
		
	}
	
	public void loadGame() {
		// Create a new game object and array
		GameBoard game2 = new GameBoard();
		
		// Load the file and fill the array
		game2.loadGame();
		
		// Display the game board
		game2.displayGameBoard();
	}
}
