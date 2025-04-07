import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {
    private Game game;

    public StatusPanel(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(300, 850));
        setBackground(Color.green);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        

        int y = 50;

        g.setColor(Color.BLACK);
        g.drawString("🌫️ Pollution: " + game.getPollution() + "%", 10, y);
        y += 50;

        g.drawString("⚡ Power: " + game.getPowerUsage() + " / " + game.getPowerSupply(), 10, y);
        y += 50;

        g.drawString("😊 Happiness: " + game.getHappiness() + "%", 10, y);
        y += 50;

        g.drawString("👨‍👩‍👧‍👦 Population: " + game.getPopulation(), 10, y);
        y += 50;

        g.drawString("Selected: " + game.getGamePanel().getSelectedType() + " (1–5 to change)", 10, y);
    }
}
