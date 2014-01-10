public class playGame {
	public static void main(String[] args) {
		// Add items to food to use for healing. 
		food.put("Lobster", "240"); 
		food.put("Shark", "500"); 
		food.put("Shrimp", "100"); 
		// Create two players. 
		Player Zach = new Player(100, "Zach", 1000); 
		Player Liz = new Player(100, "Liz", 1000);
		// Variables to keep tract of who deals and receives damage. 
		Player currPlayer = Zach; 
		Player other = Liz; 
		private boolean loopCheck = true; 
		private boolean playCheck = true; 
		// While loop to create the textual interface of the game. 
		while (loopCheck){
			System.out.println(curr.getName() + " it is your turn."); 
			Scanner scan = new Scanner(System.in); 
			System.out.println("Choose a move by typing an option from the list below: (Type 0 to quit)"); 
			System.out.println("Attack | Heal | Pass");
			String choice = scan.next(); 
			if ("Attack".equals(choice) || "attack".equals(choice)){
				dmg = generator.nextInt(maxDmg);
				System.out.println("You dealt " + dmg +" damage to " + other.getName() ); 
				other.dmgDealt(dmg); 
				System.out.println("Your current health is: " + getHealth()); 
				System.out.println(other.getName() + "'s current health is: " + other.getHealth()); 
				playCheck = true; 
			} else if ("Heal".equals(choice) || "heal".equals(choice)){
				System.out.println("Choose what to heal with: (Type 0 to quit)"); 
				System.out.println("Lobster | Shark | Shrimp"); 
				String foodChoice = scan.next(); 
				if ("0".equals(foodChoice)){
					loopCheck = false; 
				} else if (!food.containsKey(foodChoice)) {
					System.out.println("That food is not available. Choose again."); 
					playCheck = false; 
				} else {
					heal(foodChoice); 
					System.out.println(getHealth()); 
					playCheck = true; 
				}
			} else if ("0".equals(choice)){
				loopCheck = false; 
			} else if ("Pass".equals(choice) || "pass".equals(choice)){
				System.out.println("You choose to pass."); 
			} else {
				System.out.println("Invalid Command. Choose again."); 
				playCheck = false;
			}
		}
	}
}