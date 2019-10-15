public class Player extends Character {

    private int xp;
    private int maxHealth;

    public Player(String name, int level, int health, int attack, int maxHealth, int xp){
        super(name, health, attack, level);
        this.xp = xp;
        this.maxHealth = 100;
    }
}
