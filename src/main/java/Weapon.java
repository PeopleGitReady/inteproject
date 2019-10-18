import java.awt.*;

public class Weapon extends EquippableItem {
    private int attackBonus;
    private int range;
    private int ammo;
    private int magasine;
    private int ammoPerMag;

    public Weapon(String name, Point point,int attackBonus) {
        super(name, point);
        this.attackBonus=attackBonus;
    }

    public Weapon(String name, Point point,int attackBonus,int ammo, int mag) {
        super(name, point);
        this.attackBonus=attackBonus;
        this.ammo=ammo;
        this.magasine=mag;
    }

    public Weapon(){

    }


    public void EquipWeapon(Character c){

        if(ammo !=0){
            c.setDamage(attackBonus);
        }

    }

    public int calcAmmoPerMag(int ammo,int mag){

        int x = ammo/mag;

        return x;
    }



}
