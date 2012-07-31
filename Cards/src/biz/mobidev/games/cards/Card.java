/*
 * Classname			: Card
 * 
 * Version information	: 1.0 (Release to MobiDev)
 *
 * Date					: July 31, 2012
 * 
 * Copyright notice		: alexander.bogomol
 */

package biz.mobidev.games.cards;

/**
 * This class represents a card of appropriate
 * suit and rank. Also it provides methods for
 * the equality check and compare of suit  and
 * rank for the other card instance. 
 * @author alexander.bogomol
 */

public class Card {
	
	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public int compareSuit(Card other) {
		// by default - all suits are equivalent
		return 0;
	}

	/**
	 * This method compares ranks for two cards
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

	@Override
	public String toString() {
		return String.format("Card:[%s,%s]", suit, rank);
	}
	
}