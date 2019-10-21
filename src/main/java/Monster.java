import java.awt.*;

public abstract class Monster extends Character {

    public int xpGiven;

    public Monster(String name, int health, int attack, int level, int xpGiven) {
        super(name, health, attack, level, new Point(1, 1));
        this.xpGiven = xpGiven;
    }

    public void moveX() {
        getPoint().setLocation(getPoint().getX() + 1, getPoint().getY());
    }

    public void moveY() {
        getPoint().setLocation(getPoint().getX() , getPoint().getY() + 1);
    }

    public int calculateXp () {
        return xpGiven * getLevel();
    }

    public void takeDamage (int damage) {
       setHealth(getHealth() - damage);
        if (getHealth() <= 0) {
            setIsDead(true);
            System.out.println("RIP");
            // generateDrop(getPoint());
        }
    }

}