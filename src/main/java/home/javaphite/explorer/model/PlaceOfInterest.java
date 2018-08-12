package home.javaphite.explorer.model;

public class PlaceOfInterest {
    //TODO: implement hashcode and equals, replace id with hashcode
    private final int id = (int) Math.abs(super.hashCode()/111119);
    private boolean scanned;
    private Item associatedItem;

    PlaceOfInterest(Item associatedItem) {
        this.associatedItem = associatedItem;
    }

    public boolean isScanned() {
        return scanned;
    }

    public void setScanned(boolean scanned) {
        this.scanned = scanned;
    }

    public Item getAssociatedItem() {
        return associatedItem;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String result = associatedItem.getName() + "(" + id + ")";
        return result;
    }

    public String getStatus() {
        String status;
        if(scanned) {
            status = associatedItem.getDescription() + "(" + associatedItem.getType() + ")";
        }
        else {
            status = "UNKNOWN";
        }
        return status;
    }
}
