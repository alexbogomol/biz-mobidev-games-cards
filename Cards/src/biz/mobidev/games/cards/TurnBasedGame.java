package biz.mobidev.games.cards;

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