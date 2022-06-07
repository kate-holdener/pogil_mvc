package controller;

import model.*;

public class BlackJackController
{
   protected Dealer dealer;
   protected Player player;
   protected Deck   deck;
   protected BlackJackUserInterface userInterface;

   public BlackJackController(Dealer dealer, Player player, Deck deck, BlackJackUserInterface ui)
   {
      this.dealer = dealer;
      this.player = player;
      this.deck = deck;
      this.userInterface = ui;
   }

   /**
    * Modified version of UseCases.startNewGame method
    */
   public void startNewGame()
   {
      userInterface.reset();
      player.getHand().clear();
      dealer.getHand().clear();

      deck.shuffle();
      for (int i = 0; i < 2; i++)
      {
        deck.dealOneCard(player);
        deck.dealOneCard(dealer);
      }

      userInterface.showHand(player.getHand(), false);
      userInterface.peekHand(dealer.getHand());

      // only ask the player to hit or stand if the player's
      // hand is less than 21
      if (player.getHand().getValue() < 21)
      {
         userInterface.chooseHitOrStand();
      }
      else
      {
         onStand();
      }
   }
 
   /**
    * Modified version of UseCases.onHit method
    */
   public void onHit()
   {
      boolean hit = false;
      deck.dealOneCard(player);
      userInterface.showHand(player.getHand(), false);

      if (player.getHand().getValue() >= 21)
      {
         userInterface.endUserActions();
         onStand();
      }
      else
      {
         userInterface.chooseHitOrStand();
      }
   }

   /**
    * Modified version of UseCases.onStand method
    */
   public void onStand()
   {
      userInterface.endUserActions();

      if (!player.getHand().isBust())
      {
         dealer.play(deck);
      }
      userInterface.showHand(player.getHand(), false);
      userInterface.showHand(dealer.getHand(), true);
      onFinish();
   }

   /**
    * This used to be in the driver. New functionality:
    * ask the uer to play again.
    */
   public void onFinish()
   {
      // Determine the game result and announce the winner
      Result r = Rules.compareHands(player.getHand(), dealer.getHand());
      boolean playAgain = userInterface.askToPlayAgain(r);
      if (playAgain)
      {
         startNewGame();
      }
   }
}
