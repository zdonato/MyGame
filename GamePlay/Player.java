// Developer: Zachary Donato 
// Date: 1.8.13 

// A class to create a player. 
public class Player{
	// Initialize variables. 
	private int maxDmg; 
	private String name; 
	private int health; 
	// The available foods. Attempted to use TreeMap, but method heal malfcuntioned. 
	// Reminder to try that again at a later time. 
	private int lobster = 200; 
	private int shark = 500; 
	private int shrimp = 100; 
	// Variables to keep count of the available supplies during a session. 
	private int numL = 5; 
	private int numShark = 2; 
	private int numShrimp = 10; 
	
	// Constructor. 
	public Player(int md, String n, int h){
		this.maxDmg = md;  
		this.name = n; 
		this.health = h; 
	} // End Constructor. 
	
	// Method dmgDealt for receiving damage. 
	public void dmgDealt(int damage){
		health -= damage; 
	} // End dmgDealth. 
	
	// Method heal for healing the player. 
	public void heal(String foodName){
		if ("Lobster".equals(foodName) || "lobster".equals(foodName)){
			if (numL > 0){
				health += lobster; 
				numL--;
				System.out.println("You have " + numL + " lobsters left."); 
			 } else {
				System.out.println("Sorry, you are out of lobsters."); 
			}
		} else if ("Shark".equals(foodName) || "shark".equals(foodName)){
			if (numShark > 0){
				health += shark; 
				numShark--; 
				System.out.println("You have " + numShark + " sharks left."); 
			} else { 
				System.out.println("Sorry, you are out of sharks."); 
			}
		} else if ("Shrimp".equals(foodName) || "shrimp".equals(foodName)){
			if (numShrimp > 0){
				health += shrimp; 
				numShrimp--; 
				System.out.println("You have " + numShrimp + " shrimp left."); 
			} else {
				System.out.println("Sorry, you are out of shrimp."); 
			}
		} else { 
			System.out.println("Sorry you do not have any " + foodName + ". You forfeit your turn."); 
		}
	} // End heal. 
	
	// Method getHealth to return the health of the player. 
	public int getHealth(){
		if (health < 0){ 
			return 0; 
		} else {
		return health;  
		}
	} // End getHealth. 
	
	// Method getName. 
	public String getName(){
		return name; 
	} // End getName.	
	
	// Method getMaxDmg.
	public int getMaxDmg(){
		return maxDmg; 
	} // End getMaxDmg. 
}