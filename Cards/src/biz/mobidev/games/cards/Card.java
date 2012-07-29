package biz.mobidev.games.cards;

/**
 * 
 * @author alexander.bogomol
 *
 */

public class Card {
	
	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}
	
	private Suit suit;
	
	private Rank rank;
	
	public Suit getSuit() {
		return suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	@Override
	public String toString() {
		return String.format("Card:[%s,%s]", suit, rank);
	}
	
	public int compareSuit(Card other) {
		
		// by default - all suits are equal
		return 0;
	}

	/**
	 * @param other - another Card to compare with
	 * @return 0 / -1 / +1 whether other Card has the same / higher / lower rank
	 */
	
	public int compareRank(Card other) {

		if (this.equalRank(other))
			return 0;
		else {
			if (this.getRank().compareTo(other.getRank()) > 0)
				return 1;
			else
				return -1;
		}
	}
	
	public boolean equalSuit(Card other) {
		return (this.getSuit().equals(other.getSuit()));
	}
	
	public boolean equalRank(Card other) {
		return (this.getRank().equals(other.getRank()));
	}
	
}