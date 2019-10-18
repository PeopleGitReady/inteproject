import java.awt.*;

public abstract class Monster extends Character {

    public int xpGiven = 5;

    public Monster(String name, int health, int attack, int level, int xpGiven) {
        super(name, health, attack, level, new Point(1, 1));
    }

    public int getXpGiven () { return xpGiven;  }

    public void takeDamage (int damage, Player player) {
       int newHealth = getHealth() - damage;
       setHealth(newHealth);
        if (getHealth() <= 0) {
            setIsDead(true);
            System.out.println("RIP");
            // generateDrop(getPoint());
        }
    }

    public int calculateXp () {
        return getXpGiven() * getLevel();
    }

/*
    public void generateDrop(Point point) {
        Item item = new Item(point);
    }
 */

}