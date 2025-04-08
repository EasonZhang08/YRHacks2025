public class FossilPower extends Power{

    public FossilPower(int row, int col) {
        super(row, col, "F");
        this.sprite = SpriteLoader.load("fossilPower");
    }
    
    public void affectGame(Game game){
        game.addPollution(20);
        game.addPowerSupply(20);
        game.changeMoney(-200000);
    }
}
