import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Frame extends javax.swing.JFrame{
    private static CardLayout cl;
    private static javax.swing.JPanel cardPanel;
    private Game g;
    private Menu start;

    public Frame(){
        //frame = new JFrame("Eco Architect");


        start = new Menu();

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
        switchToCard(start.CARD_NAME);
    }

    private void addPanels() {
        cardPanel.add(g.getWrapper(), Game.CARD_NAME);
        cardPanel.add(start, Menu.CARD_NAME);
    }

    public static void switchToCard(String cardName) {
        cl.show(cardPanel, cardName);       
    }

    
}
