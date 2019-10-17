
public abstract class Monster extends Character {

    public Monster(String name, int health, int attack, int level) {
        super(name, health, attack, level);
    }

    public void takeDamage (int damage) {
       int newHealth = getHealth() - damage;
       setHealth(newHealth);
        if (getHealth() <= 0) {
            setIsDead(true);
            System.out.println("RIP");
            // generateDrop(getPoint());
        }
    }

/*
    public void generateDrop(Point point) {
        Item item = new Item(point);
    }
 */

}