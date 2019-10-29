
public abstract class Monster extends Character {

    public int xpGiven;

    public Monster(String name, int health, int attack, int level, int xpGiven) {
        super(name, health, attack, level);
        this.xpGiven = xpGiven;
    }

    public int calculateXp () {
        return xpGiven * getLevel();
    }

    public void takeDamage (int damage) {
       setHealth(getHealth() - damage);
        if (getHealth() <= 0) {
            setIsDead(true);
            System.out.println("RIP");
        }
    }

}