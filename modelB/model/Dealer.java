package model;
public class Dealer extends Player
{
   public void play(Deck deck)
   {
      while (this.getHand().getValue() < 17)
      {
         deck.dealOneCard(this);
      }
   }
}
