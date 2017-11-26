
public class Battleships {
	
	public Battleships(){
	}
	
	public void startNewGame() {
		int shots = 0;
		// Create game board
		GameBoard game1 = new GameBoard();
				
		// Generate enemy
		game1.generateEnemy();
				
		// Run game
		while(shots <50) {
			game1.displayGameBoard();
			game1.getUserShot();
		}
	}
	
	public void loadGame() {
		GameBoard game2 = new GameBoard();
		game2.loadGame();
		game2.displayGameBoard();
	}
}
