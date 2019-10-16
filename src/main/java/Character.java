import java.awt.*;

public abstract class Character {

    private String name;
    private int health;
    private int attack;
    private int level;
    Point point;
    private boolean isDead;


    public Character(String name, int health, int attack, int level) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.level = level;
    }

    public void movement(){

    }

    public String getName(){
        return name;
    }
    public int getAttack(){
        return attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }

    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
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

    public boolean setIsDead(boolean isDead) {
        isDead = true;
    }

    //calculate Xplevel()



    //healthIsCorrect(int)

        //calculate health








}
