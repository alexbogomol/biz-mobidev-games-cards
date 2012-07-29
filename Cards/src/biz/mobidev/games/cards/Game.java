/**
 * 
 */
package biz.mobidev.games.cards;

import java.util.ArrayList;

/**
 * @author alexander.bogomol
 *
 */

public class Game extends TurnBasedGame {
	
	private ArrayList<Player> players;
	private Player turningPlayer;
	private Player emptiedPlayer;
	private Table table;
	
	public Game(Table aTable) {
		table = aTable;
		players = new ArrayList<Player>();
		turningPlayer = null;
		emptiedPlayer = null;
	}
	
	public void attachPlayer(Player aPlayer) {
		players.add(aPlayer);
	}

	/*
	 * Turn PreCondition: if everyone has cards in deck?
	 * 	If true => just do next turn
	 * 	If false => kick off that guy and continue, or set winner
	 */
	@Override
	public boolean checkTurnPreConditions() {
		
		boolean result = true;
		emptiedPlayer = null;
		
		for (Player player : players)
			if (player.hasEmptyBank() == true) {
				result = false;
				emptiedPlayer = player;
				break;
			}
		
		return result;
	}
	
	/*
	 * Simply take a turn by the current player
	 */
	@Override
	public void handleTurnPreConditionSucceed() {
		turningPlayer.takeTurn();
	}
	
	/* 
	 * Kick off emptied player
	 * Check if an only guy has left among players
	 * 	If true => he is a WINNER!, finish game
	 * 	If false => define next turning player(?), continue game
	 */
	@Override
	public void handleTurnPreConditionFailed() {
		
		players.remove(emptiedPlayer);
		System.out.println("Player " + emptiedPlayer.getName() + 
						   " was kicked off...");
		
		if (players.size() == 1)
			applauseOurWinner(players.get(0));
	}
	
	/* 
	 * Turn PostCondition: are the last two cards of equal suit?
	 * 	If true => take the table bank by turning player
	 * 	If false => do the next turn
	 */
	@Override
	public boolean checkTurnPostConditions() {
		
		// look at last and pre-last card on the table
		Card lastPutted = table.bank.peekTop(1);
		Card prevPutted = table.bank.peekTop(2);
		
		// are they equal?
		return lastPutted.equalSuit(prevPutted);
	}
	
	/* 
	 * Take the table bank by the turning player
	 * Change turning player
	 * Continue the game
	 */
	@Override
	public void handleTurnPostConditionSucceed() {
		turningPlayer.takeBankFromTable();
		changeTurningPlayer(); // ?
		playTurn();
	}
	
	/* 
	 * Change turning player
	 * Continue the game 
	 */
	@Override
	public void handleTurnPostConditionFailed() {
		changeTurningPlayer();
		playTurn();
	}

	private void changeTurningPlayer() {
		
		int indexOfTheCurrent = players.indexOf(turningPlayer);
		
		if (indexOfTheCurrent == (players.size() - 1))
			turningPlayer = players.get(0);
		else
			turningPlayer = players.get(indexOfTheCurrent + 1);
	}

	private void applauseOurWinner(Player aPlayer) {
		System.out.println("Congratulations, " + aPlayer.getName() + 
						   "! You won!");
	}
}