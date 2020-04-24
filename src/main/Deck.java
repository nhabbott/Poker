package main;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	// Holds the cards for the game
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	// Generates a deck containing the number of cards specified by the user
	// TODO Figure out how to provide suit
	public Deck(int numOfDecks) {
		// Add cards to the deck
		for (int i = 0; i < (numOfDecks * 52); i++) {
			String suit = "";
			String value = "";
			
			// Figure out the card's suit
			if (((i + 1) >= 1 && (i + 1) <= 13) || ((i + 1) >= 55 && (i + 1) <= 67) || ((i + 1) >= 109 && (i + 1) <= 121)) {
				suit = "spade";
			}
			
			if (((i + 1) >= 14 && (i + 1) <= 26) || ((i + 1) >= 68 && (i + 1) <= 80) || ((i + 1) >= 122 && (i + 1) <= 134)) {
				suit = "heart";
			}
			
			if (((i + 1) >= 27 && (i + 1) <= 39) || ((i + 1) >= 81 && (i + 1) <= 93) || ((i + 1) >= 135 && (i + 1) <= 147)) {
				suit = "diamond";
			}
			
			if (((i + 1) >= 40 && (i + 1) <= 52) || ((i + 1) >= 94 && (i + 1) <= 106) || ((i + 1) >= 148 && (i + 1) <= 160)) {
				suit = "club";
			}
			
			// Figure out the card's value
			if ((i + 1) == 1 || (i + 1) == 14 || (i + 1) == 27 || (i + 1) == 40 || (i + 1) == 55 || (i + 1) == 68 || (i + 1) == 81 || (i + 1) == 94 || (i + 1) == 109 || (i + 1) == 122 || (i + 1) == 135 || (i + 1) == 148) {
				value = "ace";
			}
			
			if ((i + 1) == 2 || (i + 1) == 15 || (i + 1) == 28 || (i + 1) == 41 || (i + 1) == 56 || (i + 1) == 69 || (i + 1) == 82 || (i + 1) == 95 || (i + 1) == 110 || (i + 1) == 123 || (i + 1) == 136 || (i + 1) == 149) {
				value = "2";
			}
			
			if ((i + 1) == 3 || (i + 1) == 16 || (i + 1) == 29 || (i + 1) == 42 || (i + 1) == 57 || (i + 1) == 70 || (i + 1) == 83 || (i + 1) == 96 || (i + 1) == 111 || (i + 1) == 124 || (i + 1) == 137 || (i + 1) == 150) {
				value = "3";
			}
			
			if ((i + 1) == 4 || (i + 1) == 17 || (i + 1) == 30 || (i + 1) == 43 || (i + 1) == 58 || (i + 1) == 71 || (i + 1) == 84 || (i + 1) == 97 || (i + 1) == 112 || (i + 1) == 125 || (i + 1) == 138 || (i + 1) == 151) {
				value = "4";
			}
			
			if ((i + 1) == 5 || (i + 1) == 18 || (i + 1) == 31 || (i + 1) == 44 || (i + 1) == 59 || (i + 1) == 72 || (i + 1) == 85 || (i + 1) == 98 || (i + 1) == 113 || (i + 1) == 126 || (i + 1) == 139 || (i + 1) == 152) {
				value = "5";
			}
			
			if ((i + 1) == 6 || (i + 1) == 19 || (i + 1) == 32 || (i + 1) == 45 || (i + 1) == 60 || (i + 1) == 73 || (i + 1) == 86 || (i + 1) == 99 || (i + 1) == 114 || (i + 1) == 127 || (i + 1) == 140 || (i + 1) == 153) {
				value = "6";
			}
			
			if ((i + 1) == 7 || (i + 1) == 20 || (i + 1) == 33 || (i + 1) == 46 || (i + 1) == 61 || (i + 1) == 74 || (i + 1) == 87 || (i + 1) == 100 || (i + 1) == 115 || (i + 1) == 128 || (i + 1) == 141 || (i + 1) == 154) {
				value = "7";
			}
			
			if ((i + 1) == 8 || (i + 1) == 21 || (i + 1) == 34 || (i + 1) == 47 || (i + 1) == 62 || (i + 1) == 75 || (i + 1) == 88 || (i + 1) == 101 || (i + 1) == 116 || (i + 1) == 129 || (i + 1) == 142 || (i + 1) == 155) {
				value = "8";
			}
			
			if ((i + 1) == 9 || (i + 1) == 22 || (i + 1) == 35 || (i + 1) == 48 || (i + 1) == 63 || (i + 1) == 76 || (i + 1) == 89 || (i + 1) == 102 || (i + 1) == 117 || (i + 1) == 130 || (i + 1) == 143 || (i + 1) == 156) {
				value = "9";
			}
			
			if ((i + 1) == 10 || (i + 1) == 23 || (i + 1) == 36 || (i + 1) == 49 || (i + 1) == 64 || (i + 1) == 77 || (i + 1) == 90 || (i + 1) == 103 || (i + 1) == 118 || (i + 1) == 131 || (i + 1) == 144 || (i + 1) == 157) {
				value = "10";
			}
			
			if ((i + 1) == 11 || (i + 1) == 24 || (i + 1) == 37 || (i + 1) == 50 || (i + 1) == 65 || (i + 1) == 78 || (i + 1) == 91 || (i + 1) == 104 || (i + 1) == 119 || (i + 1) == 132 || (i + 1) == 145 || (i + 1) == 158) {
				value = "jack";
			}
			
			if ((i + 1) == 12 || (i + 1) == 25 || (i + 1) == 38 || (i + 1) == 51 || (i + 1) == 66 || (i + 1) == 79 || (i + 1) == 92 || (i + 1) == 105 || (i + 1) == 120 || (i + 1) == 133 || (i + 1) == 146 || (i + 1) == 159) {
				value = "queen";
			}
			
			if ((i + 1) == 13 || (i + 1) == 26 || (i + 1) == 39 || (i + 1) == 52 || (i + 1) == 67 || (i + 1) == 80 || (i + 1) == 93 || (i + 1) == 106 || (i + 1) == 121 || (i + 1) == 134 || (i + 1) == 147 || (i + 1) == 160) {
				value = "king";
			}
 			
			Card card = new Card(value, (i + 1), suit);
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
	
	// Returns a random card from the deck and then removes it
	public Card getRandomCard() {
		Random random = new Random();						// Creates new random number generator
		int ranIndex = random.nextInt(this.deck.size());	// Holds random index
		Card card = this.deck.get(ranIndex);				// Holds the selected card
		
		this.deck.remove(ranIndex);							// Remove the selected card from the deck
		return card;
	}
	
	// Print the deck to console
	public void print() {
        for (Card d:this.deck) {
            System.out.println(d.getValue());
        }
	}
}
