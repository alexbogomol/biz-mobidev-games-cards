/*
 * Classname			: Player
 * 
 * Version information	: 1.0 (Release to MobiDev)
 *
 * Date					: July 31, 2012
 * 
 * Copyright notice		: alexander.bogomol
 */

package biz.mobidev.games.cards;

import java.util.Scanner;

/*
 * This class represents a player who is
 * taking a part in the game
 */

public class Player {
	
	private String name;
	private Deck bank;
	private Table table;
	private PlayerType playerType;
	
	public Player(String name, Table table, PlayerType type) {
		this.name = name;
		this.table = table;
		this.playerType = type;
		this.bank = new Deck();
	}
	
	public String getName() {
		return name;
	}

	public boolean hasEmptyBank() {
		return (bank.getCount() == 0);
	}
	
	public void takeTurn() {
		
		if (this.playerType.equals(PlayerType.Human))
			waitForUserHitEnter();
		
		Card aCard = bank.takeFromTop();
		table.putOn(aCard);
		
		// print report
		System.out.println(this.getName() + "'s turn: " + aCard);
	}
	
	@Override
	public String toString() {
		
		return "Player " + name + " has " + 
			   bank.getCount() + " cards in bank";
	}
	
	public void takeBankFromTable() {
		
		int cardsInBank = table.bank.getCount();

		while (table.bank.getCount() != 0) {
			Card aCard = table.bank.takeFromTop();
			this.bank.putUnderBottom(aCard);
		}
		
		// print report
		System.out.println("Player " + this.getName() + 
							" grabs a bank of " + cardsInBank + 
							" cards");
		System.out.println(this);
	}
	
	public void waitForUserHitEnter() {
		Scanner sc = new Scanner(System.in);
		while(!sc.nextLine().equals(""));
	}

	public void takeCard(Card aCard) {
		this.bank.putOnTop(aCard);
	}
}