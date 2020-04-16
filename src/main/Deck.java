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
	
	// Get a specific card in the deck
	public Card getCard(int index) {
		return this.deck.get(index);
	}
	
	// Add a card to the deck
	public void addCard(Card card) {
		this.deck.add(card);
	}
	
	// Remove a specific card from the deck
	public void removeCard(int index) {
		this.deck.remove(index);
	}
	
	// Get the size of the deck
	public int getSize() {
		return this.deck.size();
	}
	
	// Print the deck to console
	public void print() {
        for (Card d:this.deck) {
            System.out.println(d.getValue());
        }
	}
}
