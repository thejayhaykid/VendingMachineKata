import java.util.*;


public class VendingMachine {
	//Global Variables
	private int numNickels;
	private int numDimes;
	private int numQuarters;
	private int paymentAmount;
	private boolean exactChange;
	private HashMap<String, Integer> inventory;
	private HashMap<String, Integer> prices;
	
	
	//Vending Machine Constructor
	public VendingMachine() {
		//When created, vending machine will have 10 of each coin
		numNickels = 10;
		numDimes = 10;
		numQuarters = 10;
		
		paymentAmount = 0;
		exactChange = false;
		
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
			if (leftover >= 25 && numQuarters > 0) { 
				leftover -= 25;
				quarters++;
				numQuarters--;
			} else if (leftover >= 10 && numDimes > 0) {
				leftover -= 10;
				dimes++;
				numDimes--;
			} else if (leftover >= 5 && numNickels > 0){
				leftover -= 5;
				nickels++;
				numNickels--;
			} else {
				System.out.println("Unable to make change.");
			}
		}

		retVal = nickels + " " + dimes + " " + quarters;
		updateExactChange();
		paymentAmount = 0;
		return retVal;
	}

	private void printChange(String change) {
		System.out.println("Your change is: ");
		String[] coins = change.split(" ");
		System.out.println("\tNickels: " + coins[0]);
		System.out.println("\tDimes: " + coins[1]);
		System.out.println("\tQuarters: " + coins[2]);
	}
	
	//Dispense food or return false if sold out.
	protected boolean buyItem(String item) {
		if(inventory.get(item) > 0) {
			if (paymentAmount >= prices.get(item)){
				int temp = inventory.get(item);
				temp--;
				inventory.replace(item, temp);
				String change = makeChange(paymentAmount - prices.get(item));
				printChange(change);
				return true;
			} else {
				System.out.println("Add more coins");
				return false;
			}
		} else {
			System.out.println("SOLD OUT");
			return false;
		}
	}
	
	//Allowing for exact change setting to be changed
	private void updateExactChange() {
		if (numNickels <= 2 || numDimes <= 2 || numQuarters <= 4) {
			exactChange = true;
		} else {
			exactChange = false;
		}
	}
	
	//exactChange is a private variable
	public boolean getExactChange() {
		return exactChange;
	}
	
	//Get payment amount
	public int getPaymentAmount() {
		return paymentAmount;
	}
	
}
