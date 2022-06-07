package model;

public class Card
{
   public enum Suite {CLUBS, DIAMONDS, HEARTS, SPADES}
   public enum Face  {
       TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), 
       NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
  
       private final int value;
       Face(int v)
       {
           this.value = v;
       }
       public int getValue()
       {
           return this.value;
       }
   }


   Face value;
   Suite suite;

   public Card(Face value, Suite suite)
   {
       this.value = value;
       this.suite = suite;
   }

   /**
    * Retrieve the face value of this card
    * @return the face value of the card
    */
   public Face getFace()
   {
       return value;
   }

   /**
    * Retrieve the suite of this card
    * @return the suite of this card
    */
   public Suite getSuite()
   {
       return suite;
   }

   @Override
   public String toString()
   {
       String result = value.toString() +" of " +suite.toString();
       return result;
   }
}
