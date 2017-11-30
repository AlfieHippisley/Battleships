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
	private String[][] shipBoard;
	
	public GameBoard(){
		gridSize = 10;
		totalShotsTaken = 0;
		totalShotsHit = 0;
		
		// Create array with our grid size restrictions
		gameBoard = new String[gridSize][gridSize];
		// Ship board array stores ship locations not visible to user
		shipBoard = new String[gridSize][gridSize];
	}
		
	public void setGrid() {
		// Fill gameBoard array with 'water'
		for(int rows=0 ; rows < gridSize ; rows++ ) {
			for(int cols=0 ; cols < gridSize ; cols++ ) {
				gameBoard[rows][cols]="~";
			}
		}
				
		// Fill ship array with water
		for(int rows=0 ; rows < gridSize ; rows++ ) {
			for(int cols=0 ; cols < gridSize ; cols++ ) {
				shipBoard[rows][cols]="~";
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
		// Display the current state of the board but move it down the console to reduce screen clutter
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
		"Current Board\n"+"---------------------------------------------------------");
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
	        for(int rows = 0; rows < shipBoard.length;rows++) {
	            for(int cols = 0; cols < shipBoard.length;cols++) {
	            	shipBoard[rows][cols] = nextLine;
	            	// Get new line
	            	nextLine = bufferedReader.readLine();
	            }
	        }

	        totalShotsTaken = Integer.parseInt(nextLine);
	        nextLine = bufferedReader.readLine();
	        totalShotsHit = Integer.parseInt(nextLine);
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
            
            // Nested loop to set each array position in to the file
            for(int rows = 0; rows < shipBoard.length;rows++) {
            	for(int cols = 0; cols < shipBoard.length;cols++) {
            		printWriter.println(shipBoard[rows][cols]);
            	}
            }
            
            // Write scores into file so can be resumed
            printWriter.println(totalShotsTaken);
            printWriter.println(totalShotsHit);
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
		battleship.placeShip(shipBoard);
		cruiser1.placeShip(shipBoard);
		cruiser2.placeShip(shipBoard);
		destroyer1.placeShip(shipBoard);
		destroyer2.placeShip(shipBoard);
		destroyer3.placeShip(shipBoard);
		Sub1.placeShip(shipBoard);
		Sub2.placeShip(shipBoard);
		Sub3.placeShip(shipBoard);
	}
	
	public void playGame() {
		
		boolean invalid = false;
		
		while(totalShotsHit <= 18) {
			displayGameBoard();
			// Check if last shot was an invalid shot
			if(invalid) {
				System.out.println("\n--------------------------------------------------------"+
								   "\nThat shot was not valid.\nMake sure it is between 1 & 9\nMake sure you are not shooting "
				                 + "somewhere you have already shot,\nPlease try again");
				invalid = false;
			}
			System.out.println("\n--------------------------------------------------------"
					+ "\nPlease enter where you would like to shoot (e.g 1 'enter' then 2 'enter')"
					+ "\nIf you would like to save and quit, enter '-1'"
					+ "\n---------------------------------------------------------"
					+ "\n\nEnter : ");
			
			// Get user input and process
			Scanner scanner1 = new Scanner(System.in);
			int userInput = scanner1.nextInt();
			
			if(userInput == -1) {
				saveGameAndQuit();
			}
			
			else if(userInput == -2) {
				System.exit(0);
			}
			
			System.out.println("\nEnter second point : ");
			
			int userInput2 = scanner1.nextInt();
			
			if( userInput > 9  || userInput < 1  || userInput2 > 9  || userInput2 <1) {
				invalid = true;
			}
			
			// If a ship then mark a hit
			else if(shipBoard[userInput2][userInput] == "S") {
				gameBoard[userInput2][userInput] = "H";
				totalShotsHit++;
				totalShotsTaken++;
			}
			
			// If water then mark a miss
			else if(shipBoard[userInput2][userInput] != "S" && gameBoard[userInput2][userInput] != "M" ) {
				gameBoard[userInput2][userInput] = "M";
				totalShotsTaken++;
			}
			// If in location already shot at, tell user don't count score
			else if(shipBoard[userInput2][userInput] == "S" && gameBoard[userInput2][userInput] == "H") {
				invalid = true;
			}
			// If shooting in somewhere they have shot before... tell them
			else if(gameBoard[userInput2][userInput] == "M") {
				invalid = true;
			}
		}
		
		// Display victory message
		System.out.println("You have won with a total of " + totalShotsTaken +" shots taken.");
		System.out.println("Of those " + totalShotsTaken + " shots taken, " + totalShotsHit + " shots hit a target.");
	}
}