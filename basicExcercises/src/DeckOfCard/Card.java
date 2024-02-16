package DeckOfCard;
// Card class represents a playing card;
public class Card {

	private final String face; //Ace to king
	private final String suit; //Hearts, Diamonds, Spades, Clubs
	// after the variable final face and suit initialize it will be final
	// two-argument constructor
	public Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
	}
	
	public String toString() {
		return face + " of " + suit;
	}
}
