public class Building extends Tile{

    public Building(int row, int col) {
        super(row, col, "B");
    }

    public void affectGame(Game game){
        game.addPollution(10);
        game.addPowerUsage(5);
    }
    
}
