public class Monster extends Character {

    private String type;

    public Monster(String type, int health, int attack, int level) {
        super(health, attack, level);
        this.type = type;
    }


}
