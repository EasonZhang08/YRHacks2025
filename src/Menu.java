import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Menu extends javax.swing.JPanel{
    public static final String CARD_NAME = "Start";

    public Menu(Frame f) {
        setFocusable(true);
        setPreferredSize(new Dimension(1200, 850));
        // setBackground(Game.TEA_ROSE);
        

        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 20, 0); // top, left, bottom, right
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // JPanel contentPanel = new JPanel();
        // contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        // contentPanel.setOpaque(false); // let outer background show


        //Title

        JLabel title = new JLabel("Eco Architect");
        title.setFont(new Font("Arial", Font.BOLD, 70));
        title.setForeground(Game.SHAMROCK_GREEN); // Optional: text color
        title.setBackground(Color.WHITE);
        title.setOpaque(true);
        gbc.gridy = 0;
        add(title, gbc);
        

        //add a button for start
        JButton startButton = new JButton("Start"); 
        styleButton(startButton);
        gbc.gridy = 1;
        add(startButton, gbc);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // start the game
                f.switchToCard("Game");
                //start the simulation
                f.getG().startSimulationLoop();
            }
        });

        startButton.setPreferredSize(new Dimension(400, 100)); // Set size
        startButton.setFont(new Font("Arial", Font.BOLD, 25)); // Set font
        startButton.setBackground(Color.BLACK); // Set background color

        //add button for instruction

        JButton instructionButton = new JButton("Instructions"); 
        styleButton(instructionButton);
        gbc.gridy = 2;
        add(instructionButton, gbc);

        instructionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // change to the instructions panel
                f.switchToCard("Instruction");
            }
        });

        instructionButton.setPreferredSize(new Dimension(400, 100)); // Set size
        instructionButton.setFont(new Font("Arial", Font.BOLD, 25)); // Set font
        instructionButton.setBackground(Color.BLACK); // Set background color
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image, scaled to fit
        //g.fillRect(0, 0, 1200, 850);
        g.drawImage(SpriteLoader.load("menu"), 0, 0, 1200, 850, null);
    }

    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(400, 80));
        button.setFont(new Font("Arial", Font.BOLD, 24));
        //button.setBackground(Game.SHAMROCK_GREEN); // SHAMROCK_GREEN
        button.setForeground(Game.SHAMROCK_GREEN);
        button.setFocusPainted(false);
        button.setBorderPainted(true);
    }
    
}
