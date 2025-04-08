public class Building extends Tile{

    public Building(int row, int col) {
        super(row, col, "B");
        this.sprite = SpriteLoader.load("building");
    }

    public void affectGame(Game game){
        game.addPollution(10);
        game.addPopulation(10);
        game.addPowerUsage(5);
        game.changeMoney(-100000);
    }
    
}
