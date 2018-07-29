package home.javaphite.explorer.model;

public class PlaceOfInterest {
    private final int id = (int) Math.abs(super.hashCode()/111119);
    private boolean scanned;
    private Item associatedItem;

    PlaceOfInterest(Item associatedItem) {
        this.associatedItem = associatedItem;
    }

    public boolean isScanned() {
        return scanned;
    }

    public Item getAssociatedItem() {
        return associatedItem;
    }

    public int getId() {
        return id;
    }
}
