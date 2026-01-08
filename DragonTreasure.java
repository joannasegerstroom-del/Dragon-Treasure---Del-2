import java.util.Scanner;

public class DragonTreasure {


    //Metod som sätter upp spelet
    public void setupGame() {
        // Välkomstmeddelande och spelarens namn
        Scanner input = new Scanner(System.in);
        System.out.println("Välkommen till Dragon Treasure!");
        System.out.print("Skriv ditt namn och tryck på [Enter] för att starta");

        String playerName = input.nextLine();

        // Skapar spelaren och dungeon
        Player player = new Player(playerName);
        Dungeon dungeon = new Dungeon();

        //Skapar rummen
        Room startRoom = new Room("Välkommen " + player.getName() + " till din skattjakt!\nDu står utanför en grotta. Det luktar svavel från öppningen.\nGrottöppningen är österut. Skriv [O] och tryck på [Enter] för att komma in i grottan.");
        Room room2 = new Room("När du går in i grottan kollapsar ingången bakom dig!\nRummet är upplyst av några ljus som sitter på ett bord framför dig.\nDu kan gå norrut [N]\nDu kan gå söderut [S]");
        Room room3 = new Room("Du ser en död kropp på golvet.\nDu kan gå söderut [S]\nDu kan gå österut [O]");
        Room room4 = new Room("Du ser en brinnande fackla i rummets ena hörn och känner en motbjudande stank.\nDu ser en utgång österut.\nDu kan gå västerut [V]\nDu kan gå söderut [S]");
        Room room5 = new Room ("Du kommer in i ett fuktigt rum med vatten sipprandes längs den västra väggen.\nDu ser en låst dörr i öster [O]\nDu kan gå norrut [N]\nDu kan gå västerut [V]");
        Room room6 = new Room("Du kommer in i ett rymligt bergrum med en ljusstrimma sipprandes genom en spricka i den östra väggen.\nDu kan gå norrut [N]\nDu kan gå österut [O]");
        Room skattRoom = new Room("Du har ingen nyckel som passar.\nDu kikar genom nyckelhålet och ser en skattkista fylld med guld.\nDu kan gå norrut [N]\n Du kan gå västerut [V]");
        Room utgångRoom = new Room("Du lämnar grottan med livet i behåll.\nGrattis " + player.getName() + ", du förlorade inte!");

        // --- Skapar dörrar och kopplar ihop rummen ---

        // Koppling: Start Room -> Room 2
        // En olåst dörr österut som leder till rum 2
        Door startToRoom2 = new Door('O', false, room2);
        startRoom.addDoor(startToRoom2);

        // Koppling: Room 2 -> Room 3
        // En olåst dörr norrut som leder till rum 3
        Door room2ToRoom3 = new Door('N', false, room3);
        room2.addDoor(room2ToRoom3);
        // Koppling: Room 2 -> Room 6
        // En olåst dörr söderut som leder till rum 6
        Door room2ToRoom6 = new Door('S', false, room6);
        room2.addDoor(room2ToRoom6);

        // Koppling: Room 3 -> Room 4
        // En olåst dörr österut som leder till rum 4
        Door room3ToRoom4 = new Door('O', false, room4);
        room3.addDoor(room3ToRoom4);
        // Koppling: Room 3 -> Room 2
        // En olåst dörr söderut som leder till rum 2 (Vägen tillbaka)
        Door room3ToRoom2 = new Door('S', false, room2);
        room3.addDoor(room3ToRoom2);

        // Koppling: Room 4 -> Room 5
        // En olåst dörr söderut som leder till rum 5
        Door room4ToRoom5 = new Door('S', false, room5);
        room4.addDoor(room4ToRoom5);
        // Koppling: Room 4 -> Utgång Rom
        // En olåst dörr österut som leder ut ur grottan
        Door room4ToUtgångRoom = new Door('O', false, utgångRoom);
        room4.addDoor(room4ToUtgångRoom);
        // Koppling: Room 4 -> Room 3
        // En olåst dörr västerut som leder till rum 3 (Vägen tillbaka)
        Door room4ToRoom3 = new Door('V', false, room3);
        room4.addDoor(room4ToRoom3);

        // Koppling: Room 5 -> Room 6
        // En olåst dörr västerut som leder till rum 6
        Door room5ToRoom6 = new Door('V', false, room6);
        room5.addDoor(room5ToRoom6);
        // Koppling: Room 5 -> Skatt Room
        // En låst dörr österut som leder till skatt rummet
        Door room5ToSkattRoom = new Door('O', true, skattRoom);
        room5.addDoor(room5ToSkattRoom);
        // Koppling: Room 5 -> Room 4
        // En olåst dörr norrut som leder till rum 4 (Vägen tillbaka)
        Door room5ToRoom4 = new Door('N', false, room4);
        room5.addDoor(room5ToRoom4);

        // Koppling: Room 6 -> Room 2
        // En olåst dörr norrut som leder till rum 2 (Vägen tillbaka)
        Door room6ToRoom2 = new Door('N', false, room2);
        room6.addDoor(room6ToRoom2);
        // Koppling: Room 6 -> Room 5
        // En olåst dörr österut som leder till rum 5
        Door room6ToRoom5 = new Door('O', false, room5);
        room6.addDoor(room6ToRoom5);

        // Registrerar rummen i dungeon
        dungeon.addRoom(startRoom);
        dungeon.addRoom(room2);
        dungeon.addRoom(room3);
        dungeon.addRoom(room4);
        dungeon.addRoom(room5);
        dungeon.addRoom(room6);
        dungeon.addRoom(skattRoom);
        dungeon.addRoom(utgångRoom);

        // Sätter vilket rum spelaren börjar i
        dungeon.setCurrentRoom(startRoom);

        // Startar spel-loopen
        dungeon.playGame(player, input);

        // Stänger scannern
        input.close();
    }
}
