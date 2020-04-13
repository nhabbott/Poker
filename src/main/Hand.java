package main;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public Hand(Deck deck) {
		for (int i = 0; i < 5; i++) {
			// TODO generate randomNumber within 0 - deck.getSize()
			this.hand.add(deck.getCard(randomNumber));
			deck.removeCard(randomNumber);
		}
	}
	
	// Get a specific card from the hand
	public Card getCard(int index) {
		return this.hand.get(index);
	}
	
	// Add a card to the hand
	public void addCard(Card card) {
		this.hand.add(card);
	}
	
	// Remove a specific card from the hand
	public void removeCard(int index) {
		this.hand.remove(index);
	}
}
