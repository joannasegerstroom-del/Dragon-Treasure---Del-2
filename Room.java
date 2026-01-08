import java.util.ArrayList;
import java.util.Iterator;

public class Room {
    
    //Instansvariabler
    private String roomDesc;
    private ArrayList<Door> doors;

    //Konstruktor
    public Room(String roomDesc) {
        this.roomDesc = roomDesc;
        this.doors = new ArrayList<>();
    }
   
    // --- Metoder ---

    //Lägger till en dörr till rummet
    public void addDoor(Door door) {
        doors.add(door);
    }

    //"Getter" som returnerar listan av dörrar i rummet
    public ArrayList<Door> getDoors() {
        return doors;
    }

    public void doNarrative() {
        // Skriver ut rummets beskrivning
        System.out.println(roomDesc);
        System.out.println("Doors available for further navigation");
        
        // Itererar genom dörrarna och skriver ut deras positioner
        Iterator<Door> var1 = doors.iterator();
    
        //Loopa genom dörrarna
        while (var1.hasNext()) {
            Door d = var1.next();

            char position = d.getPosition();
            String directionText = "";
            
            switch (position) {
                case 'N': directionText = "Norrut "; break;
                case 'S': directionText = "Söderut "; break;
                case 'V': directionText = "Västerut "; break;
                case 'O': directionText = "Österut "; break;
                default: directionText = "Okänd riktning";
            }

            System.out.println("Väderstreck: " + directionText + d.getPosition());
        }
    }
}
