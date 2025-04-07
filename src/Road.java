public class Road extends Tile{

    public Road(int row, int col) {
        super(row, col, "R");
    }
    
    public void affectGame(Game game){
        game.addPollution(7);
        game.addPowerUsage(5);
        game.changeHappiness(2);
    }
}
