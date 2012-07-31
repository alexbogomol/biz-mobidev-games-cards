/*
 * Classname			: Table
 * 
 * Version information	: 1.0 (Release to MobiDev)
 *
 * Date					: July 31, 2012
 * 
 * Copyright notice		: alexander.bogomol
 */

package biz.mobidev.games.cards;

/**
 * This class represents a table where
 * the game is going on
 * @author alexander.bogomol
 */
public class Table {
	
	Deck bank = new Deck();
	
	public void putOn(Card aCard) {
		bank.putOnTop(aCard);
	}
}