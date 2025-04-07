public class TileFactory {
    public static Tile createTile(String type, int row, int col) {
        switch (type) {
            case "Building":
                return new Building(row, col);
            case "Park":
                return new Park(row, col);
            case "PowerSolar":
                return new SolarPower(row, col);  // true = green
            case "PowerFossil":
                return new FossilPower(row, col); // false = fossil
            case "Road":
                return new Road(row, col);
            default:
                return null;
        }
    }
}
