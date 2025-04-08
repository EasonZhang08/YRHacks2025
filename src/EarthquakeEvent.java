public class EarthquakeEvent extends Event{

    public EarthquakeEvent() {
        super("Earthquake", 1, "Earthquake is coming! Buildings are getting destoryed!");
    }

    
    public void affectGame(Game game) {
        //destory random buildings 
        int randRow = (int)(Math.random() * 80);
        int randCol = (int)(Math.random() * 80);
        TileFactory.removeTile(randRow, randCol, game);
        
        //decrease population
        game.addPopulation(-20);


        //decrease happiness
        game.changeHappiness(-10);
    }
    
}
