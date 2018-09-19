package home.javaphite.explorer.model;

import home.javaphite.explorer.model.exceptions.InvalidDirectionNameException;

public class Area {
    private Location[][] locations;
    private int xCurrentPos, yCurrentPos;

    public Area(int height, int width) {
        locations = new Location[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                locations[x][y] = Location.randomized();
            }
        }
    }

    public Location getCurrentLocation() {
        return locations[xCurrentPos][yCurrentPos];
    }

    public Location move(String direction) {
        switch (direction) {
            case "west":  setPosition(xCurrentPos, yCurrentPos-1); break;
            case "east":  setPosition(xCurrentPos, yCurrentPos+1); break;
            case "north": setPosition(xCurrentPos-1, yCurrentPos); break;
            case "south": setPosition(xCurrentPos+1, yCurrentPos); break;
            default:
                throw new InvalidDirectionNameException("Warning: unknown direction! Awaiting new commands...");
        }
        return getCurrentLocation();
    }

    private void setPosition(int xPos, int yPos) {
        int xMax = locations.length-1;
        int yMax = locations[0].length-1;

        if ((xPos > xMax) || (yPos > yMax)) {
            throw new ArrayIndexOutOfBoundsException("Warning: you tried to leave exploration area! Movement command aborted. Awaiting new one...");
        } else {
            xCurrentPos = xPos;
            yCurrentPos = yPos;
        }
    }
}
