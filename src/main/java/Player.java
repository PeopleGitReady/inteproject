import java.awt.*;
import java.util.ArrayList;

public class Player extends Character {

    private int xp = 0;
    private int maxHealth = 100;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private ArrayList<Weapon> weaponsSlot= new ArrayList<>();


    public Player(String name){
        super(name, 100, 20, 1, new Point(0, 0) );
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getMaxHealth () { return maxHealth; }

    public int getXp () { return xp; }

    public void setXp (int xp) { this.xp = xp; }

    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }

    public void moveX() {
        if (! getIsDead())
        getPoint().setLocation(getPoint().getX() + 1, getPoint().getY());
    }

    public void moveY() {
        if (! getIsDead())
        getPoint().setLocation(getPoint().getX() , getPoint().getY() + 1);
    }

    public void pickUpLoot(Item item) {
        if(inventory.size() < 10) {
            inventory.add(item);
        } else {
            System.out.print("This inventory is full! ");
        }
    }

    public void takeDamage (int damage) {
        int newHealth = getHealth() - damage;
        setHealth(newHealth);
        if (getHealth() <= 0) {
            setIsDead(true);
            System.out.println("You lost the game");
            // game over, player should not be able to move!
        }
    }

    public void gainXp(Monster m) {
        setXp(getXp() + m.calculateXp());

        if (getXp() >= ( getLevel() * getLevel() ) * 100 ) {
            setLevel(getLevel() + 1);
            setMaxHealth(getMaxHealth() + 50);
            System.out.println("Ding ding ding, you are now level " + getLevel() + "! Congratulations!");
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

    public void equipWeapon(Weapon weapon){
        //this weapon also changes a stat of the player holding the weapon.

        if(inventory.contains(weapon)){

            if(!weaponsSlot.isEmpty()){

                Weapon tempWeapon = weaponsSlot.get(0);
                inventory.add(tempWeapon);
                weaponsSlot.clear();
                weaponsSlot.add(weapon);
                setDamage(getDamage() + weapon.getAttackBonus());
                inventory.remove(weapon);

            } else {
                weaponsSlot.add(weapon);
                setDamage(getDamage() + weapon.getAttackBonus());
                inventory.remove(weapon);
            }
        }
    }

    public void unequipWeapon(){
        if(! weaponsSlot.isEmpty() && getInventory().size() < 10 ) {
            Weapon w = weaponsSlot.get(0);
            weaponsSlot.clear();
            inventory.add(w);
            setDamage(getDamage() - w.getAttackBonus());
        } else {
            System.out.println("Your inventory is full!");
        }
    }
}
