package home.javaphite.explorer;

public class Area {
    private Location[][] locations;
    private int xCurrentPos;
    private int yCurrentPos;

    Area(int height, int width) {
        locations = new Location[height][width];
        for (int x = 0; x < (height-1); x++) {
            for (int y = 0; y < (width-1); y++) {
                locations[x][y] = new Location();
            }
        }
        xCurrentPos = (height/2)-1;
        yCurrentPos = (width/2)-1;

    }

    private Location getCurrentLocation() {
        return locations[xCurrentPos][yCurrentPos];
    }

    public Location move(String direction) {
        switch (direction) {
            case "west": yCurrentPos--; break;
            case "east": yCurrentPos++; break;
            case "north": xCurrentPos--; break;
            case "south": xCurrentPos++; break;
            default: throw new IllegalArgumentException("Unknown direction! Awaiting new orders...");
        }
        return getCurrentLocation();
    }
}
