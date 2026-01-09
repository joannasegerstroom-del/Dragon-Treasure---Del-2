import java.util.ArrayList;

public class Player {
    // Instansvariabler 
    private String name;
    private int healthPoints;
    private int damage;
    private ArrayList<Item> inventory; // Aggregation till Item

    // Konstruktor
    public Player(String name, int healthPoints, int damage) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.inventory = new ArrayList<>();
    }

             // Getters

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

             // Spel-logik

    // Metod för att plocka upp ett föremål
    public void addItem(Item item) {
        inventory.add(item);

        // Om föremålet är ett vapen, öka spelarens skada
        if (item instanceof Weapon) {
            Weapon w = (Weapon) item;
            this.damage += w.getIncreaseDamage();
            System.out.println("Du gör nu " + this.damage + " poäng i skada.");
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

    // Metod för att kolla om spelaren har ett specifikt föremål
    public boolean hasItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
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