import java.util.ArrayList;

/**
 * The BigTwo class is a public class to represent the BigTwo object and contains the overall flow of the BigTwo card game
 * @author Tarun
 * 
 */
public class BigTwo implements CardGame {
	
	private Deck deck;
	private ArrayList<CardGamePlayer> playerList; // a list of all players in the game 
	private ArrayList<Hand> handsOnTable; // a list of hands played on the table
	private int currentIdx; // an int type specifying the index of the active player
	private BigTwoTable bigTwoTable;
	
	/**
	 *  A constructor for creating the BigTwo card game. 
	 */
	
	public BigTwo()
	{
		playerList = new ArrayList<CardGamePlayer> ();
		
		for(int i = 0; i < 4;i++)
		{
			playerList.add(new CardGamePlayer());
		}
		
		handsOnTable = new ArrayList<Hand>();
		//bigTwoConsole = new BigTwoConsole(this);
		bigTwoTable = new BigTwoTable(this);
	}
	
	/**
	 * This is a getter method to retrieve the deck of cards being played 
	 * @return
	 * 		Returns a deck object containing the deck of cards currently being played 
	 */
	
	public Deck getDeck()
	{
		return this.deck;
	}
	
	/**
	 * A getter method to retrieve the list of players 
	 * @return an arraylist containing the list of players 
	 */
	
	public ArrayList<CardGamePlayer> getPlayerList()
	{
		return this.playerList;		
    }
	/**
	 * Gets the current cards that have been played on the table by the previous player 
	 * @return an arraylist containing the cards played by the previous player
	 */
	public ArrayList<Hand> getHandsOnTable()
	{
		return this.handsOnTable;
	}
	
	/**
	 * A get method which retrieves the index of the active player
	 * @return an int type which could either be 0,1,2 or 3 
	 */
	public int getCurrentIdx()
	{
		return this.currentIdx;	
	}
	
	/**
	 * A method to start to the game with a shuffled deck of cards as given in the BigTwoDeck object deck
	 * @param Deck 
	 * 		the BigTwoDeck object supplied as the shuffled deck of cards used to play the game 
	 */
	public void start(Deck Deck)
	{
		int x = 0;
		
		handsOnTable.clear();
		
		for(int i = 0; i < 4; i++)   // adding cards to the hand 
		{
			playerList.get(i).removeAllCards();
			
			for(int j = 0; j < 13; j++)
			{
				playerList.get(i).addCard(Deck.getCard(x+i+j));
			
			}
			
			x = x+12;
		}
		
		for(int i = 0; i < 4;i++)
		{
			playerList.get(i).getCardsInHand().sort();
		}
		
		currentIdx = -1;
		
		for(int i = 0; i < 4;i++) // setting the active player
		{
			if(playerList.get(i).getCardsInHand().contains(new Card(0,2)))
			{
				bigTwoTable.setActivePlayer(i);
				currentIdx = i;
			}
		}
		
		bigTwoTable.repaint();
	}
	
	/* 
	 * {@inheritDoc}
	 */
	
	public void makeMove(int playerID, int [] cardIdx)
	{
		checkMove(playerID,cardIdx);
	}
	
	/* 
	 * {@inheritDoc}
	 */
	
