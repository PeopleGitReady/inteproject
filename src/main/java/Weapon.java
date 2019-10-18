import java.awt.*;

public class Weapon extends EquippableItem {
    private int attackBonus;
    private int range;


    public Weapon(String name, Point point,int attackBonus) {
        super(name, point);
        this.attackBonus=attackBonus;
    }

    public Weapon(String name, Point point,int attackBonus,int ammo, int mag) {
        super(name, point);
        this.attackBonus=attackBonus;

    }

    public Weapon(String name, int attackBonus) {
        super(name);
        this.attackBonus=attackBonus;


    }

    public Weapon(){

    }

public int getAttackBonus(){

        return attackBonus;
}







}
