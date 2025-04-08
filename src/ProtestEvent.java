public class ProtestEvent extends Event{

    public ProtestEvent() {
        super("Protest", 2, "Protest! Citizens are upset.");
    }

    
    public void affectGame(Game game) {
        //decrease happiness
        game.changeHappiness(-20);
    }
    
}