	public void checkMove(int playerID, int [] cardIdx)
	{
		CardList cardlist = new CardList(); // CardList object to store the cards played by the player
		boolean check_is_valid = true; // storing the value of boolean returned by object.isValid() method
		int previous_player;
		
		if(handsOnTable.isEmpty())
		{
			previous_player = -1;
		}
		
		else
		{
			Hand lastHandOnTable = handsOnTable.get(handsOnTable.size() - 1);
			String player_name = lastHandOnTable.getPlayer().getName();
					
			if(player_name.equals("Player 0"))
			{
				previous_player = 0;
			}
			
			else if(player_name.equals("Player 1"))
			{
				previous_player = 1;
			}
			
			else if(player_name.equals("Player 2"))
			{
				previous_player = 2;
			}
			
			else
			{
				previous_player = 3;
			}
		}
		
		if(cardIdx != null)
		{
			
			cardlist = playerList.get(playerID).play(cardIdx);
			Hand hand = composeHand(playerList.get(playerID), cardlist);
			if(handsOnTable.isEmpty())
			{
				if(hand.contains(new Card(0,2)) && hand != null)
				{
					check_is_valid = true; // assigning check_is_valid true if the first move 3 of diamonds and hand is not empty 
				}
				
				else
				{
					check_is_valid = false;
				}
			}
			
			else
			{
				if(previous_player != playerID)
				{
					if(hand != null || handsOnTable.size() != 0)
					{
						check_is_valid = hand.beats(handsOnTable.get(handsOnTable.size() - 1));
					}
				
				else
					check_is_valid = false;
				}
					
				else
					if(hand != null)
					{
						check_is_valid = true;
					}
				
					else
						check_is_valid = false;
			}
			
			
			if(check_is_valid)
			{
				previous_player = playerID;
				for(int i = 0; i < cardlist.size();i++)
				{
					playerList.get(playerID).getCardsInHand().removeCard(cardlist.getCard(i)); // removes the card upon the player playing a successful move
				}
				
				bigTwoTable.printMsg("Player " + playerID  + "'s turn: ");
				bigTwoTable.printMsg("{" + hand.getType() + "}" + " " + hand);
				handsOnTable.add(hand);
				playerID = (playerID+1)%4;
				bigTwoTable.setActivePlayer(playerID); // setting the next active player
				bigTwoTable.printMsg("");
				
				System.out.println("Previous Player: " + previous_player);
				System.out.println("PlayerID: " + playerID);
			}
			
			else
			{
				bigTwoTable.printMsg("Player " + playerID  + "'s turn");
				bigTwoTable.printMsg("Not a legal move!"); // printing in case the current active player didn't play a valid move
				
			}
			
		}
			
			else
			{
				if(!handsOnTable.isEmpty() && previous_player != playerID) // condition if the current player tries to pass
				{
					playerID = (playerID+1)%4;
					bigTwoTable.setActivePlayer(playerID);
					bigTwoTable.printMsg("Player " + playerID  + "'s turn");
					bigTwoTable.printMsg("{Pass}");  
					check_is_valid = true;
				}
				
				else
				{
					bigTwoTable.printMsg("Player " + playerID  + "'s turn");
					bigTwoTable.printMsg("Not a legal move");
				} 
			}
			

		if(endOfGame())
		{
			
			bigTwoTable.setActivePlayer(-1);
			bigTwoTable.repaint();
			bigTwoTable.printMsg("");
			bigTwoTable.printMsg("Game ends");
			
			
			for(int i = 0; i < playerList.size();i++)
			{
					if(playerList.get(i).getCardsInHand().size() == 0)
					{
						bigTwoTable.printMsg("Player " + i + " wins the game"); // declare that player as winner
					}
				
				else
				{
					bigTwoTable.printMsg("Player " + i + " has " + playerList.get(i).getCardsInHand().size() + " cards in hand"); // list the number of cards left in the other players' hand
				}
			}
			
			bigTwoTable.disable();
		}
	}
	
	/**
	 * A method to return a valid hand from all the list of cards played by the player. 
	 * @param player
	 * 		A CardGamePlayer object which contains the list of players in the game 
	 * @param cards
	 * 		A CardList object which contains list of cards played by the active player
	 * @return the type of hand 
	 */
	
	public Hand composeHand(CardGamePlayer player, CardList cards)
	{
		StraightFlush straightflush = new StraightFlush(player,cards); // declaring a new straightflush object
		Triple triple = new Triple(player,cards); // declaring a new triple object 
		Single single = new Single(player,cards); // declaring a new single object
		Pair pair = new Pair(player,cards); // declaring a new pair object
		Quad quad = new Quad(player,cards); // declaring a new quad object
		Flush flush = new Flush(player,cards); // declaring a new flush object 
		Straight straight = new Straight(player,cards); // declaring a new straight object 
		FullHouse fullhouse = new FullHouse(player,cards); // declaring a new fullhouse object 
		
		if(straightflush.isValid())
		{
			return straightflush; // returns a straightflush object 
		}
		
		if(quad.isValid())
		{
			return quad; // returns a quad object 
		}
		
		if(fullhouse.isValid())
		{
			return fullhouse; // returns a fullhouse object 
		}
		
		if(flush.isValid())
		{
			return flush; // returns a flush object
		}
		
		if(straight.isValid())
		{	
			return straight; // returns a straight object 
		}
		
		if(triple.isValid())
		{
			return triple; // returns a triple object 
		}
		
		if(pair.isValid())
		{
			return pair; // returns a pair object 
		}
		
		if(single.isValid())
		{
			return single; // returns a single object 
		}
		
		return null; 
	}
	 
	
	/**
	 * Main helps in creating BigTwo and BigTwoDeck objects and shuffle and start the game by calling the void start function
	 * @param args
	 */
	
	public static void main(String [] args)
	{
		BigTwo game_1_a = new BigTwo();
		BigTwoDeck game_1_b = new BigTwoDeck();
		game_1_b.shuffle(); // shuffle the cards to each player
		game_1_a.start(game_1_b);
	}

	/* 
	 * {@inheritDoc}
	 */
	
	@Override
	public int getNumOfPlayers() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* 
	 *  {@inheritDoc}
	 */
	
	@Override
	public boolean endOfGame() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < playerList.size();i++)
		{
			if(playerList.get(i).getCardsInHand().size() == 0)
			{
				return true;
			}
		}
		
		return false;
	}
	
}
