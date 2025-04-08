public abstract class Event {
    String name;
    int rarity;
    String alert;

    public Event(String name, int rarity, String alert){
        this.name = name;
        this.rarity = rarity;
        this.alert = alert;
    }
    
    public abstract void affectGame(Game game);
}
