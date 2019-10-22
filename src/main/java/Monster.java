import java.awt.*;

public abstract class Monster extends Character {

    public int xpGiven;

    public Monster(String name, int health, int attack, int level, int xpGiven) {
        super(name, health, attack, level);
        this.xpGiven = xpGiven;
    }

    public void moveX(int i) {
        super.setLocation(super.getX() + i, super.getY());
    }

    public void moveY(int i) {
        super.setLocation(super.getX() , super.getY() + i);
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