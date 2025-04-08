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
import javax.swing.JTextArea;

public class InstructionScreen extends javax.swing.JPanel{
    public static final String CARD_NAME = "Instruction";

    public InstructionScreen(Frame f) {
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
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(title, gbc);

        JTextArea instructionText = new JTextArea(
        "🎯 Objective:\n" +
        "Build a sustainable city by balancing pollution, power, happiness, and population.\n\n" +
        "🛠 How to Play:\n" +
        "- Click on tiles to place buildings, parks, roads, and power sources.\n" +
        "- Each tile affects your city, use #1 - 5 to select:\n" +
        "    🏢 Buildings: pollution + 10, population + 10, power usage + 5, cost: 100000\n" +
        "    🌳 Parks: pollution - 10, power usage + 2, happiness + 3, cost: 50000\n" +
        "    ⚡ Fossil Power: pollution + 20, power supply + 20, cost: 100000\n" +
        "    ⚡ Solar Power: pollution + 2, power supply + 10, cost: 200000\n" +
        "    🍟 Restaurant: pollution + 10, power usage + 5, cost: 100000\n\n" +
        "💥 Random Events:\n" +
        "Every 10 seconds, a random event changes your city's stats.\n\n" +
        "☠️ Game Over:\n" +
        "Happens if pollution reaches 100, happiness drops to 0, population goes negative, or power usage exceeds supply.\n\n" +
        "🏆 Win:\n" +
        "Gain 200 population without dying!"
    );
    instructionText.setEditable(false);
    instructionText.setOpaque(true);
    instructionText.setForeground(Color.BLACK);
    instructionText.setFont(new Font("Arial", Font.PLAIN, 18));
    instructionText.setLineWrap(true);
    instructionText.setMargin(new Insets(15, 20, 15, 20)); // top, left, bottom, right
    instructionText.setWrapStyleWord(true);
    instructionText.setPreferredSize(new Dimension(900, 500));
    

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    add(instructionText, gbc);

        

        //add a button for start
        JButton startButton = new JButton("Start"); 
        styleButton(startButton);
        gbc.gridx = 2;
        gbc.gridy = 2;
        add(startButton, gbc);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // start the game
                f.switchToCard("Game");
                //start the simulation
                f.getG().startSimulationLoop();
            }
        });

        startButton.setPreferredSize(new Dimension(250, 100)); // Set size
        startButton.setFont(new Font("Arial", Font.BOLD, 25)); // Set font
        startButton.setBackground(Color.BLACK); // Set background color

        //add button for instruction

        JButton backButton = new JButton("Back"); 
        styleButton(backButton);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(backButton, gbc);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // change to the instructions panel
                f.switchToCard("Start");
            }
        });

        backButton.setPreferredSize(new Dimension(250, 100)); // Set size
        backButton.setFont(new Font("Arial", Font.BOLD, 25)); // Set font
        backButton.setBackground(Color.BLACK); // Set background color
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
