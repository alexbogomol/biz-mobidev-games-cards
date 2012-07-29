/**
 * 
 */
package biz.mobidev.games.cards;

import java.util.ArrayList;

/**
 * @author cs106
 *
 */
public class Game {
	
	private ArrayList<Player> players;
	private Table table;
	
	public boolean checkRoundPreConditions() {
		return true;
	}
	
	public boolean checkRoundPostConditions() {
		return true;
	}
	
	public void playRound() {
		
//		// 
//		if (checkRoundPreConditions() == false)
//			return;
//		
//		// iterate through players.takeTurn()
//		
//		if (checkRoundPostConditions() == false)
//			return;
		
		if (checkRoundPreConditions() == true) {
			
			// iterate takeTurn() throughout players
			handleRoundPreConditionSucceed();
			
			if (checkRoundPostConditions() == true) {
				handleRoundPostConditionSucceed();
			} else {
				handleRoundPostConditionFailed();
			}
			
		} else {
			handleRoundPreConditionFailed();
		}
	}

	private void handleRoundPreConditionSucceed() {
		for (Player player : players)
			player.takeTurn();
	}

	private void handleRoundPostConditionSucceed() {
		// TODO Auto-generated method stub
		
	}

	private void handleRoundPostConditionFailed() {
		// TODO Auto-generated method stub
		
	}

	private void handleRoundPreConditionFailed() {
		// TODO Auto-generated method stub
		
	}
}