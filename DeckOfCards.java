
public class DeckOfCards {
	public static void main(String[] args) {
		
		Card[][] deck = new Card[4][13];
		int ksuit, kvalue;
		Card.Suit addSuit;
		String cardVals = "23456789TJQKA";
		
		for(ksuit = 0; ksuit < Card.Suit.values().length; ksuit++) {
			addSuit = Card.Suit.values()[ksuit];
			
			for(kvalue = 0; kvalue < cardVals.length(); kvalue++) {
				deck[ksuit][kvalue] = new Card(cardVals.charAt(kvalue), addSuit);
			}
		}
		
		Card queenOfSpades = new Card('q', Card.Suit.spades);
		String phrase;
		
		for(int row = 0; row < deck.length; row++) {
			for(int col = 0; col < deck[row].length; col++) {
				if(queenOfSpades.compareTo(deck[row][col]) < 0)
					phrase = " is less than ";
				else if(queenOfSpades.compareTo(deck[row][col]) > 0)
					phrase = " is greater than ";
				else
					phrase = " is equal to ";
				
				System.out.println(queenOfSpades + phrase + deck[row][col]);
			}
		}
	}
}


class Card implements Comparable{
	private char value;
	public enum Suit {
		clubs, diamonds, hearts, spades
	}
	private Suit suit;
	
	public static char[] valueRanks = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
	static Suit[] suitRanks = {Suit.clubs, Suit.diamonds, Suit.hearts, Suit.spades};
	static int numValsInOrderingArray = 13;
	
	public int compareTo(Object other) {
		if(!(other instanceof Card))
			return -1;
		Card otherCard = (Card)other;
		
		if(this.value == otherCard.value)
			return (getSuitRank(this.suit) - getSuitRank(otherCard.suit));
		
		return (getValueRank(this.value) - getValueRank(otherCard.value));
	}
	
	public static int getSuitRank(Suit st) {
		int k;
		
		for(k = 0; k < 4; k++) 
			if(suitRanks[k] == st)
				return k;
		
		return 0;
	}
	
	public static int getValueRank(char val) {
		int k;
		
		for(k = 0; k < numValsInOrderingArray; k++)
			if(valueRanks[k] == val)
				return k;
		
		return 0;
	}
	
	public Card(char value, Suit suit) {
		set(value, suit);
	}
	
	public Card(char value) {
		this(value, Suit.spades);
	}
	
	public Card() {
		this('A', Suit.spades);
	}
	
	public Card(Card card) {
		this.suit = card.suit;
		this.value = card.value;
	}
	
	public boolean set(char value, Suit suit) {
		char upVal;
		boolean valid = true;
		
		this.suit = suit;
		
		upVal = Character.toUpperCase(value);
		
		if (upVal == 'A' || upVal == 'K' || upVal == 'Q' || upVal == 'J'
	        || upVal == 'T' || (upVal >= '2' && upVal <= '9'))
		{
			this.value = upVal;
		}
		else {
			valid = false;
			this.value = 'A';
		}
		
		return valid;
	}
	
	public char getVal() {
		return value;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public String toString() {
		String retVal;
		
		retVal = String.valueOf(value) + " of " + suit;
		
		return retVal;
	}
}