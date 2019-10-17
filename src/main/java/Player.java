import java.util.ArrayList;

public class Player extends Character {

    private int xp = 0;
    private int maxHealth = 100;
    private ArrayList<Item> inventory = new ArrayList<Item>();

    public Player(String name){
        super(name, 100, 20, 1);

    }

    public String getName(){
        return super.getName();
    }

    public void pickUpLoot(Item item) {
        if(inventory.size() < 9) {
            inventory.add(item);
        } else {
            System.out.print("This inventory is full!");
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

    public void useHealthPotion (HealthPotion healthPotion) {
        boolean containsHealthPotion = false;

        for (Item item : inventory) {
            if (item instanceof HealthPotion) {

                containsHealthPotion = true;
                int increase = healthPotion.getHealthPoints();

                if (getHealth() + increase >= maxHealth) {
                    setHealth(maxHealth);
                }
                else {
                    setHealth(getHealth() + increase);
                }
                inventory.remove(item);
            }
        }

        if (containsHealthPotion) {
            System.out.println("You do not have any health potions in your inventory!");
        }

    }

    public void setMaxHealth(int maxHealth) {

        this.maxHealth = maxHealth;

    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
}
