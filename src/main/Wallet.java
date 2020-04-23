package main;

public class Wallet {
	private float amount;			// Holds total wallet amount
	private float min = 1;			// Holds minimum bet amount
	private float max;				// Holds max bet amount
	private int betAmount = 0;		// Holds current bet amount
	
	// Constructor
	Wallet(float amt) {
		this.amount = amt;
		this.max = amt;
	}
	
	// Getters
	public float getAmount() {
		return this.amount;
	}
	
	public float getMin() {
		return this.min;
	}
	
	public float getMax() {
		return this.max;
	}
	
	public int getBetAmount() {
		return this.betAmount;
	}
	
	// changes the amount to a string and returns it
	public String toString() {
		return Float.toString(this.amount);
	}
	
	// Setters
	public void setAmount(float amt) {
		this.amount = amt;
	}
	
	public void setBetAmount(int amt) {
		this.betAmount = amt;
	}
}
