public class SolarPower extends Power{

    public SolarPower(int row, int col) {
        super(row, col, "S");
    }
    
    public void affectGame(Game game){
        game.addPollution(2);
        game.addPowerSupply(10);
    }
}
