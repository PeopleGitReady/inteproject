public abstract class Character {

    private int health;
    private int attack;
    private int level;
    private int positionX;
    private int positionY;
    private boolean isDead;


    public Character(int health, int attack, int level) {
        this.health = 100;
        this.attack=22;
        this.level = level;
    }

    public void movement(){

    }


    public int getAttack(){
        return attack;
    }

    public int getHealth(){
        return health;
    }

    public int getLevel(){
        return level;
    }
    //calculate Xplevel()



    //healthIsCorrect(int)






}
