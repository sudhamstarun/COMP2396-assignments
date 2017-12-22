
/**
 * This public class is a subclass of Hand which is used to model a triple hand and check if the hand is a valid triple type, return triple type if it is and also return the top card of a triple hand
 * @author Tarun
 *
 */
public class Triple extends Hand implements Abstract_Interface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * This constructor helps creating a Triple object holding the triple hand of specific player and cards played by that player
	 * @param player
	 * 		A CardGamePlayer object which contains specified player to whom the current hand belongs to
	 * @param card
	 * 		A CardList object which contains list of cards played by the active player
	 */
	public Triple(CardGamePlayer player, CardList card)
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
			if(this.getCard(0).suit > this.getCard(2).suit)
			{
				return this.getCard(0);
			}
			
			else
			{
				return this.getCard(2);
			}
		}
		
		else
		{
			if(this.getCard(1).suit > this.getCard(2).suit)
			{
				return this.getCard(1);
			}
			
			else
			{
				return this.getCard(2);
			}
		}
		
	}
	
	/* (non-Javadoc)
	 * @see Hand#isValid()
	 */
	
	public boolean isValid()
	{
		if(this.size()  != 3)
		{
			return false;
		}
		
		if(this.getCard(0).rank == this.getCard(1).rank && this.getCard(0).rank == this.getCard(2).rank)
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
		return new String("Triple");
	}

}
