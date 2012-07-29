package biz.mobidev.games.cards;

/*
 * all terms and subjects are taken from:
 * http://en.wikipedia.org/wiki/Suit_(cards)
 */

public class EntryPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TestGameController();
	}
	
	private static void TestGameController() {
		
		Table tbl = new Table();
		
		Deck bank = new Deck();
		bank.fillSorted();
		bank.reshuffleDeck();
		
		Player pl1 = new Player("Sash", new Deck(), tbl, PlayerType.Human);
		Player pl2 = new Player("Josh", new Deck(), tbl, PlayerType.Automatic);
		
		Game game = new Game(tbl);
		game.attachPlayer(pl1);
		game.attachPlayer(pl2);
		
		System.out.println("Hello!");
		game.playTurn();
	}
	
	static void DeckOperationsTest() {
		
		Deck aDeck = new Deck();
		
		Card C2 = new Card(Suit.Clubs, Rank.Two);
		Card D10 = new Card(Suit.Diamonds, Rank.Ten);
		Card HQ = new Card(Suit.Hearts, Rank.Queen);
		
		aDeck.putOnTop(C2);
		aDeck.putOnTop(D10);
		aDeck.putUnderBottom(HQ);
		aDeck.putUnderBottom(new Card(Suit.Spades, Rank.Ace));
		aDeck.putOnTop(new Card(Suit.Diamonds, Rank.Jack));
		
		System.out.println(aDeck);
		
		Card topMost = aDeck.takeFromTop();
		System.out.println("TopMost card taken: " + topMost);
		
		Card bottomMost = aDeck.takeFromBottom();
		System.out.println("BottomMost card taken: " + bottomMost);
		
		System.out.println(aDeck);
	}
	
	static void CardOperationTest() {
		
		System.out.println("Hello World");
		
		Card aCard = new Card(Suit.Diamonds, Rank.Queen);
		System.out.println("You just created a card: " + aCard);
		
		Card oneMore = new Card(Suit.Diamonds, Rank.Ace);
		
//		boolean areEq = aCard.equalSuit(oneMore);
		boolean areEq = aCard.equalRank(oneMore);
		if (areEq)
			System.out.println("The same");
		else
			System.out.println("Different");
		
		int compared = aCard.compareRank(oneMore);
		System.out.println(compared);
	}

}