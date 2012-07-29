/**
 * 
 */
package biz.mobidev.games.cards;

/**
 * @author alexander.bogomol
 *
 */
public class Table {
	
	Deck bank = new Deck();
	
	public void putOn(Card aCard) {
		bank.putOnTop(aCard);
	}
}