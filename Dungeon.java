import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Dungeon {
    
    //Instansvariabler
    private ArrayList<Room> rooms;
    private Room currentRoom;

    //Konstruktor
    public Dungeon() {
        this.rooms = new ArrayList<>();
    }

    // --- Metoder ---

    //Lägger till ett rum i dungeon
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Sätter nuvarande rum
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    // --- Spel-loopen ---

    // Välkomnar spelaren och hanterar spel-loopen
    public void playGame(Player player, Scanner scanner) {
        System.out.println("Välkommen " + player.getName() + " till Dragon Treasure!");

        while (true) {

            // Visar nuvarande rums beskrivning
            System.out.println("-------------------------");
            currentRoom.doNarrative();

            // Frågar spelaren om vilken dörr de vill ta
            System.out.print("Välj en dörr att gå igenom: ");
            String input = scanner.nextLine().trim().toUpperCase();

            // Avslutar spelet om spelaren trycker [Q] "Quit"
            if (input.equals("Q")) {
                System.out.println("Tack för att du spelade!");
                break;
            }

            // Hittar dörren baserat på spelarens input
            ArrayList<Door> doorsInRoom = currentRoom.getDoors();
            Iterator<Door> iter = doorsInRoom.iterator();

            boolean foundDoor = false;

            // Loopar igenom dörrarna i rummet för att hitta den valda dörren
            while (iter.hasNext()) {
                Door door = iter.next();
                
                String doorKey = String.valueOf(door.getPosition());

                if (doorKey.equals(input)) {
                    foundDoor = true;
                    // Kollar om dörren är låst
                    if (door.isLocked()) {
                        System.out.println("Dörren är låst! Du behöver en nyckel.");
                    } else {
                        currentRoom = door.getNextRoom();
                        System.out.println("Du går vidare...");
                    }
                    break;
                }
            }
            // Om ingen dörr matchade spelarens val
            if (!foundDoor) {
                System.out.println("Ogiltigt val. Försök igen.");
            }
        }
        
    }
}
