/**
 * 
 */
package biz.mobidev.games.cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author alexander.bogomol
 *
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
	
	@Override
	public String toString() {
		return cards.toString();
	}
	
	public int getCount() {
		return cards.size();
	}
	
	public void fill() {
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values())
				if (suffitientCardCheck(suit, rank))
					putUnderBottom(new Card(suit, rank));
	}
	
	public boolean suffitientCardCheck(Suit aSuit, Rank aRank) {
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
}