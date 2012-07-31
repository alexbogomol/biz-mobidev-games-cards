/*
 * Classname			: JassDeck
 * 
 * Version information	: 1.0 (Release to MobiDev)
 *
 * Date					: July 31, 2012
 * 
 * Copyright notice		: alexander.bogomol
 */

package biz.mobidev.games.cards;

/**
 * This class represents a kind of a deck, 
 * called JassDeck. It consists cards for 
 * all four suits and a ranks Six ... Ace. 
 * @author alexander.bogomol
 */
public class JassDeck extends Deck {

	/**
	 * 
	 */
	public JassDeck() {
		super();
	}
	
	@Override
	public boolean isAcceptableCard(Suit aSuit, Rank aRank) {
		return (aRank.compareTo(Rank.Five) > 0);
	}
}