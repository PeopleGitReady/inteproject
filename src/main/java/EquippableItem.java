import java.awt.*;

public class EquippableItem extends Item{

    private int requiredLevel;


    public EquippableItem(String name, Point point, int requiredLevel) {
        super(name, point);
        this.requiredLevel = requiredLevel;

    }


    public EquippableItem(String name){

    }

    public EquippableItem(){

    }

    public EquippableItem(String name,Point point){
        super(name,point);
    }

}
