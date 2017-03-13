import java.util.*;


public class VendingMachine {
	//Global Variables
	private int numNickels;
	private int numDimes;
	private int numQuarters;
	private int paymentAmount;
	private HashMap<String, Integer> inventory;
	private HashMap<String, Float> prices;
	
	
	//Vending Machine Constructor
	public VendingMachine() {
		//When created, vending machine will have 10 of each coin
		numNickels = 10;
		numDimes = 10;
		numQuarters = 10;
		
		paymentAmount = 0;
		
		inventory = new HashMap<String, Integer>();
		prices = new HashMap<String, Float>();
		
		inventory = (HashMap<String, Integer>) createInventory();
		prices = (HashMap<String, Float>) setPrices();
	}
	
	//Separate Method to set vending machine prices at initialization
	private HashMap<String, Float> setPrices() {
		HashMap<String, Float> retMap = new HashMap<String, Float>();
		
		retMap.put("cola", (float) 1.0);
		retMap.put("chips", (float) 0.5);
		retMap.put("candy", (float) 0.65);
		
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

	public void addCoins(int nickels, int dimes, int quarters) {
		paymentAmount = ((nickels * 5) + (dimes * 10) + (quarters * 25));
		numNickels += nickels;
		numDimes += dimes;
		numQuarters += quarters;
	}
}
