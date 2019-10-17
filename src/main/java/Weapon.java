import java.awt.*;

public class Weapon extends EquippableItem {
    private int attackBonus;
    private int range;

    public Weapon(String name, Point point, int requiredLevel, int rarity) {
        super(name, point, requiredLevel, rarity);
    }

    public Weapon(){

    }
}
