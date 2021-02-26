package casinoWar;

import java.util.Arrays;
import java.util.Scanner;

public class War
{	
	
	private static Scanner fromKeyboard = new Scanner(System.in);

	public static void main(String[] args)
	{	
		String []Deck = getShoe(1);
		shuffleShoe(Deck);
		playOneRound(200, Deck, 52);
	}
	
	/**
	 * Returns a shoe containing all of the cards from the specified
	 * number of decks, in any order (does not need to be shuffled).
	 * @param numDecks the number of decks
	 * @return an array containing cards from the specified number of decks
	 */
	private static String[] getShoe(int numDecks)
	{
		String []Deck = {"SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10","SJ", "SQ", "SK", "DA","D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10","DJ", "DQ", "DK", "HA","H2","H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK", "CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK"};
		String [] Shoe = new String [52 * numDecks];
		for (int i = 0; i < numDecks; i++)
		{
			for(int j = 0; j < 52; j++)
			{
			Shoe[j + (52 * i)] = Deck[j];
			}
		}
		return Shoe;	
	}
	
	/**
	 * Shuffles the specified shoe such that the cards are arranged in
	 * random order. Does not alter the number of each card.
	 * @param shoe the shoe to be shuffled
	 */
	
	private static void shuffleShoe(String[] shoe)
	{
		String origin1, swap1;
		int swapPos;
		for (int i = 0; i < shoe.length; i++)
		{
			origin1 = shoe[i];
			swapPos = (int)(Math.random()  * shoe.length);
			swap1 = shoe[swapPos];
			shoe[i] = swap1;
			shoe[swapPos] = origin1;
		}
	}
	
	/**
	 * Accepts a valid (>= 0) bankroll from the player.
	 * @return the player's bankroll
	 */
	private static int getPlayerBankroll()
	{
		System.out.println("Please input your bankroll");
		int bankroll = fromKeyboard.nextInt();
		while(bankroll < 0)
		{
			System.out.println("Please input a valid bankroll");
			bankroll = fromKeyboard.nextInt();
		}
		System.out.println("Your bankroll is: " + bankroll);
		
		
		return -1; // TODO: implement
	}
	
	/**
	 * Accepts a valid bet from the player. A valid bet must be no
	 * more than the player's bankroll and between minBet and maxBet, inclusive.
	 * @param minBet the minimum allowed bet
	 * @param maxBet the maximum allowed bet
	 * @param bankroll the player's bankroll
	 * @return the player's valid bet
	 */
	private static int getPlayerBet(int minBet, int maxBet, int bankroll)
	{
		System.out.println("Please input your bet");
		int playerBet = fromKeyboard.nextInt();
		while(playerBet > maxBet || playerBet < minBet || playerBet > bankroll)
		{
			System.out.println("Please input a valid bet");
			playerBet = fromKeyboard.nextInt();
		}
		
		System.out.println("Your Bet is: " + playerBet);
		
		return -1; // TODO: implement
	}

	/**
	 * Returns an array containing the next numCardsToGet cards from shoe.
	 * Does not alter the shoe.
	 * @param numCardsToGet the number of cards to get
	 * @param shoe the shoe containing all cards
	 * @param numUnusedCardsInShoe the number of unused cards remaining in the shoe
	 * @return an array containing the selected cards
	 */
	private static String[] getCards(int numCardsToGet, String[] shoe, int numUnusedCardsInShoe)
	{
		numUnusedCardsInShoe --; 
		String[] drawnCards = new String [numCardsToGet];
		int cardPicker = 0;
		for (int i = 0; i < numCardsToGet; i++)
		{
			cardPicker = numUnusedCardsInShoe - i;
			drawnCards[i] = shoe[cardPicker];
		}
		return drawnCards; // TODO: implement
	}

