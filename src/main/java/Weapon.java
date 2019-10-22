import java.awt.*;

public class Weapon extends EquippableItem {

    private int attackBonus;
    private WeaponType rarity;

    public Weapon(String name, Point point, int attackBonus, WeaponType rarity) {
        super(name, point);
        this.attackBonus=attackBonus;
        this.rarity = rarity;
    }

    public Weapon(String name, int attackBonus, WeaponType rarity) {
        super(name);
        this.attackBonus = attackBonus;
        this.rarity = rarity;
    }

    public Weapon(String name, int attackBonus) {
        super(name);
        this.attackBonus=attackBonus;
    }

    public Weapon(){

    }

    public int getAttackBonus(){
        return attackBonus + (int)rarity.getAddedDamageValue();
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "attackBonus=" + attackBonus +
                ", rarityType=" + getAttackBonus() +
                '}';
    }
}
