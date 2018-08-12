package home.javaphite.explorer.model;

//TODO: rework on composite locations
public class Area {
    private Location[][] locations;
    private int xCurrentPos;
    private int yCurrentPos;

    public Area(int height, int width) {
        locations = new Location[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                locations[x][y] = new Location();
            }
        }
    }

    public Location getCurrentLocation() {
        return locations[xCurrentPos][yCurrentPos];
    }

    public Location move(String direction) {
        switch (direction) {
            case "west": setPosition(xCurrentPos, yCurrentPos-1); break;
            case "east": setPosition(xCurrentPos, yCurrentPos+1); break;
            case "north": setPosition(xCurrentPos-1, yCurrentPos); break;
            case "south": setPosition(xCurrentPos+1, yCurrentPos); break;
            default: throw new IllegalArgumentException("Unknown direction! Awaiting new orders...");
        }
        return getCurrentLocation();
    }

    private void setPosition(int xPos, int yPos) {
        int xMax = locations.length-1;
        int yMax = locations[0].length-1;
        xCurrentPos = (xPos > xMax) ? xMax : xPos;
        yCurrentPos = (yPos > yMax) ? yMax : yPos;
    }
}
