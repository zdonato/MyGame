// Developer: Zachary Donato 
// Date: 1.17.14

// A class for items to be used in the game. 

public class Item{
	// Initialize variables. 
	private int amount; 
	private String itemName; 
	private String type; 
	
	// Constructor method. Expects a name of the item as a string and the amount of health or attack damage it will increase. 
	public Item(String name, int amt, String t){
		this.amount = amt; 
		this.itemName = name;
		this.type = t; 
	} // End constructor.
	
	// Method to get the name of the item. 
	public String getName(){
		return itemName; 
	} // End getName. 
	
	// Method to get the type of the item. 
	public String getType(){
		return type; 
	} // End getType.
	
	// Method to get the amount to be applied from the item.
	public int getAmount(){
		return amount; 
	} // End getAmount. 
	
	public static void main(String[] args){
		Item sword = new Item("Longsword", 100, "Att"); 
		System.out.println(sword.getName()); 
		System.out.println(sword.getType()); 
		System.out.println(sword.getAmount()); 
	}
}