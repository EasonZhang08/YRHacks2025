import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements MouseListener {
    private GridManager gridManager;
    private String selectedType = "Building"; // Default

    public GamePanel() {
        setFocusable(true);
        gridManager = new GridManager();
        setPreferredSize(new Dimension(gridManager.getGridWidth(), gridManager.getGridHeight()));
        addMouseListener(this);

        // Key bindings to change selected tile type
        bindKey("1", "Building");
        bindKey("2", "Park");
        bindKey("3", "PowerSolar");
        bindKey("4", "PowerFossil");
        bindKey("5", "Road");
    }

    private void bindKey(String key, String typeName) {
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), "select_" + typeName);
        getActionMap().put("select_" + typeName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                selectedType = typeName;
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gridManager.draw(g);

        g.setColor(Color.BLACK);
        g.drawString("Selected: " + selectedType + " (1–5 to change)", 10, gridManager.getGridHeight() + 20);
    }

    
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {

        requestFocusInWindow();
        Tile oldTile = gridManager.getTileAtPoint(e);
        if (oldTile != null && oldTile instanceof EmptyTile) {
            int row = oldTile.getRow();
            int col = oldTile.getCol();
            Tile newTile = TileFactory.createTile(selectedType, row, col);
            if (newTile != null) {
                gridManager.setTile(row, col, newTile);
                repaint();
            }
        }

    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
