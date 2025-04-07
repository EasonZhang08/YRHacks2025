public class EmptyTile extends Tile{

    public EmptyTile(int row, int col) {
        super(row, col, "");
    }
    
    public void affectGame(Game game){}
}
