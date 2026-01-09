import java.util.ArrayList;
import java.util.Iterator;

public class Room {
    // Instansvariabler
    private String roomDesc;
    private Monster monster;       // Aggregation (0..1)
    private Item item;             // Aggregation (0..1)
    private ArrayList<Door> doors; // Aggregation (1..4)

    // Konstruktor
    public Room(String roomDesc) {
        this.roomDesc = roomDesc;
        this.doors = new ArrayList<>();
        // Monster och Item är null från start (tomt rum)
    }

            // Setup-metoder
    public void addDoor(Door door) {
        this.doors.add(door);
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void setItem(Item item) {
        this.item = item;
    }

            // Getters
    public Monster getMonster() {
        return monster;
    }

    public Item getItem() {
        return item;
    }

    // Tar bort föremålet från rummet när spelaren plockar upp det
    public void removeItem() {
        this.item = null;
    }

    // Letar upp en dörr baserat på position (n, s, ö, v)
    public Door getDoor(char position) {
        for (Door door : doors) {
            // Jämför dörrens position med den efterfrågade
            if (door.getPosition() == position) {
                return door;
            }
        }
        return null; // Ingen dörr åt det hållet
    }

            // Spel-logik

    // doNarrative: Beskriver rummet, föremål och monster
    public void doNarrative() {
        System.out.println(roomDesc);

        // Visar föremål (om det finns)
        if (item != null) {
            System.out.println("Du ser " + item.getItemDesc());
        }

        // Visar monster
        if (monster != null && monster.isAlive()) {
            System.out.println("VARNING: " + monster.getMonsterDesc());
        }
    }

    // doDoors: Visar vilka dörrar som finns i rummet
    public void doDoors() {

        System.out.println("Tillgängliga dörrar:");
        
        // Itererar genom dörrarna och skriver ut deras positioner
        Iterator<Door> var1 = doors.iterator();
    
        //Loopa genom dörrarna
        while (var1.hasNext()) {
            Door d = var1.next();

            char position = d.getPosition();
            String directionText = "";
            
            switch (position) {
                case 'N': directionText = "Norrut   "; break;
                case 'S': directionText = "Söderut  "; break;
                case 'V': directionText = "Västerut "; break;
                case 'O': directionText = "Österut  "; break;
                default: directionText = "Okänd riktning";
            }

            System.out.println(directionText + d.getPosition());
        }
    }
    // doBattle: Hanterar striden mellan spelaren och monstret i rummet
    public void doBattle(Player player) {
        // Om inget monster finns eller det är dött, gör ingenting
        if (monster == null || !monster.isAlive()) {
            return;
        }

        // Striden pågår så länge båda lever
        while (player.isAlive() && monster.isAlive()) {
            
            // 1. Monstret attackerar först
            System.out.println("VARNING! " + monster.getName() + " attackerar dig och gör " + monster.getDamage() + " skada");
        player.takeDamage(monster.getDamage());

            // Om spelaren dör, avbryt direkt
            if (!player.isAlive()) {
                System.out.println("Du har dött...");
                break;
            }

            // 2. Spelaren attackerar tillbaka automatiskt
            System.out.println("Du attackerar " + monster.getName() + " och gör " + player.getDamage() + " skada");
        monster.takeDamage(player.getDamage());
    }

        // Efter striden
        if (player.isAlive()) {
            System.out.println("Du besegrade " + monster.getName() + "!");
            this.monster = null; // Monstret försvinner från rummet
        }
    }
}