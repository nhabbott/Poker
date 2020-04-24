package main;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public Hand(Deck deck) {
		for (int i = 0; i < 5; i++) {
			// Generate a random number between 1 and the size of the deck
			int randomNumber = 1 + (int)(Math.random() * (((deck.getSize() - 1) - 1) + 1));
			
			// Add the randomly selected card to the hand
			this.hand.add(deck.getCard(randomNumber));
			
			// Remove the selected card from the deck
			deck.removeCard(randomNumber);
		}
	}
	
	// Get the whole hand array
	public ArrayList<Card> getArray() {
		return this.hand;
	}
	
	// Get a specific card from the hand
	public Card getCard(int index) {
		return this.hand.get(index);
	}
	
	// Add a card to the hand
	public void addCard(Card card) {
		this.hand.add(card);
	}
	
	// Adds a card at the specified index
	public void addCardAtIndex(int index, Card card) {
		this.hand.add(index, card);
	}
	
	// Remove a specific card from the hand
	public void removeCard(int index) {
		this.hand.remove(index);
	}
	
	public boolean isWinner() {
		boolean sameSuits = false;
		
		// Counters for each of the suits of the card
		int heart = 0;
		int diamond = 0;
		int spade = 0;
		int club = 0;
		
		// Loop through and count suits
		for (int i = 0; i < this.hand.size(); i ++) {
			if (hand.get(i).getSuit() == "heart") {
				heart++;
			} else if (hand.get(i).getSuit() == "diamond") {
				diamond++;
			} else if (hand.get(i).getSuit() == "spade") {
				spade++;
			} else if (hand.get(i).getSuit() == "club") {
				club++;
			}
 		}
		
		// Determine if cards are all same suit
		if (heart == 5 || diamond == 5 || spade == 5 || club == 5) {
			sameSuits = true;
		}
		
		return false;
	}
	
	// Print the hand to console
	public void print() {
        for (Card h:this.hand) {
            System.out.println(h.getValue());
        }
	}
}
