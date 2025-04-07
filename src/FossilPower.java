public class FossilPower extends Power{

    public FossilPower(int row, int col) {
        super(row, col, "F");
    }
    
    public void affectGame(Game game){
        game.addPollution(20);
        game.addPowerSupply(20);
    }
}
