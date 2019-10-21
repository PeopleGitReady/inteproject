import java.awt.*;

public class Weapon extends EquippableItem {

    private int attackBonus;

    //fix rarity

    private static final int CLASSIC=1;
    public static final int RARE=2;
    public static final int EPIC=4;

    private int rarityType;

    public Weapon(String name, Point point,int attackBonus) {
        super(name, point);
        this.attackBonus=attackBonus;
    }

    public Weapon(String name, int attackBonus,int typeOfRarity) {
        super(name);
        this.attackBonus=attackBonus;
        this.rarityType=typeOfRarity;
    }

    public Weapon(String name, int attackBonus) {
        super(name);
        this.attackBonus=attackBonus;
    }

    public Weapon(){

    }

    public boolean isClassic(){
        return rarityType == CLASSIC;
    }

    public boolean isRare(){
        return rarityType == RARE;
    }

    public boolean isEpic(){
        return rarityType== EPIC;
        }


    public int getAttackBonus(){
//fix logic for rarity with attack bonus
        return attackBonus;
        }

}
