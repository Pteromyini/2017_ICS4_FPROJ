// The "CardClass" class.
import java.awt.*;
import hsa.Console;

public class CardClass extends ShapeClass                                                           // CardClass inherits ShapeClass
{
    private int cardFaceUp;                                                                             // Initialize encapsulated data, with no values, for this class.
    private int cardSize;                                                                           //
    private int cardRankValue;                                                                          //
    private int cardSuit;                                                                           //

    public CardClass ()                                                                             // This is the default constructor that initializes the encapsulated data with values.
    {
	cardFaceUp = 1;
	cardSize = 1;
	cardRankValue = 1;
	cardSuit = 1;
	setHeight (60);
	setWidth ((int) (getHeight () * 0.7));
    }


    public CardClass (int newFaceUpOrDown)                                                          // This is another constructor.
    {
	setCardFaceUpOrDown (newFaceUpOrDown);

	cardSize = 1;
	cardRankValue = 1;
	cardSuit = 1;

	setHeight (60);
	setWidth ((int) (getHeight () * 0.7));
    }


    public CardClass (int newFaceUpOrDown, int newCardSize, int newCardRankValue, int newCardSuit)      // This is another constructor that sets the encapsulated data with values.
    {
	setCardFaceUpOrDown (newFaceUpOrDown);
	setCardSize (newCardSize);
	setCardRankValue (newCardRankValue);
	setCardSuit (newCardSuit);
	setHeight (60);
	setWidth ((int) (getHeight () * 0.7));
    }


    public CardClass (int newCardSize, int newCardRankValue, int newCardSuit)                           // This is another constructor that sets the encapsulated data with values.
    {
	setCardFaceUpOrDown (1);
	setCardSize (newCardSize);
	setCardRankValue (newCardRankValue);
	setCardSuit (newCardSuit);
	setHeight (60);
	setWidth ((int) (getHeight () * 0.7));
    }


    public void setCardFaceUpOrDown (int newFaceUpOrDown)                                               // This is a "set" method to set the card to be faced up or down.
    {
	if (newFaceUpOrDown == 1)
	{
	    cardFaceUp = 1;
	}
	else                                                                                        // Just set the card size to 1.
	{
	    cardFaceUp = 0;
	}
    }


    public int getCardFaceUpOrDown ()                                                                   // This is a "get" method to return if the card is faced up or down.
    {
	return cardFaceUp;
    }


    public void setCardSize (int newCardSize)                                                       // This is a "set" method to set the size of the card.
    {
	if (newCardSize >= 1 && newCardSize <= 4)
	{
	    cardSize = newCardSize;
	}
	else                                                                                        // Just set the card size to 1.
	{
	    cardSize = 1;
	}
    }


    public int getCardSize ()                                                                       // This is a "get" method to return the size of the card.
    {
	return cardSize;
    }


    public void setCardRankValue (int newCardRankValue)                                                     // This is a "set" method to set the value of the card.
    {
	if (newCardRankValue >= 1 && newCardRankValue <= 13)
	{
	    cardRankValue = newCardRankValue;
	}
	else                                                                                        // Just set the card value to 1.
	{
	    cardRankValue = 1;
	}
    }


    public int getCardRankValue ()                                                                      // This is a "get" method to return the value of the card.
    {
	return cardRankValue;
    }


    public void setCardSuit (int newCardSuit)                                                       // This is a "set" method to set the suit of the card.
    {
	if (newCardSuit >= 1 && newCardSuit <= 4)                                                   // This validates the data to see if I am allowed to changed the suit value of the card.
	{
	    cardSuit = newCardSuit;
	}
	else                                                                                        // Just set the card suit to 1.
	{
	    cardSuit = 1;
	}
    }


    public int getCardSuit ()                                                                       // This is a "get" method to return the suit value of the card.

    {
	return cardSuit;
    }


    public void resizeCard ()                                                                       // This is a method to set the height and width of the card, depending on the variable cardSize.
    {
	if (cardSize == 1)                                                                          // If the value of the variable cardSize is 1, then set the height of the variable card to 60.
	{
	    setHeight (60);
	}
	else if (cardSize == 2)                                                                     // If the value of the variable cardSize is 2, then set the height of the variable card to 80.
	{
	    setHeight (80);
	}
	else if (cardSize == 3)                                                                     // If the value of the variable cardSize is 3, then set the height of the variable card to 100.
	{
	    setHeight (100);
	}
	else if (cardSize == 4)                                                                     // If the value of the variable cardSize is 4, then set the height of the variable card to 120.
	{
	    setHeight (120);
	}
	setWidth ((int) (getHeight () * 0.7));                                                      // Set the width of the card to the height of the card multiplied by 0.7 and convert the result to an integer value.
    }


