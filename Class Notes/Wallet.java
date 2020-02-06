import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class to mimic a wallet that holds Card objects
 *
 * @author jcehng3 & eemilyshih
 * @version 4 February 2020
 */
public class Wallet
{
    private ArrayList<Card> cards;

    public Wallet()
    {
        this.cards = new ArrayList<Card>();
    }

    public void addCard(Card q)
    {
        cards.add(q);
        if (cards.get(0) != q)
        {
            if(cards.get(1) != q) 
            {
                cards.remove(3); 
            }
        }
    }

    public int getExpiredCardCount()
    {
        int count = 0;
        for(Card c : cards)
        {
            if( c.isExpired() )
            {
                count++;
            }
        }
        return count;
    }

    public String toString()
    {        
        String wallet = new String();
        for( Card c : cards )
        {
            wallet += c.toString() + " | ";
        }
        return wallet;
    }
}