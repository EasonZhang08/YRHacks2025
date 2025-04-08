public class Park extends Tile{

    public Park(int row, int col) {
        super(row, col, "P");
        this.sprite = SpriteLoader.load("park1");
    }
    
    public void affectGame(Game game){
        game.changeHappiness(3);
        game.addPowerUsage(2);
        game.reducePollution(5);
    }
}
