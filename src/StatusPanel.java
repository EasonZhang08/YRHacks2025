import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StatusPanel extends JPanel {
    private Game game;

    public StatusPanel(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(250, 850));
        setBackground(Game.CELADON);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int padding = 20;
        int barWidth = 180;
        int barHeight = 20;
        int x = padding;
        int y = 50;

        g2.setFont(new Font("SansSerif", Font.BOLD, 20));
        g2.setColor(Color.DARK_GRAY);
        g2.drawString("📊 City Stats", x, y);
        y += 50;

        g2.setFont(new Font("SansSerif", Font.BOLD, 16));

        // Pollution Bar
        drawLabeledBar(g2, "🌫 Pollution", game.getPollution(), Color.RED, x, y, barWidth, barHeight);
        y += 70;

        // Power Usage Bar
        int usage = game.getPowerUsage();
        int supply = game.getPowerSupply();
        int powerPercent = supply == 0 ? 0 : (int) (100.0 * usage / Math.max(1, supply));
        drawLabeledBar(g2, "⚡ Power Usage", powerPercent, Color.ORANGE, x, y, barWidth, barHeight);
        g2.setFont(new Font("SansSerif", Font.PLAIN, 12));
        g2.drawString(usage + " / " + supply, x + barWidth + 10, y + barHeight - 3);
        y += 70;

        // Happiness Bar
        drawLabeledBar(g2, "😊 Happiness", game.getHappiness(), Color.GREEN.darker(), x, y, barWidth, barHeight);
        y += 70;

        // Population Text
        g2.setFont(new Font("SansSerif", Font.BOLD, 16));
        g2.setColor(Color.DARK_GRAY);
        g2.drawString("👨‍👩‍👧‍👦 Population: " + game.getPopulation(), x, y);
        y += 70;

        // Money Text
        g2.drawString("💵 Money: " + game.getMoney(), x, y);
        y += 70;

        // //event alert
        // g2.drawString("Event: " + game.getEventAlert(), x, y);
        // y += 70;

        g.drawString("🔔 Event:", x, y);
        y += 18;

        ArrayList<String> lines = wrapText(g, game.getEventAlert(), 200);
        for (String line : lines) {
            g.drawString(line, x, y);
            y += 18;
        }
        y += 50;

        //ticks
        g2.drawString("Time Past: " + game.getTickCounter(), x, y);
        y += 70;

        //selection
        g2.drawString("Selected: " + game.getGamePanel().getSelectedType() + " (1–5 to change)", x, y);
    }

    private void drawLabeledBar(Graphics2D g2, String label, int value, Color color, int x, int y, int width, int height) {
        g2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g2.setColor(Color.DARK_GRAY);
        g2.drawString(label, x, y - 5);

        // Background
        g2.setColor(new Color(220, 220, 220));
        g2.fillRoundRect(x, y, width, height, 10, 10);

        // Filled value
        int filled = (int) (width * (value / 100.0));
        g2.setColor(color);
        g2.fillRoundRect(x, y, filled, height, 10, 10);

        // Border
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(x, y, width, height, 10, 10);
    }


    private ArrayList<String> wrapText(Graphics g, String text, int maxWidth) {
        FontMetrics fm = g.getFontMetrics();
        ArrayList<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();
    
        for (String word : text.split(" ")) {
            if (fm.stringWidth(line + word) > maxWidth) {
                lines.add(line.toString());
                line = new StringBuilder(word + " ");
            } else {
                line.append(word).append(" ");
            }
        }
        lines.add(line.toString());
        return lines;
    }
    
}
