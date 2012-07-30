/**
 * 
 */
package biz.mobidev.games.cards;

/**
 * @author alexander.bogomol
 *
 */
public class JassDeck extends Deck {

	/**
	 * 
	 */
	public JassDeck() {
		super();
	}
	
	@Override
	public boolean suffitientCardCheck(Suit aSuit, Rank aRank) {
		return (aRank.compareTo(Rank.Five) > 0);
	}
}