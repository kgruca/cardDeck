
public class DeckOfCards {
	public static void main(String[] args) {
		
		Deck deck1 = new Deck(2);
		
		while(deck1.getNumCards() > 0)
			System.out.print(deck1.dealCard() + " / ");
		System.out.println('\n');
		
		while(deck1.getNumCards() > 0)
			System.out.print(deck1.dealCard() + " / ");
		System.out.println('\n');
		
		Deck deck2 = new Deck();
		
		while(deck2.getNumCards() > 2)
			System.out.print(deck2.dealCard() + " / ");
		System.out.println('\n');
		
		deck2.init();
		deck2.shuffle();
		
		while(deck2.getNumCards() > 0)
			System.out.print(deck2.dealCard() + " / ");
		System.out.println('\n');
	}
}


