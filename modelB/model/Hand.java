package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Hand implements Iterable<Card>
{
   private ArrayList<Card> cards;
   public Hand()
   {
       cards = new ArrayList<Card>();
   }

   public Iterator<Card> iterator()
   {
      return cards.iterator();
   }

   /**
    * Adds the given card to the hand
    * @param c the card to be added to the hand
    **/
   public void add(Card c)
   {
       cards.add(c);
   }

   /**
    * Prints the hand value to the terminal
    */
   public void show()
   {
       for (Card c: cards)
       {
           System.out.println(c);
       }
   }
  
   /**
    * Determines the value of the hand
    * @return the total numeric value of the hand
    */
   public int getValue()
   {
       int value = 0;
       int numAces = 0;
       for (Card c: cards)
       {
           if (c.getFace() == Card.Face.ACE)
           {
              value+=11;
              numAces++;
           }
           else if (c.getFace().getValue() >= 10)
           {
              value+=10;
           }
           else
           {
              value+=c.getFace().getValue();
           }
       }

       // if the value is over 21 and we have ACEs
       // subtract 10 from the value for each ACE
       // until we get to 21 or lower
       while (value > 21 && numAces > 0)
       {
          value-=10;
          numAces--;
       }
       return value;
   }

   /**
    * Determines if the hand is bust (over 21)
    * @return true if the hand is bust, false otherwise
    */
   public boolean isBust()
   {
       boolean bust = false;
       int value = this.getValue();
       if (value > 21)
       {
           bust = true;
       }
       return bust;
   }

   /**
    * Determines if the hand is a black jack
    * @return true if the hand is a blackjack, false otherwise
    */
   public boolean isBlackJack()
   {
       boolean result = false;
       if (cards.size() == 2)
       {
           boolean foundAce = false;
           boolean foundTen = false;
           for (Card c: cards)
           {
               if (c.getFace() == Card.Face.ACE)
               {
                   foundAce = true;
               }

               else if (c.getFace().getValue() >= 10)
               {
                   foundTen = true;
               }
           }
           if (foundAce && foundTen)
           {
               result = true;
           }

       }
       return result;
   }

   /**
    * Prints all cards to the terminal
    */
   public void reveal()
   {
       for (Card c: cards)
       {
          System.out.println(c);
       }
   }

   /**
    * Empties the hand
    */
   public void clear()
   {
      cards.clear();
   }
   /**
    * Prints one card to the terminal
    */
   public void showOne()
   {
       System.out.println(cards.get(0));
   }
}
