public abstract class Character {

    private String name;
    private int health;
    private int attack;
    private int level;

    public Character(String name, int health, int attack, int level) {
        this.name = name;
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
