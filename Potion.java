public class Potion extends Item {
    private int healing;

    // Konstruktor för Potion som tar namn, beskrivning och helande värde
    public Potion(String name, String itemDesc, int healing) {
        super(name, itemDesc); // Anropar konstruktorn i Item
        this.healing = healing;
    }

    // Getter för healing
    public int getHealing() {
        return healing;
    }
}