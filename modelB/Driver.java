import model.*;
import view.*;
import controller.*;

import java.awt.event.*;

public class Driver
{
    public static void main(String []args)
    {
        // Objects from our original version of the game
        Deck deck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer();

        // Graphical User Interface object
        BlackJackTable gameTable = new BlackJackTable();

        // BlackJackController now handles the use cases
        BlackJackController gameController = new BlackJackController(dealer, player, deck, gameTable);

        // Connect the "hit" button with BlackJackController.onHit()
        gameTable.setOnHit(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
              gameController.onHit();
           }
        });
        
        // Connect the "stand" button with BlackJackController.onStand()
        gameTable.setOnStand(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
              gameController.onStand();
           }
        });

        // Start the game. 
        gameController.startNewGame();

    }
}
