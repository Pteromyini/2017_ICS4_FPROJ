// The "DeckClass" class.
import java.awt.*;
import hsa.Console;
import java.util.*;                                         // Vector class is in the 'util'  package

public class DeckClass extends ShapeClass                   // This is a Deck class.
{
    private Vector deck;                                    // Instansiate a vector with a size of 0 and grows by 1.


    public DeckClass ()                                     // This is the default constructor which initilizes the encapsulated data with default values;
    {
	super ();
	deck = new Vector (0, 1);
    }


    public DeckClass (char deckType)                        // This is an overloaded constructor.
    {
	super ();
	deck = new Vector (0, 1);

	if (deckType == 's')                                // If the type of deck is a standard deck of 52 cards, then add 52 cards to the deck.
	{
	    deck.setSize (52);

	    for (int suitValue = 1 ; suitValue < 5 ; suitValue++)
	    {
		for (int rankValue = 1 ; rankValue < 14 ; rankValue++)
		{
		    deck.addCard (rankValue, CardClass card = new CardClass (0, 1, rankValue, suitValue));
		}
	    }
	}
    }


    public void addCard (int givenPos, CardClass aCardToAdd)      // This is a method to add a card.
    {
	deck.add (givenPos, aCardToAdd);
    }


    public void removeCard (int givenPos, CardClass aCardToAdd)      // This is a method to remove a card.
    {
	deck.remove (givenPos, aCardToAdd);
    }


    public CardClass dealCard (int givenPos)                     // This is a method to deal a card out.
    {
	return (CardClass) deck.remove (givenPos);                      // must type cast element
    }


    public void shuffleDeck ()                              // This is a method to shuffle the deck
    {
    }
} // DeckClass class

