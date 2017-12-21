
/**
 * This public class is a subclass of Deck which models the deck of cards used in the BigTwo card game
 * @author Tarun
 *
 */

public class BigTwoDeck extends Deck {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see Deck#initialize()
	 */
	
	public void initialize()
	{
		removeAllCards();
		for (int i = 0; i < 4; i++) 
		{
			for (int j = 0; j < 13; j++) 
			{
				BigTwoCard bigtwocard = new BigTwoCard(i, j);
				this.addCard(bigtwocard);
			}
		}
		
	}

}
