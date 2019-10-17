import java.awt.*;

public abstract class Monster extends Character {

    //Monster bawser = new Monster("Bawser", 100, 10, 10);

    public Monster(String name, int health, int attack, int level) {
        super(name, health, attack, level);
    }



    // Metod som kollar om Monster är död så droppa item på dess plats

    public void takeDamage (int damage) {
       int newHealth = getHealth() - damage;
       setHealth(newHealth);
        if (getHealth() <= 0) {
            setIsDead(true);
            System.out.println("RIP");
            generateDrop(getPoint());
        }
    }



    public void generateDrop(Point point) {
        Item item = new Item(point);
    }

}