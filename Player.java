
public enum Player {

	X("X"),O("O");
	
	private String player;
	private Player(String player)
	{
		this.player=player;
	}
	String getPlayer()
	{
		return this.player;
	}
	Player getOpponent()
	{
		return this==X?O:X;
	}
	
}
