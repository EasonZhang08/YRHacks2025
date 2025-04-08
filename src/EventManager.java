import java.util.ArrayList;

public class EventManager {
    ArrayList<Event> events = new ArrayList<>();

    public EventManager(){
        events.add(new EarthquakeEvent());
        events.add(new HeatwaveEvent());
        events.add(new ProtestEvent());
        events.add(new SolarBoostEvent());
    }

    public void triggerRandomEvent(){

    }
}
