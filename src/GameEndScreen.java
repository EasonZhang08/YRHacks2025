import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GameEndScreen extends javax.swing.JPanel{
    public static final String CARD_NAME = "End";

    public GameEndScreen() {
        setFocusable(true);
        setPreferredSize(new Dimension(1200, 850));
        //Title

        JLabel title = new JLabel("Sim-City");
        title.setFont(new Font("Arial", Font.BOLD, 48));
        title.setForeground(Color.BLACK); // Optional: text color
        add(title);
        
        JLabel status;
        if (true){//if you lose
            status = new JLabel("Game Over!");
        } else {
            status = new JLabel("You Win!");
        }
        status.setFont(new Font("Arial", Font.BOLD, 48));
        status.setForeground(Color.BLACK); // Optional: text color
        add(status);
    }
    
}
