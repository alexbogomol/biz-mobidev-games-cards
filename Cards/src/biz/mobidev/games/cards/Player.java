package biz.mobidev.games.cards;

public class Player {
	
	private String name;
	private Deck bank;
	
	public Player(String name, Deck bank) {
		this.name = name;
		this.bank = bank;
	}
	
	public boolean hasEmptyBank() {
		return (bank.getCount() == 0);
	}
	
	public void takeTurn() {
		// TODO uncomment all after implementing Table class
		//Card aCard = bank.takeFromTop();
		//Table.putOn(aCard);
	}
	
	@Override
	public String toString() {
		return "Player " + name + " has " + 
			   bank.getCount() + " cards in bank";
	}
}