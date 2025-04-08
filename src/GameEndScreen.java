import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;

public class GameEndScreen extends javax.swing.JPanel{
    public static final String CARD_NAME = "End";
    public static JLabel reason = new JLabel("You lost to __");
    public static JLabel status = new JLabel("You Win!");
    private Frame f;

    public GameEndScreen(Frame f) {
        this.f = f;
        setFocusable(true);
        setPreferredSize(new Dimension(1200, 850));
        
        
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 20, 0); // top, left, bottom, right
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        
        


        status.setFont(new Font("Arial", Font.BOLD, 48));
        status.setForeground(Game.SHAMROCK_GREEN); // Optional: text color
        status.setBackground(Color.white);
        status.setOpaque(true);
        add(status, gbc);

        
        System.out.println(f.getGameOverReason());
        reason.setFont(new Font("Arial", Font.BOLD, 48));
        reason.setForeground(Game.SHAMROCK_GREEN); // Optional: text color
        reason.setBackground(Color.white);
        reason.setOpaque(true);
        add(reason, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image, scaled to fit
        //g.fillRect(0, 0, 1200, 850);
        g.drawImage(SpriteLoader.load("menu"), 0, 0, 1200, 850, null);
    }

    // public void reasonForGameOver(String textReason){
    //     reason = new JLabel(textReason);
    // }
    // //getters and setters
    // public void changeReason(String textReason) { reason = textReason; }

    // public int getReason() { return reason; }
}
