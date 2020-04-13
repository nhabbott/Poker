package main;

public class Card {
	private String suit;	// Holds the suit of the card
	private int value;		// Holds the numeric value of the card
	
	// Card constructor
	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
	}
	
	// Get the card's numerical value
	public int getValue() {
		return this.value;
	}
	
	// Get the card's suit
	public String getSuit() {
		return this.suit;
	}
}
