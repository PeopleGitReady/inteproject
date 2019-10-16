import java.util.ArrayList;

public class Player extends Character {

    private int xp = 0;
    private int maxHealth = 100;
    private ArrayList<Item> inventory = new ArrayList<Item>();

    public Player(String name){
        super(name, 22, 100, 1);
    }


    public void pickUpLoot(Item item) {
        if(inventory.size() < 9) {
            inventory.add(item);
        } else {
            System.out.println("This inventory is full!");
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
}
