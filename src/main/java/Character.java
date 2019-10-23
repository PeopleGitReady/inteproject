import java.awt.*;

public abstract class Character extends Point {

    private String name;
    private int health;
    private int damage;
    private int level;
    private boolean isDead;


    public Character(String name, int health, int damage, int level) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.level = level;

        if (name == null) {
            throw new NullPointerException("Parameter Type cannot be null");
        }

        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be Empty! ");
        }
        if(name.matches(".*\\d.*")){
            throw new IllegalArgumentException("Name cannot be Number!");

        }
    }

    public String getName(){
        return name;
    }
    public int getDamage(){
        return damage;
    }
    protected void setDamage(int damage){
        this.damage = damage;
    }

    public int getHealth(){
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }

    public boolean getIsDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    //calculate health

    /*
    public void attack(Character c, Character attacker){
        if (c instanceof Player) {
            Player p = (Player) c;
            p.takeDamage(damage);
        }

        if (c instanceof Monster) {
            Monster m = (Monster) c;
            Player a = (Player) attacker;
            m.takeDamage(damage);
            if (m.getIsDead()) {
                a.gainXp(m);
            }
        }
    }

     */

    public void attack(Character c, Character attacker){
        if (c instanceof Player) {
            Player p = (Player) c;
            Monster m = (Monster) attacker;
            // Kan förenklas med en metod som direkt kollar så att skillnaden i y eller x är 1
            if(Math.abs(p.getX() - m.getX())  <= 1 && Math.abs(p.getY() - m.getY())  <= 1) {
                p.takeDamage(damage);
            }
        }

        if (c instanceof Monster) {
            Monster m = (Monster) c;
            Player a = (Player) attacker;
            if(Math.abs(m.getX() - a.getX()) <= 1 && Math.abs(m.getY() - a.getY()) <= 1) {
                m.takeDamage(damage);
                if (m.getIsDead()) {
                    a.gainXp(m);
                }
            }
        }
    }

}
