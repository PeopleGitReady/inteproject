public class Player extends Character {

    private int xp;
    private int maxHealth;
    private String name;

    public Player(String name, int level, int health, int attack, int maxHealth, int xp){
        super(health, attack, level);
        this.xp = xp;
        this.maxHealth = 100;
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
