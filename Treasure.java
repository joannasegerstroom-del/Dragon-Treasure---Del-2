public class Treasure extends Item {
    private int goldValue;

    // Konstruktor för Treasure som tar namn, beskrivning och guldvärde
    public Treasure(String name, String itemDesc, int goldValue) {
        super(name, itemDesc); // Anropar konstruktorn i Item
        this.goldValue = goldValue;
    }

    // Getter för goldValue
    public int getGoldValue() {
        return goldValue;
    }
}