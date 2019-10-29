import java.awt.*;

public class Weapon extends EquippableItem {

    private int attackBonus;
    private WeaponType rarity;


    public Weapon(String name, int attackBonus, WeaponType rarity) {
        super(name);
        this.attackBonus = attackBonus;
        this.rarity = rarity;
    }



    public Weapon(){

    }

    public int getAttackBonus(){
        return attackBonus + rarity.getAddedDamageValue();
    }


}
