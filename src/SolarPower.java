public class SolarPower extends Power{

    public SolarPower(int row, int col) {
        super(row, col, "S");
        this.sprite = SpriteLoader.load("solarPower");
    }
    
    public void affectGame(Game game){
        game.addPollution(2);
        game.addPowerSupply(10);
        game.changeMoney(-200000);
    }
}
