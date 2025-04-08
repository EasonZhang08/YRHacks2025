public class HeatwaveEvent extends Event{

    public HeatwaveEvent() {
        super("Heatwave", 2, "Heatwave! Pollution rises.");
    }

    
    public void affectGame(Game game) {
        
        //increase pollution
        game.addExtraPollution(10);


        //decrease happiness
        game.changeExtraHappiness(-5);
    }
    
}
