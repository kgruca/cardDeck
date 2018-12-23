import java.util.*;
public class Deck {
	
	private static Card[] masterPack;
	
	private ArrayList<Card> cards;
	private int numPacks;

	private static boolean firstTime = true;
	
	public Deck(int numPacks) {
		allocateMasterPack();
		cards = new ArrayList<Card>();
		init(numPacks);
	}
	
	static private void allocateMasterPack() {
		int j, k;
		Card.Suit st;
		char val;
		
		if(!firstTime)
			return;
		firstTime = false;
		
		masterPack = new Card[52];
		for(k = 0; k < 52; k++)
			masterPack[k] = new Card();
		
		for(k = 0; k < 4; k++) {
			
			st = Card.Suit.values()[k];
			
			masterPack[13 * k].set('A', st);
			for(val = '2', j = 1; val <= '9'; val++, j++)
				masterPack[13 * k + j].set(val, st);
			masterPack[13 * k + 9].set('T', st);
			masterPack[13 * k + 10].set('J', st);
			masterPack[13 * k + 11].set('Q', st);
			masterPack[13 * k + 12].set('K', st);
		}
	}
	
	public Deck() {
		this(1);
	}
	
	public void init(int numPacks) {
		int k, pack;
		
		if(numPacks < 1 || numPacks > 6)
			numPacks = 1;
		
		cards.clear();
		
		for(pack = 0; pack < numPacks; pack++)
			for(k = 0; k < 52; k++)
				cards.add(0, masterPack[k]);
		
		this.numPacks = numPacks;
	}
	
	public void init() {
		init(1);
	}
	
	public int getNumCards() {
		return cards.size();
	}
	
	public void shuffle() {
		Card tempCard;
		int k, randInt, topCard;
		
		topCard = cards.size();
		for(k = 0; k < topCard; k++) {
			randInt = (int)(Math.random() * topCard);
			
			tempCard = cards.get(k);
			cards.set(k,  cards.get(randInt));
			cards.set(randInt, tempCard);
		}
	}
	
	public Card dealCard() {
		Card errorReturn = new Card('E', Card.Suit.spades);
		
		if(cards.size() == 0)
			return errorReturn;
		else
			return cards.remove(0);
	}
	
	public Card inspectCard(int k) {
		Card errorReturn = new Card('E', Card.Suit.spades);
		
		if(k < 0 || k >= cards.size())
			return errorReturn;
		else
			return cards.get(k);
	}
}
