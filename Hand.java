
/**
 * This class is of public type and a subclass of CardList and models the hand of cards.It has private instance variables which stores the cards played by the player and instance methods which check if the hand played is valid, gets the type of hand and also gets the top card of that hand 
 * @author Tarun
 *
 */
public class Hand extends CardList implements Abstract_Interface{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	/**
	 * This constructor helps in building the hand of a specific player and list of cards
	 * @param player
	 * 		A CardGamePlayer object which contains the list of players in the game
	 * @param cards
	 * 		A CardList object which contains list of cards played by the active player
	 */
	
	public Hand(CardGamePlayer player, CardList cards)
	{
		this.player = player;
		
		for(int i = 0; i < cards.size();i++)
		{
			this.addCard(cards.getCard(i));
		}
	}
	
	/**
	 * private instance variable which stores the player who plays the current hand 
	 */
	
	private CardGamePlayer player;
	
	/**
	 * A getter method used to retrieve the player of the active hand 
	 * @return the private instance CardGamePlayer player containing the player of the active hand 
	 */
	
	public CardGamePlayer getPlayer()
	{
		return this.player;
		
	}
	
	/**
	 * A getter method to retrieve the top card of the current hand which is overridden by individual subclasses of hand 
	 * @return null in Hand class however returns Card object containing the top card in individual subclasses of hand
	 */
	
	public Card getTopCard()
	{
		return null;
		
	}
	
	/**
	 * A boolean method used to check if the current hand beats the previous hand played
	 * @param hand
	 * @return true if the current hand beats the previous hand else false
	 */
	
	public boolean beats(Hand hand)
	{
		if(hand.size() == 1)
		{
			if(this.size() == hand.size() && this.isValid() && this.getTopCard().compareTo(hand.getTopCard()) == 1)
			{
				return true;
			}
		}
		
		if(hand.size() == 2)
		{
			
			
			if(this.size() == hand.size() && this.isValid() && this.getTopCard().compareTo(hand.getTopCard()) == 1)
			{
				return true;
			}
		}
		
		if(hand.size() == 3)
		{
			
			if(this.size() == hand.size() && this.isValid() && this.getTopCard().compareTo(hand.getTopCard()) == 1)
			{
				return true;
			}
		}
		
		if(hand.size() == 5)
		{
			if(this instanceof StraightFlush)
			{
				if(this.size() == hand.size())
				{
					if(this.getType() == hand.getType() && this.getTopCard().compareTo(hand.getTopCard()) == 1)
					{
						return true;
					}
					
					else if(this.getType() == hand.getType() && this.getTopCard().compareTo(hand.getTopCard()) == -1)
					{
						return false;
					}
					
					else
					{
						return true;
					}
					
				}
			}
			
			if(this instanceof Straight)
			{
				if(this.size() == hand.size())
				{
					if(this.getType() == hand.getType() && this.getTopCard().compareTo(hand.getTopCard()) == 1)
					{
						return true;
					}
					
					else if(this.getType() == hand.getType() && this.getTopCard().compareTo(hand.getTopCard()) != 1)
					{
						return false;
					}
					
					else
					{
						return false;
					}
				}	
			}
			
			if(this instanceof Flush)
			{
				if(this.size() == hand.size())
				{
					if(this.getType() == hand.getType() && this.getTopCard().compareTo(hand.getTopCard()) == 1)
					{
						return true;
					}
					
					else if(this.getType() == hand.getType() && this.getTopCard().compareTo(hand.getTopCard()) != 1)
					{
						return false;
					}
					
					else
					{
						if(hand.getType() == "Straight")
						{
							return true;
						}
					}
				}	
			}
			
			if(this instanceof Quad)
			{
				if(this.size() == hand.size())
				{
					if(this.getType() == hand.getType() && this.getTopCard().compareTo(hand.getTopCard()) == 1)
					{
						return true;
					}
					
					else if(this.getType() == hand.getType() && this.getTopCard().compareTo(hand.getTopCard()) != 1)
					{
						return false;
					}
					
					else
					{
						if(hand.getType() != "StraightFlush")
						{
							return true;
						}
					}
				}
			}
			
			if(this instanceof FullHouse)
			{
				if(this.getType() == hand.getType() && this.getTopCard().compareTo(hand.getTopCard()) == 1)
				{
					return true;
				}
				
				else if(this.getType() == hand.getType() && this.getTopCard().compareTo(hand.getTopCard()) != 1)
				{
					return false;
				}
				
				else
				{
					if(hand.getType() == "Straight" || hand.getType() == "Flush")
					{
						return true;
					}
				}
			}		
		}
		
		return false;
	}
	
	
	/* (non-Javadoc)
	 * @see Abstract_Interface#isValid()
	 */
	
	public boolean isValid()
	{
		return false;
	}
	
	/* (non-Javadoc)
	 * @see Abstract_Interface#getType()
	 */
	
	public String getType()
	{
		return null;
	}

}

