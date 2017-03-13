import java.util.*;


public class VendingMachine {
	//Global Variables
	private int numNickles;
	private int numDimes;
	private int numQuarters;
	private HashMap<String, Integer> inventory;
	private HashMap<String, Float> prices;
	
	
	//Vending Machine Constructor
	public VendingMachine() {
		//When created, vending machine will have 10 of each coin
		numNickles = 10;
		numDimes = 10;
		numQuarters = 10;
		
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

	public int getNumNickles(){
		return numNickles;
	}
	
	public int getNumDimes(){
		return numDimes;
	}
	
	public int getNumQuarters(){
		return numQuarters;
	}
}
