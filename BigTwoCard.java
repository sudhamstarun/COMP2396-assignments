/**
 * This public class is a subclass of Card which allows us to model the cards which are being used in the BigTwo card game. 
 * @author Tarun
 *
 */
public class BigTwoCard extends Card {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * This constructor builds a card with a secific suit and rank
	 * @param suit
	 * 		an int value between 0 and 3 representing the suit of a card:
	 *            <p>
	 *            0 = Diamond, 1 = Club, 2 = Heart, 3 = Spade
	 * @param rank
	 * 		an int value between 0 and 12 representing the rank of a card:
	 *            <p>
	 *            0 = 'A', 1 = '2', 2 = '3', ..., 8 = '9', 9 = '0', 10 = 'J', 11
	 *            = 'Q', 12 = 'K'
	 */
	
	public BigTwoCard(int suit, int rank) {
		super(suit, rank);
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see Card#compareTo(Card)
	 */
	
	public int compareTo(Card card)
	{
		
		int this_rank = this.rank;
		int card_rank = card.rank;
		
		if(this_rank == 0)
		{
			this_rank = 13;
		}
		
		if(this_rank == 1)
		{
			this_rank = 14;
		}
		
		if(card_rank == 0)
		{
			card_rank = 13;
		}
		
		if(card_rank == 1)
		{
			card_rank = 14;
		}		
		
		if (this_rank > card_rank) {
			return 1;
		} else if (this_rank < card_rank) {
			return -1;
		} else if (this.suit > card.suit) {
			return 1;
		} else if (this.suit < card.suit) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
