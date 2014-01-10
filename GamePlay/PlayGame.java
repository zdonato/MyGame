// Developer: player1ary Donato
// Date: 1.8.14

import java.util.Random; 
import java.util.Scanner; 

// A class to play the game. 
public class PlayGame {
	static boolean turnCheck = true; // Bool value to ensure the player has made a move before switching to the other player's turn. 
	private static int dmg; 
	private static Random generator = new Random(); 
	
	public static void main(String[] args) {
		// Create two players. 
		Player player1 = new Player(100, "player1", 1000); 
		Player player2 = new Player(100, "player2", 1000);
		// Variables to keep tract of who deals and receives damage. 
		Player currPlayer = player1; 
		Player other = player2; 
		// While loop to create the textual interface of the game. 
		while (true){
			System.out.println(currPlayer.getName() + " it is your turn."); 
			Scanner scan = new Scanner(System.in); // Scanner to read input. 
			System.out.println("Choose a move by typing an option from the list below: (Type 0 to quit)"); 
			System.out.println("Attack | Heal | Pass");
			String choice = scan.next(); // Read the user's choice as a string value on the next line. 
			if ("Attack".equals(choice) || "attack".equals(choice)){
				// Generate a random number to be applied as damage. 
				dmg = generator.nextInt(currPlayer.getMaxDmg()) + 1; 
				System.out.println("You dealt " + dmg +" damage to " + other.getName() ); 
				other.dmgDealt(dmg); // Apply the damage. 
				System.out.println("Your current health is: " + currPlayer.getHealth()); 
				System.out.println(other.getName() + "'s current health is: " + other.getHealth()); 
				turnCheck = true; // Allow switch to other player's turn. 
			} else if ("Heal".equals(choice) || "heal".equals(choice)){
				System.out.println("Choose what to heal with: (Type 0 to quit)"); 
				// List of options to choose to heal with. Expandable. 
				System.out.println("Lobster (200) | Shark (500) | Shrimp (100) | Back (To go back)"); 
				Scanner foodScan = new Scanner(System.in); // New Scanner to read the user's choice. 
				String foodChoice = foodScan.next(); // Read the next line as a string value. 
				if ("0".equals(foodChoice)){
					break;  // End the loop and game if 0 is the input. 
				} else if ("Back".equals(foodChoice) || "back".equals(foodChoice)){ // Option to return to main menu. 
					System.out.println("Taking you back to the main menu... "); 
					turnCheck = false; // Go back to the main menu without switching turns. 
				} else {
					currPlayer.heal(foodChoice); // Heal the player based on choice. The heal method will check for invalid inputs. 
					System.out.println("Your current health is: " + currPlayer.getHealth()); 
					System.out.println(other.getName() + "'s current health is: " + other.getHealth()); 
					turnCheck = true; // Allow for turn switch. 
				}
			} else if ("0".equals(choice)){
				break; // End the loop if 0 is chosen.  
			} else if ("Pass".equals(choice) || "pass".equals(choice)){ // Option to pass if no action is desired.
				System.out.println("You choose to pass. Switching turns..."); 
			} else { // Covers any other case that is not a valid input. Except for an enter command. 
				System.out.println("Invalid Command. Choose again..."); 
				turnCheck = false; // Go back to main menu without switching turns. 
			}
			// Cases to determine if there is a win. 
			if (currPlayer.getHealth() <= 0){
				System.out.println("Congratulations! " + other.getName() + " wins!");
				break;
			} else if (other.getHealth() <= 0){
				System.out.println("Congratulations! " + currPlayer.getName() + " wins!"); 
				break; 
			}
			// Cases to switch turns only if turnCheck = true. 
			if (currPlayer.equals(player1) && turnCheck){
			currPlayer = player2; 
			other = player1; 
			} else if(currPlayer.equals(player2) && turnCheck){
				currPlayer = player1; 
				other = player2; 
			}
		}
	} // End main. 
} // End class playGame. 