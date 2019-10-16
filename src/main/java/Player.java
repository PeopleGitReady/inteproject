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

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
}
