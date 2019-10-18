import java.awt.*;
import java.util.ArrayList;

public class Player extends Character {

    private int xp = 0;
    private int maxHealth = 100;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private ArrayList<Weapon> weaponsSlot= new ArrayList<>();
    private boolean equipsWeaponStatus = false;



    public Player(String name){
        super(name, 100, 20, 1, new Point(0, 0) );
    }

    public String getName(){
        return super.getName();
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getMaxHealth () { return maxHealth; }

    public int getXp () { return xp; }

    public void setXp (int xp) { this.xp = xp; }

    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }

    public void pickUpLoot(Item item) {
        if(inventory.size() < 10) {
            inventory.add(item);
        } else {
            System.out.print("This inventory is full! ");
        }
    }

    public void useHealthPotion () {
        boolean containsHealthPotion = false;

        for (Item item : inventory) {
            if (item instanceof HealthPotion) {
                containsHealthPotion = true;
               HealthPotion healthPotion = (HealthPotion) item;
                int increase = healthPotion.getHealthPointsGiven();

                if (getHealth() + increase >= maxHealth) {
                    setHealth(maxHealth);
                }
                else {
                    setHealth(getHealth() + increase);
                }
                inventory.remove(item);
                break;
            }
        }
        if (! containsHealthPotion) {
            System.out.println("You do not have any health potions in your inventory!");
        }
    }

    public void takeDamage (int damage) {
        int newHealth = getHealth() - damage;
        setHealth(newHealth);
        if (getHealth() <= 0) {
            setIsDead(true);
            System.out.println("You lost the game");
            // game over, player cant move
        }
    }

    public void gainXp(Monster m) {
        setXp(m.calculateXp());
    }

    public void moveX() {
        getPoint().setLocation(getPoint().getX() + 1, getPoint().getY());
    }

    public void moveY() {
        getPoint().setLocation(getPoint().getX() , getPoint().getY() + 1);
    }

    public void addTotalDamage(Weapon weapon){

        int sumOfDmg = weapon.getAttackBonus()+super.getDamage();

        setDamage(sumOfDmg);

    }

    public boolean pickUpWeapon(Weapon weapon){
        //this weapon also changes a stat of the player holding the weapon.

        if(!(weapon instanceof Weapon)){
            throw new IllegalArgumentException("The passed parameter has to be of type Weapon");
        }

        if(!weaponsSlot.isEmpty() && equipsWeaponStatus == true){
            weaponsSlot.clear();
            weaponsSlot.add(weapon);
            addTotalDamage(weapon);
            equipsWeaponStatus = true;
        }

        if(weaponsSlot.isEmpty() && equipsWeaponStatus == false ){
            weaponsSlot.add(weapon);
            addTotalDamage(weapon);
            equipsWeaponStatus = true;

        }

        return equipsWeaponStatus;
    }

    //public boolean


}
