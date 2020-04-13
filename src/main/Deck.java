package main;

import java.util.ArrayList;

public class Deck {
	// Holds the cards for the game
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	// Generates a deck containing the number of cards specified by the user
	// TODO Figure out how to provide suit
	public Deck(int numOfDecks) {
		// Add cards to the deck
		for (int i = 0; i < (numOfDecks * 52); i++) {
			Card card = new Card((i + 1), "placeHolder");
			deck.add(card);
		}
	}
}
