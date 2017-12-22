import java.util.Arrays;

/**
 * This public class is a subclass of Hand which is used to model a straight hand and check if the hand is a valid straight type, return straight type if it is and also return the top card of a straight hand
 * @author Tarun
 *
 */

public class Straight extends Hand implements Abstract_Interface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This constructor helps creating a Straight object holding the straight hand of specific player and cards played by that player
	 * @param player
	 * 		A CardGamePlayer object which contains specified player to whom the current hand belongs to
	 * @param card
	 * 		A CardList object which contains list of cards played by the active player
	 */
	
	public Straight(CardGamePlayer player, CardList card)
	{
		super(player,card);
	}
	
	/* (non-Javadoc)
	 * @see Hand#getTopCard()
	 */
	
	public Card getTopCard()
	{
		int [] numbers = {this.getCard(0).rank, this.getCard(1).rank, this.getCard(2).rank, this.getCard(3).rank, this.getCard(4).rank};
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
		
		
		int [] numbers = {this.getCard(0).rank, this.getCard(1).rank, this.getCard(2).rank, this.getCard(3).rank, this.getCard(4).rank};
		
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
		
		for (int i = 1; i < numbers.length; i++) 
		{
		    if (numbers[i] != numbers[i-1] + 1) 
		    {	
		      return false;
		    }
		}
		
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see Hand#getType()
	 */
	
	public String getType()
	{
		return "Straight";
	}
}
