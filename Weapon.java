public class Weapon extends Item {
    private int increaseDamage;

    // Konstruktor för Weapon som tar namn, beskrivning och skadaökning
    public Weapon(String name, String itemDesc, int increaseDamage) {
        super(name, itemDesc); // Anropar konstruktorn i Item
        this.increaseDamage = increaseDamage;
    }
    // Getter för increaseDamage
    public int getIncreaseDamage() {
        return increaseDamage;
    }
}
