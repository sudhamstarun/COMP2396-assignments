
/**
 * This public class is a subclass of Hand which is used to model a single hand and check if the hand is a valid single type, return single type if it is and also return the top card of a single hand
 * @author Tarun
 *
 */

public class Single extends Hand implements Abstract_Interface{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * This constructor helps creating a single object holding the single hand of specific and card played by that player
	 * @param player
	 * 		A CardGamePlayer object which contains specified player to whom the current hand belongs to
	 * @param card
	 * 		A CardList object which contains list of cards played by the active player
	 */
	
	public Single(CardGamePlayer player, CardList card)
	{
		super(player,card);
	}
	
	/* (non-Javadoc)
	 * @see Hand#getTopCard()
	 */
	
	public Card getTopCard()
	{
		return this.getCard(0);
	}
	
	/* (non-Javadoc)
	 * @see Hand#isValid()
	 */
	
	public boolean isValid()
	{
		if(this.size() == 1)
			return true;
		
		return false;
	}
	
	/* (non-Javadoc)
	 * @see Hand#getType()
	 */
	
	public String getType()
	{
		return new String("Single");
	}
	
	

}
