/*
 * Classname			: Deck
 * 
 * Version information	: 1.0 (Release to MobiDev)
 *
 * Date					: July 31, 2012
 * 
 * Copyright notice		: alexander.bogomol
 */

package biz.mobidev.games.cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class provides a common deck functionality.
 * 
 * @author alexander.bogomol
 */

public class Deck {
	
	private ArrayList<Card> cards;
	
	public Deck() {
		super();
		this.cards = new ArrayList<Card>();
	}

	public void putOnTop(Card aCard) {
		cards.add(0, aCard);
	}
	
	public void putUnderBottom(Card aCard) {
		cards.add(aCard);
	}
	
	public Card takeFromTop() {
		return cards.remove(0);
	}
	
	public Card takeFromBottom() {
		return cards.remove(cards.size() - 1);
	}
	
	public int getCount() {
		return cards.size();
	}
	
	/**
	 * This method fills the empty deck with acceptable cards
	 * in a sorted way. If deck is not empty - nothing happens.
	 */
	public void fill() {
		if (this.getCount() == 0){
			for (Suit suit : Suit.values())
				for (Rank rank : Rank.values())
					if (isAcceptableCard(suit, rank))
						putUnderBottom(new Card(suit, rank));
		}
	}
	
	/**
	 * This method defines if the certain card can be a member 
	 * of a deck of specific kind (e.g. JassDeck).
	 * Can be overriden in inherited subclasses, 
	 * representing specific kind of deck.
	 * @param aSuit - suit of a card
	 * @param aRank - rank of a card
	 * @return true if the card is acceptable
	 */
	public boolean isAcceptableCard(Suit aSuit, Rank aRank) {
		return true;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card peekTop() {
		return cards.get(0);
	}
	
	public Card peekTop(int indexToPeek) {
		return cards.get(indexToPeek - 1);
	}

	public Card peekBottom() {
		return cards.get(cards.size() - 1);
	}
	
	public Card peekBottom(int indexToPeek) {
		return cards.get(cards.size() - indexToPeek);
	}

	@Override
	public String toString() {
		return cards.toString();
	}
}