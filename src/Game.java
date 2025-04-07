import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    private int pollution = 0;
    private int powerSupply = 0;
    private int powerUsage = 0;
    private int happiness = 100;
    private int population = 0;

    private GamePanel gamePanel;
    private StatusPanel statusPanel;
    private JFrame frame;
    private Timer simulationTimer;

    public Game() {
        gamePanel = new GamePanel(this);
        statusPanel = new StatusPanel(this); 
        frame = new JFrame("Eco Architect");

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BorderLayout());
        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setBackground(Color.gray); 
        centerWrapper.setPreferredSize(new Dimension(700, 850));
        centerWrapper.add(gamePanel); // Centered in the GridBagLayout
        wrapper.add(centerWrapper, BorderLayout.CENTER);
        JPanel eastWrapper = new JPanel(new BorderLayout());
        eastWrapper.setPreferredSize(new Dimension(350, 850));
        eastWrapper.add(statusPanel, BorderLayout.CENTER);
        wrapper.add(eastWrapper, BorderLayout.EAST);
        

        frame.add(wrapper);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // frame.add(gamePanel);
        // frame.add(statusPanel);
        frame.setSize(new Dimension(1200, 850));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Delay ensures focus works
        SwingUtilities.invokeLater(() -> gamePanel.requestFocusInWindow());

        startSimulationLoop();
    }

    private void startSimulationLoop() {
        simulationTimer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStatsFromGrid();
                System.out.println(pollution);
                System.out.println(powerSupply);
                System.out.println(powerUsage);
                System.out.println(happiness);
                System.out.println(population);
                checkGameOver();
                gamePanel.repaint(); 
                statusPanel.repaint();
            }
        });
        simulationTimer.start();
    }

    private void updateStatsFromGrid() {
        // Reset all stats
        pollution = 0;
        powerSupply = 0;
        powerUsage = 0;
        happiness = 100;
        population = 0;

        // Loop over all tiles and apply their effects
        Tile[][] grid = gamePanel.getGridManager().getGrid();
        for (Tile[] row : grid) {
            for (Tile tile : row) {
                tile.affectGame(this);
            }
        }

        // Clamp values to 0–100
        pollution = Math.min(pollution, 100);
        happiness = Math.max(0, Math.min(happiness, 100));
    }

    

    private void checkGameOver() {
        if (pollution >= 100 || happiness <= 0 || powerUsage > powerSupply) {
            simulationTimer.stop();
            JOptionPane.showMessageDialog(frame, "Game Over!");
        }
    }






    // Getters and setters
    public void addPollution(int amount) { pollution += amount; }
    public void reducePollution(int amount) { pollution = Math.max(0, pollution - amount); }
    public void addPowerSupply(int amount) { powerSupply += amount; }
    public void addPowerUsage(int amount) { powerUsage += amount; }
    public void changeHappiness(int delta) { happiness += delta; }
    public void addPopulation(int amount) { population += amount; }

    public int getPollution() { return pollution; }
    public int getPowerSupply() { return powerSupply; }
    public int getPowerUsage() { return powerUsage; }
    public int getHappiness() { return happiness; }
    public int getPopulation() { return population; }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public StatusPanel getStatusPanel() {
        return statusPanel;
    }

    public void setStatusPanel(StatusPanel statusPanel) {
        this.statusPanel = statusPanel;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Timer getSimulationTimer() {
        return simulationTimer;
    }

    public void setSimulationTimer(Timer simulationTimer) {
        this.simulationTimer = simulationTimer;
    }

    
}
