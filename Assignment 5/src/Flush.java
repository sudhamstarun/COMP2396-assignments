import java.util.Arrays;

/**
 * This public class is a subclass of Hand which is used to model a Flush hand and check if the hand is a valid Flush type, return Flush type if it is and also return the top card of a Flush hand
 * @author Tarun
 *
 */

public class Flush extends Hand implements Abstract_Interface {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * This constructor helps creating a Flush object holding the flush hand of specific player and cards played by that player 
	 * @param player
	 * 		A CardGamePlayer object which contains specified player to whom the current hand belongs to
	 * @param card
	 * 		A CardList object which contains list of cards played by the active player
	 */
	
	public Flush(CardGamePlayer player, CardList card)
	{
		super(player,card);
	}
	
	/* (non-Javadoc)
	 * @see Hand#getTopCard()
	 */
	
	public Card getTopCard()
	{
		int [] numbers = {this.getCard(0).rank, this.getCard(1).rank, this.getCard(2).rank, this.getCard(3).rank, this.getCard(4).rank}; // store the ranks of each card inside an array
		int index = 0;
		
		for(int i = 0; i < 5;i++)
		{
			if(numbers[i] == 0)
			{
				numbers[i] = 13;
			}
			
			if(numbers[i] == 1)
			{
				numbers[i] = 14;
			}
		}
		
		Arrays.sort(numbers);
		
		
		for(int i = 0; i < numbers.length;i++)
		{
			if(this.getCard(i).rank == numbers[4])
			{
				index = i;
			}
		}
		
		return this.getCard(index);
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
		
		if(this.getCard(0).suit == this.getCard(1).suit && this.getCard(1).suit == this.getCard(2).suit && this.getCard(2).suit == this.getCard(3).suit && this.getCard(3).suit == this.getCard(4).suit)
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
		return "Flush";
	}
	

}
