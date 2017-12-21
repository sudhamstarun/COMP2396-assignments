
/**
 * This constructor helps creating a Pair object holding the pair hand of specific player and cards played by that player
 * @author Tarun
 *
 */

public class Pair extends Hand implements Abstract_Interface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * This constructor helps creating a Pair object holding the pair hand of specific player and cards played by that player
	 * @param player
	 * 		A CardGamePlayer object which contains specified player to whom the current hand belongs to
	 * @param card
	 * 		A CardList object which contains list of cards played by the active player
	 */
	
	public Pair(CardGamePlayer player, CardList card)
	{
		super(player,card);
	}
	
	/* (non-Javadoc)
	 * @see Hand#getTopCard()
	 */
	
	public Card getTopCard()
	{
		if(this.getCard(0).suit > this.getCard(1).suit)
		{
			return this.getCard(0);
		}
		
		return this.getCard(1);
	}
	
	/* (non-Javadoc)
	 * @see Hand#isValid()
	 */
	
	public boolean isValid()
	{
		if(this.size() != 2)
		{
			return false;
		}
		
		if(this.getCard(0).rank == this.getCard(1).rank)
		{
			return true;
		}
		
		return false;	
	}
	
	/* (non-Javadoc)
	 * @see Hand#getType()
	 */
	
	public String getType()
	{
		return new String("Pair");
	}
}
