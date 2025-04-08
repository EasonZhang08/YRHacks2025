import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements MouseListener {
    private GridManager gridManager;
    private String selectedType = "SolarPower"; // Default

    public GamePanel(Game g) {
        setFocusable(true);
        gridManager = new GridManager();
        setPreferredSize(new Dimension(gridManager.getGridWidth(), gridManager.getGridHeight()));
        addMouseListener(this);

        // Key bindings to change selected tile type
        bindKey("1", "SolarPanel", g);
        bindKey("2", "FossilPower", g);
        bindKey("3", "Building", g);
        bindKey("4", "Park", g);
        bindKey("5", "Restaurant", g);
    }

    private void bindKey(String key, String typeName, Game g) {
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), "select_" + typeName);
        getActionMap().put("select_" + typeName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                setSelectedType(typeName);
                g.getStatusPanel().repaint();
            }
        });
    }
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gridManager.draw(g);

        g.setColor(Color.BLACK);
        
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

    public GridManager getGridManager() {
        return gridManager;
    }

    public String getSelectedType() {
        return selectedType;
    }

    public void setGridManager(GridManager gridManager) {
        this.gridManager = gridManager;
    }

    public void setSelectedType(String selectedType) {
        this.selectedType = selectedType;
    }

    
}
