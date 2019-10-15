import java.util.ArrayList;

public class Player extends Character {

    private int xp = 0;
    private int maxHealth = 100;
    private String name;
    private ArrayList<Item> inventory = new ArrayList<Item>();

    public Player(String name, int level, int attack, int health){
        super(health, attack, level);
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