    public void drawCard (Console c)                                                                // This is a "draw" method to draw a card, either the outline of the card.
    {
	resizeCard ();

	int x1 = getCentreX () - (getWidth () / 2);                                                 // Create the x and y points to calculate the corners of the card.
	int y1 = getCentreY () - (getHeight () / 2);

	c.setColour (getColour ());                                                                 // Set the colour of the card by "getting" the colour from its super class.

	if (cardSuit >= 1 && cardSuit <= 4)                                                         // If the suit value of the card is between 1 and 4 (inclusive), then draw a rectangle by using the declared variables above, and set the card to be faced up.
	{
	    cardFaceUp = 1;
	    c.drawRect (x1, y1, getWidth (), getHeight ());
	}
	else if (cardSuit == 0)                                                                     // If the suit value of the card is 0, then draw a filled rectangle by using the declared variables above, and set the card to be faced down.
	{
	    cardFaceUp = 0;
	    c.fillRect (x1, y1, getWidth (), getHeight ());
	}
    }


    public int resizeText ()                                                                        // This is a method to return the value of the text of the card value.
    {
	if (cardSize == 1 || cardSize == 2)                                                         // If the value of the variable cardSize is 1 or 2 , then return 15.
	{
	    return 15;
	}
	else if (cardSize == 3 || cardSize == 4)                                                    // If the value of the variable cardSize is 3 or 4, then return 20.
	{
	    return 20;
	}
	else                                                                                        // Just return 15.
	{
	    return 15;
	}
    }


    public void drawText (Console c)                                                                // This is a method to draw the text of the card value.
    {
	Font f1 = new Font ("SanSerif", Font.PLAIN, resizeText ());                                 // Instansiate the Font Class and
	c.setFont (f1);                                                                             // Set the font.
	int xPosOfText = (int) (getCentreX () - (getWidth () / 2) + 2);                             // Create the positions of the text of the card value.
	int yPosOfText = (int) (getCentreY () - (getHeight () / 2) + 15);                           //
	c.drawString (Integer.toString (cardRankValue), xPosOfText, yPosOfText);
    }


    public void drawSuit (Console c)
    {
	int suitWidth = (int) (getHeight () * 0.25);                                            // Create the required variables to draw a card.
	int suitHeight = (int) (getHeight () * 0.25);                                           //
	int suitCX = getCentreX () + (getWidth () / 4);                                         //
	int suitCY = getCentreY () - (getHeight () / 2) + (suitWidth / 2);                      //
	Color suitColour = getColour ();                                                        //
	boolean suitIsFilled = getFilled ();                                                    //

	if (cardSuit == 1 || cardSuit == 3)                                                     // This checks to see if I can change the suit colour of the card, and this applies to the suit colours of a diamond (1) and a heart (3).
	{
	    if (suitColour != Color.white)                                                      // This checks to see if the suit is being drawn, and if it's being drawn, then change the colour of the suit.
	    {
		suitColour = Color.red;
	    }
	}

	if (cardSuit == 1)                                                                      // If the value of the variable cardSuit is 1, then draw a diamond object (diamond suit).
	{
	    DiamondClass diamondObject = new DiamondClass (suitCX, suitCY, suitWidth, suitHeight, suitColour, suitIsFilled);
	    diamondObject.draw (c);
	}
	else if (cardSuit == 2)                                                                 // If the value of the variable cardSuit is 2, then draw a club object (club suit).
	{
	    ClubClass clubObject = new ClubClass (suitCX, suitCY, suitWidth, suitHeight, suitColour, suitIsFilled);
	    clubObject.draw (c);
	}
	else if (cardSuit == 3)                                                                 // If the value of the variable cardSuit is 3, then draw a heart object (heart suit).
	{
	    HeartClass heartObject = new HeartClass (suitCX, suitCY, suitWidth, suitHeight, suitColour, suitIsFilled);
	    heartObject.draw (c);
	}
	else if (cardSuit == 4)                                                                 // If the value of the variable cardSuit is 4, then draw a spade object (spade suit)
	{
	    SpadeClass spadeObject = new SpadeClass (suitCX, suitCY, suitWidth, suitHeight, suitColour, suitIsFilled);
	    spadeObject.draw (c);
	}
    }


    public void draw (Console c)                                                                    // This is a "draw" method to draw the entire card which contains the outline, value, and suit of the card.
    {
	drawCard (c);                                                                               // Draw the outline of the card.
	if (cardFaceUp == 1)                                                                            // Draw the rest of card value and the suit if the card value is not zero.
	{
	    drawText (c);
	    drawSuit (c);
	}
    }


    public void draw (Graphics g)                                                                   // This is an overloaded draw method.
    {
    }
} // CardClass class


