
public class Battleships {
	
	public Battleships(){
	}
	
	public void startNewGame() {
		int shots = 0;
		
		// Create game board
		GameBoard game1 = new GameBoard();
				
		// Generate enemy
		game1.generateEnemy();
		
		game1.playGame();
		
	}
	
	public void loadGame() {
		GameBoard game2 = new GameBoard();
		game2.loadGame();
		game2.displayGameBoard();
	}
}
