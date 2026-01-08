public class Monster {
    // Instansvariabler
    private String name;
    private int healthPoints;
    private int damage;
    private String monsterDesc;

    // Konstruktor
    public Monster(String name, int healthPoints, int damage, String monsterDesc) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.monsterDesc = monsterDesc;
    }

    // Getters 
    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public String getMonsterDesc() {
        return monsterDesc;
    }

    // --- Stridslogik ---

    // Metod för att attackera spelaren
    public void attack(Player player) {
        System.out.println(this.name + " attackerar dig och gör " + this.damage + " skada.");
        player.takeDamage(this.damage);
    }

    // Metod för att skada monstret
    public void takeDamage(int amount) {
        this.healthPoints -= amount;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
        System.out.println("Du attackerar " + this.name + " och gör " + amount + " skada.");
    }

    // Metod för att kolla om monstret är vid liv
    public boolean isAlive() {
        return healthPoints > 0;
    }
}