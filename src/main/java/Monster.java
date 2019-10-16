import java.awt.*;

public class Monster extends Character {

    //Monster bawser = new Monster("Bawser", 100, 10, 10);

    public Monster(String name, int health, int attack, int level) {
        super(name, health, attack, level);
    }



    // Metod som kollar om Monster är död så droppa item på dess plats

    public void takeDamage (int attack) {
       int newHealth = getHealth() - attack;
       setHealth(newHealth);
        if (getHealth() <= 0) {
            setIsDead(true);
            generateDrop(getPoint());
        }
    }

    public void generateDrop(Point point) {
        Item item = new Item(point);
    }

}