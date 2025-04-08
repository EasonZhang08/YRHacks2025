import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Tile {
    private int row;
    private int col;
    private String label;
    protected Image sprite;

    public Tile(int row, int col, String label){
        this.row = row;
        this.col = col;
        this.label = label;
    }

    public void draw(Graphics g, int x, int y, int size) {
        if (sprite != null) {
            g.drawImage(sprite, x, y, size, size, null);
        }
        //g.setColor(Color.BLACK);
        //g.drawRect(x, y, size, size);
    }

    public abstract void affectGame(Game game);

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    
}
