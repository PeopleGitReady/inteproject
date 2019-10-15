import java.util.ArrayList;

public class Player extends Character {

    private int xp = 0;
    private int maxHealth = 100;
    private String name;
    private ArrayList<Item> inventory = new ArrayList<Item>();

    public Player(String name){
        super(name, 22, 100, 1);
    }

    public String getName(){
        return name;
    }
}
