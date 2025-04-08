public class SolarBoostEvent extends Event{

    public SolarBoostEvent() {
        super("SolarBoost", 2, "Solar Boost! Power supply increased.");
    }

    
    public void affectGame(Game game) {
        
        //increase power supply
        game.addExtraPowerSupply(10);


        //decrease happiness
        game.changeExtraHappiness(-2);
    }
    
}
