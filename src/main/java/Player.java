public class Player extends Character {

    private int xpLevel;
    private int maxHealth;

    public Player(String name, int level, int health, int attack, int maxHealth){
        super(name, health, attack, level);
        this.maxHealth = maxHealth;
    }
}
