package controller;

import model.Hand;
import model.Result;

public interface BlackJackUserInterface
{
   public void chooseHitOrStand();
   public void endUserActions();
   public void showHand(Hand hand, boolean isDealer);
   public void peekHand(Hand hand);
   public boolean askToPlayAgain(Result result);
   public void reset();
}
