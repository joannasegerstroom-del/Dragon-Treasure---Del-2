import java.util.ArrayList;

public class Player {
    // Instansvariabler 
    private String name;
    private int healthPoints;
    private int damage;
    private ArrayList<Item> inventory; // Aggregation till Item

    // Konstruktor
    public Player(String name) {
        this.name = name;
        this.healthPoints = 10; // Startvärde
        this.damage = 1;        // Startvärde (utan vapen)
        this.inventory = new ArrayList<>();
    }

    // --- Getters & Setters ---
    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getDamage() {
        return damage;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    // --- Spel-logik ---

    // Metod för att plocka upp ett föremål
    public void pickUpItem(Item item) {
        inventory.add(item);
        System.out.println("Du plockade upp: " + item.getName());

        // Om föremålet är ett vapen, öka spelarens skada
        if (item instanceof Weapon) {
            Weapon w = (Weapon) item;
            this.damage += w.getIncreaseDamage();
            System.out.println("Du gör nu " + this.damage + " i skada.");
        }
    }

    // Metod för att använda en potion
    public void usePotion(Potion potion) {

        if (inventory.contains(potion)) {
            this.healthPoints += potion.getHealing();
            inventory.remove(potion); // Tar bort den efter användning
            System.out.println("Du drack " + potion.getName() + " och fick " + potion.getHealing() + " HP.");
            System.out.println("Nuvarande HP: " + this.healthPoints);
        } else {
            System.out.println("Du har ingen sådan potion.");
        }
    }

    // Metod för att kolla om spelaren har en nyckel
    public boolean hasKey() {
        for (Item i : inventory) {
            if (i instanceof Key) {
                return true;
            }
        }
        return false;
    }

    // Metod för att ta skada
    public void takeDamage(int amount) {
        this.healthPoints -= amount;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
        System.out.println(name + " tog " + amount + " skada. HP kvar: " + healthPoints);
    }

    // Metod för att kolla om spelaren är vid liv
    public boolean isAlive() {
        return healthPoints > 0;
    }
}