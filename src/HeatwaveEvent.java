public class HeatwaveEvent extends Event{

    public HeatwaveEvent() {
        super("Heatwave", 2, "Heatwave! Pollution rises.");
    }

    
    public void affectGame(Game game) {
        
        //increase pollution
        game.addPollution(10);


        //decrease happiness
        game.changeHappiness(-5);
    }
    
}
