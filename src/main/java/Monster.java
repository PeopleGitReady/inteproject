import java.awt.*;

public class Monster extends Character {

    //Monster bawser = new Monster("Bawser", 100, 10, 10);

    public Monster(String name, int health, int attack, int level) {
        super(name, health, attack, level);
    }



    // Metod som kollar om Monster är död så droppa item på dess plats

    public int monsterDeadDamage (int decreaseHealth) {
        int health
        bawser.setHealth(); -= decreaseHealth;
        if(bawser.getHealth() <= 0) {
            bawser.setIsDead(true);
            System.out.println("RIP");
            Point deadLocation = bawser.getPoint().getLocation();
            Item item = new Item(deadLocation);
        }
    }
}
