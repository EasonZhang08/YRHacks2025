import java.awt.Dimension;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Build the Future");
            GamePanel gamePanel = new GamePanel();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setSize(new Dimension(1100, 875));
            frame.add(gamePanel);
            gamePanel.setFocusable(true);
            //frame.pack(); // Auto-size based on panel
            frame.setLocationRelativeTo(null); // Center on screen
            frame.setVisible(true);
        });
    }
}
