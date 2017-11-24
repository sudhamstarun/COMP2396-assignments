
/**
 * This public class is a subclass of Hand which is used to model a Quad hand and check if the hand is a valid Quad type, return Quad type if it is and also return the top card of a Quad hand
 * @author Tarun
 *
 */
public class Quad extends Hand implements Abstract_Interface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * This constructor helps creating a Quad object holding the quad hand of specific player and cards played by that player
	 * @param player
	 * 		A CardGamePlayer object which contains specified player to whom the current hand belongs to
	 * @param card
	 * 		A CardList object which contains list of cards played by the active player
	 */
	
	public Quad(CardGamePlayer player, CardList card)
	{
		super(player,card);
	}
	
	/* (non-Javadoc)
	 * @see Hand#getTopCard()
	 */
	
	public Card getTopCard()
	{
		this.sort();
		
		if(this.getCard(0).rank == this.getCard(1).rank)
		{
			return this.getCard(3);
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
		
		
		
		this.sort();
		
		if(this.getCard(0).rank == this.getCard(1).rank)
		{
			if(this.getCard(1).rank == this.getCard(2).rank && this.getCard(2).rank == this.getCard(3).rank)
			{
				return true;
			}
		}
		
		else if(this.getCard(1).rank == this.getCard(2).rank)
		{
			if(this.getCard(2).rank == this.getCard(3).rank && this.getCard(2).rank == this.getCard(4).rank)
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
		return "Quad";
	}
}
