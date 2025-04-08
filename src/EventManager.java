import java.util.ArrayList;

public class EventManager {
    ArrayList<Event> events = new ArrayList<>();
    ArrayList<Event> totalEvents = new ArrayList<>();

    public EventManager(){
        events.add(new EarthquakeEvent());
        events.add(new HeatwaveEvent());
        events.add(new ProtestEvent());
        events.add(new SolarBoostEvent());
        for (Event e: events){
            for (int i = 0; i < e.getRarity(); i++){
                totalEvents.add(e);
            }
        }
    }

    public Event triggerRandomEvent(Game g){
        int rand = (int)(Math.random()*totalEvents.size());
        totalEvents.get(rand).affectGame(g);
        return totalEvents.get(rand);
    }
}
