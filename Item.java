public abstract class Item {
    // Variabler för namn och beskrivning av föremålet
    private String name;
    private String itemDesc;

    // Konstruktor
    public Item(String name, String itemDesc) {
        this.name = name;
        this.itemDesc = itemDesc;
    }

    // Getters för att komma åt variablerna (eftersom de är privata)
    public String getName() {
        return name;
    }

    public String getItemDesc() {
        return itemDesc;
    }
    
    // En toString-metod för felsökning och utskrift
    @Override
    public String toString() {
        return name;
    }
}
