public class Door {

    //Instansvariabler
    private char position;
    private boolean locked;
    private Room nextRoom;

    //Konstruktor
    public Door(char position, boolean locked, Room nextRoom) {
        this.position = position;
        this.locked = locked;
        this.nextRoom = nextRoom;
    }

    // --- Metoder ---

    //Returnerar om dörren är låst eller inte
    public boolean isLocked() {
        return locked;
    }

    //"Getter" som returnerar dörrens position
    public char getPosition() {
        return position;
    }

    //"Getter" som returnerar rummet dörren leder till
    public Room getNextRoom() {
        return nextRoom;
    }
}
