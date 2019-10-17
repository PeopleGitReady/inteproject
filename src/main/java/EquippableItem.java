import java.awt.*;

public class EquippableItem extends Item{

    private int requiredLevel;
    private int rarity;

    public EquippableItem(String name, Point point, int requiredLevel, int rarity) {
        super(name, point);
        this.requiredLevel = requiredLevel;
        this.rarity = rarity;
    }


    public EquippableItem(){

    }

}
