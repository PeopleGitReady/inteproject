public abstract class Monster extends Character {

    private int xpGiven;
    private boolean inCombat;

    public Monster(String name, int health, int attack, int level, int xpGiven) {
        super(name, health, attack, level);
        this.xpGiven = xpGiven;
    }

    public int calculateXp () {
        return xpGiven * getLevel();
    }

    public void attack(Character c) {
        if (c instanceof Player) {
            Player p = (Player) c;
            if(Math.abs(p.getX() - getX())  <= 1 && Math.abs(p.getY() - getY())  <= 1) {
                p.takeDamage(getDamage());
            }
        }
    }

    public void takeDamage (int damage) {
       setHealth(getHealth() - damage);
        if (getHealth() <= 0) {
            setIsDead(true);
            System.out.println("RIP");
        }
    }

}