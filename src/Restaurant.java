public class Restaurant extends Tile{

    public Restaurant(int row, int col) {
        super(row, col, "R");
        this.sprite = SpriteLoader.load("restaurant");
    }
    
    public void affectGame(Game game){
        game.addPollution(10);
        game.addPowerUsage(5);
        game.changeHappiness(10);
        game.changeMoney(-10000);
    }
}
