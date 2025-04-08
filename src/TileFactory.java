public class TileFactory {
    public static Tile createTile(String type, int row, int col) {
        switch (type) {
            case "Building":
                return new Building(row, col);
            case "Park":
                return new Park(row, col);
            case "PowerSolar":
                return new SolarPower(row, col);  
            case "PowerFossil":
                return new FossilPower(row, col); 
            case "Road":
                return new Road(row, col);
            default:
                return new EmptyTile(row, col);
        }
    }

    public static void removeTile(int row, int col, Game g){
        Tile[][] grid = g.getGamePanel().getGridManager().getGrid();
        
        switch (grid[row][col].getLabel()) {
            case "B":
                g.reducePollution(-10);
                g.addPowerUsage(-5);
                break;
            case "P":
                g.changeHappiness(-3);
                g.addPowerUsage(-2);
                g.addPollution(3);
                break;
            case "S":
                g.reducePollution(2);
                g.addPowerSupply(-10);
                break;
            case "F":
                g.reducePollution(20);
                g.addPowerSupply(-20);
                break;
            case "R":
                g.reducePollution(7);
                g.addPowerUsage(-5);
                g.changeHappiness(-2);
            default:
                return;
        }
        g.getGamePanel().getGridManager().getGrid()[row][col] = createTile("", row, col);
    }
}
