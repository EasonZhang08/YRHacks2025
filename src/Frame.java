import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Frame extends javax.swing.JFrame{
    private CardLayout cl;
    private javax.swing.JPanel cardPanel;
    private Game g;

    public Frame(){
        //frame = new JFrame("Eco Architect");

        g = new Game();

        //default settings for frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(1200, 850));
        setLocationRelativeTo(null);
        setVisible(true);
        

        cardPanel = new JPanel();
        cl = new CardLayout();
        cardPanel.setLayout(cl);
        cardPanel.setPreferredSize(new Dimension(1200, 850));
        add(cardPanel);

        g = new Game();

        addPanels();  // adds wrapper
        System.out.println(cardPanel);
        addPanels();  // adds wrapper
        System.out.println(cardPanel);
        switchToCard(g.CARD_NAME);
    }

    private void addPanels() {
        cardPanel.add(g.getWrapper(), Game.CARD_NAME);
    }

    public void switchToCard(String cardName) {
        cl.show(cardPanel, cardName);       
    }
}
