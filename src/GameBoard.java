import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
	
	private int totalShotsTaken;
	private int totalShotsHit;
	private int gridSize;
	private String[][] gameBoard;
	
	public GameBoard(){
		gridSize = 9;
		totalShotsTaken = 0;
		totalShotsHit = 0;
		
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
	
	public void loadGame() {
		
		// Notify user
		System.out.println("Loading Game,");
		
		// Set file reader and buffered reader
		FileReader fileReader = null;
	    BufferedReader bufferedReader = null;
		
	    // Set save file name
		String fileName = "gameSave";
		
		// Set string which will hold the data being read in
		String nextLine = null;
		
		try {
			// Create file reader and buffered reader
	    	fileReader = new FileReader(fileName);
	        bufferedReader = new BufferedReader(fileReader); 
	        
	        // Read in a line from the file
	        nextLine = bufferedReader.readLine();
	      
	        // Nested loop to set each line read in to the array
	        for(int rows = 0; rows < gameBoard.length;rows++) {
	            for(int cols = 0; cols < gameBoard.length;cols++) {
	            	gameBoard[rows][cols] = nextLine;
	            	// Get new line
	            	nextLine = bufferedReader.readLine();
	            }
	        }
		}
	    catch (FileNotFoundException e){
	    	System.out.println("Sorry, your file was not found.");
		}
						
		catch (IOException e){
			System.out.println("Sorry, there has been a problem opening or writing to the file");
		}
						
		finally {	            
			if (bufferedReader != null) {
				try{
					bufferedReader.close();    
				}
					            
				catch (IOException e){
					System.out.println("An error occurred when attempting to close the file");
				}
			}
		}
	}
	
	public void saveGameAndQuit() {
		saveGame();
		System.out.print("Game will now quit");
		System.exit(0);
	}
	
	public void saveGame() {
		// Notify user
		System.out.println("Running file save,");

		// Set file reader and buffered reader
		FileOutputStream outputStream = null;
        PrintWriter printWriter = null;
        
        // Set save file name
     	String fileName = "gameSave";
        
        try{
        	// Create file reader and buffered reader
            outputStream = new FileOutputStream(fileName);
            printWriter = new PrintWriter(outputStream); 
            
            // Nested loop to set each array position in to the file
            for(int rows = 0; rows < gameBoard.length;rows++) {
            	for(int cols = 0; cols < gameBoard.length;cols++) {
            		printWriter.println(gameBoard[rows][cols]);
            	}
            }
            
            System.out.print("File save complete sucessfully\n");
            // Close print writer
            printWriter.close();
        }
        
        catch (IOException e){
            System.out.println("Sorry, there has been a problem opening or writing to the file");
        }
        
        finally{
            if (printWriter != null){
            	 printWriter.close();
            }
        }
        
        playGame();
		
	}
	
	public void generateEnemy() {
		
		// Create the ships passing the size of each ship
		Ship battleship = new Ship(4);
		Ship cruiser1 = new Ship(3);
		Ship cruiser2 = new Ship(3);
		Ship destroyer1 = new Ship(2);
		Ship destroyer2 = new Ship(2);
		Ship destroyer3 = new Ship(2);
		Ship Sub1 = new Ship(1);
		Ship Sub2 = new Ship(1);
		Ship Sub3 = new Ship(1);
		
		// Place each of the ships passing the gameBoard array
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
	
	public void playGame() {
		
		
		while(totalShotsHit <= 18) {
			displayGameBoard();
			// Get user shot
			System.out.println("\nPlease enter where you would like to shoot (e.g 1,2)"
					+ "\nIf you would like to just save the game, enter '-1'."
					+ "\nIf you would like to save and quit, enter '-2'.\n\nEnter : ");
			Scanner entry = new Scanner(System.in);
			int userInput = entry.nextInt();
		
			// Process user shot
			if(userInput == -1) {
				saveGame();
			}
			
			if(userInput == -2) {
				saveGameAndQuit();
			}

			int userInput2 = entry.nextInt();
			
			// If a ship then mark a hit
			if(gameBoard[userInput][userInput2] != "~") {
				gameBoard[userInput][userInput2] = "H";
				System.out.println(totalShotsHit);
				totalShotsHit++;
				totalShotsTaken++;
			}
			
			// If water then mark a miss
			else if(gameBoard[userInput][userInput2] == "~") {
				gameBoard[userInput][userInput2] = "M";
				totalShotsTaken++;
			}
		}
		
		// Display victory message
		System.out.println("You have won with a total of " + totalShotsTaken +" shots taken.");
		System.out.println("Of those " + totalShotsTaken + " shots taken, " + totalShotsHit + " shots hit a target.");
	}
}