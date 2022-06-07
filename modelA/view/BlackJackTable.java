package view;

import model.*;
import controller.BlackJackUserInterface;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class BlackJackTable implements BlackJackUserInterface
{
    public static int frameSize = 400;

    private HandPanel dealerHand;
    private HandPanel userHand;
    private JButton   hit;
    private JButton   stand;
    private JFrame    mainFrame;

    public BlackJackTable()
    {
        // top level container for the game
        mainFrame = new JFrame("Black Jack");
        mainFrame.setPreferredSize(new Dimension(frameSize, frameSize*3/2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // top level panel representing our card table
        JPanel cardTable = new JPanel();
        cardTable.setLayout(new BoxLayout(cardTable, BoxLayout.Y_AXIS));

        // panel to show dealer's hand
        this.dealerHand = new HandPanel("DEALER", frameSize);

        // panel to show user's hand
        this.userHand = new HandPanel("YOU", frameSize);
        //userHand.add(new Card(12, Card.Suite.SPADES), true);


        // place dealer's and user's hands on the card table
        cardTable.add(this.dealerHand);
        cardTable.add(this.userHand);

        
        // panel for buttons
        JPanel controlPanel = new JPanel();
        hit = new JButton("Hit");
        stand = new JButton("Stand");
        controlPanel.add(hit);
        controlPanel.add(stand);
        cardTable.add(controlPanel);


        mainFrame.add(cardTable);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }


    public void peekHand(Hand hand)
    {
       Iterator<Card> handIter = hand.iterator();
       if (handIter.hasNext())
       {
          Card c = handIter.next();
          dealerHand.add(c, true);
          dealerHand.add(c, false);
       }
    }
    public void showHand(Hand hand, boolean isDealer)
    {
        HandPanel panel = isDealer ? dealerHand: userHand;
        panel.clearCards();
        for (Card c: hand)
        {
            panel.add(c, true);
        }
    }

    public void setOnHit(ActionListener l)
    {
        hit.addActionListener(l);
    }
    public void setOnStand(ActionListener l)
    {
        stand.addActionListener(l);
    }

    public void reset()
    {
        dealerHand.clearCards();
        userHand.clearCards();
    }

    public void chooseHitOrStand()
    {
        hit.setEnabled(true);
        stand.setEnabled(true);
    }

    public void endUserActions()
    {
        hit.setEnabled(false);
        stand.setEnabled(false);
    }

    public boolean askToPlayAgain(Result r)
    {
        int choice = JOptionPane.showConfirmDialog(mainFrame, "You "+r+". Play again?", "Results", JOptionPane.YES_NO_OPTION);
        return choice == JOptionPane.YES_OPTION;
    }
}
