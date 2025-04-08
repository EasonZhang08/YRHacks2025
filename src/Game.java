import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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

    public static final String CARD_NAME = "Game";

    //basic stats
    private int pollution = 0;
    private int powerSupply = 10;
    private int powerUsage = 0;
    private int happiness = 100;
    private int population = 100;
    private int money = 1000000;


    private int extraPowerSupply = 0;
    private int extraPowerUsage = 0;
    private int extraPollution = 0;
    private int extraHappiness = 0;
    private int extraPopulation = 0;


    
    private GamePanel gamePanel;
    private StatusPanel statusPanel;
    private Timer simulationTimer;
    private int tickCounter = 0;
    private EventManager eventManager;
    private ArrayList<Event> pastEvents;
    private String eventAlert;
    private JPanel wrapper;
    


    public Game() {
        //panel set up
        gamePanel = new GamePanel(this);
        statusPanel = new StatusPanel(this); 
        eventManager = new EventManager();
        pastEvents = new ArrayList<Event>();
        eventAlert = "";
       

        // create a wrapper to better center stuff and control where things are
        wrapper = new JPanel();
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
                if (tickCounter % 2 == 0){ // every 2 seconds
                    updatePopulationFluctuation();
                }  
                updateMoney();             
                if (tickCounter % 10 == 0) { // Every 10 seconds
                    pastEvents.add(eventManager.triggerRandomEvent(Game.this));
                    eventAlert = pastEvents.get(pastEvents.size()-1).getAlert();
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
        money = 1000000;

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

    private void updatePopulationFluctuation() {
        if (happiness >= 85) {
            extraPopulation += 10;
            eventAlert = "📈 Population is growing rapidly!";
        } else if (happiness >= 70) {
            extraPopulation += 5;
            eventAlert = "📈 Population is growing.";
        } else if (happiness <= 19) {
            extraPopulation = Math.max(extraPopulation - 10, -population); // don't go below 0 total
            eventAlert = "📉 Population is leaving the city!";
        } else if (happiness <= 39) {
            extraPopulation = Math.max(extraPopulation - 5, -population);
            eventAlert = "📉 Population is slowly declining.";
        } else {
            // No change
            eventAlert = "";
        }
    
        
    }
    
    private int updateMoney(){
        int profit = tickCounter * population * 500;
        return money + profit;
    }

    private void checkGameOver() {
        if (pollution >= 100 || happiness <= 0 || powerUsage > powerSupply) {
            simulationTimer.stop();
            System.out.println("Game over");
            ///JOptionPane.showMessageDialog(frame, "Game Over!");
        }
    }






    // Getters and setters
    public void addPollution(int amount) { pollution += amount; }
    public void reducePollution(int amount) { pollution = Math.max(0, pollution - amount); }
    public void addPowerSupply(int amount) { powerSupply += amount; }
    public void addPowerUsage(int amount) { powerUsage += amount; }
    public void changeHappiness(int delta) { happiness += delta; }
    public void addPopulation(int amount) { population += amount; }
    public void changeMoney(int delta) { money += delta; }

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
    public int getMoney() { return money; }

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

    public int getExtraPowerSupply() {
        return extraPowerSupply;
    }

    public int getExtraPowerUsage() {
        return extraPowerUsage;
    }

    public int getExtraPollution() {
        return extraPollution;
    }

    public int getExtraHappiness() {
        return extraHappiness;
    }

    public int getExtraPopulation() {
        return extraPopulation;
    }

    public ArrayList<Event> getPastEvents() {
        return pastEvents;
    }

    public JPanel getWrapper() {
        return wrapper;
    }

    
    
}
