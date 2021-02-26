package blackjack;

import java.util.ArrayList;
import junit.framework.TestCase;

public class Hand
{
	private boolean hasAce;
    private ArrayList<Card> cards;
	
	public Hand()
	{
		cards = new ArrayList<Card>();
		hasAce = false;
	}
	

	public void addCardToHand() //Adds a single card to hand
	{
		Card x = new Card();
		cards.add(x);
	}

	public int getHandValue2()
	{
		int handValue = 0;
		
		for(int i = 0; i < cards.size(); i++)
		{
			Card x = cards.get(i);
			handValue += x.getNumValue();
		}
				
		return handValue;
	}
	
	public String toString()
	{
		return null;
	}
	
}