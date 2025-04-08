import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

public class Menu extends javax.swing.JPanel{
    public static final String CARD_NAME = "Start";

    public Menu() {
        setFocusable(true);
        setPreferredSize(new Dimension(1200, 850));
        //Title

        JLabel title = new JLabel("Sim-City");
        title.setFont(new Font("Arial", Font.BOLD, 48));
        title.setForeground(Color.BLACK); // Optional: text color
        add(title);

        //add a button for start
        JButton startButton = new JButton("Start"); 
        add(startButton);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // start the game
                Frame.switchToCard("Game");
            }
        });

        startButton.setPreferredSize(new Dimension(400, 100)); // Set size
        startButton.setFont(new Font("Arial", Font.BOLD, 25)); // Set font
        startButton.setBackground(Color.BLACK); // Set background color

        //add button for instruction

        JButton instructionButton = new JButton("Instructions"); 
        add(instructionButton);

        instructionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // change to the instructions panel
                System.out.println("Button clicked!");
            }
        });

        instructionButton.setPreferredSize(new Dimension(400, 100)); // Set size
        instructionButton.setFont(new Font("Arial", Font.BOLD, 25)); // Set font
        instructionButton.setBackground(Color.BLACK); // Set background color
    }
    
}
