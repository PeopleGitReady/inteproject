import java.util.ArrayList;

public class Player extends Character {

    private int xp = 0;
    private int maxHealth = 100;
    private ArrayList<Item> inventory = new ArrayList<Item>();

    public Player(String name){
        super(name, 22, 100, 1);
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

    protected void setHealth(int damageGotten){
        int i = maxHealth-damageGotten;
        if(i<=0){
            setIsDead(true);
        }else{
           setMaxHealth(i);
        }
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
}
