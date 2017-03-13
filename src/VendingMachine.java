import java.util.*;


public class VendingMachine {
	//Global Variables
	private int numNickels;
	private int numDimes;
	private int numQuarters;
	private int paymentAmount;
	private HashMap<String, Integer> inventory;
	private HashMap<String, Integer> prices;
	
	
	//Vending Machine Constructor
	public VendingMachine() {
		//When created, vending machine will have 10 of each coin
		numNickels = 10;
		numDimes = 10;
		numQuarters = 10;
		
		paymentAmount = 0;
		
		inventory = new HashMap<String, Integer>();
		prices = new HashMap<String, Integer>();
		
		inventory = (HashMap<String, Integer>) createInventory();
		prices = (HashMap<String, Integer>) setPrices();
	}
	
	//Separate Method to set vending machine prices at initialization
	private HashMap<String, Integer> setPrices() {
		HashMap<String, Integer> retMap = new HashMap<String, Integer>();
		
		retMap.put("cola", 100);
		retMap.put("chips", 50);
		retMap.put("candy", 65);
		
		return retMap;
	}

	//Separate Method to set vending machine inventory at initialization
	private Map<String, Integer> createInventory(){
		HashMap<String, Integer> retMap = new HashMap<String, Integer>();
		
		retMap.put("cola", 20);
		retMap.put("chips", 20);
		retMap.put("candy", 20);
		
		return retMap;
	}

	//Get private int for number of Nickels
	public int getNumNickels(){
		return numNickels;
	}
	
	//Get private int for number of Dimes
	public int getNumDimes(){
		return numDimes;
	}
	
	//Get private int for number of Quarters
	public int getNumQuarters(){
		return numQuarters;
	}
	
	//Get inventory amount based on type
	public int getInventory(String item){
		return inventory.get(item);
	}
	
	//Add items to the vending machine
	public boolean addInventory(String item, int amount){
		if (inventory.containsKey(item)){
			int itemAmount = inventory.get(item);
			itemAmount += amount;
			inventory.replace(item, itemAmount);
			return true;
		} else {
			return false;
		}
	}

	//Add coins to the vending machine
	public void addCoins(int nickels, int dimes, int quarters) {
		paymentAmount = ((nickels * 5) + (dimes * 10) + (quarters * 25));
		numNickels += nickels;
		numDimes += dimes;
		numQuarters += quarters;
	}
	
	//Make change, returning string with number of nickels, dimes, quarters in that order
	protected String makeChange(int leftover) {
		int nickels = 0;
		int dimes = 0;
		int quarters = 0;
		String retVal = "";
		
		while (leftover > 0) {
			if (leftover >= 25) { 
				leftover -= 25;
				quarters++;
			} else if (leftover >= 10) {
				leftover -= 10;
				dimes++;
			} else {
				leftover -= 5;
				nickels++;
			}
		}
		
		retVal = nickels + " " + dimes + " " + quarters;
		return retVal;
	}

	//Dispense food or return false if sold out.
	public boolean buyItem(String item) {
		if(inventory.get(item) > 0) {
			int temp = inventory.get(item);
			temp--;
			inventory.replace(item, temp);
			return true;
		} else {
			return false;
		}
	}
	
	
}
