import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridManager {
    private final int rows = 8;
    private final int cols = 8;
    private final int tileSize = 100;

    private Tile[][] grid;

    public GridManager() {
        grid = new Tile[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new EmptyTile(i, j);
            }
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Tile tile = grid[i][j];

                int x = i * tileSize;
                int y = j * tileSize;

                
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x, y, tileSize, tileSize);
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x, y, tileSize, tileSize);

                if (tile != null){
                    g.setColor(Color.BLACK);
                    g.drawString(tile.getLabel(), x + tileSize / 2 - 5, y + tileSize / 2 + 5);           
                }
            }
        }
    }

    public Tile getTileAtPoint(MouseEvent e) {
        int col = e.getX() / tileSize;
        int row = e.getY() / tileSize;

        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return grid[col][row];
        }
        return null;
    }

    public void setTile(int row, int col, Tile newTile) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            grid[row][col] = newTile;
        }
    }

    public Tile[][] getGrid() {
        return grid;
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getGridWidth() {
        return cols * tileSize;
    }

    public int getGridHeight() {
        return rows * tileSize;
    }


}
