// The "DeckClass" class.
import java.awt.*;
import hsa.Console;
import java.util.*;                                         // Vector class is in the 'util'  package

public class DeckClass extends ShapeClass                   // This is a Deck class.
{
    private Vector deck;                                    // Instansiate a vector.


    public DeckClass ()                                     // This is the default constructor which initilizes the encapsulated data with default values;
    {
	super ();
	deck = new Vector (0, 1);
    }


    public DeckClass (char deckType)                        // This is an overloaded constructor.
    {
	super ();

	if (deckType == 's')                                // If the type of deck is a standard deck of 52 cards, then add 52 cards to the deck.
	{
	    deck = new Vector (0, 1);

	    for (int suitValue = 1 ; suitValue < 5 ; suitValue++)
	    {
		for (int rankValue = 1 ; rankValue < 14 ; rankValue++)
		{
		    CardClass card = new CardClass (1, 1, rankValue, suitValue);
		    addCard (card);
		}
	    }
	}
	else if (deckType == 'p')
	{
	    deck = new Vector (5, 0);

	    for (int i = 0 ; i < 5 ; i++)
	    {
		int randomRankValue = Math.random () * 14;
		int randomSuitValue = Math.random () * 4;
		CardClass card = new CardClass (1, 1, randomRankValue, randomSuitValue);
		addCard (card);
	    }
	}

	shuffleDeck ();
    }


    public boolean isEmpty ()
    {
	return deck.isEmpty ();
    }


    public int cardsRemaining ()
    {
	return deck.size ();
    }


    public void addCard (int givenPos, CardClass aCardToAdd)      // This is a method to add a card.
    {
	deck.add (givenPos, aCardToAdd);
    }


    public void addCard (CardClass aCardToAdd)       // This is a method to add a card.
    {
	deck.add (aCardToAdd);
    }


    public void removeCard ()      // This is a method to remove a card.
    {
	deck.remove (0);
    }


    public void removeCardFromPos (int pos)
    {
	deck.remove (pos);
    }


    public CardClass deal ()
    {
	return (CardClass) (deck.remove (cardsRemaining () - 1));
    }


    public void deleteCard (int cardPos)
    {
	deck.remove (cardPos);
    }


    public boolean isPointInside (int px, int py)
    {
	if ((px >= getCentreX () - (getWidth () / 2)) && (px <= getCentreX () + (getWidth () / 2)))
	{
	    if ((py >= getCentreY () - (getHeight () / 2)) && (py <= getCentreY () + (getHeight () / 2)))
	    {
		return true;
	    }
	    else
	    {
		return false;
	    }
	}
	else
	{
	    return false;
	}

    }


    public void shuffleDeck ()                              // This is a method to shuffle the deck
    {
	for (int shuffleTimes = 0 ; shuffleTimes < deck.size () ; shuffleTimes++)
	{
	    deck.add (0, (CardClass) (deck.remove ((int) (Math.random () * deck.size ()))));
	}
    }


    public CardClass cardAt (int pos)
    {
	if (!isEmpty ())
	{
	    if (pos < cardsRemaining () && pos > -1)
	    {
		return (CardClass) (deck.elementAt (pos));
	    }
	    else
	    {
		return null;
	    }
	}
	else
	{
	    return null;
	}
    }


    public void draw (Console c)
    {
    }


    public void draw (Graphics g)
    {
	if (isEmpty ())
	{
	    g.setColor (Color.black);
	    g.drawRect (getCentreX (), getCentreY (), getHeight (), getWidth ());
	}
	else
	{
	    g.setColor (Color.red);
	    g.fillRect (getCentreX (), getCentreY (), getHeight (), getWidth ());
	}
    }
} // DeckClass class


