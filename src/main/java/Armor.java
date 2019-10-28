import java.awt.*;
import java.util.Objects;

public class Armor extends EquippableItem {

    private int armorValue;

    public static final String CHEST = "CHEST";
    public static final String HEAD = "HEAD";
    public static final String LEG= "LEG";
    public static final String FEET= "FEET";

    private ArmorTypeRarity armorTypeRarity;

    private String ArmorType;



    public Armor(String name,int armorValue, String armorType ,ArmorTypeRarity armorRarity) {
        super(name);
        this.armorValue = (armorValue+armorTypeRarity.getArmorBonus());
        this.armorTypeRarity = armorRarity;
        this.ArmorType=armorType;
    }

    public String getArmorType(){
        return ArmorType;
    }

    public int getArmorValue(){
        return armorValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (o instanceof Armor) {
            Armor aa = (Armor) o;
            return (aa.ArmorType.equals(this.ArmorType) );
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(ArmorType);
    }

}
