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
//		fillSorted();
//		reshuffleDeck();
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
	
	public void fillSorted() {
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values())
				putUnderBottom(new Card(suit, rank));
	}
	
	public void reshuffleDeck() {
		Collections.shuffle(cards);
	}
}