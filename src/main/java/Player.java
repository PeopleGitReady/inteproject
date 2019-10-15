public class Player extends Character {

    private int xpLevel;
    private int maxHealth;

    public Player(String name, int xpLevel, int health, int attack, int maxHealth){
        super(name, health, attack);
        this.xpLevel = xpLevel;
        this.maxHealth = maxHealth;
    }
}
