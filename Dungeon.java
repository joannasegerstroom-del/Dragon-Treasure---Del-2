import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {
    
    //Instansvariabler
    private ArrayList<Room> rooms;
    private Room currentRoom;

    //Konstruktor
    public Dungeon() {
        this.rooms = new ArrayList<>();
    }

            // Metoder

    //Lägger till ett rum i dungeon
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Sätter nuvarande rum
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

            // Spel-loopen

    // Välkomnar spelaren och hanterar spel-loopen
    public void playGame(Player player, Scanner scanner) {

        boolean running = true;

        while (running && player.isAlive()) {
            System.out.println("---------------------------------------------");

            // Visar nuvarande rums beskrivning
            currentRoom.doNarrative();

            // Hanterar Monster & Strid
            Monster monster = currentRoom.getMonster();
            if (monster != null && monster.isAlive()) {
                currentRoom.doBattle(player);
                
                // Om spelaren dog i striden, bryt loopen
                if (!player.isAlive()) {
                    System.out.println("Du har dött! Spelet är över.");
                    break;
                }
            }

            // Hanterar föremål (Om det finns något i rummet)
            Item item = currentRoom.getItem();
            if (item != null) {
                System.out.print("För att plocka upp " + item.getName() + ", tryck [P]: ");
                String svar = scanner.nextLine().trim().toUpperCase();
                if (svar.equalsIgnoreCase("P")) {
                    player.addItem(item);
                    System.out.println("Du plockade upp " + item.getName());
                    currentRoom.removeItem(); // Tar bort saken från rummet

                    // Dricka potion om spelaren har någon
                    if (item.getName().equals("Hälsopotion")) {
                        player.usePotion((Potion) item);
                    } 
                }
            }
        
            // Visar vilka dörrar som finns
            currentRoom.doDoors();

            // Frågar spelaren om vilken dörr de vill ta
            System.out.print("Välj en dörr att gå igenom: ");
            String input = scanner.nextLine().trim().toUpperCase();


            // Avslutar spelet om spelaren trycker [Q] "Quit"
            if (input.equals("Q")) {
                System.out.println("Tack för att du spelade!");
                running = false;
                break;
            }

            if (input.length() > 0) {
                char direction = input.charAt(0);

                Door door = currentRoom.getDoor(direction);

                if (door != null) {
                    // Kollar om dörren är låst
                    if (door.isLocked()) {
                        if (player.hasItem("Nyckel")) {
                            System.out.println("Du låser upp dörren med nyckeln.");
                            door.setLocked(false);
                            currentRoom = door.getNextRoom();
                        } else {
                            System.out.println("Dörren är låst! Du behöver en nyckel. Du kikar in genom nyckelhålet och ser en skattkista fylld med guld.");
                        }
                    } else {
                        currentRoom = door.getNextRoom();
                        System.out.println("Du går vidare...");
                    }
                } else {
                    System.out.println("Ogiltigt val. Försök igen.");
                }
            }
        }
        // Spelet är slut
    if (!player.isAlive()) {
            System.out.println("Du dog i grottan. Game Over.");
        } else if (!running) {
             System.out.println("Tack för att du spelade!");
        }
    }

}
