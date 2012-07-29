package biz.mobidev.games.cards;

import java.util.Scanner;

public class Player {
	
	private String name;
	private Deck bank;
	private Table table;
	private PlayerType playerType;
	
	public Player(String name, Deck bank, Table table, PlayerType type) {
		this.name = name;
		this.bank = bank;
		this.table = table;
		this.playerType = type;
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
	}
	
	@Override
	public String toString() {
		
		return "Player " + name + " has " + 
			   bank.getCount() + " cards in bank";
	}
	
	public void takeBankFromTable() {

		while (table.bank.getCount() != 0) {
			Card aCard = table.bank.takeFromTop();
			this.bank.putUnderBottom(aCard);
		}
	}
	
	public void waitForUserHitEnter() {
		Scanner sc = new Scanner(System.in);
		while(!sc.nextLine().equals(""));
	}
}