import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Frame extends javax.swing.JFrame{
    private CardLayout cl;
    private javax.swing.JPanel cardPanel;
    private Game g;
    private Menu start;
    private GameEndScreen end;
    private String gameOverReason = "";

    public Frame(){
        //frame = new JFrame("Eco Architect");

        g = new Game(this);
        start = new Menu(this);
        end = new GameEndScreen(this);

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

        

        addPanels();  // adds wrapper
        System.out.println(cardPanel);
        addPanels();  // adds wrapper
        System.out.println(cardPanel);
        switchToCard(start.CARD_NAME);
    }

    private void addPanels() {
        cardPanel.add(g.getWrapper(), Game.CARD_NAME);
        cardPanel.add(start, Menu.CARD_NAME);
        cardPanel.add(end, GameEndScreen.CARD_NAME);
    }

    public void switchToCard(String cardName) {
        cl.show(cardPanel, cardName);       
    }

    public CardLayout getCl() {
        return cl;
    }

    public void setCl(CardLayout cl) {
        this.cl = cl;
    }

    public javax.swing.JPanel getCardPanel() {
        return cardPanel;
    }

    public void setCardPanel(javax.swing.JPanel cardPanel) {
        this.cardPanel = cardPanel;
    }

    public Game getG() {
        return g;
    }

    public void setG(Game g) {
        this.g = g;
    }

    public Menu getStart() {
        return start;
    }

    public void setStart(Menu start) {
        this.start = start;
    }

    public GameEndScreen getEnd() {
        return end;
    }

    public void setEnd(GameEndScreen end) {
        this.end = end;
    }

    public String getGameOverReason() {
        return gameOverReason;
    }

    public void setGameOverReason(String gameOverReason) {
        this.gameOverReason = gameOverReason;
    }

    
    
}