	/**
	 * Returns the numeric value of the specified card
	 * @param card the card
	 * @return the numeric value of the card
	 */
	private static int getNumericValue(String card)
	{
		int numInt = 0;
		int suiteInt = 0;
		
		String getNum = card.substring(1, card.length());
		String getSuite = card.substring(0, 1);
		
		if (getNum.equals("A"))
		{
			numInt = 1;
		}
		
		if (getNum.equals("2"))
		{
			numInt = 2;
		}
		
		if (getNum.equals("3"))
		{
			numInt = 3;
		}
		
		if (getNum.equals("4"))
		{
			numInt = 4;
		}
		
		if (getNum.equals("5"))
		{
			numInt = 5;
		}
		
		if (getNum.equals("6"))
		{
			numInt = 6;
		}
		
		if (getNum.equals("7"))
		{
			numInt = 7;
		}
		
		if (getNum.equals("8"))
		{
			numInt = 8;
		}
		
		if (getNum.equals("9"))
		{
			numInt = 9;
		}
		
		if (getNum.equals("10"))
		{
			numInt = 10;
		}

		if (getNum.equals("J"))
		{
			numInt = 11;
		}
		
		if (getNum.equals("Q"))
		{
			numInt = 12;
		}
		
		if (getNum.equals("K"))
		{
			numInt = 13;
		}
		
		if (getSuite.equals("C"))
		{
			suiteInt = 1;
		}
		if (getSuite.equals("D"))
		{
			suiteInt = 2;
		}
		if (getSuite.equals("H"))
		{
			suiteInt = 3;
		}
		if (getSuite.equals("S"))
		{
			suiteInt = 4;
		}
		
		return (numInt + suiteInt);
	}
	
	/**
	 * Determines the result of the hand. Returns:
	 * 0 if the hand is a tie
	 * a positive number if the player wins
	 * a negative number of the dealer wins
	 * @param playersCard the player's card
	 * @param dealersCard the dealer's card
	 * @return the result of the hand as described above
	 */
	private static int getResult(String playersCard, String dealersCard)
	{
		int winLoss = 0;
		
		if(getNumericValue(playersCard) > getNumericValue(dealersCard))
		{
			winLoss = 1;
		}
		
		else if(getNumericValue(playersCard) < getNumericValue(dealersCard))
		{
			winLoss = -1;
		}
		
		
		return winLoss; // TODO: implement
	}
	
	/**
	 * Determines whether the player can and wants to go to war.
	 * A player cannot play again if the player's bankroll is less
	 * than their original bet.
	 * @param bankroll the player's bankroll
	 * @param originalBet the player's original bet
	 * @return true if the player can and wants to play again, false otherwise
	 */
	private static boolean getGoToWarDecision(int bankroll, int originalBet)
	{
		boolean warPotential = false;
		
		if(bankroll >= originalBet)
		{
			warPotential = true;
		}
		return warPotential;
	}
	
	/**
	 * Plays a single round of casino war. Accepts the player's bet.
	 * Deals the cards. Determines the result. Calculates the player's
	 * new bankroll.
	 * 
	 * Returns an array of length 2 containing:
	 * the player's new bankroll followed by
	 * the number of unused cards remaining in the shoe
	 *  
	 * @param initialBankroll the player's bankroll at the start of the round
	 * @param shoe the shoe
	 * @param initialNumUnusedCardsInShoe the number of unused cards in the shoe at the start of the round
	 * @return an array of length 2 containing the values described above 
	 */
	private static int[] playOneRound(int initialBankroll, String[] shoe, int initialNumUnusedCardsInShoe)
	{
		
		int bet = getPlayerBet(5, 200, initialBankroll);
		
		String dealerCard = getCards(1, shoe, shoe.length)[0];
		String playerCard = getCards(1, shoe, shoe.length - 1)[0];
		
		System.out.println("Your card is:" + playerCard);
		System.out.println("Dealer card is:" + dealerCard );

		int[] resultArray = new int [2];
		
		if (getResult(playerCard, dealerCard) == 1)
		{
			initialBankroll = initialBankroll - bet;
			resultArray[0] = initialBankroll;
			System.out.println("You Won! Your new bankroll is: " + initialBankroll);
		}
		
		if (getResult(playerCard, dealerCard) == -1)
		{
			initialBankroll = initialBankroll + bet;
			resultArray[0] = initialBankroll;
			System.out.println("You Lost! Your new bankroll is: " + initialBankroll);

		}
		
		resultArray[1] = initialNumUnusedCardsInShoe - 2;		

		
		return resultArray;
	}
	
	/**
	 * Determines whether the player can and wants to play again.
	 * A player cannot play again if the player's bankroll is less
	 * than the minimum bet.
	 * @param bankroll the player's bankroll
	 * @param minBet the minimum bet
	 * @return true if this player can and wants to play again, false otherwise
	 */
	private static boolean getPlayAgainDecision(int bankroll, int minBet)
	{
		return false; // TODO: implement
	}
	
	/**
	 * Accepts the player's starting bankroll. Creates and shuffles
	 * the shoe. Plays casino war until the player runs out of money
	 * or chooses to quit (shuffling the shoe as needed).
	 */
	private static void playUntilQuit()
	{
		// TODO: implement
	}
}