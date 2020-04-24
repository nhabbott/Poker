package main;

public class Card {
	private String suit;	// Holds the suit of the card
	private String value;		// Holds the value of the card
	private int number; 	// Holds the number of the card in regards to the image names
	
	// Card constructor
	public Card(String value, int number, String suit) {
		this.value = value;
		this.number = number;
		this.suit = suit;
	}
	
	// Get the card's numerical value
	public String getValue() {
		return this.value;
	}
	
	// Get the card's number
	public int getNumber() {
		return this.number;
	}
	
	// Get the card's suit
	public String getSuit() {
		return this.suit;
	}
}
