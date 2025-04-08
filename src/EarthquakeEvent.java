public class EarthquakeEvent extends Event{

    public EarthquakeEvent() {
        super("Earthquake", 1, "Earthquake is coming! Buildings are getting destoryed!");
    }

    
    public void affectGame(Game game) {
        for (int i = 0; i < 3; i ++){
            int randRow = (int)(Math.random() * 8);
            int randCol = (int)(Math.random() * 8);
            TileFactory.removeTile(randRow, randCol, game);
        }
        //destory random buildings 
        
        
        //decrease population
        game.addExtraPopulation(-20);


        //decrease happiness
        game.changeExtraHappiness(-10);
    }
    
}
