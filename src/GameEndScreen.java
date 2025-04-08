import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;

public class GameEndScreen extends javax.swing.JPanel{
    public static final String CARD_NAME = "End";
    public static JLabel reason = new JLabel("You lost to __");
    private Frame f;

    public GameEndScreen(Frame f) {
        this.f = f;
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

        
        System.out.println(f.getGameOverReason());
        reason.setFont(new Font("Arial", Font.BOLD, 48));
        reason.setForeground(Color.BLACK); // Optional: text color
        add(reason);
    }

    // public void reasonForGameOver(String textReason){
    //     reason = new JLabel(textReason);
    // }
    // //getters and setters
    // public void changeReason(String textReason) { reason = textReason; }

    // public int getReason() { return reason; }
}
