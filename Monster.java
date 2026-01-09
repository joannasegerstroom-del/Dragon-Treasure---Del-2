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

    public int getDamage() {
        return damage;
    }

            // Stridslogik

    // Metod för att attackera spelaren
    public void attack(Player player) {
        player.takeDamage(this.damage);
    }

    // Metod för att ta skada
    public void takeDamage(int amount) {
        this.healthPoints -= amount;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }

    // Metod för att kolla om monstret är vid liv
    public boolean isAlive() {
        return healthPoints > 0;
    }
}