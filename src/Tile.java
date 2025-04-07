public abstract class Tile {
    private int row;
    private int col;
    private String label;

    public Tile(int row, int col, String label){
        this.row = row;
        this.col = col;
        this.label = label;
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
