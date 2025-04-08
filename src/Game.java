import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game {

    final static Color TEA_ROSE = new Color(229, 194, 192);
    final static Color CELADON = new Color(143, 213, 166);
    final static Color SHAMROCK_GREEN = new Color(50, 159, 91);
    final static Color SEA_GREEN = new Color(12, 131, 70);
    final static Color CARRIBEAN_CURRENT = new Color(13, 93, 86);

    //basic stats
    private int pollution = 0;
    private int powerSupply = 10;
    private int powerUsage = 0;
    private int happiness = 100;
    private int population = 100;


    private int extraPowerSupply = 0;
    private int extraPowerUsage = 0;
    private int extraPollution = 0;
    private int extraHappiness = 0;
    private int extraPopulation = 0;


    
    private GamePanel gamePanel;
    private StatusPanel statusPanel;
    private JFrame frame;
    private Timer simulationTimer;
    private int tickCounter = 0;
    private EventManager eventManager;
    private ArrayList<Event> pastEvents;
    private String eventAlert;


    public Game() {
        //panel set up
        gamePanel = new GamePanel(this);
        statusPanel = new StatusPanel(this); 
        eventManager = new EventManager();
        pastEvents = new ArrayList<Event>();
        eventAlert = "";
        frame = new JFrame("Eco Architect");

        // create a wrapper to better center stuff and control where things are
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BorderLayout());
        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setBackground(SHAMROCK_GREEN); 
        centerWrapper.setPreferredSize(new Dimension(700, 850));
        centerWrapper.add(gamePanel); // Centered in the GridBagLayout
        wrapper.add(centerWrapper, BorderLayout.CENTER);
        JPanel eastWrapper = new JPanel(new BorderLayout());
        eastWrapper.setPreferredSize(new Dimension(350, 850));
        eastWrapper.add(statusPanel, BorderLayout.CENTER);
        wrapper.add(eastWrapper, BorderLayout.EAST);
        

        frame.add(wrapper);

        //default settings for frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // frame.add(gamePanel);
        // frame.add(statusPanel);
        frame.setSize(new Dimension(1200, 850));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Delay ensures focus works
        SwingUtilities.invokeLater(() -> gamePanel.requestFocusInWindow());

        //start the simulation
        startSimulationLoop();
    }

    private void startSimulationLoop() {
                                        //1 sec
        simulationTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tickCounter++; //records seconds passed
                
                updateStatsFromGrid();
                updatePopulationFluctuation();
                if (tickCounter % 10 == 0) { // Every 10 seconds
                    pastEvents.add(eventManager.triggerRandomEvent(Game.this));
                    eventAlert = pastEvents.getLast().getAlert();
                }
                
                gamePanel.repaint(); 
                statusPanel.repaint();
                checkGameOver();
            }
        });
        simulationTimer.start();
    }

    private void updateStatsFromGrid() {
        // Reset all stats
        pollution = 0;
        powerSupply = 10;
        powerUsage = 0;
        happiness = 100;
        population = 100;

        // Loop over all tiles and apply their effects
        Tile[][] grid = gamePanel.getGridManager().getGrid();
        for (Tile[] row : grid) {
            for (Tile tile : row) {
                tile.affectGame(this);
            }
        }
        
        pollution += extraPollution;
        powerSupply += extraPowerSupply;
        powerUsage += extraPowerUsage;
        happiness += extraHappiness;
        population += extraPopulation;
       

        // Clamp values to 0–100
        pollution = Math.min(pollution, 100);
        happiness = Math.max(0, Math.min(happiness, 100));
    }

    private void updatePopulationFluctuation(){

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

    public void addExtraPollution(int amount) { extraPollution += amount; }
    public void addExtraPowerSupply(int amount) { extraPowerSupply += amount; }
    public void addExtraPowerUsage(int amount) { extraPowerUsage += amount; }
    public void changeExtraHappiness(int delta) { extraHappiness += delta; }
    public void addExtraPopulation(int amount) { extraPopulation += amount; }

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

    public int getTickCounter() {
        return tickCounter;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public String getEventAlert() {
        return eventAlert;
    }

    
}
