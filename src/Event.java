public abstract class Event {
    private String name;
    private int rarity;
    private String alert;

    public Event(String name, int rarity, String alert){
        this.name = name;
        this.rarity = rarity;
        this.alert = alert;
    }
    
    public abstract void affectGame(Game g);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    
}
