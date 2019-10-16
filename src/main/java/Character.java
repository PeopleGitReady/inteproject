import java.awt.*;

public abstract class Character {

    private String name;
    private int health;
    private int damage;
    private int level;
    private Point point;
    private boolean isDead;


    public Character(String name, int health, int damage, int level) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.level = level;
    }

    public void movement(){

    }

    public String getName(){
        return name;
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
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

    public Point getPoint(){
        return point;
    }
    public void setPoint(Point point){
        this.point = point;
    }

    public boolean getIsDead() {
        return isDead;
    }


    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    //calculate health

    //attack monster to Payer
    public void attack(Character c){
        if (c instanceof Player) {
            Player p = (Player) c;
            p.takeDamage(damage);
        }

        if (c instanceof Monster) {
            Monster m = (Monster) c;
            m.takeDamage(damage);
        }

    }







}
