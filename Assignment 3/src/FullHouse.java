/**
 * This public class is a subclass of Hand which is used to model a FullHouse hand and check if the hand is a valid FullHouse type, return FullHouse type if it is and also return the top card of a FullHouse hand
 * @author Tarun
 *
 */
public class FullHouse extends Hand implements Abstract_Interface {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * This constructor helps creating a FullHouse object holding the FullHouse hand of specific player and cards played by that player
	 * @param player
	 * 		A CardGamePlayer object which contains specified player to whom the current hand belongs to
	 * @param card
	 * 		A CardList object which contains list of cards played by the active player
	 */
	
	public FullHouse(CardGamePlayer player, CardList card)
	{
		super(player,card);
	}
	
	/* (non-Javadoc)
	 * @see Hand#getTopCard()
	 */
	
	public Card getTopCard()
	{
		this.sort();
		
		if(this.getCard(0).rank == this.getCard(2).rank) // comparing ranks
		{
			return this.getCard(2);
		}
		
		else
		{
			return this.getCard(4);
		}
	}
	
	/* (non-Javadoc)
	 * @see Hand#isValid()
	 */
	
	public boolean isValid()
	{
		if(this.size() != 5)
		{
			return false;
		}
		
		this.sort(); // sorting
		
		if(this.getCard(0).rank == this.getCard(2).rank)
		{
			if(this.getCard(0).rank == this.getCard(1).rank && this.getCard(0).rank == this.getCard(2).rank && this.getCard(3).rank == this.getCard(4).rank)
			{
				return true; // condition for isValid is satisfied 
			}
		}
		
		else if(this.getCard(2).rank == this.getCard(4).rank)
		{
			if(this.getCard(2).rank == this.getCard(3).rank && this.getCard(2).rank == this.getCard(4).rank && this.getCard(0).rank == this.getCard(1).rank)
			{
				return true;
			}
		}
		
		return false;
		
		
	}
	
	
	/* (non-Javadoc)
	 * @see Hand#getType()
	 */
	
	public String getType()
	{
		return "FullHouse";
	}
}
