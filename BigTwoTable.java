import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Image;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 * The public class which implements the CardGameTable enables us to create the GUI for the BigTwo game
 * @author Tarun
 *
 */

public class BigTwoTable implements CardGameTable {

	/*
	 * {@inheritDoc}
	 */
	
	@Override
	public void setActivePlayer(int activePlayer) {
		// TODO Auto-generated method stub
		this.activePlayer = activePlayer;	
	}

	/* 
	 * {@inheritDoc}
	 */
	
	@Override
	public int[] getSelected() {
		// TODO Auto-generated method stub
		
		int ct = 0;
		
		for(int i = 0; i < 13;i++)
		{
			if(selected[i] == true)
			{
				ct++;
			}
		}
		
		int [] user_inputs = null;
		int counter = 0;
		
		if(ct != 0)
		{	
			user_inputs = new int[ct];
			for(int i = 0; i < 13;i++)
			{
				if(selected[i] == true)
				{
					user_inputs[counter] = i;
					counter++;
				}	
			}
		}
		
		
		
			return user_inputs;
	}

	/* 
	 * {@inheritDoc}
	 */
	
	@Override
	public void resetSelected() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 13;i++)
		{
			selected[i] = false;
		}
		
	}

	/* 
	 * {@inheritDoc}
	 */
	
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 13;i++)
		{
			selected[i] = false;
		}
		
		bigTwoPanel.repaint();
		bigTwoPanel.revalidate();
	}

	/* 
	 * {@inheritDoc}
	 */
	
	@Override
	public void printMsg(String msg) {
		
		msgArea.append(msg + "\n");
		
	}

	/*
	 *  {@inheritDoc}
	 */
	
	@Override
	public void clearMsgArea() {
		// TODO Auto-generated method stub
		msgArea.setText("");
	}

	/* 
	 * {@inheritDoc}
	 */
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.clearMsgArea();
		this.resetSelected();
		
	}

	/* 
	 * {@inheritDoc}
	 */
	
	@Override
	public void enable() {
		// TODO Auto-generated method stub
		playButton.setEnabled(true);
		passButton.setEnabled(true);
		bigTwoPanel.setEnabled(true);
	}

	/* 
	 * * {@inheritDoc}
	 */
	
	@Override
	public void disable() {
		// TODO Auto-generated method stub
		playButton.setEnabled(false);
		passButton.setEnabled(false);
		bigTwoPanel.setEnabled(false);
	}
	
	/**
	 * This function contains the basic GUI setup including menubar, JPanel, reading images, text area, buttons and helps to set the layout for the GUI
	 */
	
	public void setup()
	{
		
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		setActivePlayer(game.getCurrentIdx()); 
		
		
		JMenuItem i1, i2;
		JMenuBar menu_bar = new JMenuBar();
		JMenu menu = new JMenu("Game");
		i1 = new JMenuItem("End Game");
		i2 = new JMenuItem("Reset Game");
		i1.addActionListener(new QuitMenuItemListener());
		i2.addActionListener(new RestartMenuItemListener());
		menu.add(i1); menu.add(i2); 
		menu_bar.add(menu);
		frame.setJMenuBar(menu_bar);
		
		bigTwoPanel = new BigTwoPanel();
		bigTwoPanel.setLayout(new BoxLayout(bigTwoPanel,BoxLayout.Y_AXIS));
		
		cardImages = new Image [4][13];
		avatars = new Image[4];
		
		avatars[0] = new ImageIcon("src/avatars/flash_128.png").getImage();
		avatars[1] = new ImageIcon("src/avatars/superman_128.png").getImage();
		avatars[2] = new ImageIcon("src/avatars/wonder_woman_128.png").getImage();
		avatars[3] = new ImageIcon("src/avatars/batman_128.png").getImage();
		cardBackImage = new ImageIcon("src/cards/b.gif").getImage();
		
		char[] suit = {'d','c','h','s'};
		char[] rank = {'a', '2', '3', '4', '5', '6', '7', '8', '9', 't', 'j', 'q', 'k'};
		
		String fileLocation = new String();
		for (int i = 0; i < 4; i++)
		    {
				for(int j = 0 ; j < 13;j++)
				{
					fileLocation = "src/cards/" + rank[j] + suit[i] + ".gif";
			        cardImages[i][j] = new ImageIcon(fileLocation).getImage();
				}
		        
		    }

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		playButton = new JButton("Play");
		playButton.addActionListener(new PlayButtonListener());
		bottomPanel.add(playButton);
		bottomPanel.add(new JSeparator());
		passButton = new JButton("Pass");
		passButton.addActionListener(new PassButtonListener());
		bottomPanel.add(passButton);

		msgArea = new JTextArea ();
		JScrollPane scroll = new JScrollPane (msgArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(525, 0));
		DefaultCaret caret = (DefaultCaret)msgArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		frame.getContentPane().add(BorderLayout.EAST, scroll);
		

		frame.add(bigTwoPanel, BorderLayout.CENTER);
		
		frame.add(bottomPanel, BorderLayout.SOUTH);
		
		frame.setSize(1500,900);  
	    frame.setVisible(true); 
		
	}
	
	private CardGame game;
	private boolean[] selected;
	private int activePlayer;
	private JFrame frame;
	private JPanel bigTwoPanel;
	private JButton playButton;
	private JButton passButton;
	private JTextArea msgArea;
	private Image[][] cardImages;
	private Image cardBackImage;
	private Image [] avatars;

	
	/**
	 * This constructor used for creating a BigTwoTable and game parameter is a reference to  a card game that is assoiated with the table
	 * @param game
	 */
	
	public BigTwoTable(CardGame game){
		this.game = game;
		selected = new boolean[13];
		this.setup();
		msgArea.setEditable(false);
		
	}
	
	/**
	 * This is an inner class within BigTwoTable which extends JPanel and implements the MouseListener Interface. 
	 * @author Tarun
	 *
	 */
	
	class BigTwoPanel extends JPanel implements MouseListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		/**
		 * This is a BigTwoPanel constructor and all helps add Mouse Listener to the panels.
		 */
		
		public BigTwoPanel()
		{
			this.addMouseListener(this);
		}

		/*  
		 * {@inheritDoc}
		 */
		
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			// TODO Auto-generated method stub

			boolean flag = false; 
			int starting_point = game.getPlayerList().get(activePlayer).getNumOfCards()-1;
			
			
			if (e.getX() >= (155+starting_point*40) && e.getX() <= (155+starting_point*40+73)) 
			{
				if(selected[starting_point] == false && e.getY() >= 43 + 160 * activePlayer && e.getY() <= 43 + 160 * activePlayer+97) 
				{
					selected[starting_point] = true;
					flag = true;
			
				} 
				
				else if (selected[starting_point] == true && e.getY() >= 43 + 160 * activePlayer-20 && e.getY() <= 43 + 160 * activePlayer+97-20)
				{
					selected[starting_point] = false;
					flag = true;
				}
			}
			
			for (starting_point = game.getPlayerList().get(activePlayer).getNumOfCards()-2; starting_point >= 0 && !flag; starting_point--) 
			{
				if (e.getX() >= (155+starting_point*40) && e.getX() <= (155+starting_point*40+40)) 
				{
					if(selected[starting_point] == false && e.getY() >= 43 + 160 * activePlayer && e.getY() <= 43 + 160 * activePlayer+97) 
					{
						selected[starting_point] = true;
						flag = true;
					} 
					
					else if (selected[starting_point] == true && e.getY() >= 43 + 160 * activePlayer-20 && e.getY() <= 43 + 160 * activePlayer+97-20)
					{
						selected[starting_point] = false;
						flag = true;
					}
				}
				
				else if (e.getX() >= (155+starting_point*40+40) && e.getX() <= (155+starting_point*40+73) && e.getY() >= 43 + 160 * activePlayer && e.getY() <= 43 + 160 * activePlayer+97) 
				{
					if (selected[starting_point+1] == true && selected[starting_point] == false) 
					{
						selected[starting_point] = true;
						flag = true;
					}
				}
				
				else if (e.getX() >= (155+starting_point*40+40) && e.getX() <= (155+starting_point*40+73) && e.getY() >= 43 + 160 * activePlayer-20 && e.getY() <= 43 + 160 * activePlayer+97-20)
				{
					if (selected[starting_point+1] == false && selected[starting_point] == true)
					{
						selected[starting_point] = false;
						flag = true;
					}
				}
			}
			
			this.repaint();		
		}

		
		/*  
		 * {@inheritDoc}
		 */
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			this.setBackground(Color.GREEN.darker().darker());
	        
	      
		   
		    g.drawString("Player 0", 5 , 20); 
			g.setColor(Color.BLACK);
			g.drawImage(avatars[0], 5, 30, this);
		    g2.drawLine(0, 160, 1600, 160);
		    
		    if (activePlayer == 0) 
		    {
		    	for (int i = 0; i < game.getPlayerList().get(0).getNumOfCards(); i++) 
		    	{
		    		if (!selected[i])
		    		{
		    			g.drawImage(cardImages[game.getPlayerList().get(0).getCardsInHand().getCard(i).getSuit()][game.getPlayerList().get(0).getCardsInHand().getCard(i).getRank()], 155+40*i, 43, this);
		    		}
		    			
		    		else
		    		{
		    			g.drawImage(cardImages[game.getPlayerList().get(0).getCardsInHand().getCard(i).getSuit()][game.getPlayerList().get(0).getCardsInHand().getCard(i).getRank()], 155+40*i, 43-20, this);
		    		}
		    			
		    	}
		    } 
		    
		    else
		    {
		    	for (int i = 0; i < game.getPlayerList().get(0).getCardsInHand().size(); i++)
		    	{
		    		g.drawImage(cardBackImage, 155 + 40*i, 43, this);
		    	}
		    }
		 
		       
		        g.drawString("Player 1", 5 , 180);	
			    g.setColor(Color.BLACK);
			    g.drawImage(avatars[1], 5, 190, this);
			    g2.drawLine(0, 320, 1600, 320);
			    
			    
		    if (activePlayer == 1) 
		    {
		    	for (int i = 0; i < game.getPlayerList().get(1).getNumOfCards(); i++)
		    	{
		    		if (!selected[i])
		    		{
		    			g.drawImage(cardImages[game.getPlayerList().get(1).getCardsInHand().getCard(i).getSuit()][game.getPlayerList().get(1).getCardsInHand().getCard(i).getRank()], 155+40*i, 203, this);
		    		}
		    			
		    		else
		    		{
		    			g.drawImage(cardImages[game.getPlayerList().get(1).getCardsInHand().getCard(i).getSuit()][game.getPlayerList().get(1).getCardsInHand().getCard(i).getRank()], 155+40*i, 203-20, this);
		    		}
		    			
		    	}
		    }
		    
		    else
		    {
		    	for (int i = 0; i < game.getPlayerList().get(1).getCardsInHand().size(); i++)
		    	{
		    		g.drawImage(cardBackImage, 155 + 40*i, 203, this);
		    	}
		    }
		    
		   
		        g.drawString("Player 2", 5 , 340);
			    g.setColor(Color.BLACK);
			    g.drawImage(avatars[2], 5, 350, this);
			    g2.drawLine(0, 480, 1600, 480);
			    
		    if (activePlayer == 2)
		    {
		    	for (int i = 0; i < game.getPlayerList().get(2).getNumOfCards(); i++)
		    	{
		    		if (!selected[i])
		    		{
		    			g.drawImage(cardImages[game.getPlayerList().get(2).getCardsInHand().getCard(i).getSuit()][game.getPlayerList().get(2).getCardsInHand().getCard(i).getRank()], 155+40*i, 363, this);
		    		}
		    			
		    		else
		    		{
		    			g.drawImage(cardImages[game.getPlayerList().get(2).getCardsInHand().getCard(i).getSuit()][game.getPlayerList().get(2).getCardsInHand().getCard(i).getRank()], 155+40*i, 363-20, this);
		    		}
		    			
		    	}
		    } 
		    
		    else 
		    {
		    	for (int i = 0; i < game.getPlayerList().get(2).getCardsInHand().size(); i++) 
		    	{
		    		g.drawImage(cardBackImage, 155 + 40*i, 363, this);
		    	}
		    }
		        	
		       
		        g.drawString("Player 3", 10, 500);		        
			    g.setColor(Color.BLACK);
			    g.drawImage(avatars[3], 5 , 510, this);
			    g2.drawLine(0, 640, 1600, 640);
		    
		    if (activePlayer == 3)
		    {
		    	for (int i = 0; i < game.getPlayerList().get(3).getNumOfCards(); i++)
		    	{
		    		if (!selected[i])
		    		{
		    			g.drawImage(cardImages[game.getPlayerList().get(3).getCardsInHand().getCard(i).getSuit()][game.getPlayerList().get(3).getCardsInHand().getCard(i).getRank()], 155+40*i, 523, this);
		    		}
		    			
		    		else
		    		{
		    			g.drawImage(cardImages[game.getPlayerList().get(3).getCardsInHand().getCard(i).getSuit()][game.getPlayerList().get(3).getCardsInHand().getCard(i).getRank()], 155+40*i, 523-20, this);
		    		}
		    			
		    	}
		    }
		    
		    else 
		    {
		    	for (int i = 0; i < game.getPlayerList().get(3).getCardsInHand().size(); i++) 
		    	{
		    		g.drawImage(cardBackImage, 155 + 40*i, 523, this);
		    	}
		    }
		    
		    g.drawString("Hand on Table", 10, 660);
		     
		    if (!game.getHandsOnTable().isEmpty())
		    {
		    	 	Hand handOnTable = game.getHandsOnTable().get(game.getHandsOnTable().size()-1);
			    	g.drawString("Hand Type:\n ", 10, 700);
			    		for (int i = 0; i < handOnTable.size(); i++)
			    		{
			    			g.drawImage(cardImages[handOnTable.getCard(i).getSuit()][handOnTable.getCard(i).getRank()], 160 + 40*i, 690, this);
			    		}
			    		
			    		g.drawString("Played by" + game.getHandsOnTable().get(game.getHandsOnTable().size()-1).getPlayer().getName(), 10, 725);
			    		g.drawString(game.getHandsOnTable().get(game.getHandsOnTable().size()-1).getType() , 10, 745);
			    	
		    }
		    
		    repaint();
		}

		/*  
		 * {@inheritDoc}
		 */
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		/* 	
		 * {@inheritDoc}
		 */
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		/*  
		 * {@inheritDoc}
		 */
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		/*  
		 * {@inheritDoc}
		 */
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	/**
	 * This is an inner class within BigTwoTable which implements the ActionListener and handles the click events on the PlayButton
	 * @author Tarun
	 *
	 */
	
	class PlayButtonListener implements ActionListener{

		/* 
		 *  {@inheritDoc}
		 */
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			game.makeMove(activePlayer, getSelected());
			repaint();
		}
		
	}
	
	/**
	 * This is an inner class within BigTwoTable which implements the ActionListener and handles the click events on the PauseButton
	 * @author Tarun
	 *
	 */
	
	class PassButtonListener implements ActionListener{

		/*  
		 * {@inheritDoc}
		 */
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			game.makeMove(activePlayer, null);
			repaint();
		}
		
	}
	
	/**
	 * This is an inner class within BigTwoTable which implements the ActionListener and handles the click events on the RestartMenuItem present in the MenuBar
	 * @author Tarun
	 *
	 */
	
	class RestartMenuItemListener implements ActionListener{

		/*  
		 * {@inheritDoc}
		 */
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			BigTwoDeck deck = new BigTwoDeck();
			deck.shuffle();
			game.start(deck);
			reset();
			
		}
	}
	
	/**
	 * This is an inner class within BigTwoTable which implements ActionListener and handles the click events on the QuitMenuItem present in the MenuBar
	 * @author Tarun
	 *
	 */
	
	class QuitMenuItemListener implements ActionListener{

		/*  
		 * {@inheritDoc}
		 */
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(activePlayer);	
		}
		
		
	}

}
