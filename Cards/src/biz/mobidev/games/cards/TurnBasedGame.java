/*
 * Classname			: TurnBasedGame (abstract)
 * 
 * Version information	: 1.0 (Release to MobiDev)
 *
 * Date					: July 31, 2012
 * 
 * Copyright notice		: alexander.bogomol
 */

package biz.mobidev.games.cards;

/*
 * This is an abstract class, representing a game,
 * driving by turns. Consist playTurn() method,
 * representing basic logic for a turn operation.
 * Absract methods must be implemented in subclasses
 * to specify the concrete rules of a game.
 */

public abstract class TurnBasedGame {

	public TurnBasedGame() {
		super();
	}

	public void playTurn() {
		
		if (checkTurnPreConditions()) {
			handleTurnPreConditionSucceed();
			if (checkTurnPostConditions()) {
				handleTurnPostConditionSucceed();
			} else {
				handleTurnPostConditionFailed();
			}
		} else {
			handleTurnPreConditionFailed();
		}
	}

	public abstract boolean checkTurnPreConditions();

	public abstract void handleTurnPreConditionSucceed();

	public abstract void handleTurnPreConditionFailed();

	public abstract boolean checkTurnPostConditions();

	public abstract void handleTurnPostConditionSucceed();

	public abstract void handleTurnPostConditionFailed();

}