import java.awt.*;

public abstract class Monster extends Character {

    public int xpGiven;

    public Monster(String name, int health, int attack, int level, int xpGiven) {
        super(name, health, attack, level);
        this.xpGiven = xpGiven;
    }

    public void moveRight() {
        super.setLocation(super.getX() + 1, super.getY());
    }

    public void moveLeft() {
        super.setLocation(super.getX() - 1, super.getY());
    }

    public void moveUp() {
        super.setLocation(super.getX() , super.getY() + 1);
    }

    public void moveDown() {
        super.setLocation(super.getX() , super.getY() - 1);
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